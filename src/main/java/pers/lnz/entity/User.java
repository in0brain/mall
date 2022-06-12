package pers.lnz.entity;

import pers.lnz.util.StringUtil;

import java.awt.*;

public class User {
    private String userName="";
    private String password="";
    private String email="";
    private String img_src="./img/user_src/account.png";
    private String description="";
    private String authority="Merchant";

    public User(){
        description= StringUtil.getDate();
    }

    public User(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.description=StringUtil.getDate();
    }

    public String getImg_src() {
        return img_src;
    }

    public void setImg_src(String img_src) {
        this.img_src = img_src;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority.equals("Admin")?"Admin":"Merchant";
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", img_src='" + img_src + '\'' +
                ", authority='" + authority + '\'' +
                '}';
    }
}
