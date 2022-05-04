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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import priv.oms.dao.ProductDao;
import priv.oms.util.ProductOverallTable;

public class ProductOverallController implements Initializable {

  @FXML
  private BorderPane borderpane;

  @FXML
  private TableView<ProductOverallTable> table;

  @FXML
  private TableColumn<ProductOverallTable, String> col_color;

  @FXML
  private TableColumn<ProductOverallTable, String> col_colorcode;

  @FXML
  private TableColumn<ProductOverallTable, String> col_descirption;

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

  @FXML
  private TextField priceEnd;

  @FXML
  private TextField priceStart;

  @FXML
  private ChoiceBox<String> productChoiceBox;

  @FXML
  private ChoiceBox<String> colorChoiceBox;

  @FXML
  private ChoiceBox<String> sizeChoiceBox;

  private ObservableList<ProductOverallTable> oblist = FXCollections.observableArrayList();

  /**
   * set item value to choice box
   * initialize table with all products
   */
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    //set item value to choice box
    ObservableList<String> product_cb = FXCollections.observableArrayList("","Shirt", "Trouser", "Jacket");
    productChoiceBox.setItems(product_cb);
    ObservableList<String> color_cb = FXCollections.observableArrayList("","Black", "White", "Grey");
    colorChoiceBox.setItems(color_cb);
    ObservableList<String> size_cb = FXCollections.observableArrayList("","S", "M", "L", "XL");
    sizeChoiceBox.setItems(size_cb);

    //initialize table with all products
    //get result from SQL query result set
    try{
      ResultSet rs = ProductDao.getAllValue();
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
    col_descirption.setCellValueFactory(celldata->celldata.getValue().getDiscription());

    table.setItems(oblist);

  }


  @FXML
  void click_select(ActionEvent event) {
    borderpane.setCenter(new Pane());
  }
}

