package priv.oms.util;

public class CreateOrderTable {
  String name,color,size,quantity,price,discount;

  public CreateOrderTable(String name, String color, String size, String quantity,
      String price, String discount) {
    this.name = name;
    this.color = color;
    this.size = size;
    this.quantity = quantity;
    this.price = price;
    this.discount = discount;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getQuantity() {
    return quantity;
  }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getDiscount() {
    return discount;
  }

  public void setDiscount(String discount) {
    this.discount = discount;
  }
}
