package priv.oms.view;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import priv.oms.dao.DashBoardDao;
import priv.oms.util.TopTenTable;

public class TopTenItemController implements Initializable {

  @FXML
  private TableView<TopTenTable> jacket;

  @FXML
  private TableColumn<TopTenTable, String> jacket_color;

  @FXML
  private TableColumn<TopTenTable, String> jacket_id;

  @FXML
  private TableColumn<TopTenTable, String> jacket_name;

  @FXML
  private TableColumn<TopTenTable, String> jacket_quantity;

  @FXML
  private TableColumn<TopTenTable, String> jacket_size;

  @FXML
  private TableView<TopTenTable> shirt;

  @FXML
  private TableColumn<TopTenTable, String> shirt_color;

  @FXML
  private TableColumn<TopTenTable, String> shirt_id;

  @FXML
  private TableColumn<TopTenTable, String> shirt_name;

  @FXML
  private TableColumn<TopTenTable, String> shirt_quantity;

  @FXML
  private TableColumn<TopTenTable, String> shirt_size;

  @FXML
  private TableView<TopTenTable> trouser;

  @FXML
  private TableColumn<TopTenTable, String> trouser_color;

  @FXML
  private TableColumn<TopTenTable, String> trouser_id;

  @FXML
  private TableColumn<TopTenTable, String> trouser_name;

  @FXML
  private TableColumn<TopTenTable, String> trouser_quantity;

  @FXML
  private TableColumn<TopTenTable, String> trouser_size;

  /**
   * initialize with three table
   */  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    //initialize table with top 10 items

    //create object list
    ObservableList<TopTenTable> shirt_list = FXCollections.observableArrayList();
    ObservableList<TopTenTable> trouser_list = FXCollections.observableArrayList();
    ObservableList<TopTenTable> jacket_list = FXCollections.observableArrayList();

    //get result from SQL query result set and add to object list
    try{
      ResultSet rs_shirt = DashBoardDao.getTopShirt();
      while(rs_shirt.next()){
        //orderid, date, time, quantity, amount, firstname, lastname, credit_card, account, status;
        shirt_list.add(new TopTenTable(rs_shirt.getString("productid"),rs_shirt.getString("product name"),
            rs_shirt.getString("color"),rs_shirt.getString("size"),rs_shirt.getString("quantity")));
      }
    }catch(SQLException ex){
      Logger.getLogger(ProductOverallController.class.getName()).log(Level.SEVERE,null,ex);
    }

    try{
      ResultSet rs_trouser = DashBoardDao.getTopTrouser();
      while(rs_trouser.next()){
        //orderid, date, time, quantity, amount, firstname, lastname, credit_card, account, status;
        trouser_list.add(new TopTenTable(rs_trouser.getString("productid"),rs_trouser.getString("product name"),
            rs_trouser.getString("color"),rs_trouser.getString("size"),rs_trouser.getString("quantity")));
      }
    }catch(SQLException ex){
      Logger.getLogger(ProductOverallController.class.getName()).log(Level.SEVERE,null,ex);
    }

    try{
      ResultSet rs_jacket = DashBoardDao.getTopJacket();
      while(rs_jacket.next()){
        //orderid, date, time, quantity, amount, firstname, lastname, credit_card, account, status;
        jacket_list.add(new TopTenTable(rs_jacket.getString("productid"),rs_jacket.getString("product name"),
            rs_jacket.getString("color"),rs_jacket.getString("size"),rs_jacket.getString("quantity")));
      }
    }catch(SQLException ex){
      Logger.getLogger(ProductOverallController.class.getName()).log(Level.SEVERE,null,ex);
    }



    //set the table
    shirt_id.setCellValueFactory(new PropertyValueFactory<>("id"));
    shirt_name.setCellValueFactory(new PropertyValueFactory<>("name"));
    shirt_color.setCellValueFactory(new PropertyValueFactory<>("color"));
    shirt_size.setCellValueFactory(new PropertyValueFactory<>("size"));
    shirt_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

    trouser_id.setCellValueFactory(new PropertyValueFactory<>("id"));
    trouser_name.setCellValueFactory(new PropertyValueFactory<>("name"));
    trouser_color.setCellValueFactory(new PropertyValueFactory<>("color"));
    trouser_size.setCellValueFactory(new PropertyValueFactory<>("size"));
    trouser_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

    jacket_id.setCellValueFactory(new PropertyValueFactory<>("id"));
    jacket_name.setCellValueFactory(new PropertyValueFactory<>("name"));
    jacket_color.setCellValueFactory(new PropertyValueFactory<>("color"));
    jacket_size.setCellValueFactory(new PropertyValueFactory<>("size"));
    jacket_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));


    //add data to table
    shirt.setItems(shirt_list);
    trouser.setItems(trouser_list);
    jacket.setItems(jacket_list);
  }
}
