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

public class AddRoomReserveController implements Initializable{
	@FXML private TextField txt_roomId;
	@FXML private TextField txt_type;
	@FXML private TextField txt_status;
	@FXML private TextField txt_client1;
	@FXML private TextField txt_client1ID;
	@FXML private TextField txt_client2;
	@FXML private TextField txt_client2ID;
	@FXML private TextField txt_clientPhone;
	@FXML private TextField txt_price;
	@FXML private TextField txt_breakfast;
	@FXML private TextField txt_service;
	@FXML private TextField txt_day;
	@FXML private TextField txt_startTime;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	public void on_AddConfirm(ActionEvent event){
	      if(checknull()){
	      String roomId = txt_roomId.getText();
	      String type = txt_type.getText();
	      String price = txt_price.getText();
	      String status = txt_status.getText();
	      String client1 = txt_client1.getText();
	      String client1ID = txt_client1ID.getText();
	      String client2 = txt_client2.getText();
	      String client2ID = txt_client2ID.getText();
	      String clientPhone = txt_clientPhone.getText();
	      String breakfast = txt_breakfast.getText();
	      String day = txt_day.getText();
	      String startTime = txt_startTime.getText();
	      String service = txt_service.getText();

	      DBhelper connector = new DBhelper(); 
     String insert= "insert into room_order (roomId,type,status,clientName1,clientID1,clientName2,clientID2,clientPhone,price, breakfast,service,day,startTime)"
     		+ " values ('"+roomId+"','"+type+"','"+status+"','"+client1+"','"+client1ID+"','"+client2+"','"+client2ID+"','"+clientPhone+"','"+price+"','"+breakfast+"','"+service+"','"+day+"','"+startTime+"')";
     connector.execute(insert);
     connector = new DBhelper();
     String query = "select id from room_order where roomId="+roomId+";";
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
	  String update = "update room_info set orderId='"+orderIds+"' where id="+roomId+";";
	  connector.execute(update);
     RoomReserveController.stage_add.close();
     RoomReserveController.refresh();
     RoomController.refresh();
	      }else{
	    	  
	      }
	}
  
  public void on_AddCancel(ActionEvent event){
    	 RoomReserveController.stage_add.close();
  }

  public boolean checknull(){
   	 if(txt_roomId.getText().isEmpty()){
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
   	 }else if(txt_client1.getText().isEmpty()){
   		 MainController.f_alert_confirmDialog("信息填写不完整", "客户1姓名尚未填写!");
   		 return false;
   	 }else if(txt_client1ID.getText().isEmpty()){
   		 MainController.f_alert_confirmDialog("信息填写不完整", "客户1身份证尚未填写!");
   		 return false;
   	 }else if(txt_client2.getText().isEmpty()){
  		 MainController.f_alert_confirmDialog("信息填写不完整", "客户2姓名尚未填写!");
  		 return false;
   	 }else if(txt_client2ID.getText().isEmpty()){
  		 MainController.f_alert_confirmDialog("信息填写不完整", "客户2身份证尚未填写!");
  		 return false;
   	 }else if(txt_clientPhone.getText().isEmpty()){
 		 MainController.f_alert_confirmDialog("信息填写不完整", "联系方式尚未填写!");
 		 return false;
   	 }else if(txt_breakfast.getText().isEmpty()){
 		 MainController.f_alert_confirmDialog("信息填写不完整", "早餐信息尚未填写!");
 		 return false;
   	 }else if(txt_service.getText().isEmpty()){
 		 MainController.f_alert_confirmDialog("信息填写不完整", "服务信息尚未填写!");
 		 return false;
   	 }else if(txt_day.getText().isEmpty()){
  		 MainController.f_alert_confirmDialog("信息填写不完整", "日期尚未填写!");
  		 return false;
   	 }else if(txt_startTime.getText().isEmpty()){
 		 MainController.f_alert_confirmDialog("信息填写不完整", "时间尚未填写!");
 		 return false;
   	 }else{
   		 return true;
   	 }
    }


}
