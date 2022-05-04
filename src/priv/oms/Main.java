package priv.oms;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import priv.oms.entity.Order;
import priv.oms.entity.Product;
import priv.oms.util.DBUtil;

public class Main extends Application {
  private Stage primaryStage;
  private static BorderPane mainLayout;

  /**
   * start with login view
   */
  @Override
  public void start(Stage primaryStage) throws IOException {
    this.primaryStage = primaryStage;
    this.primaryStage.setTitle("Order Management System");
    showLoginView();
  }

  /**
   * launch login view
   */
  private void showLoginView() throws IOException{
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(Main.class.getResource("fxml/Login.fxml"));
    mainLayout = loader.load();
    Scene scene = new Scene(mainLayout);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /**
   * launch MainStage view
   */
  public static void showMainStage() throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(Main.class.getResource("fxml/MainStage.fxml"));
    BorderPane mainStage = loader.load();
    mainLayout.setCenter(mainStage);
  }

  /**
   * launch Product_Control view
   */
  public static BorderPane showProdcutOverviewStage() throws IOException{
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(Main.class.getResource("fxml/ProductOverall.fxml"));
    BorderPane product_overall_stage = loader.load();
    return product_overall_stage;
  }

  /**
   * launch Product_Discount view
   */
  public static BorderPane showProdcutDiscountStage() throws IOException{
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(Main.class.getResource("fxml/ProductDiscount.fxml"));
    BorderPane product_discount_stage = loader.load();
    return product_discount_stage;
  }

  /**
   * launch Product_Discount view
   */
  public static BorderPane showOrderOverallStage() throws IOException{
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(Main.class.getResource("fxml/OrderOverall.fxml"));
    BorderPane order_overall_stage = loader.load();
    return order_overall_stage;
  }

  /**
   * launch Product_Discount view
   */
  public static BorderPane showOrderDetailStage() throws IOException{
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(Main.class.getResource("fxml/OrderDetail.fxml"));
    BorderPane order_detail_stage = loader.load();
    return order_detail_stage;
  }

  /**
   * launch Customer_Overall view
   */
  public static BorderPane showCustomerOverallStage() throws IOException{
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(Main.class.getResource("fxml/CustomerOverall.fxml"));
    BorderPane customer_overall_stage = loader.load();
    return customer_overall_stage;
  }

  /**
   * launch Dash_Stocktake view
   */
  public static SplitPane showStocktake() throws IOException{
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(Main.class.getResource("fxml/Stocktake.fxml"));
    SplitPane stocktake_stage = loader.load();
    return stocktake_stage;
  }

  /**
   * launch Dash_Quarterly sales view
   */
  public static SplitPane showQuarterlySales() throws IOException{
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(Main.class.getResource("fxml/QuartelySales.fxml"));
    SplitPane QuarterlySales_stage = loader.load();
    return QuarterlySales_stage;
  }

  /**
   * launch Customer demographic view
   */
  public static AnchorPane showCustomerDemographic () throws IOException{
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(Main.class.getResource("fxml/CustomerDemographic.fxml"));
    AnchorPane CustomerDemographic_stage = loader.load();
    return CustomerDemographic_stage;
  }

  /**
   * launch Top 10 view
   */
  public static BorderPane showTopTen () throws IOException{
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(Main.class.getResource("fxml/TopTenItem.fxml"));
    BorderPane TopTen_stage = loader.load();
    return TopTen_stage;
  }

  /**
   * launch create order view
   */
  public static BorderPane showCreateOrder () throws IOException{
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(Main.class.getResource("fxml/CreateOrder.fxml"));
    BorderPane CreateOrder_stage = loader.load();
    return CreateOrder_stage;
  }

  public static void main(String[] args) {
    DBUtil dbutil = new DBUtil();
    launch(args);
  }
}
