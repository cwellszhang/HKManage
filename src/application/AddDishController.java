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

public class AddDishController implements Initializable{
	@FXML private TextField txt_name;
	@FXML private TextField txt_type;
	@FXML private TextField txt_price;
	@FXML private TextField txt_elementId;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	public void on_AddConfirm(ActionEvent event){
	      if(checknull()){
	      String name = txt_name.getText();
	      String type = txt_type.getText();
	      String price = txt_price.getText();
	      String elementId = txt_elementId.getText();

	      DBhelper connector = new DBhelper(); 
	      String insert= "insert into dish_info (name,type,price,elementId)"
     		+ " values ('"+name+"','"+type+"','"+price+"','"+elementId+"')";
	      connector.execute(insert);
	      DishController.stage_add.close();
	      DishController.refresh();
	      }else{
	    	  
	      }
	}
  
  public void on_AddCancel(ActionEvent event){
    	 DishController.stage_add.close();
  }

  public boolean checknull(){
   	 if(txt_name.getText().isEmpty()){
   		 MainController.f_alert_confirmDialog("信息填写不完整", "名称尚未填写!");
   		 return false;
   	 }else if(txt_type.getText().isEmpty()){
   		 MainController.f_alert_confirmDialog("信息填写不完整", "类型尚未填写!");
   		 return false;
   	 }else if(txt_price.getText().isEmpty()){
   		 MainController.f_alert_confirmDialog("信息填写不完整", "价格尚未填写!");
   		 return false;
   	 }else if(txt_elementId.getText().isEmpty()){
 		 MainController.f_alert_confirmDialog("信息填写不完整", "食材尚未填写!");
 		 return false;
   	 }else{
   		 return true;
   	 }
    }

}
