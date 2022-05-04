package priv.oms.util;

import javafx.beans.property.SimpleStringProperty;

/**
 * this class is prepare for generate the table in product overall page
 */
public class OrderOverallTable {
  String orderid, date, time, quantity, amount, firstname, lastname, credit_card, account, status;

  public OrderOverallTable(String orderid, String date, String time, String quantity,
      String amount, String firstname, String lastname, String credit_card, String account,
      String status) {
    this.orderid = orderid;
    this.date = date;
    this.time = time;
    this.quantity = quantity;
    this.amount = amount;
    this.firstname = firstname;
    this.lastname = lastname;
    this.credit_card = credit_card;
    this.account = account;
    this.status = status;
  }

  public String getOrderid() {
    return orderid;
  }

  public void setOrderid(String orderid) {
    this.orderid = orderid;
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

  public String getQuantity() {
    return quantity;
  }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getCredit_card() {
    return credit_card;
  }

  public void setCredit_card(String credit_card) {
    this.credit_card = credit_card;
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
