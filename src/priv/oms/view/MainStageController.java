package priv.oms.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import priv.oms.Main;
import priv.oms.entity.Operator;


public class MainStageController implements Initializable {

  @FXML
  private BorderPane contentPane;

  @FXML
  private Text inputtext;

  /**
   * write upper conner--Welcome: + username
   */
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    inputtext.setText("Welcome: "+ Operator.getName());

  }

  /**
   * user click Product_Discount button->switch the content pane
   */
  @FXML
  void clic_pro_dis_butt(ActionEvent event) throws IOException {
    System.out.println("Click product discount button!");
    contentPane.setCenter(Main.showProdcutDiscountStage());
  }

  /**
   * user click Product_Overall button->switch the content pane
   */
  @FXML
  void clic_pro_over_butt(ActionEvent event) throws IOException {
    System.out.println("Click product overall button!");
    contentPane.setCenter(Main.showProdcutOverviewStage());
  }

  /**
   * user click Order_Overall button->switch the content pane
   */
  @FXML
  void click_order_overall(ActionEvent event) throws IOException {
    System.out.println("Click order overall button!");
    contentPane.setCenter(Main.showOrderOverallStage());
  }

  /**
   * user click Order_detail button->switch the content pane
   */
  @FXML
  void click_order_detail(ActionEvent event) throws IOException {
    System.out.println("Click order detail button!");
    contentPane.setCenter(Main.showOrderDetailStage());
  }

  /**
   * user click Order_create button->switch the content pane
   */
  @FXML
  void click_order_create(ActionEvent event) throws IOException {
    System.out.println("Click order create button!");
    contentPane.setCenter(Main.showCreateOrder());
  }

  @FXML
  void click_cus_create(ActionEvent event) throws IOException {

  }

  /**
   * user click Customer_Overall button->switch the content pane
   */
  @FXML
  void click_cus_overall(ActionEvent event) throws IOException {
    System.out.println("Click customer overall button!");
    contentPane.setCenter(Main.showCustomerOverallStage());
  }

  /**
   * user click Dashboard Customer demographic button->switch the content pane
   */
  @FXML
  void click_cus_demo(ActionEvent event) throws IOException {
    contentPane.setCenter(Main.showCustomerDemographic());
  }

  /**
   * user click Dashboard Quarterly Sales button->switch the content pane
   */
  @FXML
  void click_qua_sales(ActionEvent event) throws IOException {
    contentPane.setCenter(Main.showQuarterlySales());
  }

  /**
   * user click Dashboard Customer demographic button->switch the content pane
   */
  @FXML
  void click_stock(ActionEvent event) throws IOException {
    contentPane.setCenter(Main.showStocktake());
  }

  /**
   * user click Dashboard Monthly top10  button->switch the content pane
   */
  @FXML
  void click_top(ActionEvent event) throws IOException {
    contentPane.setCenter(Main.showTopTen());
  }

}
