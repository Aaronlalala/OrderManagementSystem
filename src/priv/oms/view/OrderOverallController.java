package priv.oms.view;

import java.net.URL;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import priv.oms.dao.OrderDao;
import priv.oms.util.OrderOverallTable;

public class OrderOverallController implements Initializable {

  @FXML
  private TableView<OrderOverallTable> table;
  @FXML
  private TableColumn<OrderOverallTable, String> col_admin;

  @FXML
  private TableColumn<OrderOverallTable, String> col_amount;

  @FXML
  private TableColumn<OrderOverallTable, String> col_card;

  @FXML
  private TableColumn<OrderOverallTable, String> col_date;

  @FXML
  private TableColumn<OrderOverallTable, String> col_first;

  @FXML
  private TableColumn<OrderOverallTable, String> col_last;

  @FXML
  private TableColumn<OrderOverallTable, String> col_orderid;

  @FXML
  private TableColumn<OrderOverallTable, String> col_quantity;

  @FXML
  private TableColumn<OrderOverallTable, String> col_status;

  @FXML
  private TableColumn<OrderOverallTable, String> col_time;

  @FXML
  private ChoiceBox<String> statusChoiceBox;

  private ObservableList<OrderOverallTable> oblist = FXCollections.observableArrayList();

  @FXML
  void click_select(ActionEvent event) {

  }
  /**
   * set item value to choice box
   * initialize table with all orders
   */
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    //set item value to choice box
    ObservableList<String> status_cb = FXCollections.observableArrayList("","complete", "deliver", "backorder","prepare");
    statusChoiceBox.setItems(status_cb);

    //initialize table with all orders
    //get result from SQL query result set
    try{
      ResultSet rs = OrderDao.getAllOrderValue();
      while(rs.next()){
        //orderid, date, time, quantity, amount, firstname, lastname, credit_card, account, status;
        oblist.add(new OrderOverallTable(rs.getString("orderid"),rs.getString("date"),
            rs.getString("time"),rs.getString("total quantity"),rs.getString("total amount"),
            rs.getString("first name"),rs.getString("last name"),rs.getString("credit card"),
            rs.getString("account"),rs.getString("status")));
      }
    }catch(SQLException ex){
      Logger.getLogger(ProductOverallController.class.getName()).log(Level.SEVERE,null,ex);
    }


    col_orderid.setCellValueFactory(new PropertyValueFactory<>("orderid"));
    col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
    col_time.setCellValueFactory(new PropertyValueFactory<>("time"));
    col_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
    col_amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
    col_first.setCellValueFactory(new PropertyValueFactory<>("firstname"));
    col_last.setCellValueFactory(new PropertyValueFactory<>("lastname"));
    col_card.setCellValueFactory(new PropertyValueFactory<>("credit_card"));
    col_admin.setCellValueFactory(new PropertyValueFactory<>("account"));
    col_status.setCellValueFactory(new PropertyValueFactory<>("status"));


    table.setItems(oblist);

  }
}