package priv.oms.view;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javax.swing.Popup;
import priv.oms.entity.Customer;
import priv.oms.entity.Operator;
import priv.oms.entity.Order;
import priv.oms.entity.Product;
import priv.oms.util.CreateOrderTable;
import priv.oms.util.PopupUtil;

public class CreateOrderController implements Initializable {

  @FXML
  private TextField cardField;

  @FXML
  private TextField phoneField;

  @FXML
  private BorderPane borderpane;

  @FXML
  private TableColumn<CreateOrderTable, String> col_color;

  @FXML
  private TableColumn<CreateOrderTable, String> col_dicount;

  @FXML
  private TableColumn<CreateOrderTable, String> col_price;

  @FXML
  private TableColumn<CreateOrderTable, String> col_product;

  @FXML
  private TableColumn<CreateOrderTable, String> col_quantity;

  @FXML
  private TableColumn<CreateOrderTable, String> col_size;

  @FXML
  private ChoiceBox<String> colorChoiceBox;

  @FXML
  private ChoiceBox<String> productChoiceBox;

  @FXML
  private ChoiceBox<String> sizeChoiceBox;

  @FXML
  private TextField quantityField;

  @FXML
  private TextField orderidField;

  @FXML
  private TableView<CreateOrderTable> table;

  private ObservableList<CreateOrderTable> productlist = FXCollections.observableArrayList();

  /**
   * set item value to choice box
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

    //set up table
    col_product.setCellValueFactory(new PropertyValueFactory<>("name"));
    col_color.setCellValueFactory(new PropertyValueFactory<>("color"));
    col_size.setCellValueFactory(new PropertyValueFactory<>("size"));
    col_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
    col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
    col_dicount.setCellValueFactory(new PropertyValueFactory<>("discount"));
  }

  @FXML
  void click_add(ActionEvent event) {
    String product = productChoiceBox.getSelectionModel().getSelectedItem();
    String color = colorChoiceBox.getSelectionModel().getSelectedItem();
    String size = sizeChoiceBox.getSelectionModel().getSelectedItem();
    String quantity = quantityField.getText();
    System.out.println(product+color+size+quantity);
    Product product1 = new Product(product,color,size,quantity);
    productlist.add(new CreateOrderTable(product1.getName(), product1.getColor(),product1.getSize(),product1.getQuantity(),
        product1.getPrice(),product1.getDiscount()));
    Product.products.add(product1);
    table.setItems(productlist);
    borderpane.setCenter(table);
  }

  @FXML
  void click_auto(ActionEvent event) {
    orderidField.setText(Order.getOrderidFromDB());
  }

  @FXML
  void click_create(ActionEvent event) {
    //first valid phone
    String phone = phoneField.getText();
    String creditcard = cardField.getText();
    if(Customer.validPhone(phone)){ //if the customer exists
      //validate credit card
      if(Customer.validCreditCard(creditcard)){ // if the credit card number is correct,create order
        String orderid = Order.getOrderidFromDB();
        String total_quan = Product.getQuantityProducts(Product.products);
        String total_amount = Product.getAmountProducts(Product.products);
        String cusid = Customer.getCustomerValueFromDB("customerid", phone);
        String empid = Operator.getEmployeeid();
        String date = LocalDate.now().toString();
        String time = LocalTime.now().toString();
        if(Product.validProducts(Product.products)){// if all products have quantity, create normal order
          String status = "prepare";
          new Order(orderid, total_quan, total_amount, cusid,
              empid, status, date, time);
          PopupUtil.popup("infor","Order create! Now prepare!");
        }else{//else create backorder
          String status = "backorder";
          PopupUtil.popup("infor","Exist unavailable item! Backorder create!");
          new Order(orderid, total_quan, total_amount, cusid,
              empid, status, date, time);
        }
      }else{
        PopupUtil.popup("error","Wrong credit card number!");
      }
    }else{
      PopupUtil.popup("error","Please create a account for this customer!");
    }


    //next valid credit card


    //valid order and create order

  }



}