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
import javafx.scene.chart.XYChart;
import priv.oms.dao.DashBoardDao;


public class QuarterlySalesController implements Initializable {

  @FXML
  private BarChart<String, Integer> quantity_chart;

  @FXML
  private BarChart<String, Integer> sales_chart;

  /**
   * initialize chart in Quarterly Sales
   */
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    XYChart.Series<String, Integer> series_left = new XYChart.Series<>(); //prepare XYChart.Series for upper chart
    XYChart.Series<String, Integer> series_right = new XYChart.Series<>(); //prepare XYChart.Series for lower chart

    //initialize with barchart
    //get result from SQL query result set and draw upper graph
    try{
      //get sql result for right chart and add to series
      ResultSet rs_left = DashBoardDao.getQuarterlySalesQuantityValue();
      while(rs_left.next()){
        series_left.getData().add(new XYChart.Data<>(rs_left.getString(1),rs_left.getInt(2)));
      }

      //get sql result for left chart and add to series
      ResultSet rs_right = DashBoardDao.getQuarterlySalesValue();
      while(rs_right.next()){
        series_right.getData().add(new XYChart.Data<>(rs_right.getString(1),rs_right.getInt(2)));
      }
    }catch(SQLException ex){
      Logger.getLogger(ProductOverallController.class.getName()).log(Level.SEVERE,null,ex);
    }

    //add series data to bar chart
    quantity_chart.getData().add(series_left);
    sales_chart.getData().add(series_right);


  }
}

