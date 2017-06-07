package application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import Utils.DBhelper;
import Infomation.Employer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainController implements Initializable{
	   @FXML private Text txt_id;
	   @FXML private Text txt_name;
	   @FXML private Text txt_gender;
	   @FXML private Text txt_department;
	   @FXML private Text txt_job;
	   @FXML private Text txt_priority;
//	   private Main application;
//	   
//	   public void setApp(Main application){  
//	        this.application = application;  
//	    }  
	   @Override
	   public void initialize(URL location, ResourceBundle resources) {
	       // TODO (don't really need to do anything here)

		   DBhelper connector = new DBhelper(); 
	       String query= "select * from employee_info where id="+LoginPage.id;
	       ResultSet result = connector.query(query);
	       try {
	         while (result.next()) {
				System.out.println(result.getString("account"));
			     txt_id.setText(result.getString("id"));
			     txt_name.setText(result.getString("name"));
			     String sex= result.getString("sex");
			     if(sex==null){
			          txt_gender.setText("男");
			     }else if (sex.equals("1")) { 
			          txt_gender.setText("女");
			     }else{
			    	 txt_gender.setText("男");
			     }
			     txt_department.setText(result.getString("departmentId"));
			     txt_priority.setText(result.getString("priority"));
	          }
	       }
			  catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }
	   public boolean check_priority(){
		   DBhelper connector = new DBhelper(); 
	       String query= "select * from employee_info where id="+LoginPage.id;
	       ResultSet result = connector.query(query);
	       Integer i ;
	       i=10;//默认最低权限10
	       try {
		         while (result.next()) {
				      i=Integer.parseInt(result.getString("priority"));
		          }
		       }
				  catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		    // 权限大于3，无权查看员工信息
		    if (i>3){
		    	  return false;
		    }else{
		    	  return true;
		    }
		 
	   }
	   
	   public void start_employer(ActionEvent event){
		   if(check_priority()){
		   try {
			    Stage stage = new Stage();
				Parent root = FXMLLoader.load(getClass()
						.getResource("/application/Employer.fxml"));
				Scene scene = new Scene(root);
			    stage.setTitle("员工管理系统");
				stage.setScene(scene);
				stage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		   }else{
			   f_alert_confirmDialog("权限警告","对不起，您无权查看该信息");
		   }
		   
	   }
	   public void start_vip(ActionEvent event){
		   if(check_priority()){
		   try {
			    Stage stage = new Stage();
				Parent root = FXMLLoader.load(getClass()
						.getResource("/application/Vip.fxml"));
				Scene scene = new Scene(root);
			    stage.setTitle("贵宾管理系统");
				stage.setScene(scene);
				stage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		   }else{
			   f_alert_confirmDialog("权限警告","对不起，您无权查看该信息");
		   }
		   
	   }
	   
	   public void start_park(ActionEvent event){
		   if(check_priority()){
		   try {
			    Stage stage = new Stage();
				Parent root = FXMLLoader.load(getClass()
						.getResource("/application/Park.fxml"));
				Scene scene = new Scene(root);
			    stage.setTitle("车库管理系统");
				stage.setScene(scene);
				stage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		   }else{
			   f_alert_confirmDialog("权限警告","对不起，您无权查看该信息");
		   }
		   
	   }
	   
	   public void start_entertainment(ActionEvent event){
		   if(check_priority()){
		   try {
			    Stage stage = new Stage();
				Parent root = FXMLLoader.load(getClass()
						.getResource("/application/Entertainment.fxml"));
				Scene scene = new Scene(root);
			    stage.setTitle("娱乐订单系统");
				stage.setScene(scene);
				stage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		   }else{
			   f_alert_confirmDialog("权限警告","对不起，您无权查看该信息");
		   }
		   
	   }
	   
	   public void start_room(ActionEvent event){
		   if(check_priority()){
		   try {
			    Stage stage = new Stage();
				Parent root = FXMLLoader.load(getClass()
						.getResource("/application/Room.fxml"));
				Scene scene = new Scene(root);
			    stage.setTitle("客房管理系统");
				stage.setScene(scene);
				stage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		   }else{
			   f_alert_confirmDialog("权限警告","对不起，您无权查看该信息");
		   }
		   
	   }
	   /**
	     * 弹出一个通用的确定对话框
	     * @param p_header 对话框的信息标题
	     * @param p_message 对话框的信息
	     * @return 用户点击了是或否
	     */
	    public static boolean f_alert_confirmDialog(String p_header,String p_message){
//	        按钮部分可以使用预设的也可以像这样自己 new 一个
	        Alert _alert = new Alert(Alert.AlertType.WARNING);
//	        设置窗口的标题
//	        _alert.setTitle(p_header);
	        _alert.setHeaderText(p_header);
	        _alert.setContentText(p_message);
//	        设置对话框的 icon 图标，参数是主窗口的 stage
//	        showAndWait() 将在对话框消失以前不会执行之后的代码
	        Optional<ButtonType> _buttonType = _alert.showAndWait();
//	        根据点击结果返回
	        if(_buttonType.get().getButtonData().equals(ButtonBar.ButtonData.YES)){
	            return true;
	        }
	        else {
	            return false;
	        }
	    }
}
