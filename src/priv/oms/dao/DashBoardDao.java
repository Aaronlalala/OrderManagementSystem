package priv.oms.dao;

import java.sql.ResultSet;
import priv.oms.util.DBUtil;

public class DashBoardDao {
  /**
   * result will display in Dashboard stocktake upper
   */
  public static ResultSet getStocktakeUpValue(){
    String sql =
        "SELECT \"product name\" ,SUM(quantity) FROM product\n"
            + "GROUP BY \"product name\""; // sql query
    return DBUtil.getResult(sql);
  }

  /**
   * result will display in Dashboard stocktake lower
   */
  public static ResultSet getStocktakelowValue(){
    String sql =
        "SELECT \"productid\" ,SUM(quantity) FROM product\n"
            + "GROUP BY \"product name\",color,size\n"
            + "ORDER BY SUM(quantity) desc"; // sql query
    return DBUtil.getResult(sql);
  }

  /**
   * result will display in Dashboard quarterly sales quantity
   */
  public static ResultSet getQuarterlySalesQuantityValue(){
    String sql =
        "SELECT \"product name\", sum(op.quantity)\n"
            + "FROM orders o, product p, order_product op\n"
            + "WHERE o.orderid = op.orderid AND p.productid = op.productid \n"
            + "AND date BETWEEN '2021-08-01' AND '2021-10-31'\n"
            + "GROUP BY \"product name\""; // sql query
    return DBUtil.getResult(sql);
  }

  /**
   * result will display in Dashboard quarterly sales sales
   */
  public static ResultSet getQuarterlySalesValue(){
    String sql =
        "SELECT \"product name\", sum(op.quantity*op.\"unit price\")\n"
            + "FROM orders o, product p, order_product op\n"
            + "WHERE o.orderid = op.orderid AND p.productid = op.productid \n"
            + "AND date BETWEEN '2021-08-01' AND '2021-10-31'\n"
            + "GROUP BY \"product name\""; // sql query
    return DBUtil.getResult(sql);
  }

  /**
   * result will display in Dashboard Customer Demographic
   */
  public static ResultSet getCustomerDemographic(){
    String sql = "SELECT sex, COUNT(*) from customer\n" + "GROUP BY sex"; // sql query
    return DBUtil.getResult(sql);
  }

  /**
   * result will display in Dashboard top 10 item
   */
  public static ResultSet getTopShirt(){
    String sql =
        "SELECT p.productid, \"product name\", color, size, sum(op.quantity) quantity\n"
            + "FROM orders o, product p, order_product op\n"
            + "WHERE o.orderid = op.orderid AND p.productid = op.productid \n"
            + "AND date BETWEEN '2021-10-01' AND '2021-10-31'\n"
            + "AND \"product name\"='Shirt'\n"
            + "GROUP BY p.\"productid\"\n"
            + "ORDER BY sum(op.quantity) DESC"; // sql query
    return DBUtil.getResult(sql);
  }

  /**
   * result will display in Dashboard top 10 item
   */
  public static ResultSet getTopTrouser(){
    String sql =
        "SELECT p.productid, \"product name\", color, size, sum(op.quantity) quantity\n"
            + "FROM orders o, product p, order_product op\n"
            + "WHERE o.orderid = op.orderid AND p.productid = op.productid \n"
            + "AND date BETWEEN '2021-10-01' AND '2021-10-31'\n"
            + "AND \"product name\"='Trouser'\n"
            + "GROUP BY p.\"productid\"\n"
            + "ORDER BY sum(op.quantity) DESC"; // sql query
    return DBUtil.getResult(sql);
  }

  /**
   * result will display in Dashboard top 10 item
   */
  public static ResultSet getTopJacket(){
    String sql =
        "SELECT p.productid, \"product name\", color, size, sum(op.quantity) quantity\n"
            + "FROM orders o, product p, order_product op\n"
            + "WHERE o.orderid = op.orderid AND p.productid = op.productid \n"
            + "AND date BETWEEN '2021-10-01' AND '2021-10-31'\n"
            + "AND \"product name\"='Jacket'\n"
            + "GROUP BY p.\"productid\"\n"
            + "ORDER BY sum(op.quantity) DESC"; // sql query
    return DBUtil.getResult(sql);

  }

}
