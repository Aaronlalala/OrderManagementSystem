package priv.oms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import priv.oms.entity.Operator;
import priv.oms.util.DBUtil;

public class LoginDao {
  //for login event
  static Connection con = DBUtil.conn; //get database connection

  /**
   * login status
   * @param account get account from user input
   * @param password get password from user input
   * @return true:login success false:login fail
   */
  public static boolean loginStart(String account, String password){
    //login and preprocess of database data
    PreparedStatement presql; //preprocess
    ResultSet rs; //store result
    String sqlStr = "select * from administrators where account=? and password=? and authority=1"; //sql query
    try{
      presql = con.prepareStatement(sqlStr);
      presql.setString(1, account);
      presql.setString(2, password);// fill param into sql statement
      rs = presql.executeQuery();
      if(rs.next()){ //if can get result from database, return true, else false
        String employid = rs.getString("employid");
        String name = rs.getString("account"); //get employeeid and name from database
        Operator operator = new Operator(employid,name); //create a operator
        return true;
      }else{
        return false;
      }
    }catch(SQLException e){
      return false;
    }
  }
}
