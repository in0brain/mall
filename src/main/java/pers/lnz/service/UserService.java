package pers.lnz.service;

import pers.lnz.entity.User;
import pers.lnz.entity.vo.MessageModel;
import pers.lnz.util.SqlHelper;
import pers.lnz.util.StringUtil;

public class UserService {
    /**
     * 用户登录
     * @param userName 前台输入的名字
     * @param password 前台输入的密码
     * @return 返回需要的数据
     */
    public MessageModel userLogin(String userName, String password){
//      存前台传输的数据和model类型
        MessageModel messageModel = new MessageModel();
        messageModel.setKind("login");
        User u = new User();
//      回显数据
        u.setUserName(userName);
        u.setPassword(password);

        messageModel.setObj(u);

        if (StringUtil.isEmpty(userName)||StringUtil.isEmpty(password)){
            messageModel.setFlag(false);
            messageModel.setMsg("UserName or password can't be empty!");
            return messageModel;
        }


        SqlHelper sqlHelper = new SqlHelper();
//        数据库查询信息
        User user = sqlHelper.queryUserByName(userName);
        if (user==null){
            messageModel.setFlag(false);
            messageModel.setMsg("User is not exist!");

            return messageModel;
        }

//        密码错误
        if (!password.equals(user.getPassword())){
            messageModel.setFlag(false);
            messageModel.setMsg("Password Wrong!");
            return messageModel;
        }

        messageModel.setObj(user);
        return messageModel;
    }

    /**
     *
     * @param userName 前台的输入的用户名
     * @param email 前台填写的邮箱地址
     * @param password 前台拟定的密码
     * @param password_again 确定密码
     * @return 消息模型
     */
    public MessageModel userRegister(String userName,String email, String password, String password_again) {
//        存前台传输的数据和model类型
        MessageModel messageModel = new MessageModel();
        messageModel.setKind("register");
        User u = new User();
//        回显数据
        u.setUserName(userName);
        u.setEmail(email);
        u.setPassword(password);
        messageModel.setObj(u);
//        填写信息不能为空
        if (StringUtil.isEmpty(userName)||StringUtil.isEmpty(password)||StringUtil.isEmpty(password_again)||StringUtil.isEmpty(email)) {
            messageModel.setFlag(false);
            messageModel.setMsg("Necessary information can't be empty!");
            return messageModel;
        }
//        姓名长度
        if (userName.length()>20) {
            messageModel.setFlag(false);
            messageModel.setMsg("The name must be  1 ~ 20 characters long!");
            return messageModel;
        }
//        邮箱格式
        if (!StringUtil.email_legitimacy(email)) {
            messageModel.setFlag(false);
            messageModel.setMsg("Illegal email address!");
            return messageModel;
        }
//        密码长度
        if (password.length()>20) {
            messageModel.setFlag(false);
            messageModel.setMsg("The password must be  1 ~ 20 characters long!");
            return messageModel;
        }
//        两次密码不一致
        if (!password.equals(password_again)) {
            messageModel.setFlag(false);
            messageModel.setMsg("Entered passwords differ!");
            return messageModel;
        }
        SqlHelper sqlHelper = new SqlHelper();

//        该用户已存在
        User user = sqlHelper.queryUserByName(userName);
        if (user!=null){
            messageModel.setFlag(false);
            messageModel.setMsg("User already exists!");
            return messageModel;
        }
//        注册失败
        boolean flag = sqlHelper.insertUser(u);
        if (!flag) {
            messageModel.setMsg("Register has failed!");
        }else {
            messageModel.setMsg("Register has successful!");
        }
        messageModel.setFlag(flag);
        return messageModel;
    }

    public MessageModel updateUserInfo(String password, String email) {
        MessageModel messageModel = new MessageModel();
        if (StringUtil.isEmpty(password)||email.isEmpty()) {
            messageModel.setFlag(false);
            messageModel.setMsg("There are unfilled fields!");
        }
        return messageModel;
    }

    /**
     *
     * @param name 用户输入的新名字
     * @param email 新的邮箱
     * @param describe 新的描述
     * @param cur_name 原来的名字
     * @param operation 操作
     * @return MessageModel
     */
    public MessageModel updateMerchants(String name, String email, String describe, String cur_name,String operation) {
        SqlHelper sqlHelper = new SqlHelper();
        MessageModel messageModel = new MessageModel();
        if (operation.equals("delete")) {
            sqlHelper.deleteUserByName(cur_name);
//            设定处理类型
            sqlHelper.updateMerchant(cur_name,null);

            return messageModel;
        }else if (operation.equals("modify")) {

            if (sqlHelper.queryUserByName(name)!=null) {
                messageModel.setFlag(false);
                messageModel.setMsg("Have the same user name!");
                return messageModel;
            }

            User user = sqlHelper.queryUserByName(cur_name);
            user.setUserName(name);
            user.setEmail(email);
            if (!StringUtil.isEmpty(describe)){
                user.setDescription(describe);
            }
            sqlHelper.deleteUserByName(cur_name);
            sqlHelper.insertUser(user);
            sqlHelper.updateMerchant(cur_name,name);
            return messageModel;
        }

        return messageModel;
    }
}
