package priv.oms.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PopupUtil {
  /**
   * error message popup
   * @param message the message shows in popup
   */
  public static void popup(String type, String message){
    Alert alert;
    switch (type){
      case "error":
        alert = new Alert(AlertType.ERROR);
        alert.titleProperty().set("Error!");
        break;
      case "infor":
        alert = new Alert(AlertType.INFORMATION);
        alert.titleProperty().set("Alert!");
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + type);
    }
    alert.headerTextProperty().set(message);
    alert.showAndWait();
  }
}
