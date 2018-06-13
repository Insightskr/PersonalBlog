package com.ins.blog.entity;

public class Victor {
    private Integer id;

    private String victorName;

    private String victorEmail;

    private String victorPassword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVictorName() {
        return victorName;
    }

    public void setVictorName(String victorName) {
        this.victorName = victorName == null ? null : victorName.trim();
    }

    public String getVictorEmail() {
        return victorEmail;
    }

    public void setVictorEmail(String victorEmail) {
        this.victorEmail = victorEmail == null ? null : victorEmail.trim();
    }

    public String getVictorPassword() {
        return victorPassword;
    }

    public void setVictorPassword(String victorPassword) {
        this.victorPassword = victorPassword == null ? null : victorPassword.trim();
    }

    @Override
    public String toString() {
        return "Victor{" +
                "id=" + id +
                ", victorName='" + victorName + '\'' +
                ", victorEmail='" + victorEmail + '\'' +
                ", victorPassword='" + victorPassword + '\'' +
                '}';
    }
}