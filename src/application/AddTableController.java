package application;

import java.net.URL;
import java.util.ResourceBundle;

import Utils.DBhelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class AddTableController implements Initializable{
	@FXML private TextField txt_id;
	@FXML private TextField txt_type;
	@FXML private TextField txt_status;
	@FXML private TextField txt_orderId;
	
	 @Override
	 public void initialize(URL location, ResourceBundle resources) {
	 }
	 
	 public void on_AddConfirm(ActionEvent event){
  	      if(checknull()){
  	      String id = txt_id.getText();
  	      String type = txt_type.getText();
  	      String status = txt_status.getText();
  	      String orderId = txt_orderId.getText();

  	      DBhelper connector = new DBhelper(); 
         String insert= "insert into diningtable_info (id,type,status,orderId)"
         		+ " values ('"+id+"','"+type+"','"+status+"','"+orderId+"')";
         connector.execute(insert);
         DiningController.stage_add.close();
         DiningController.refresh();
  	      }else{
  	    	  
  	      }
    }
    public void on_AddCancel(ActionEvent event){
   	 DiningController.stage_add.close();
    }
    public boolean checknull(){
   	 if(txt_id.getText().isEmpty()){
   		 MainController.f_alert_confirmDialog("信息填写不完整", "桌号尚未填写!");
   		 return false;
   	 }else if(txt_type.getText().isEmpty()){
   		 MainController.f_alert_confirmDialog("信息填写不完整", "类型尚未填写!");
   		 return false;
   	 }else if(txt_status.getText().isEmpty()){
   		 MainController.f_alert_confirmDialog("信息填写不完整", "状态尚未填写!");
   		 return false;
   	 }else if(txt_orderId.getText().isEmpty()){
   		 MainController.f_alert_confirmDialog("信息填写不完整", "预定信息尚未填写!");
   		 return false;
   	 }else{
   		 return true;
   	 }
    }
	
}
