package pers.lnz.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pers.lnz.entity.Product;
import pers.lnz.entity.User;
import pers.lnz.entity.vo.MessageModel;
import pers.lnz.service.UserService;
import pers.lnz.util.Constants;
import pers.lnz.util.SqlHelper;

import java.io.IOException;
import java.util.List;

public class LoginServlet extends HttpServlet {
    //实例化
    private UserService userService = new UserService();

    /**
     *前台页面传输消息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受客户端的请求
        String userName = req.getParameter("login-user");
        String password = req.getParameter("login-password");


        MessageModel messageModel = userService.userLogin(userName,password);

//      isFlag为true的时候成功跳转到下个页面
        if (messageModel.isFlag()){

            User curUser = (User) messageModel.getObj();
//            记录当前用户名
            req.getSession().setAttribute(Constants.CUR_USER,curUser);
            SqlHelper sqlHelper = new SqlHelper();
//            获取所有的商家名称并设置
            List<String> merchantsName = sqlHelper.getAllMerchantsName();
            req.setAttribute(Constants.MERCHANTS_NAME,merchantsName);
//            获取所有的种类并设置
            List<String> productsKind = sqlHelper.getAllKind();
            req.setAttribute(Constants.PRODUCTS_KIND,productsKind);
//            获取所有的商品并设置
            List<Product> products = sqlHelper.queryAllProduct();
            req.setAttribute(Constants.PRODUCTS_LIST,products);

//           获取当前项目名
//            String path = req.getServletContext().getContextPath();
//            带参数跳转

            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }else{
            req.setAttribute("kind", messageModel.getKind());
            req.setAttribute("message", messageModel.getMsg());
            req.setAttribute("userName",userName);
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}
