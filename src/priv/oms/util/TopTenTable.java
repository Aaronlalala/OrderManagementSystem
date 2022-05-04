package priv.oms.util;

/**
 * this class is prepare for generate the table in Monthly Top 10 Item page
 */
public class TopTenTable {
  String id, name, color, size, quantity;

  public TopTenTable(String id, String name, String color, String size, String quantity) {
    this.id = id;
    this.name = name;
    this.color = color;
    this.size = size;
    this.quantity = quantity;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getQuantity() {
    return quantity;
  }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }
}
