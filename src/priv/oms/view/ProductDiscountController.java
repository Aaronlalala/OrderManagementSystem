package priv.oms.view;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import priv.oms.dao.ProductDao;
import priv.oms.util.DBUtil;
import priv.oms.util.ProductOverallTable;

public class ProductDiscountController implements Initializable {

  @FXML
  private BorderPane borderpane;

  @FXML
  private TableView<ProductOverallTable> table;

  @FXML
  private TableColumn<ProductOverallTable, String> col_color;

  @FXML
  private TableColumn<ProductOverallTable, String> col_colorcode;

  @FXML
  private TableColumn<ProductOverallTable, String> col_description;

  @FXML
  private TableColumn<ProductOverallTable, Float> col_discount;

  @FXML
  private TableColumn<ProductOverallTable, Integer> col_productid;

  @FXML
  private TableColumn<ProductOverallTable, String> col_productname;

  @FXML
  private TableColumn<ProductOverallTable, Integer> col_quantity;

  @FXML
  private TableColumn<ProductOverallTable, String> col_size;

  @FXML
  private TableColumn<ProductOverallTable, Integer> col_unitprice;



  /**
   * initialize table with current discounted product
   */
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    //initialize table with all products
    ObservableList<ProductOverallTable> oblist = FXCollections.observableArrayList();
    try{
      ResultSet rs = ProductDao.getDiscountValue();
      while(rs.next()){
        oblist.add(new ProductOverallTable(rs.getString("productid"),rs.getString("product name"),
            rs.getString("color"),rs.getString("color code"),rs.getString("size"),
            rs.getString("unit price"),rs.getString("quantity"),rs.getString("discount"),
            rs.getString("description")));
      }
    }catch(SQLException ex){
      Logger.getLogger(ProductOverallController.class.getName()).log(Level.SEVERE,null,ex);
    }

    col_productid.setCellValueFactory(new PropertyValueFactory<>("productid"));
    col_productname.setCellValueFactory(new PropertyValueFactory<>("productname"));
    col_color.setCellValueFactory(new PropertyValueFactory<>("color"));
    col_colorcode.setCellValueFactory(new PropertyValueFactory<>("colorcode"));
    col_size.setCellValueFactory(new PropertyValueFactory<>("size"));
    col_unitprice.setCellValueFactory(new PropertyValueFactory<>("unitprice"));
    col_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
    col_discount.setCellValueFactory(new PropertyValueFactory<>("discount"));
    //col_descirption.setCellValueFactory(new PropertyValueFactory<>("description"));
    col_description.setCellValueFactory(celldata->celldata.getValue().getDiscription());

    table.setItems(oblist);
  }

  @FXML
  void click_reset(ActionEvent event) {
    String sql1 = "UPDATE product SET discount = 0 WHERE discount = 0.15";
    executeSQL(sql1);
    String sql2 =
        "update product\n"
            + "set discount = 0.15\n"
            + "where productid in \n"
            + "(select productid from product\n"
            + "order by RANDOM()\n"
            + "limit 10) ";
    executeSQL(sql2);

    ObservableList<ProductOverallTable> oblist = FXCollections.observableArrayList();
    try{
      ResultSet rs = ProductDao.getDiscountValue();
      while(rs.next()){
        oblist.add(new ProductOverallTable(rs.getString("productid"),rs.getString("product name"),
            rs.getString("color"),rs.getString("color code"),rs.getString("size"),
            rs.getString("unit price"),rs.getString("quantity"),rs.getString("discount"),
            rs.getString("description")));
      }
    }catch(SQLException ex){
      Logger.getLogger(ProductOverallController.class.getName()).log(Level.SEVERE,null,ex);
    }
    table.getItems().clear();
    table.setItems(oblist);
    borderpane.setCenter(table);
  }

  /**
   * execute update SQL
   */
  void executeSQL(String sql){
    PreparedStatement presql; //preprocess
    try{
      presql = DBUtil.conn.prepareStatement(sql);
      int n = presql.executeUpdate();
    }catch(SQLException e){
      e.printStackTrace();
    }
  }
}
