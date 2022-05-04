package priv.oms.entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import priv.oms.util.DBUtil;

public class Customer {
  private String id, first, last, sex, address, phone, email, card;

  public Customer(String phone){

  }

  /**
   * valid phone number
   * @param phone input phone number
   * @return boolean whether this customer exist or not
   */
  public static boolean validPhone(String phone){
    PreparedStatement presql; //preprocess
    ResultSet rs = null; //store result
    String sql = "SELECT * FROM customer\n"
        + "WHERE \"phone number\"=? ";
    try{
      presql = DBUtil.conn.prepareStatement(sql);
      presql.setString(1, phone);// fill param into sql statement
      rs = presql.executeQuery();
      return rs.next();
    }catch(SQLException e){
      e.printStackTrace();
    }
    return false;
  }

  /**
   * valid phone number
   * @param card input credit card number
   * @return boolean whether this customer exist or not
   */
  public static boolean validCreditCard(String card){
    PreparedStatement presql; //preprocess
    ResultSet rs = null; //store result
    String sql = "SELECT * FROM customer\n"
        + "WHERE \"credit card\"=? ";
    try{
      presql = DBUtil.conn.prepareStatement(sql);
      presql.setString(1, card);// fill param into sql statement
      rs = presql.executeQuery();
      return rs.next();
    }catch(SQLException e){
      e.printStackTrace();
    }
    return false;
  }

  public static String getCustomerValueFromDB(String target, String phone){
    PreparedStatement presql; //preprocess
    ResultSet rs = null; //store result
    String sql = "SELECT * FROM customer\n"
        + "WHERE \"phone number\"=? ";
    String result = null;
    try{
      presql = DBUtil.conn.prepareStatement(sql);
      presql.setString(1, phone);// fill param into sql statement
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
}
