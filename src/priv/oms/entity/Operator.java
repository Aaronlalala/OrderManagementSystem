package priv.oms.entity;

public class Operator {
  private static String employeeid;
  private static String name;

  public Operator(String id, String input_name){
    employeeid = id;
    name = input_name;
  }

  public static String getName(){
    return name;
  }

  public static String getEmployeeid() {
    return employeeid;
  }
}
