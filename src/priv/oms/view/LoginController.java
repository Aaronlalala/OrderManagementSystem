package priv.oms.view;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import priv.oms.Main;
import priv.oms.dao.LoginDao;

public class LoginController {

  @FXML
  private Button loginButton;

  @FXML
  private TextField passwordField;

  @FXML
  private TextField AccountField;


  /**
   * user click login button and system verify the identity
   * @param event user click login button
   */
  @FXML
  void login(ActionEvent event) throws IOException {
    // get account and password
    System.out.println("Click login button");
    String account = AccountField.getText();
    String password = passwordField.getText();

    //match account and password with data in database
    boolean login_try = LoginDao.loginStart(account, password);//true:login success, false:login fail
    if (login_try){
      System.out.println("Login Success!");
      Main.showMainStage(); //if login successfully, jump to Main Stage
    }else{
      popup("Account or password is wrong!");
      System.out.println("Login Fail!");
    }
  }
  /**
   * error message popup
   * @param message     the message shows in popup
   */
  public void popup(String message){
    Alert alert = new Alert(AlertType.ERROR);
    alert.titleProperty().set("Error!");
    alert.headerTextProperty().set(message);
    alert.showAndWait();
  }

}
