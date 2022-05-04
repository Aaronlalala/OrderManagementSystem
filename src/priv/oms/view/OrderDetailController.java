package priv.oms.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import priv.oms.dao.OrderDao;
import priv.oms.util.OrderDetailTable;

public class OrderDetailController {

  @FXML
  private BorderPane borderpane;

  @FXML
  private TableColumn<OrderDetailTable, String> col_color;

  @FXML
  private TableColumn<OrderDetailTable, String> col_date;

  @FXML
  private TableColumn<OrderDetailTable, String> col_quantity;

  @FXML
  private TableColumn<OrderDetailTable, String> col_first;

  @FXML
  private TableColumn<OrderDetailTable, String> col_last;

  @FXML
  private TableColumn<OrderDetailTable, String> col_orderid;

  @FXML
  private TableColumn<OrderDetailTable, String> col_price;

  @FXML
  private TableColumn<OrderDetailTable, String> col_prodcutid;

  @FXML
  private TableColumn<OrderDetailTable, String> col_product;

  @FXML
  private TableColumn<OrderDetailTable, String> col_size;

  @FXML
  private TableColumn<OrderDetailTable, String> col_status;

  @FXML
  private TableColumn<OrderDetailTable, String> col_time;

  @FXML
  private TableColumn<OrderDetailTable, String> col_admin;

  @FXML
  private TableView<OrderDetailTable> table;

  @FXML
  private TextField orderidField;

  private ObservableList<OrderDetailTable> oblist = FXCollections.observableArrayList();

  @FXML
  void click_detail_select(ActionEvent event) {
    table.getItems().clear();
    String orderid = orderidField.getText();
    System.out.println(orderid);
    show_table(orderid);
  }

  void show_table(String orderid){
    // make the table
    try{
      ResultSet rs = OrderDao.getOrderDetail(orderid);
      while(rs.next()){
        //orderid, date, time, quantity, amount, firstname, lastname, credit_card, account, status;
        oblist.add(new OrderDetailTable(rs.getString("orderid"),rs.getString("productid"),
            rs.getString("date"),rs.getString("time"),rs.getString("first name"),
            rs.getString("last name"),rs.getString("product name"),rs.getString("color"),
            rs.getString("size"),rs.getString("unit price"),rs.getString("quantity"),
            rs.getString("account"),rs.getString("status")));
      }
    }catch(SQLException ex){
      Logger.getLogger(ProductOverallController.class.getName()).log(Level.SEVERE,null,ex);
    }

    col_orderid.setCellValueFactory(new PropertyValueFactory<>("orderid"));
    col_prodcutid.setCellValueFactory(new PropertyValueFactory<>("productid"));
    col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
    col_time.setCellValueFactory(new PropertyValueFactory<>("time"));
    col_first.setCellValueFactory(new PropertyValueFactory<>("first"));
    col_last.setCellValueFactory(new PropertyValueFactory<>("last"));
    col_product.setCellValueFactory(new PropertyValueFactory<>("product"));
    col_color.setCellValueFactory(new PropertyValueFactory<>("color"));
    col_size.setCellValueFactory(new PropertyValueFactory<>("size"));
    col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
    col_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
    col_status.setCellValueFactory(new PropertyValueFactory<>("status"));
    col_admin.setCellValueFactory(new PropertyValueFactory<>("account"));

    table.setItems(oblist);

    //set table to the center
    borderpane.setCenter(table);
  }

}

