package priv.oms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
  //private static final String CONN = "jdbc:sqlite:OMS.sqlite";
  public static java.sql.Connection conn = null;

  /**
   * connect to database
   */
  public DBUtil() {
    try {
      Class.forName("org.sqlite.JDBC");
      String dbURL = "jdbc:sqlite:OMS.sqlite";
      conn = DriverManager.getConnection(dbURL);
      System.out.println("Database connect successfully");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * check whether the connection close or not, if not, close it
   * @param sql input the sql string
   * @result rs return the resultset of the sql query
   */
  public static ResultSet getResult(String sql){
    PreparedStatement presql; //preprocess
    ResultSet rs = null; //store result
    try{
      presql = conn.prepareStatement(sql);
      rs = presql.executeQuery();
      return rs;
    }catch(SQLException e){
      e.printStackTrace();
    }
    return rs;
  }

  /**
   * check whether the connection close or not, if not, close it
   * @param rs get the interface of connection
   * @param stm the interface of preprocessing
   */
  public static void CloseDB(ResultSet rs, PreparedStatement stm){
    if(rs!=null){
      try {
        rs.close();
      }catch (SQLException e){
        e.printStackTrace();
      }
    }
    if(stm!=null){
      try {
        rs.close();
      }catch (SQLException e){
        e.printStackTrace();
      }
    }
  }
}
