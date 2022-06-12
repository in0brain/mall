package pers.lnz.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pers.lnz.entity.Product;
import pers.lnz.entity.User;
import pers.lnz.entity.vo.MessageModel;
import pers.lnz.service.ProductService;
import pers.lnz.util.Constants;
import pers.lnz.util.SqlHelper;
import pers.lnz.util.StringUtil;

import java.io.IOException;
import java.util.List;

public class IndexServlet extends HttpServlet {

    HttpServletRequest request;
    HttpServletResponse response;

    ProductService productService = new ProductService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        request = req;
        response = resp;
//        普通的信息
        String path = req.getParameter("info");
//        得到信息的操作
        String operation = req.getParameter("operation");
//        操作的参数
        String parameter = req.getParameter("parameter");

        if (path.equals(Constants.PAGE_REFRESH)) {
            if (StringUtil.isEmpty(operation)||operation.equals(Constants.KIND_ALL)) {
                showAllProduct();
            } else {
                showProduct(operation,parameter);
            }
            return;
        }
        jumpToPage(path);
    }

    private void showAllProduct() throws ServletException, IOException {
        SqlHelper sqlHelper = new SqlHelper();
        List<String> merchantsName = sqlHelper.getAllMerchantsName();
        request.setAttribute(Constants.MERCHANTS_NAME,merchantsName);
        List<String> productsKind = sqlHelper.getAllKind();
        request.setAttribute(Constants.PRODUCTS_KIND,productsKind);
        List<Product> list = sqlHelper.queryAllProduct();
        request.setAttribute(Constants.PRODUCTS_LIST,list);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    private void showProduct(String operation, String name) throws ServletException, IOException {
        MessageModel messageModel = null;
        SqlHelper sqlHelper = new SqlHelper();
        if (operation.equals(Constants.OPERATION_SEARCH)) {
            messageModel = productService.showSearchProduct(name);
        } else if (operation.equals(Constants.OPERATION_KIND)) {
            messageModel = productService.showProductsByKind(name);
        } else if (operation.equals(Constants.OPERATION_NAME)) {
            messageModel = productService.showProductByMerchant(name);
        } else if (operation.equals(Constants.OPERATION_DELETE)) {
            messageModel = productService.deleteProductByName(name);
        }

        List<String> merchantsName = sqlHelper.getAllMerchantsName();
        request.setAttribute(Constants.MERCHANTS_NAME,merchantsName);
        List<String> productsKind = sqlHelper.getAllKind();
        request.setAttribute(Constants.PRODUCTS_KIND,productsKind);
        if (messageModel==null||!messageModel.isFlag()) {
            return;
        }

        List<Product> list = (List<Product>) messageModel.getObj();
        request.setAttribute(Constants.PRODUCTS_LIST,list);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    private void jumpToPage(String path) throws ServletException, IOException {
        SqlHelper sqlHelper = new SqlHelper();
        if (path.equals(Constants.PATH_MERCHANTS)) {
            List<User> list = sqlHelper.queryUserByAuthority(Constants.MERCHANTS);
            request.setAttribute("merchants",list);
        }else if (path.equals(Constants.PATH_ADD_PRODUCT)) {
            User user = (User) request.getSession().getAttribute("user");
            if (user.getAuthority().equals(Constants.ADMIN)) {
                return;
            }
        }
        request.getRequestDispatcher(path+".jsp").forward(request,response);
    }
}
