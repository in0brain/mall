package pers.lnz.test;

import com.mysql.cj.Session;
import org.apache.ibatis.session.SqlSession;
import pers.lnz.entity.Product;
import pers.lnz.entity.User;
import pers.lnz.mapper.ProductMapper;
import pers.lnz.util.Constants;
import pers.lnz.util.GetSqlSession;
import pers.lnz.util.SqlHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestSql {
    public static void main(String[] args) {
//        获取对象
        SqlHelper sqlHelper = new SqlHelper();
        List<Product> list = sqlHelper.queryProductByMerchant("cherry");
        for (Product p:list) {
            System.out.println(p.toString());
        }
    }
}
