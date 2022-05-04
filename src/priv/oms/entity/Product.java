package priv.oms.entity;

import static java.lang.Integer.parseInt;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import priv.oms.util.DBUtil;

public class Product {

  public static ArrayList<Product> products = new ArrayList<>();
  private String name, color, code, size, description, productid, price, quantity, discount;


  public Product(String name, String color, String size, String quantity) {
    this.name = name;
    this.color = color;
    this.size = size;
    this.quantity = quantity;
    setCode();
    setDescription();
    setProductid();
    setPrice();
    setDiscount();
  }


  public void setCode() {
    this.code = getValueFromDB("color code", this.name, this.color, size);
  }

  public void setDescription() {
    this.description = getValueFromDB("description", this.name, this.color, size);
  }

  public void setProductid() {
    this.productid = getValueFromDB("productid", this.name, this.color, size);
  }

  public void setPrice() {
    this.price = getValueFromDB("unit price", this.name, this.color, size);
  }

  public void setDiscount() {
    this.discount = getValueFromDB("discount", this.name, this.color, size);
  }

  public static ArrayList<Product> getProducts() {
    return products;
  }

  public String getName() {
    return name;
  }

  public String getColor() {
    return color;
  }

  public String getCode() {
    return code;
  }

  public String getSize() {
    return size;
  }

  public String getDescription() {
    return description;
  }

  public String getProductid() {
    return productid;
  }

  public String getPrice() {
    return price;
  }

  public String getQuantity() {
    return quantity;
  }

  public String getDiscount() {
    return discount;
  }

  public static String getValueFromDB(String target, String name, String color, String size){
    PreparedStatement presql; //preprocess
    ResultSet rs = null; //store result
    String sql = "SELECT * FROM product\n"
        + "WHERE \"product name\"=? AND color=? AND size=?";
    String result = null;
    try{
      presql = DBUtil.conn.prepareStatement(sql);
      presql.setString(1, name);// fill param into sql statement
      presql.setString(2, color);
      presql.setString(3, size);
      rs = presql.executeQuery();
      while(rs.next()){
        result = rs.getString(target);
      }
    }catch(SQLException e){
      e.printStackTrace();
    }
    System.out.println(result);
    return result;
  }

  public String getDBQuantity() {
    return getValueFromDB("quantity", this.name, this.color, size);
  }

  /**
   * valid product remaining quantity > 0
   * @param product_list user input products
   */
  public static boolean validProducts(ArrayList<Product> product_list){
    for (Product p : product_list) {
      if(parseInt(p.getDBQuantity())-parseInt(p.getQuantity()) < 0){
        return false;
      }
    }
    return true;
  }

  /**
   * valid product remaining quantity > 0
   * @param product_list user input products
   */
  public static String getQuantityProducts(ArrayList<Product> product_list){
    int total_quantity = 0;
    for (Product p : product_list) {
      total_quantity += Integer.parseInt(p.getQuantity());
    }
    return Integer.toString(total_quantity);
  }

  public static String getAmountProducts(ArrayList<Product> product_list){
    int total_amount = 0;
    for (Product p : product_list) {
      total_amount += Integer.parseInt(p.getQuantity()) * Integer.parseInt(p.getPrice());
    }
    return Integer.toString(total_amount);
  }

}
