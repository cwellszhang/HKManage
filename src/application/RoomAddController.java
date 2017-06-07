package application;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Utils.DBhelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class RoomAddController implements Initializable{
	@FXML private TextField txt_id;
	@FXML private TextField txt_type;
	@FXML private TextField txt_price;
	@FXML private TextField txt_status;
	@FXML private TextField txt_orderId;
	@FXML private TextField txt_service;
	
	 @Override
	 public void initialize(URL location, ResourceBundle resources) {
	 }
	 
	 public void on_AddConfirm(ActionEvent event){
  	      if(checknull()){
  	      String id = txt_id.getText();
  	      String type = txt_type.getText();
  	      String price = txt_price.getText();
  	      String status = txt_status.getText();
  	      String orderId = txt_orderId.getText();
  	      String service = txt_service.getText();

  	      DBhelper connector = new DBhelper(); 
         String insert= "insert into room_info (id,type,price,status,orderId,service)"
         		+ " values ('"+id+"','"+type+"','"+price+"','"+status+"','"+orderId+"','"+service+"')";
         connector.execute(insert);
         RoomController.stage_add.close();
         RoomController.refresh();
  	      }else{
  	    	  
  	      }
    }
    public void on_AddCancel(ActionEvent event){
   	 RoomController.stage_add.close();
    }
    public boolean checknull(){
   	 if(txt_id.getText().isEmpty()){
   		 MainController.f_alert_confirmDialog("信息填写不完整", "房间号尚未填写!");
   		 return false;
   	 }else if(txt_type.getText().isEmpty()){
   		 MainController.f_alert_confirmDialog("信息填写不完整", "类型尚未填写!");
   		 return false;
   	 }else if(txt_price.getText().isEmpty()){
  		 MainController.f_alert_confirmDialog("信息填写不完整", "价格尚未填写!");
  		 return false;
   	 }else if(txt_status.getText().isEmpty()){
   		 MainController.f_alert_confirmDialog("信息填写不完整", "状态尚未填写!");
   		 return false;
   	 }else if(txt_orderId.getText().isEmpty()){
   		 MainController.f_alert_confirmDialog("信息填写不完整", "预定编号尚未填写!");
   		 return false;
   	 }else if(txt_service.getText().isEmpty()){
  		 MainController.f_alert_confirmDialog("信息填写不完整", "服务尚未填写!");
  		 return false;
   	 }else{
   		 return true;
   	 }
    }
	
}
