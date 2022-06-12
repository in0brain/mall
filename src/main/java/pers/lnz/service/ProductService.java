package pers.lnz.service;

import pers.lnz.entity.Product;
import pers.lnz.entity.vo.MessageModel;
import pers.lnz.util.Constants;
import pers.lnz.util.SqlHelper;
import pers.lnz.util.StringUtil;

import java.util.List;

/**
 * 点击后带id跳转到新页面：
 */
public class ProductService {
    public MessageModel showProductsByKind(String kind) {
        SqlHelper sqlHelper = new SqlHelper();
        MessageModel messageModel = new MessageModel();
        List<Product> list;
        if (StringUtil.isEmpty(kind)|| kind.equals(Constants.KIND_ALL)) {
            list = sqlHelper.queryAllProduct();
            messageModel.setObj(list);
            return messageModel;
        }
        list = sqlHelper.queryProductByKind(kind);
        if (list==null) {
            messageModel.setFlag(false);
            messageModel.setMsg(Constants.FAIL);
        }

        messageModel.setObj(list);
        return messageModel;
    }

    public MessageModel showProductByMerchant(String merchantName) {
        SqlHelper sqlHelper = new SqlHelper();
        MessageModel messageModel = new MessageModel();
        List<Product> list = sqlHelper.queryProductByMerchant(merchantName);
        messageModel.setObj(list);
        return messageModel;
    }

    public MessageModel showSearchProduct(String name) {
        SqlHelper sqlHelper = new SqlHelper();
        MessageModel messageModel = new MessageModel();
        List<Product> list = sqlHelper.queryProductByFuzzyName(name);
        messageModel.setObj(list);
        return messageModel;
    }

    public MessageModel deleteProductByName(String name) {
        SqlHelper sqlHelper = new SqlHelper();
        MessageModel messageModel = new MessageModel();
        sqlHelper.deleteProductByName(name);
        List<Product> list = sqlHelper.queryAllProduct();
        messageModel.setObj(list);
        return messageModel;
    }

    public MessageModel modifyProduct(Product product) {
        MessageModel messageModel = new MessageModel();
        SqlHelper sqlHelper = new SqlHelper();
        boolean flag = sqlHelper.modifyProduct(product);
        messageModel.setFlag(flag);
        return messageModel;
    }

    public boolean addProduct(Product product) {
        SqlHelper sqlHelper = new SqlHelper();
        boolean flag = sqlHelper.addProduct(product);
        return flag;
    }
}
