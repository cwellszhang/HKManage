package application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Infomation.Dining;
import Utils.DBhelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class AddDiningReserveController implements Initializable{
	@FXML private TextField txt_tableId;
	@FXML private TextField txt_clientName;
	@FXML private TextField txt_clientNumber;
	@FXML private TextField txt_dishId;
	@FXML private TextField txt_clientPhone;
	@FXML private TextField txt_price;
	@FXML private TextField txt_waiterName;
	@FXML private TextField txt_startTime;
	@FXML private TextField txt_type;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	public void on_AddConfirm(ActionEvent event){
	      if(checknull()){
	      String tableId = txt_tableId.getText();
	      String price = txt_price.getText();
	      String clientName = txt_clientName.getText();
	      String clientNumber = txt_clientNumber.getText();
	      String clientPhone = txt_clientPhone.getText();
	      String dishId = txt_dishId.getText();
	      String startTime = txt_startTime.getText();
	      String waiterName = txt_waiterName.getText();
	      String type = txt_type.getText();

	      DBhelper connector = new DBhelper(); 
	      String insert= "insert into diningtable_order (type,TableId,price,clientName,clientNumber,clientPhone,dishId,waiterName,startTime)"
     		+ " values ('"+type+"','"+tableId+"','"+price+"','"+clientName+"','"+clientNumber+"','"+clientPhone+"','"+dishId+"','"+waiterName+"','"+startTime+"')";
	      connector.execute(insert);
	      connector = new DBhelper();
	      String query = "select id from diningtable_order where TableId="+tableId+";";
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
		  connector.execute(update);
	      TableReserveController.stage_add.close();
	      TableReserveController.refresh();
	      DiningController.refresh();
	      }else{
	    	  
	      }
	}
  
  public void on_AddCancel(ActionEvent event){
    	 TableReserveController.stage_add.close();
  }

  public boolean checknull(){
   	 if(txt_tableId.getText().isEmpty()){
   		 MainController.f_alert_confirmDialog("信息填写不完整", "桌号尚未填写!");
   		 return false;
   	 }else if(txt_price.getText().isEmpty()){
  		 MainController.f_alert_confirmDialog("信息填写不完整", "价格尚未填写!");
  		 return false;
   	 }else if(txt_clientName.getText().isEmpty()){
   		 MainController.f_alert_confirmDialog("信息填写不完整", "客户姓名尚未填写!");
   		 return false;
   	 }else if(txt_clientNumber.getText().isEmpty()){
   		 MainController.f_alert_confirmDialog("信息填写不完整", "人数尚未填写!");
   		 return false;
   	 }else if(txt_clientPhone.getText().isEmpty()){
 		 MainController.f_alert_confirmDialog("信息填写不完整", "联系方式尚未填写!");
 		 return false;
   	 }else if(txt_dishId.getText().isEmpty()){
 		 MainController.f_alert_confirmDialog("信息填写不完整", "菜品尚未填写!");
 		 return false;
   	 }else if(txt_waiterName.getText().isEmpty()){
  		 MainController.f_alert_confirmDialog("信息填写不完整", "服务员尚未填写!");
  		 return false;
   	 }else if(txt_startTime.getText().isEmpty()){
 		 MainController.f_alert_confirmDialog("信息填写不完整", "时间尚未填写!");
 		 return false;
   	}else if(txt_type.getText().isEmpty()){
		 MainController.f_alert_confirmDialog("信息填写不完整", "类型尚未填写!");
		 return false;
   	 }else{
   		 return true;
   	 }
    }
}
