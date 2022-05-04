package priv.oms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import priv.oms.util.DBUtil;

/**
 * support the database connection in order page
 */
public class OrderDao {

  /**
   * result will display in order overall table
   */
  public static ResultSet getAllOrderValue(){

    String sql =
        "SELECT orderid, date, time, \"total quantity\", \"total amount\", \"first name\", \"last name\", \"credit card\", account,status\n"
            + "from orders o, customer c, administrators a\n"
            + "WHERE o.customerid = c.customerid AND o.employid = a.employid"; // sql query
    return DBUtil.getResult(sql);
  }

  /**
   * result will display in order detail table
   */
  public static ResultSet getOrderDetail(String orderid){
    PreparedStatement presql; //preprocess
    ResultSet rs = null; //store result
    String sqlStr =
        "SELECT o.orderid, p.productid, date, time, \"first name\", \"last name\", \"product name\", color, size, p.\"unit price\", op.quantity, account, status\n"
            + "FROM orders o, product p, order_product op, customer c, administrators a\n"
            + "WHERE o.orderid = op.orderid AND p.productid = op.productid \n"
            + "AND o.customerid = c.customerid AND o.employid = a.employid\n"
            + "AND o.orderid==?"; // sql query
    try{
      presql = DBUtil.conn.prepareStatement(sqlStr);
      presql.setString(1, orderid);// fill param into sql statement
      rs = presql.executeQuery();
    }catch(SQLException e){
      e.printStackTrace();
    }
    return rs;
  }
}
