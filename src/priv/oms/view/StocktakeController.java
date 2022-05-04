package priv.oms.view;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import priv.oms.dao.DashBoardDao;


public class StocktakeController implements Initializable {

  @FXML
  private BarChart<String, Integer> low_bar;

  @FXML
  private BarChart<String, Integer> up_bar;

  @FXML
  private CategoryAxis x_down;

  @FXML
  private CategoryAxis x_upper;

  @FXML
  private NumberAxis y_down;

  @FXML
  private NumberAxis y_upper;


  /**
   * initialize chart in Stocktake
   */
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    XYChart.Series<String, Integer> series_up = new XYChart.Series<>(); //prepare XYChart.Series for upper chart
    XYChart.Series<String, Integer> series_low = new XYChart.Series<>(); //prepare XYChart.Series for lower chart

    //initialize with barchart
    //get result from SQL query result set and draw upper graph
    try{
      //get sql result for upper chart and add to series
      ResultSet rs_up = DashBoardDao.getStocktakeUpValue();
      while(rs_up.next()){
        series_up.getData().add(new XYChart.Data<>(rs_up.getString(1),rs_up.getInt(2)));
      }

      //get sql result for lower chart and add to series
      ResultSet rs_low = DashBoardDao.getStocktakelowValue();
      while(rs_low.next()){
        series_low.getData().add(new XYChart.Data<>(rs_low.getString(1),rs_low.getInt(2)));
      }
    }catch(SQLException ex){
      Logger.getLogger(ProductOverallController.class.getName()).log(Level.SEVERE,null,ex);
    }

    //add series data to bar chart
    up_bar.getData().add(series_up);
    low_bar.getData().add(series_low);



  }
}















