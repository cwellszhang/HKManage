package application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Utils.DBhelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class AddDishReserveController implements Initializable{
	@FXML private TextField txt_tableId;
	@FXML private TextField txt_name;
	@FXML private TextField txt_number;
	@FXML private TextField txt_dishId;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	public void on_AddConfirm(ActionEvent event){
	      if(checknull()){
	      String tableId = txt_tableId.getText();
	      String name = txt_name.getText();
	      String number = txt_number.getText();
	      String dishId = txt_dishId.getText();

	      DBhelper connector = new DBhelper(); 
	      String query = "select * from dish_info where id="+dishId+";";
	      ResultSet result0 = connector.query(query);
	      String type = "";
	      try {
		         while (result0.next()) {
					type = result0.getString("type");
		          }
		       }
				  catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	      connector = new DBhelper();
	      String insert= "insert into dish_order (tableId,dishId,name,type,number)"
     		+ " values ('"+tableId+"','"+dishId+"','"+name+"','"+type+"','"+number+"')";
	      connector.execute(insert);
/*	      connector = new DBhelper();
	      query = "select id from diningtable_order where TableId="+tableId+";";
	      ResultSet result = connector.query(query);
	      String orderIds = "";
		       try {
		         while (result.next()) {
					orderIds += result.getString("id");
					orderIds += "/";
		          }
		       }
				  catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		  orderIds = orderIds.substring(0, orderIds.length()-1);
		  connector = new DBhelper();
		  String update = "update diningtable_info set orderId='"+orderIds+"' where id="+tableId+";";
		  connector.execute(update);*/
	      DishReserveController.stage_add.close();
	      DishReserveController.refresh();
	      DiningController.refresh();
	      }else{
	    	  
	      }
	}
  
  public void on_AddCancel(ActionEvent event){
    	 DishReserveController.stage_add.close();
  }

  public boolean checknull(){
   	 if(txt_tableId.getText().isEmpty()){
   		 MainController.f_alert_confirmDialog("信息填写不完整", "桌号尚未填写!");
   		 return false;
   	 }else if(txt_name.getText().isEmpty()){
   		 MainController.f_alert_confirmDialog("信息填写不完整", "名称尚未填写!");
   		 return false;
   	 }else if(txt_number.getText().isEmpty()){
   		 MainController.f_alert_confirmDialog("信息填写不完整", "数量尚未填写!");
   		 return false;
   	 }else if(txt_dishId.getText().isEmpty()){
 		 MainController.f_alert_confirmDialog("信息填写不完整", "菜品编号尚未填写!");
 		 return false;
   	 }else{
   		 return true;
   	 }
    }
}
