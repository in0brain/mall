package pers.lnz.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pers.lnz.entity.Product;
import pers.lnz.entity.vo.MessageModel;
import pers.lnz.service.UserService;
import pers.lnz.util.Constants;
import pers.lnz.util.SqlHelper;

import java.io.IOException;
import java.util.List;

public class RegisterServlet extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("sign-user");
        String email = req.getParameter("sign-email");
        String password = req.getParameter("sign-password");
        String password_again = req.getParameter("sign-password-again");

        MessageModel messageModel = userService.userRegister(userName,email,password,password_again);

        if (messageModel.isFlag()){
            req.getSession().setAttribute("user",messageModel.getObj());
//           获取当前项目名
//            String path = req.getServletContext().getContextPath();

//            带参数跳转
            SqlHelper sqlHelper = new SqlHelper();
            List<String> merchantsName = sqlHelper.getAllMerchantsName();
            req.setAttribute(Constants.MERCHANTS_NAME,merchantsName);
            List<String> productsKind = sqlHelper.getAllKind();
            req.setAttribute(Constants.PRODUCTS_KIND,productsKind);
//            获取所有的商品并设置
            List<Product> products = sqlHelper.queryAllProduct();
            req.setAttribute(Constants.PRODUCTS_LIST,products);

            req.setAttribute("kind",messageModel.getKind());

            req.getRequestDispatcher("/index.jsp").forward(req,resp);
//            重定向
//            resp.sendRedirect(path+"/index.jsp");
        }else{
            req.setAttribute("kind",messageModel.getKind());
            req.setAttribute("message", messageModel.getMsg());
            req.setAttribute("userName",userName);
            req.setAttribute("email",email);
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
