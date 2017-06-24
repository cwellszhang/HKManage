package application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import Infomation.Room;
import Utils.DBhelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RoomController implements Initializable{
	   @FXML private Button btn_showall;
	   @FXML private Button btn_reserve;
	   @FXML private Button btn_search;
	   @FXML private Button btn_add;
	   @FXML private Button btn_delete;
	   @FXML private TableView<Room> table;
	   @FXML private TableColumn<Room,String> col_id;
	   @FXML private TableColumn<Room,String> col_type;
	   @FXML private TableColumn<Room,String> col_price;
	   @FXML private TableColumn<Room,String> col_status;
	   @FXML private TableColumn<Room,String> col_orderId;
	   @FXML private TableColumn<Room,String> col_service;
	   
	   private final static ObservableList<Room> List = FXCollections.observableArrayList(); 
		
       public static Stage stage_add = new Stage();
       
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
			   col_id.setCellValueFactory(new PropertyValueFactory<Room,String>("id"));
			   col_type.setCellValueFactory(new PropertyValueFactory<Room,String>("type"));
			   col_price.setCellValueFactory(new PropertyValueFactory<Room,String>("price"));
			   col_status.setCellValueFactory(new PropertyValueFactory<Room,String>("status"));
			   col_orderId.setCellValueFactory(new PropertyValueFactory<Room,String>("orderId"));
			   col_service.setCellValueFactory(new PropertyValueFactory<Room,String>("service"));
			   table.setItems(List);
		       showall();
		   }
	
	      public static void refresh(){
	    	   List.clear();
			   DBhelper connector = new DBhelper(); 
		       String query= "select * from room_info";
		       ResultSet result = connector.query(query);
		       try {
		         while (result.next()) {

					Room tmp = new Room();
					tmp.setId(result.getString("id"));
					tmp.setType(result.getString("type"));
					tmp.setPrice(result.getString("price"));
					tmp.setStatus(result.getString("status"));
					tmp.setOrderId(result.getString("orderId"));
					tmp.setService(result.getString("service"));
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
		       String query= "select * from room_info";
		       ResultSet result = connector.query(query);
		       try {
		         while (result.next()) {

					Room tmp = new Room();
					tmp.setId(result.getString("id"));
					tmp.setType(result.getString("type"));
					tmp.setPrice(result.getString("price"));
					tmp.setStatus(result.getString("status"));
					tmp.setOrderId(result.getString("orderId"));
					tmp.setService(result.getString("service"));
					List.add(tmp);
		          }
		       }
				  catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		  }
		  public void reserve_info(){
			  try {
				  Parent root = FXMLLoader.load(getClass()
						  .getResource("/UIResource/RoomReserve.fxml"));
				  Scene scene = new Scene(root);
				  stage_add.setTitle("客房预定界面");
				  stage_add.setScene(scene);
				  stage_add.show();
			  } catch(Exception e) {
				  e.printStackTrace();
			  }
		  }
		  public void add_info(){
			  try {
					Parent root = FXMLLoader.load(getClass()
							.getResource("/UIResource/AddRoom.fxml"));
					Scene scene = new Scene(root);
				    stage_add.setTitle("客房管理界面");
					stage_add.setScene(scene);
					stage_add.show();
				} catch(Exception e) {
					e.printStackTrace();
				}
		  }
		  public void del_info(){
	    	  TextInputDialog dialog = new TextInputDialog();

	    	  dialog.setTitle("客房管理界面");
	    	  dialog.setHeaderText("删除提示");
	    	  dialog.setContentText("请输入需要删除的房间编号:");
	    	  String id=null;
	    	  // Traditional way to get the response value.
	    	  Optional<String> result = dialog.showAndWait();
	    	  if (result.isPresent()){
	    		  id = result.get();
	    	      System.out.println("Your id: " + result.get());
	    	  }
	    	  DBhelper connector = new DBhelper(); 
		      String delete= "delete from room_info where id='"+ id+"'";
		      connector.execute(delete);
		      showall();
	    	  // The Java 8 way to get the response value (with lambda expression).
//	    	  result.ifPresent(name -> System.out.println("Your name: " + name));
		  }
		  public void search_info(){
			  TextInputDialog dialog = new TextInputDialog();

	    	  dialog.setTitle("客房管理界面");
	    	  dialog.setHeaderText("查找提示");
	    	  dialog.setContentText("请输入需要查找的客房编号:");
	    	  String id=null;
	    	  // Traditional way to get the response value.
	    	  Optional<String> result = dialog.showAndWait();
	    	  if (result.isPresent()){
	    		  id = result.get();
	    	      System.out.println("Your id: " + result.get());
	    	  }
	    	  DBhelper connector = new DBhelper(); 
		      String query= "select * from room_info where id='"+ id+"'";
		      ResultSet result_info = connector.query(query);
		      List.clear();
		      try {
			         while (result_info.next()) {
						Room tmp = new Room();
						tmp.setId(result_info.getString("id"));
						tmp.setType(result_info.getString("type"));
						tmp.setPrice(result_info.getString("price"));
		
						tmp.setStatus(result_info.getString("status"));
						tmp.setOrderId(result_info.getString("orderId"));
						tmp.setService(result_info.getString("service"));
						List.add(tmp);
			          }
			       }
					  catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		  }

	   
	   
}
