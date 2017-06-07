package application;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import Utils.DBhelper;

public class AddEntertainmentController implements Initializable {
	@FXML private Button btn_confirm;
    @FXML private Button btn_cancel;
	@FXML private TextField txt_name;
	@FXML private TextField txt_phone;
//	@FXML private TextField txt_startTime;
//	@FXML private TextField txt_endTime;
	@FXML private  ChoiceBox<String> txt_type;
	@Override
	 public void initialize(URL location, ResourceBundle resources) {
		//txt_type= new ChoiceBox<String>(FXCollections.observableArrayList(
		//		 "GYM", "KTV"));
		txt_type.setValue("GYM");
		txt_type.setItems(FXCollections.observableArrayList(
				 "GYM", "KTV"));
	 }
	public void on_AddCancel(){
		EntertainmentController.stage_add.close();
	}
	public void on_AddConfirm(){
		if(checknull()){
	   	      String name = txt_name.getText();
	   	      String phone = txt_phone.getText();
//	   	      String startTime = txt_startTime.getText();
//	   	      String endTime = txt_endTime.getText();
	   	      String type=txt_type.getValue();
              
	   	      DBhelper connector = new DBhelper(); 
	          String insert= "insert into entertainment_order (clientName,clientPhone,type,status)"
	          		+ " values ('"+name+"','"+phone+"','"+type+"','-1')";
	          connector.execute(insert);
	          EntertainmentController.stage_add.close();
	         // EntertainmentController.showall();
	   	      }
	}
	public boolean checknull(){
   	 if(txt_name.getText().isEmpty()){
   		 MainController.f_alert_confirmDialog("信息填写不完整", "姓名尚未填写!");
   		 return false;
   	 }
      else if(txt_phone.getText().isEmpty()){
   		 MainController.f_alert_confirmDialog("信息填写不完整", "电话尚未填写!");
   		 return false;
   	 }
//   	 else if(txt_startTime.getText().isEmpty()){
//   		 MainController.f_alert_confirmDialog("信息填写不完整", "开始时间尚未填写!");
//   		 return false;
//   	 }else if(txt_endTime.getText().isEmpty()){
//   		 MainController.f_alert_confirmDialog("信息填写不完整", "结束时间尚未填写!");
//   		 return false;}
   	 else{
   		 return true;
   	 }
    }

}
