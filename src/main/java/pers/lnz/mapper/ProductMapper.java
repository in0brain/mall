package pers.lnz.mapper;

import org.apache.ibatis.annotations.Param;
import pers.lnz.entity.Product;

import java.util.List;
import java.util.Map;

public interface ProductMapper {

    List<Product> queryProductByFuzzyName(String name);

    Product queryProductByName(String name);
    List queryProductByKind(String kind);

    boolean addProduct(Product product);

    boolean deleteProductByName(String name);

    List<String> getAllKind();

    List queryAllProduct();

    List queryProductByMerchant(String name);
    Integer sumNum();

    /**
     *
     * @param curName 当前的名字
     * @param name 需要修改的名字
     * @return
     */
    boolean updateMerchant(@Param("curName") String curName,@Param("name") String name);

    boolean modifyProduct(Product product);
    Product queryProductById(String id);
}
