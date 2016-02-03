package com.arjunkumbakkara.codillenge;

/**
 * Created by Arjun Kumbakkara on 30-01-2016.
 */
public class Item {

    private String product_id,product_name,product_description,sku,product_image,thumbnail,price,discounted_price,discount;

    Item(String product_id, String product_name, String product_description, String sku, String product_image, String thumbnail, String price, String discounted_price, String discount) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_description = product_description;
        this.sku = sku;
        this.product_image = product_image;
        this.thumbnail = thumbnail;
        this.price = price;
        this.discounted_price = discounted_price;
        this.discount = discount;
    }

    public String getprduct_name() {
        return product_name;
    }

    public String getprice() {
        return price;
    }


    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDiscounted_price() {
        return discounted_price;
    }

    public void setDiscounted_price(String discounted_price) {
        this.discounted_price = discounted_price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }


}
