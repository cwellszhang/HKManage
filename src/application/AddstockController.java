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

public class AddstockController implements Initializable{
	@FXML private TextField txt_name;
	@FXML private TextField txt_type;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	public void on_AddConfirm(ActionEvent event){
	      if(checknull()){
	      String name = txt_name.getText();
	      String type = txt_type.getText();

	      DBhelper connector = new DBhelper(); 
	      String insert= "insert into dish_material_info (name,type)"
     		+ " values ('"+name+"','"+type+"')";
	      connector.execute(insert);
	      stockController.stage_add.close();
	      stockController.refresh();
	      }else{
	    	  
	      }
	}
  
  public void on_AddCancel(ActionEvent event){
    	 stockController.stage_add.close();
  }

  public boolean checknull(){
   	 if(txt_name.getText().isEmpty()){
   		 MainController.f_alert_confirmDialog("信息填写不完整", "名称尚未填写!");
   		 return false;
   	 }else if(txt_type.getText().isEmpty()){
   		 MainController.f_alert_confirmDialog("信息填写不完整", "类型尚未填写!");
   		 return false;
   	 }else{
   		 return true;
   	 }
    }

}
