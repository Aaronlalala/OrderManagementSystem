package priv.oms.dao;

import java.sql.ResultSet;
import priv.oms.util.DBUtil;

/**
 * support the database connection in product page
 */
public class ProductDao {

  /**
   * result will display in product overall table
   */
  public static ResultSet getAllValue(){
    String sql = "select * from product"; //sql query
    return DBUtil.getResult(sql);
  }

  /** result will display in product discount table */
  public static ResultSet getDiscountValue() {
    String sql = "select * from product where discount == 0.15"; // sql query
    return DBUtil.getResult(sql);
  }
}
