package application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import Infomation.DiningOrder;
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

public class TableReserveController implements Initializable{
	@FXML private Button btn_add;
	@FXML private Button btn_delete;
	@FXML private Button btn_search;
	@FXML private Button btn_showall;
	@FXML private TableView<DiningOrder> table;
	@FXML private TableColumn<DiningOrder,String> col_id;
	@FXML private TableColumn<DiningOrder,String> col_TableId;
	@FXML private TableColumn<DiningOrder,String> col_clientName;
	@FXML private TableColumn<DiningOrder,String> col_clientPhone;
	@FXML private TableColumn<DiningOrder,String> col_clientNumber;
	@FXML private TableColumn<DiningOrder,String> col_dishId;
	@FXML private TableColumn<DiningOrder,String> col_price;
	@FXML private TableColumn<DiningOrder,String> col_type;
	@FXML private TableColumn<DiningOrder,String> col_status;
	@FXML private TableColumn<DiningOrder,String> col_waiterName;
	@FXML private TableColumn<DiningOrder,String> col_startTime;
	
	
	private final static ObservableList<DiningOrder> List = FXCollections.observableArrayList(); 
	
    public static Stage stage_add = new Stage();
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
			   col_id.setCellValueFactory(new PropertyValueFactory<DiningOrder,String>("id"));
			   col_TableId.setCellValueFactory(new PropertyValueFactory<DiningOrder,String>("tableId"));
			   col_clientName.setCellValueFactory(new PropertyValueFactory<DiningOrder,String>("clientName"));
			   col_clientPhone.setCellValueFactory(new PropertyValueFactory<DiningOrder,String>("clientPhone"));
			   col_clientNumber.setCellValueFactory(new PropertyValueFactory<DiningOrder,String>("clientNumber"));
			   col_dishId.setCellValueFactory(new PropertyValueFactory<DiningOrder,String>("dishId"));
			   col_price.setCellValueFactory(new PropertyValueFactory<DiningOrder,String>("price"));
			   col_type.setCellValueFactory(new PropertyValueFactory<DiningOrder,String>("type"));
			   col_status.setCellValueFactory(new PropertyValueFactory<DiningOrder,String>("status"));
			   col_waiterName.setCellValueFactory(new PropertyValueFactory<DiningOrder,String>("waiterName"));
			   col_startTime.setCellValueFactory(new PropertyValueFactory<DiningOrder,String>("startTime"));
			   table.setItems(List);
		       showall();
		   }
    
    public static void refresh(){
 	   List.clear();
		   DBhelper connector = new DBhelper(); 
	       String query= "select * from diningtable_order";
	       ResultSet result = connector.query(query);
	       try {
	         while (result.next()) {

				DiningOrder tmp = new DiningOrder();
				tmp.setId(result.getString("id"));
				tmp.setTableId(result.getString("TableId"));				
				tmp.setClientName(result.getString("clientName"));				
				tmp.setClientPhone(result.getString("clientPhone"));
				tmp.setClientNumber(result.getString("clientNumber"));
				tmp.setDishId(result.getString("dishId"));
				tmp.setPrice(result.getString("price"));
				tmp.setType(result.getString("type"));
				tmp.setStatus(result.getString("status"));
				tmp.setWaiterName(result.getString("waiterName"));
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
	       String query= "select * from diningtable_order";
	       ResultSet result = connector.query(query);
	       try {
	         while (result.next()) {

				DiningOrder tmp = new DiningOrder();
				tmp.setId(result.getString("id"));
				tmp.setTableId(result.getString("TableId"));				
				tmp.setClientName(result.getString("clientName"));				
				tmp.setClientPhone(result.getString("clientPhone"));
				tmp.setClientNumber(result.getString("clientNumber"));
				tmp.setDishId(result.getString("dishId"));
				tmp.setPrice(result.getString("price"));
				tmp.setType(result.getString("type"));
				tmp.setStatus(result.getString("status"));
				tmp.setWaiterName(result.getString("waiterName"));
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
					.getResource("/application/AddDiningReserve.fxml"));
			Scene scene = new Scene(root);
		    stage_add.setTitle("餐桌预定界面");
			stage_add.setScene(scene);
			stage_add.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
        
    public void del_info(){
    	TextInputDialog dialog = new TextInputDialog();

	  	  dialog.setTitle("餐桌预定管理系统");
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
	  	  	  String query = "select TableId from diningtable_order where id="+id;
	  	  	  ResultSet result_tid = connector.query(query);
	  	  	  String del_tid = null;
	  	  	  try {
	  	  		  result_tid.next();
	  	  		  del_tid = result_tid.getString("TableId");
	  	  	  }
	  	  	  catch (SQLException e) {
	  	  		  e.printStackTrace();
	  	  	  }
	  	  	  connector = new DBhelper();
		      String delete= "delete from diningtable_order where id='"+ id +"'";
		      connector.execute(delete);
		      showall();
		      
		      connector = new DBhelper();
		      query = "select id from diningtable_order where TableId="+del_tid+";";
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
			  String update = "update diningtable_info set orderId='"+orderIds+"' where id="+del_tid+";";
			  connector.execute(update);
			  DiningController.refresh();
    }
    
    public void search_info(){
    	TextInputDialog dialog = new TextInputDialog();

  	  dialog.setTitle("餐桌预定管理系统");
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
	      String query= "select * from diningtable_order where tableId='"+ id+"'";
	      ResultSet result_info = connector.query(query);
	      List.clear();
	      try {
		         while (result_info.next()) {
					DiningOrder tmp = new DiningOrder();
					tmp.setId(result_info.getString("id"));
					tmp.setTableId(result_info.getString("TableId"));				
					tmp.setClientName(result_info.getString("clientName"));				
					tmp.setClientPhone(result_info.getString("clientPhone"));
					tmp.setClientNumber(result_info.getString("clientNumber"));
					tmp.setDishId(result_info.getString("dishId"));
					tmp.setPrice(result_info.getString("price"));
					tmp.setType(result_info.getString("type"));
					tmp.setStatus(result_info.getString("status"));
					tmp.setWaiterName(result_info.getString("waiterName"));
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
