package application;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import Utils.DBhelper;
public class EmployRegisterController implements Initializable{
	
	
	@FXML private TextField txt_name;
	@FXML private TextField txt_sex;
	@FXML private TextField txt_department;
	@FXML private TextField txt_salary;
	@FXML private TextField txt_account;
	@FXML private TextField txt_password;
	@FXML private TextField txt_priority;
	
	
	 @Override
	 public void initialize(URL location, ResourceBundle resources) {
	 }
     public void on_AddConfirm(ActionEvent event){
   	      if(checknull()){
   	      String name = txt_name.getText();
   	      String sex = txt_sex.getText();
   	      String department = txt_department.getText();
   	      String salary = txt_salary.getText();
   	      String account = txt_account.getText();
   	      String password = txt_password.getText();
   	      String priority = txt_priority.getText();

   	      DBhelper connector = new DBhelper(); 
          String insert= "insert into employee_info (name,departmentId,sex,salary,account,password,priority)"
          		+ " values ('"+name+"',"+department+",'"+sex+"',"+salary+",'"+account+"','"+password+"',"+priority+")";
          connector.execute(insert);
          EmployController.stage_add.close();
          EmployController.refresh();
   	      }else{
   	    	  
   	      }
     }
     public void on_AddCancel(ActionEvent event){
    	 EmployController.stage_add.close();
     }
     public boolean checknull(){
    	 if(txt_name.getText().isEmpty()){
    		 MainController.f_alert_confirmDialog("信息填写不完整", "姓名尚未填写!");
    		 return false;
    	 }else if(txt_sex.getText().isEmpty()){
    		 MainController.f_alert_confirmDialog("信息填写不完整", "性别尚未填写!");
    		 return false;
    	 }
    	 else if(txt_department.getText().isEmpty()){
    		 MainController.f_alert_confirmDialog("信息填写不完整", "部门号尚未填写!");
    		 return false;
    	 }
    	 else if(txt_salary.getText().isEmpty()){
    		 MainController.f_alert_confirmDialog("信息填写不完整", "工资尚未填写!");
    		 return false;
    	 }else if(txt_account.getText().isEmpty()){
    		 MainController.f_alert_confirmDialog("信息填写不完整", "账号尚未填写!");
    		 return false;
    	 }else if(txt_password.getText().isEmpty()){
    		 MainController.f_alert_confirmDialog("信息填写不完整", "密码尚未填写!");
    		 return false;
    	 }else if(txt_priority.getText().isEmpty()){
    		 MainController.f_alert_confirmDialog("信息填写不完整", "权限尚未填写!");
    		 return false;
    	 }else{
    		 return true;
    	 }
     }
	 
}
