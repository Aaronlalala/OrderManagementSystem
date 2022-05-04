package priv.oms.util;

import javafx.beans.property.SimpleStringProperty;

/**
 * this class is prepare for generate the table in product overall page
 */
public class ProductOverallTable {
  String productid, productname, color, colorcode, size, unitprice, quantity, discount;
  SimpleStringProperty description;

  public ProductOverallTable(
      String productid,
      String productname,
      String color,
      String colorcode,
      String size,
      String unitprice,
      String quantity,
      String discount,
      String description) {
    this.productid = productid;
    this.productname = productname;
    this.color = color;
    this.colorcode = colorcode;
    this.size = size;
    this.unitprice = unitprice;
    this.quantity = quantity;
    this.discount = discount;
    this.description = new SimpleStringProperty(description);
  }

  public String getProductid() {
    return productid;
  }

  public void setProductid(String productid) {
    this.productid = productid;
  }

  public String getProductname() {
    return productname;
  }

  public void setProductname(String productname) {
    this.productname = productname;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getColorcode() {
    return colorcode;
  }

  public void setColorcode(String colorcode) {
    this.colorcode = colorcode;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getUnitprice() {
    return unitprice;
  }

  public void setUnitprice(String unitprice) {
    this.unitprice = unitprice;
  }

  public String getQuantity() {
    return quantity;
  }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }

  public String getDiscount() {
    return discount;
  }

  public void setDiscount(String discount) {
    this.discount = discount;
  }

  public SimpleStringProperty getDiscription() {
    return description;
  }

  public void setDiscription(SimpleStringProperty discription) {
    this.description = discription;
  }
}
