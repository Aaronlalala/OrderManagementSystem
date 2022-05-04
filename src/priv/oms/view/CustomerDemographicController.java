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
import javafx.scene.chart.PieChart;
import priv.oms.dao.DashBoardDao;

public class CustomerDemographicController implements Initializable {

  @FXML
  private PieChart piechart;

  private ObservableList<PieChart.Data> piechartdata = FXCollections.observableArrayList();

  /**
   * initialize chart in  Customer Demographic
   */
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

    //initialize with piechart
    //get result from SQL query result set and draw pie chart
    try{
      //get sql result for upper chart and add to series
      ResultSet rs = DashBoardDao.getCustomerDemographic();
      while(rs.next()){
        piechartdata.add(new PieChart.Data(rs.getString(1),rs.getInt(2)));
      }

    }catch(SQLException ex){
      Logger.getLogger(ProductOverallController.class.getName()).log(Level.SEVERE,null,ex);
    }

    //add series data to bar chart
    piechart.setData(piechartdata);
  }
}
