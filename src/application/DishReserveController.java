package application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import Infomation.DishOrder;
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
import javafx.stage.Stage;

public class DishReserveController implements Initializable{
	@FXML private Button btn_add;
	@FXML private Button btn_delete;
	@FXML private Button btn_search;
	@FXML private Button btn_showall;
	@FXML private TableView<DishOrder> table;
	@FXML private TableColumn<DishOrder,String> col_tableId;
	@FXML private TableColumn<DishOrder,String> col_dishId;
	@FXML private TableColumn<DishOrder,String> col_name;
	@FXML private TableColumn<DishOrder,String> col_type;
	@FXML private TableColumn<DishOrder,String> col_number;
	@FXML private TableColumn<DishOrder,String> col_status;
	
	
	private final static ObservableList<DishOrder> List = FXCollections.observableArrayList(); 
	
    public static Stage stage_add = new Stage();
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
			   //col_id.setCellValueFactory(new PropertyValueFactory<DishOrder,String>("id"));
			   col_tableId.setCellValueFactory(new PropertyValueFactory<DishOrder,String>("tableId"));
			   col_type.setCellValueFactory(new PropertyValueFactory<DishOrder,String>("type"));
			   col_status.setCellValueFactory(new PropertyValueFactory<DishOrder,String>("status"));
			   col_dishId.setCellValueFactory(new PropertyValueFactory<DishOrder,String>("dishId"));
			   col_name.setCellValueFactory(new PropertyValueFactory<DishOrder,String>("name"));
			   col_number.setCellValueFactory(new PropertyValueFactory<DishOrder,String>("number"));
			   table.setItems(List);
		       showall();
		   }
    
    public static void refresh(){
 	   List.clear();
		   DBhelper connector = new DBhelper(); 
	       String query= "select * from dish_order";
	       ResultSet result = connector.query(query);
	       try {
	         while (result.next()) {

				DishOrder tmp = new DishOrder();
				//tmp.setId(result.getString("id"));
				tmp.setTableId(result.getString("tableId"));				
				tmp.setType(result.getString("type"));				
				tmp.setStatus(result.getString("status"));
				tmp.setName(result.getString("name"));
				tmp.setDishId(result.getString("dishId"));
				tmp.setNumber(result.getString("number"));			
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
	       String query= "select * from dish_order";
	       ResultSet result = connector.query(query);
	       try {
	         while (result.next()) {

				DishOrder tmp = new DishOrder();
				//tmp.setId(result.getString("id"));
				tmp.setTableId(result.getString("tableId"));				
				tmp.setType(result.getString("type"));				
				tmp.setStatus(result.getString("status"));
				tmp.setName(result.getString("name"));
				tmp.setDishId(result.getString("dishId"));
				tmp.setNumber(result.getString("number"));
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
					.getResource("/application/AddDishReserve.fxml"));
			Scene scene = new Scene(root);
		    stage_add.setTitle("点菜界面");
			stage_add.setScene(scene);
			stage_add.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
        
    public void del_info(){
    	TextInputDialog dialog = new TextInputDialog();

	  	  dialog.setTitle("点菜信息管理系统");
	  	  dialog.setHeaderText("删除提示");
	  	  dialog.setContentText("请输入需要删除的桌号:");
	  	  String id=null;
	  	  // Traditional way to get the response value.
	  	  Optional<String> result = dialog.showAndWait();
	  	  if (result.isPresent()){
	  		  id = result.get();
	  	      System.out.println("Your id: " + result.get());
	  	  }
	  	  DBhelper connector = new DBhelper(); 
/*	  	String query = "select roomId from room_order where id="+id;
	  	  ResultSet result_rid = connector.query(query);
	  	  String del_rid = null;
	  	  try {
	  		  result_rid.next();
	  		  del_rid = result_rid.getString("roomId");
	  	  }
	  	  catch (SQLException e) {
	  		  e.printStackTrace();
	  	  }
	  	  connector = new DBhelper();*/
		      String delete= "delete from dish_order where tableId='"+ id +"'";
		      connector.execute(delete);
		      showall();
		      
/*		      connector = new DBhelper();
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
			  DiningController.refresh();*/
    }
    
    public void search_info(){
    	TextInputDialog dialog = new TextInputDialog();

  	  dialog.setTitle("点菜信息管理系统");
  	  dialog.setHeaderText("查找提示");
  	  dialog.setContentText("请输入需要查找的桌号:");
  	  String id=null;
  	  // Traditional way to get the response value.
  	  Optional<String> result = dialog.showAndWait();
  	  if (result.isPresent()){
  		  id = result.get();
  	      System.out.println("Your id: " + result.get());
  	  }
  	  DBhelper connector = new DBhelper(); 
	      String query= "select * from dish_order where tableId='"+ id+"'";
	      ResultSet result_info = connector.query(query);
	      List.clear();
	      try {
		         while (result_info.next()) {
					DishOrder tmp = new DishOrder();
					//tmp.setId(result_info.getString("id"));
					tmp.setTableId(result_info.getString("tableId"));				
					tmp.setType(result_info.getString("type"));				
					tmp.setStatus(result_info.getString("status"));
					tmp.setName(result_info.getString("name"));
					tmp.setDishId(result_info.getString("dishId"));
					tmp.setNumber(result_info.getString("number"));
					List.add(tmp);
		          }
		       }
				  catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    }
}
