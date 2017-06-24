package application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import Infomation.RoomOrder;
import Infomation.Vip;
import Utils.DBhelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class RoomReserveController  implements Initializable{
	@FXML private Button btn_add;
	@FXML private Button btn_delete;
	@FXML private Button btn_search;
	@FXML private Button btn_showall;
	@FXML private TableView<RoomOrder> table;
	@FXML private TableColumn<RoomOrder,String> col_id;
	@FXML private TableColumn<RoomOrder,String> col_roomId;
	@FXML private TableColumn<RoomOrder,String> col_type;
	@FXML private TableColumn<RoomOrder,String> col_status;
	@FXML private TableColumn<RoomOrder,String> col_client1;
	@FXML private TableColumn<RoomOrder,String> col_phone;
	@FXML private TableColumn<RoomOrder,String> col_price;
	@FXML private TableColumn<RoomOrder,String> col_breakfast;
	@FXML private TableColumn<RoomOrder,String> col_service;
	@FXML private TableColumn<RoomOrder,String> col_time;
	
	
	private final static ObservableList<RoomOrder> List = FXCollections.observableArrayList(); 
	
    public static Stage stage_add = new Stage();
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
			   col_id.setCellValueFactory(new PropertyValueFactory<RoomOrder,String>("id"));
			   col_roomId.setCellValueFactory(new PropertyValueFactory<RoomOrder,String>("roomId"));
			   col_type.setCellValueFactory(new PropertyValueFactory<RoomOrder,String>("type"));
			   col_status.setCellValueFactory(new PropertyValueFactory<RoomOrder,String>("status"));
			   col_client1.setCellValueFactory(new PropertyValueFactory<RoomOrder,String>("clientName1"));
			   col_phone.setCellValueFactory(new PropertyValueFactory<RoomOrder,String>("clientPhone"));
			   col_price.setCellValueFactory(new PropertyValueFactory<RoomOrder,String>("price"));
			   col_breakfast.setCellValueFactory(new PropertyValueFactory<RoomOrder,String>("breakfast"));
			   col_service.setCellValueFactory(new PropertyValueFactory<RoomOrder,String>("service"));
			   col_time.setCellValueFactory(new PropertyValueFactory<RoomOrder,String>("day"));
			   table.setItems(List);
		       showall();
		   }
    
    public static void refresh(){
 	   List.clear();
		   DBhelper connector = new DBhelper(); 
	       String query= "select * from room_order";
	       ResultSet result = connector.query(query);
	       try {
	         while (result.next()) {

				RoomOrder tmp = new RoomOrder();
				tmp.setId(result.getString("id"));
				tmp.setRoomId(result.getString("roomId"));				
				tmp.setType(result.getString("type"));				
				tmp.setStatus(result.getString("status"));
				tmp.setClientName1(result.getString("clientName1"));
				tmp.setClientID1(result.getString("clientID1"));
				tmp.setClientName2(result.getString("clientName2"));
				tmp.setClientID2(result.getString("clientID2"));
				tmp.setClientPhone(result.getString("clientPhone"));
				tmp.setPrice(result.getString("price"));
				tmp.setBreakfast(result.getString("breakfast"));
				tmp.setService(result.getString("service"));
				tmp.setDay(result.getString("day"));
				tmp.setStartTime(result.getString("startTime"));
				tmp.setEndTime(result.getString("endTime"));				
				List.add(tmp);
	          }
	       }
			  catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
   }
    
    public void showall(){
		   List.clear();
		   DBhelper connector = new DBhelper(); 
	       String query= "select * from room_order";
	       ResultSet result = connector.query(query);
	       try {
	         while (result.next()) {

				RoomOrder tmp = new RoomOrder();
				tmp.setId(result.getString("id"));
				tmp.setRoomId(result.getString("roomId"));				
				tmp.setType(result.getString("type"));				
				tmp.setStatus(result.getString("status"));
				tmp.setClientName1(result.getString("clientName1"));
				tmp.setClientID1(result.getString("clientID1"));
				tmp.setClientName2(result.getString("clientName2"));
				tmp.setClientID2(result.getString("clientID2"));
				tmp.setClientPhone(result.getString("clientPhone"));
				tmp.setPrice(result.getString("price"));
				tmp.setBreakfast(result.getString("breakfast"));
				tmp.setService(result.getString("service"));
				tmp.setDay(result.getString("day"));
				tmp.setStartTime(result.getString("startTime"));
				tmp.setEndTime(result.getString("endTime"));	
				List.add(tmp);
	          }
	       }
			  catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
    
    public void add_info(){
    	try {
			Parent root = FXMLLoader.load(getClass()
					.getResource("/UIResource/AddRoomReserve.fxml"));
			Scene scene = new Scene(root);
		    stage_add.setTitle("客房预定添加界面");
			stage_add.setScene(scene);
			stage_add.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
        
    public void del_info(){
    	TextInputDialog dialog = new TextInputDialog();

	  	  dialog.setTitle("预定信息管理系统");
	  	  dialog.setHeaderText("删除提示");
	  	  dialog.setContentText("请输入需要删除的预定信息编号:");
	  	  String id=null;
	  	  // Traditional way to get the response value.
	  	  Optional<String> result = dialog.showAndWait();
	  	  if (result.isPresent()){
	  		  id = result.get();
	  	      System.out.println("Your id: " + result.get());
	  	  }
	  	  DBhelper connector = new DBhelper(); 
	  	String query = "select roomId from room_order where id="+id;
	  	  ResultSet result_rid = connector.query(query);
	  	  String del_rid = null;
	  	  try {
	  		  result_rid.next();
	  		  del_rid = result_rid.getString("roomId");
	  	  }
	  	  catch (SQLException e) {
	  		  e.printStackTrace();
	  	  }
	  	  connector = new DBhelper();
		      String delete= "delete from room_order where id='"+ id +"'";
		      connector.execute(delete);
		      showall();
		      
		      connector = new DBhelper();
		      query = "select id from room_order where roomId="+del_rid+";";
		      ResultSet result2 = connector.query(query);
		      String orderIds = "";
			       try {
			         while (result2.next()) {
						orderIds += result2.getString("id");
						orderIds += "/";
			          }
			       }
					  catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			  
			  if (orderIds.length()>0) 
				  orderIds = orderIds.substring(0, orderIds.length()-1);
			  else
				  orderIds = "null";
			  connector = new DBhelper();
			  String update = "update room_info set orderId='"+orderIds+"' where id="+del_rid+";";
			  connector.execute(update);
			  RoomController.refresh();
    }
    
    public void search_info(){
    	TextInputDialog dialog = new TextInputDialog();

  	  dialog.setTitle("预定信息管理系统");
  	  dialog.setHeaderText("查找提示");
  	  dialog.setContentText("请输入需要查找的房间编号:");
  	  String id=null;
  	  // Traditional way to get the response value.
  	  Optional<String> result = dialog.showAndWait();
  	  if (result.isPresent()){
  		  id = result.get();
  	      System.out.println("Your id: " + result.get());
  	  }
  	  DBhelper connector = new DBhelper(); 
	      String query= "select * from room_order where roomId='"+ id+"'";
	      ResultSet result_info = connector.query(query);
	      List.clear();
	      try {
		         while (result_info.next()) {
					RoomOrder tmp = new RoomOrder();
					tmp.setId(result_info.getString("id"));
					tmp.setRoomId(result_info.getString("roomId"));				
					tmp.setType(result_info.getString("type"));				
					tmp.setStatus(result_info.getString("status"));
					tmp.setClientName1(result_info.getString("clientName1"));
					tmp.setClientID1(result_info.getString("clientID1"));
					tmp.setClientName2(result_info.getString("clientName2"));
					tmp.setClientID2(result_info.getString("clientID2"));
					tmp.setClientPhone(result_info.getString("clientPhone"));
					tmp.setPrice(result_info.getString("price"));
					tmp.setBreakfast(result_info.getString("breakfast"));
					tmp.setService(result_info.getString("service"));
					tmp.setDay(result_info.getString("day"));
					tmp.setStartTime(result_info.getString("startTime"));
					tmp.setEndTime(result_info.getString("endTime"));
					List.add(tmp);
		          }
		       }
				  catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    }
    
    
}
