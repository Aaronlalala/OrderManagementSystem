package priv.oms.util;

/**
 * this class is prepare for generate the table in customer overall page
 */
public class CustomerOverallTable {
  String customerid, first, last, phone, card, address, email;

  public CustomerOverallTable(String customerid, String first, String last, String phone,
      String card, String address, String email) {
    this.customerid = customerid;
    this.first = first;
    this.last = last;
    this.phone = phone;
    this.card = card;
    this.address = address;
    this.email = email;
  }

  public String getCustomerid() {
    return customerid;
  }

  public void setCustomerid(String customerid) {
    this.customerid = customerid;
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

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getCard() {
    return card;
  }

  public void setCard(String card) {
    this.card = card;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
