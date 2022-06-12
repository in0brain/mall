package pers.lnz.util;

import org.apache.ibatis.session.SqlSession;
import pers.lnz.entity.Product;
import pers.lnz.entity.User;
import pers.lnz.mapper.ProductMapper;
import pers.lnz.mapper.UserMapper;

import java.util.List;

public class SqlHelper {

    SqlSession session;
     UserMapper userMapper;
     ProductMapper productMapper;


    public SqlHelper() {
        this.session = GetSqlSession.createSqlSession();
        userMapper = session.getMapper(UserMapper.class);
        productMapper = session.getMapper(ProductMapper.class);

    }

    /**
     * 通过用户名返回User对象
     * @param userName 用户名
     * @return user对象
     */
    public User queryUserByName(String userName) {
        return userMapper.queryUserByName(userName);
    }

    /**
     *通过email返回用户对象
     * @param email 邮箱地址
     * @return user
     */
    public User queryUserByEmail(String email) {
        return userMapper.queryUserByEmail(email);
    }

    public List<User> queryUserByAuthority(String authority) {
        return userMapper.queryUserByAuthority(authority);
    }
    /**
     *
     * @param user 对象
     * @return 是否成功插入
     */
    public boolean insertUser(User user) {
        boolean flag = userMapper.insertUser(user);
        session.commit();
        return flag;
    }

    /**
     *
     * @param userName 通过输入名字删除user
     * @return 是否删除成功
     */
    public boolean deleteUserByName(String userName){

        boolean flag = userMapper.deleteUserByName(userName);
        session.commit();
        return flag;
    }

    /**
     *
     * @param email 通过email删除
     * @return 删除是否成功
     */
    public boolean deleteUserByEmail(String email) {
        boolean flag = userMapper.deleteUserByEmail(email);
        session.commit();
        return flag;
    }


    public boolean updatePassword(User user) {

        boolean flag = userMapper.updatePassword(user);
        session.commit();
        return flag;
    }

    public boolean updateEmail(User user) {

        boolean flag = userMapper.updateEmail(user);
        session.commit();
        return flag;
    }

    public boolean updateImg_src(User user) {

        boolean flag = userMapper.updateImg_src(user);
        session.commit();
        return flag;
    }

    public boolean updateAuthority(User user) {

        boolean flag = userMapper.updateAuthority(user);
        session.commit();
        return flag;
    }

    public List<Product> queryProductByFuzzyName(String name) {
        return productMapper.queryProductByFuzzyName(name);
    }

    public Product queryProductByName(String name) {
        return productMapper.queryProductByName(name);
    }
    public boolean deleteProductByName(String name) {

        boolean flag = productMapper.deleteProductByName(name);
        session.commit();
        return flag;
    }

    public boolean addProduct(Product product) {

        boolean flag = productMapper.addProduct(product);
        session.commit();
        return flag;
    }

    public List queryProductByKind(String product_kind) {

        return productMapper.queryProductByKind(product_kind);
    }

    public List<Product> queryAllProduct() {
        return productMapper.queryAllProduct();
    }

    public List<Product> queryProductByMerchant(String name) {
        return productMapper.queryProductByMerchant(name);
    }

    public List<String> getAllKind() {
        return productMapper.getAllKind();
    }
    public List<User> queryMerchantByFuzzyName(String name) {
        return userMapper.queryMerchantByFuzzyName(name);
    }

    public List<String> getAllMerchantsName() {
        return userMapper.getAllMerchantsName();
    }

    public Integer sumNum() {
        return productMapper.sumNum()+1;
    }

    public boolean updateMerchant(String curName, String name) {
        boolean flag = productMapper.updateMerchant(curName, name);
        session.commit();
        return flag;
    }
    public boolean modifyProduct(Product product) {
        boolean flag = productMapper.modifyProduct(product);
        session.commit();
        return flag;
    }
    public Product queryProductById(String id) {
        return productMapper.queryProductById(id);
    }
}
