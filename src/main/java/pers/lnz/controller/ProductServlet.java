package pers.lnz.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pers.lnz.entity.Product;
import pers.lnz.entity.User;
import pers.lnz.service.ProductService;
import pers.lnz.util.Constants;
import pers.lnz.util.SqlHelper;
import pers.lnz.util.StringUtil;

import java.io.IOException;

public class ProductServlet extends HttpServlet {

    SqlHelper sqlHelper = new SqlHelper();

    ProductService productService = new ProductService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String info = req.getParameter("info");
        String operation = req.getParameter("operation");

        if (!StringUtil.isEmpty(operation)) {
            String id = req.getParameter("product-id");
            User merchant = (User)req.getSession().getAttribute(Constants.CUR_USER);
            String merchantName = merchant.getUserName();
            String img = req.getParameter("img");
            String productName = req.getParameter("product-name");
            float price = Float.parseFloat(req.getParameter("price"));
            String kind = req.getParameter("kind");
            String message = req.getParameter("message");

            if (operation.equals("MODIFY")) {
                Product product = sqlHelper.queryProductById(id);
                product.setName(productName);
                product.setPrice(price);
                product.setKind(kind);
                product.setMessage(message);
                product.setImage_src(img);
                productService.modifyProduct(product);
            } else if (operation.equals("ADD")) {

                Product product = new Product(productName,price,kind,message,img,merchantName);
                productService.addProduct(product);
                System.out.println(product);
            }
            req.getRequestDispatcher("/add_product.jsp").forward(req,resp);
            return;
        }

        if (info.equals("add_product")) {
            req.setAttribute("button","ADD");
        }else if (info.equals("modify_product")) {
            req.setAttribute("button","MODIFY");
            String productName = req.getParameter("productName");
            Product product = sqlHelper.queryProductByName(productName);
            req.setAttribute(Constants.CUR_PRODUCT,product);
        }

        req.getRequestDispatcher("/add_product.jsp").forward(req,resp);
    }
}
