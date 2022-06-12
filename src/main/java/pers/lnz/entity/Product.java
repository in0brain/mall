package pers.lnz.entity;

import pers.lnz.util.SqlHelper;

public class Product {
    private String id;//代码
    private String name;//商品名称
    private float price;//价格
    private String kind;//种类
    private String message;//描述信息
    private String image_src;//图片
    private String merchantName;//商家信息

    public Product(String name, float price, String kind, String message, String image_src, String merchantName) {
        this.id = new SqlHelper().sumNum().toString();
        this.name = name;
        this.price = price;
        this.kind = kind;
        this.message = message;
        this.image_src = image_src;
        this.merchantName = merchantName;
    }

    public Product(String id, String name, float price, String kind, String message, String image_src, String merchantName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.kind = kind;
        this.message = message;
        this.image_src = image_src;
        this.merchantName = merchantName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImage_src() {
        return image_src;
    }

    public void setImage_src(String image_src) {
        this.image_src = image_src;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", kind='" + kind + '\'' +
                ", message='" + message + '\'' +
                ", image_src='" + image_src + '\'' +
                ", merchantName='" + merchantName + '\'' +
                '}';
    }
}
