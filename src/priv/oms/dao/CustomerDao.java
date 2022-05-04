package priv.oms.dao;

import java.sql.ResultSet;
import priv.oms.util.DBUtil;

/**
 * support the database connection in order page
 */
public class CustomerDao {
  /**
   * result will display in customer overall table
   */
  public static ResultSet getAllCustomerValue(){
    String sql = "select * from customer"; //sql query
    return DBUtil.getResult(sql);
  }
}
