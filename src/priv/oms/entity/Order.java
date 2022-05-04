package priv.oms.entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import priv.oms.util.DBUtil;

public class Order {

  String orderid, quantity, amount, cusid, employid, status,date,time;

  /**
   * update order
   */
  public Order(String orderid, String quantity, String amount, String cusid,
      String employid, String status, String date, String time) {
    PreparedStatement ps;
    String sql =
        "INSERT INTO orders (orderid, date, time, \"total quantity\",\"total amount\",customerid,employid,status) \n"
            + "VALUES (?,?,?,?,?,?,?,?)";
    try{
      ps = DBUtil.conn.prepareStatement(sql);
      ps.setString(1, orderid);
      ps.setString(2, date);
      ps.setString(3, time);
      ps.setString(4, quantity);
      ps.setString(5, amount);
      ps.setString(6, cusid);
      ps.setString(7, employid);
      ps.setString(8, status);
      int n = ps.executeUpdate();
      if (n == 1) System.out.println("Order update successfully");
      else System.out.println("Order update failed");
    }catch(SQLException e){
      e.printStackTrace();
    }
  }


  public static String getOrderidFromDB() {
    String sql = "SELECT max(orderid) from orders";
    ResultSet rs = DBUtil.getResult(sql);
    int maxid = 0;
    try {
      maxid = rs.getInt(1);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    String newid = Integer.toString(maxid+1);
    return newid;
  }
}
