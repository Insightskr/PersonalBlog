<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!--登录模态框-->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">登录</h4>
            </div>
            <div class="modal-body">
                <form id="login_form">
                    <div class="form-group">
                        <label for="login_name_input">用户名</label>
                        <input type="text" class="form-control" id="login_name_input" name="victorName"
                               placeholder="请输入用户名">
                        <span class="help-block"></span>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="login_password_input">密码</label>
                        <input type="password" class="form-control" id="login_password_input" name="victorPassword"
                               placeholder="请输入密码">
                        <span class="help-block"></span>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="login_btn" login-able="false">登录</button>
            </div>
        </div>
    </div>
</div>

<!--注册模态框-->
<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="registerModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">注册</h4>
            </div>
            <div class="modal-body">
                <form id="register_form" class="form-horizontal">
                    <div class="form-group">
                        <label for="register_name_input" class="col-sm-2 col-sm-offset-1 control-label">用户名</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="register_name_input" name="victorName"
                                   placeholder="请输入用户名">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="register_email_input" class="col-sm-2 col-sm-offset-1 control-label">邮箱</label>
                        <div class="col-sm-8">
                            <input type="email" class="form-control" id="register_email_input" name="victorEmail"
                                   placeholder="请输入邮箱">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="register_password_input" class="col-sm-2 col-sm-offset-1 control-label">密码</label>
                        <div class="col-sm-8">
                            <input type="password" class="form-control" id="register_password_input"
                                   name="victorPassword"
                                   placeholder="请输入密码">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="confirm_password_input" class="col-sm-2 col-sm-offset-1 control-label">确认密码</label>
                        <div class="col-sm-8">
                            <input type="password" class="form-control" id="confirm_password_input"
                                   placeholder="请再次输入密码">
                            <span class="help-block"></span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="register_btn" register-able="false">注册</button>
            </div>
        </div>
    </div>
</div>

