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

public class VipRegisterController implements Initializable{
	@FXML private TextField txt_name;
	@FXML private TextField txt_sex;
	@FXML private TextField txt_phone;
	@FXML private TextField txt_address;
	@FXML private TextField txt_degree;
	@FXML private DatePicker txt_time;
	
	
	 @Override
	 public void initialize(URL location, ResourceBundle resources) {
	 }
     public void on_AddConfirm(ActionEvent event){
   	      if(checknull()){
   	      String name = txt_name.getText();
   	      String sex = txt_sex.getText();
   	      String phone = txt_phone.getText();
   	      String address = txt_address.getText();
   	      String degree = txt_degree.getText();
   	      LocalDate date = txt_time.getValue();
  
//          DateFormat df = new SimpleDateFormat("yyyy-dd-MM");
//          String dateTimeString = df.format(txt_time.getValue());
   	      DBhelper connector = new DBhelper(); 
          String insert= "insert into member_info (name,sex,phone,address,degree,startTime)"
          		+ " values ('"+name+"','"+sex+"','"+phone+"','"+address+"','"+degree+"','"+date+"')";
          connector.execute(insert);
          VipController.stage_add.close();
          VipController.refresh();
   	      }else{
   	    	  
   	      }
     }
     public void on_AddCancel(ActionEvent event){
    	 VipController.stage_add.close();
     }
     public boolean checknull(){
    	 if(txt_name.getText().isEmpty()){
    		 MainController.f_alert_confirmDialog("信息填写不完整", "姓名尚未填写!");
    		 return false;
    	 }else if(txt_sex.getText().isEmpty()){
    		 MainController.f_alert_confirmDialog("信息填写不完整", "性别尚未填写!");
    		 return false;
    	 }
    	 else if(txt_phone.getText().isEmpty()){
    		 MainController.f_alert_confirmDialog("信息填写不完整", "手机号尚未填写!");
    		 return false;
    	 }
    	 else if(txt_address.getText().isEmpty()){
    		 MainController.f_alert_confirmDialog("信息填写不完整", "地址尚未填写!");
    		 return false;
    	 }else if(txt_degree.getText().isEmpty()){
    		 MainController.f_alert_confirmDialog("信息填写不完整", "会员等级尚未填写!");
    		 return false;
    	 }else if(txt_time.getValue()==null){
    		 MainController.f_alert_confirmDialog("信息填写不完整", "注册时间尚未填写!");
    		 return false;
    	 }else{
    		 return true;
    	 }
     }
	
}
