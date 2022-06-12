package pers.lnz.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pers.lnz.entity.User;
import pers.lnz.entity.vo.MessageModel;
import pers.lnz.service.UserService;
import pers.lnz.util.Constants;
import pers.lnz.util.SqlHelper;
import java.io.IOException;
import java.util.List;

public class MerchantsServlet extends HttpServlet {

    private SqlHelper sqlHelper;
    private UserService userService;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        sqlHelper = new SqlHelper();
        userService = new UserService();
        String name  = req.getParameter("name");
        String email = req.getParameter("email");
        String describe = req.getParameter("describe");
        String info_name = req.getParameter("info");
        String operation = req.getParameter("operation");

        if (operation.equals(Constants.OPERATION_SEARCH)) {
            List<User> list = sqlHelper.queryMerchantByFuzzyName(info_name);
            req.setAttribute("merchants",list);
            req.getRequestDispatcher("/merchants_table.jsp").forward(req,resp);
            return;
        }
//      更新名字的时候要考虑到product表
        MessageModel messageModel = userService.updateMerchants(name,email,describe,info_name,operation);
        List<User> list = sqlHelper.queryUserByAuthority("Merchant");
        if (!messageModel.isFlag()){
            req.setAttribute("alert",messageModel.getMsg());
            req.setAttribute("merchants",list);
            req.getRequestDispatcher("/merchants_table.jsp").forward(req,resp);
            return;
        }

        req.setAttribute("merchants",list);
        req.getRequestDispatcher("/merchants_table.jsp").forward(req,resp);

    }
}
