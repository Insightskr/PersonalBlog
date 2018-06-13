
//为标题栏的登录按钮绑定事件
function loginModel() {
    //清空原先的数据
    $("#loginModal form")[0].reset();
    clear_validate_msg("#login_name_input");
    clear_validate_msg("#login_password_input");
    //弹出模态框
    $("#loginModal").modal();
}

//为标题栏的注册按钮绑定事件
function registerModel() {
    //清空原先的数据
    $("#loginModal form")[0].reset();
    clear_validate_msg("#register_name_input");
    clear_validate_msg("#register_email_input");
    clear_validate_msg("#register_password_input");
    clear_validate_msg("#confirm_password_input");

    $('#registerModal').modal();
}

//为标题栏的登出按钮绑定事件
function logout() {
    $.get("/logout", function (result) {
        if (200 === result.code) {
            //如果退出登录成功，就重新跳转到主页，更新元素。
            $(location).attr("href", "/index.jsp")
        }
    });
}

//每次显示之前，先清空先前的元素的属性
function clear_validate_msg(element) {
    $(element).parent().removeClass("has-success has-error");
    $(element).next("span").text("");
}

//显示校验信息
function show_validate_msg(element, status, msg) {
    clear_validate_msg(element);
    if ("success" == status) {
        $(element).parent().addClass("has-success");
        $(element).next("span").text(msg);
    } else if ("error" == status) {
        $(element).parent().addClass("has-error");
        $(element).next("span").text(msg);
    }
}

//检查字段是否存在
function checkExist(element, url) {
    $.ajax({
        url: url,
        data: "val=" + $(element).val(),
        type: "get",
        success: function (result) {
            if (200 === result.code) {
                //todo:这里的状态和提示信息后期都可以修改为由服务器提供，以实现注册和登陆共用这个函数
                show_validate_msg(element, "success", result.msg);
            } else {
                show_validate_msg(element, "error", result.msg);
            }
        }
    })
}

//加载绑定事件
$(function () {
    // 对登陆的用户名进行检查
    $("#login_name_input").blur(function () {
        var name = $(this).val();
        var regaxName = /(^[a-zA-Z0-9_-]{3,16}$)|(^[\u2E80-\u9FFF]{2,7}$)/;
        if (!regaxName.test(name)) {
            //显示错误信息
            show_validate_msg("#login_name_input", "error", "用户名必须是3-16位的英文或2-7位的中文");
            $("#login_btn").attr("login-able", "false");
        } else {
            show_validate_msg("#login_name_input", "success", null);
            //这里应该还有一个检查用户名是否存在的函数，到时候再做。
            $("#login_btn").attr("login-able", "true");
        }
    });

    //绑定模态框登陆按钮
    $("#login_btn").click(function () {
        if ($("#login_btn").attr("login-able") !== "false") {
            //发送登录请求
            $.ajax({
                url: "/login",
                data: $("#loginModal form").serialize(),
                type: "post",
                success: function (result) {
                    if (200 === result.code) {
                        //如果登陆成功，就重新跳转到当前页面，更新元素。
                        //todo:应该是登陆成功，跳转到当前页面才对。
                        $(location).attr("href", window.location.pathname);
                    } else {
                        //如果登陆失败，则提示密码错误
                        show_validate_msg("#login_password_input", "error", "输入密码不正确");
                    }
                }
            });
        } else {
            alert("请输入正确的信息");
        }
    });

    // 对注册的用户名进行检查
    $("#register_name_input").blur(function () {
        var name = $(this).val();
        var regaxName = /(^[a-zA-Z0-9_-]{3,16}$)|(^[\u2E80-\u9FFF]{2,7}$)/;
        if (!regaxName.test(name)) {
            //显示错误信息
            show_validate_msg("#register_name_input", "error", "用户名必须是3-16位的英文或2-7位的中文");
        } else {
            checkExist("#register_name_input", "/checkUsername");
        }
    });

    // 对注册的邮箱进行检查
    $("#register_email_input").blur(function () {
        var email = $(this).val();
        var regaxEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
        if (!regaxEmail.test(email)) {
            //显示错误信息
            show_validate_msg("#register_email_input", "error", "邮箱格式不正确");
        } else {
            checkExist("#register_email_input", "/checkEmail");
        }
    });

    //对密码框进行监听
    $("#register_password_input").change(function () {
        var passwd = $("#register_password_input").val();
        var repasswd = $("#confirm_password_input").val();
        if (passwd !== '' && repasswd !== '' && passwd === repasswd) {
            show_validate_msg("#confirm_password_input", "success", "密码正确");
        } else {
            show_validate_msg("#confirm_password_input", "error", "两次输入的密码不一致");
        }
    });

    //对确认密码框进行监听
    $("#confirm_password_input").change(function () {
        var passwd = $("#register_password_input").val();
        var repasswd = $("#confirm_password_input").val();
        if (passwd !== '' && repasswd !== '' && passwd === repasswd) {
            show_validate_msg("#confirm_password_input", "success", "密码正确");
        } else {
            show_validate_msg("#confirm_password_input", "error", "两次输入的密码不一致");
        }
    });

    //对模态框的注册按钮进行监听
    $("#register_btn").click(function () {
        //判断字段是否为空
        var name = $("#register_name_input").val();
        var email = $("#register_email_input").val();
        var passwd = $("#register_passwd_input").val();
        var confirm = $("#confirm_password_input").val();
        //当所有字段不为空时才进入下一步
        if (!(name !== '' && email !== '' && passwd !== '' && confirm !== '')) {
            alert("请输入完整信息");
        } else {
            //当通过所有验证之后,也就是没有警告后才允许注册
            if ($(".has-error").length > 0) {
                return false;
            } else {
                $.ajax({
                    url: '/register',
                    type: "post",
                    data: $("#registerModal form").serialize(),
                    success: function (result) {
                        if (200 === result.code) {
                            alert("注册成功！");
                            //注册成功后自动登录
                            $(location).attr("href", "index.jsp");
                        } else {
                            alert("注册失败");
                        }
                    }
                });
            }
        }
    });
});

