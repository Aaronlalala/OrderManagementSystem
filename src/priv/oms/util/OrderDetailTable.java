package priv.oms.util;

/**
 * this class is prepare for generate the table in order detail page
 */
public class OrderDetailTable {
  String orderid, productid, date, time, first, last, product, color, size, price, quantity, account, status;

  public OrderDetailTable(String orderid, String productid, String date, String time,
      String first, String last, String product, String color, String size, String price,
      String quantity, String account, String status) {
    this.orderid = orderid;
    this.productid = productid;
    this.date = date;
    this.time = time;
    this.first = first;
    this.last = last;
    this.product = product;
    this.color = color;
    this.size = size;
    this.price = price;
    this.quantity = quantity;
    this.account = account;
    this.status = status;
  }

  public String getOrderid() {
    return orderid;
  }

  public void setOrderid(String orderid) {
    this.orderid = orderid;
  }

  public String getProductid() {
    return productid;
  }

  public void setProductid(String productid) {
    this.productid = productid;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getFirst() {
    return first;
  }

  public void setFirst(String first) {
    this.first = first;
  }

  public String getLast() {
    return last;
  }

  public void setLast(String last) {
    this.last = last;
  }

  public String getProduct() {
    return product;
  }

  public void setProduct(String product) {
    this.product = product;
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

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getQuantity() {
    return quantity;
  }

  public void setQuantity(String discount) {
    this.quantity = quantity;
  }

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
