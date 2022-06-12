package pers.lnz.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pers.lnz.entity.User;
import pers.lnz.entity.vo.MessageModel;
import pers.lnz.service.UserService;
import pers.lnz.util.SqlHelper;
import pers.lnz.util.StringUtil;

import java.io.IOException;

public class InfoServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String authority = req.getParameter("options");
        String img_newSrc = req.getParameter("img-src");

        User user =(User) req.getSession().getAttribute("user");


        UserService userService = new UserService();
        MessageModel messageModel = userService.updateUserInfo(password,email);
        if (messageModel.isFlag()) {
            SqlHelper sqlHelper = new SqlHelper();
            user.setPassword(password);
            user.setAuthority(authority);
            user.setEmail(email);
            if(!StringUtil.isEmpty(img_newSrc)){
                user.setImg_src(img_newSrc);
            }

            req.getSession().setAttribute("user",user);
            sqlHelper.deleteUserByName(user.getUserName());
            sqlHelper.insertUser(user);
            req.getRequestDispatcher("/personal_page.jsp").forward(req,resp);
        }else {

            req.getRequestDispatcher("/personal_page.jsp").forward(req,resp);
        }
    }
}
