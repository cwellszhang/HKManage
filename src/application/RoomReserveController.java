package application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Infomation.RoomOrder;
import Utils.DBhelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class RoomReserveController  implements Initializable{
	@FXML private Button btn_add;
	@FXML private Button btn_delete;
	@FXML private TableView<RoomOrder> table;
	@FXML private TableColumn<RoomOrder,String> col_id;
	@FXML private TableColumn<RoomOrder,String> col_roomId;
	@FXML private TableColumn<RoomOrder,String> col_type;
	@FXML private TableColumn<RoomOrder,String> col_status;
	@FXML private TableColumn<RoomOrder,String> col_client1;
	@FXML private TableColumn<RoomOrder,String> col_client1ID;
	@FXML private TableColumn<RoomOrder,String> col_client2;
	@FXML private TableColumn<RoomOrder,String> col_client2ID;
	@FXML private TableColumn<RoomOrder,String> col_phone;
	@FXML private TableColumn<RoomOrder,String> col_price;
	@FXML private TableColumn<RoomOrder,String> col_breakfast;
	@FXML private TableColumn<RoomOrder,String> col_service;
	@FXML private TableColumn<RoomOrder,String> col_time;
	@FXML private TableColumn<RoomOrder,String> col_startTime;
	@FXML private TableColumn<RoomOrder,String> col_endTime;
	
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
    	
    }
    
    public void del_info(){
    	
    }
    
    public void search_info(){
    	
    }

}
