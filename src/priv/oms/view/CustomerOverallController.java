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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import priv.oms.dao.CustomerDao;
import priv.oms.util.CustomerOverallTable;

public class CustomerOverallController implements Initializable {

  @FXML
  private TableColumn<CustomerOverallTable, String> col_add;

  @FXML
  private TableColumn<CustomerOverallTable, String> col_card;

  @FXML
  private TableColumn<CustomerOverallTable, String> col_cus;

  @FXML
  private TableColumn<CustomerOverallTable, String> col_email;

  @FXML
  private TableColumn<CustomerOverallTable, String> col_first;

  @FXML
  private TableColumn<CustomerOverallTable, String> col_last;

  @FXML
  private TableColumn<CustomerOverallTable, String> col_phone;

  @FXML
  private TableView<CustomerOverallTable> table;

  private ObservableList<CustomerOverallTable> oblist = FXCollections.observableArrayList();

  @FXML
  void click_select(ActionEvent event) {

  }

  /**
   * initialize table with all customers
   */
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    //initialize table with all customers
    //get result from SQL query result set
    try{
      ResultSet rs = CustomerDao.getAllCustomerValue();
      while(rs.next()){
        oblist.add(new CustomerOverallTable(rs.getString("customerid"),rs.getString("first name"),
            rs.getString("last name"),rs.getString("address"),rs.getString("phone number"),
            rs.getString("email"),rs.getString("credit card")));
      }
    }catch(SQLException ex){
      Logger.getLogger(ProductOverallController.class.getName()).log(Level.SEVERE,null,ex);
    }

    //customerid, first, last, phone, card, address, email
    col_cus.setCellValueFactory(new PropertyValueFactory<>("customerid"));
    col_first.setCellValueFactory(new PropertyValueFactory<>("first"));
    col_last.setCellValueFactory(new PropertyValueFactory<>("last"));
    col_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
    col_card.setCellValueFactory(new PropertyValueFactory<>("card"));
    col_add.setCellValueFactory(new PropertyValueFactory<>("address"));
    col_email.setCellValueFactory(new PropertyValueFactory<>("email"));

    table.setItems(oblist);

  }
}
