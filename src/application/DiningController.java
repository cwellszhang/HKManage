package application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import Infomation.Dining;
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

public class DiningController implements Initializable{
	   @FXML private Button btn_showall;
	   @FXML private Button btn_reserve;
	   @FXML private Button btn_search;
	   @FXML private Button btn_add_table;
	   @FXML private Button btn_add_dish;
	   @FXML private Button btn_delete;
	   @FXML private TableView<Dining> table;
	   @FXML private TableColumn<Dining,String> col_id;
	   @FXML private TableColumn<Dining,String> col_type;
	   @FXML private TableColumn<Dining,String> col_status;
	   @FXML private TableColumn<Dining,String> col_orderId;
	   //@FXML private TableColumn<Dining,String> col_dishId;
	   
	   private final static ObservableList<Dining> List = FXCollections.observableArrayList(); 
		
       public static Stage stage_add = new Stage();
       
       @Override
   	public void initialize(URL location, ResourceBundle resources) {
   		// TODO Auto-generated method stub
   			   col_id.setCellValueFactory(new PropertyValueFactory<Dining,String>("id"));
   			   col_type.setCellValueFactory(new PropertyValueFactory<Dining,String>("type"));
   			   col_status.setCellValueFactory(new PropertyValueFactory<Dining,String>("status"));
   			   col_orderId.setCellValueFactory(new PropertyValueFactory<Dining,String>("orderId"));
   			   //col_dishId.setCellValueFactory(new PropertyValueFactory<Dining,String>("dishId"));
   			   table.setItems(List);
   		       showall();
   		   }
   	
   	      public static void refresh(){
   	    	   List.clear();
   			   DBhelper connector = new DBhelper(); 
   		       String query= "select * from diningtable_info";
   		       ResultSet result = connector.query(query);
   		       try {
   		         while (result.next()) {
   					Dining tmp = new Dining();
   					tmp.setId(result.getString("id"));
   					tmp.setType(result.getString("type"));
   					tmp.setStatus(result.getString("status"));
   					tmp.setOrderId(result.getString("orderId"));
   					//tmp.setDishId(result.getString("dishId"));
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
	       String query= "select * from diningtable_info";
	       ResultSet result = connector.query(query);
	       try {
	         while (result.next()) {

				Dining tmp = new Dining();
				tmp.setId(result.getString("id"));
				tmp.setType(result.getString("type"));
				tmp.setStatus(result.getString("status"));
				tmp.setOrderId(result.getString("orderId"));
				//tmp.setDishId(result.getString("dishId"));
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
					  .getResource("/UIResource/TableReserve.fxml"));
			  Scene scene = new Scene(root);
			  stage_add.setTitle("餐桌预定界面");
			  stage_add.setScene(scene);
			  stage_add.show();
		  } catch(Exception e) {
			  e.printStackTrace();
		  }
	  }
	  public void add_info(){
		  try {
				Parent root = FXMLLoader.load(getClass()
						.getResource("/UIResource/AddTable.fxml"));
				Scene scene = new Scene(root);
			    stage_add.setTitle("餐桌管理界面");
				stage_add.setScene(scene);
				stage_add.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
	  }
	  public void add_dish() {
		  try {
			  Parent root = FXMLLoader.load(getClass()
					  .getResource("/UIResource/Dish.fxml"));
			  Scene scene = new Scene(root);
			  stage_add.setTitle("菜单界面");
			  stage_add.setScene(scene);
			  stage_add.show();
		  } catch(Exception e) {
			  e.printStackTrace();
		  }
	  }
	  public void del_info(){
    	  TextInputDialog dialog = new TextInputDialog();

    	  dialog.setTitle("餐桌管理界面");
    	  dialog.setHeaderText("删除提示");
    	  dialog.setContentText("请输入需要删除的餐桌编号:");
    	  String id=null;
    	  // Traditional way to get the response value.
    	  Optional<String> result = dialog.showAndWait();
    	  if (result.isPresent()){
    		  id = result.get();
    	      System.out.println("Your id: " + result.get());
    	  }
    	  DBhelper connector = new DBhelper(); 
	      String delete= "delete from diningtable_info where id='"+ id+"'";
	      connector.execute(delete);
	      showall();
    	  // The Java 8 way to get the response value (with lambda expression).
//    	  result.ifPresent(name -> System.out.println("Your name: " + name));
	  }
	  public void search_info(){
		  TextInputDialog dialog = new TextInputDialog();

    	  dialog.setTitle("餐桌管理界面");
    	  dialog.setHeaderText("查找提示");
    	  dialog.setContentText("请输入需要查找的餐桌编号:");
    	  String id=null;
    	  // Traditional way to get the response value.
    	  Optional<String> result = dialog.showAndWait();
    	  if (result.isPresent()){
    		  id = result.get();
    	      System.out.println("Your id: " + result.get());
    	  }
    	  DBhelper connector = new DBhelper(); 
	      String query= "select * from diningtable_info where id='"+ id+"'";
	      ResultSet result_info = connector.query(query);
	      List.clear();
	      try {
		         while (result_info.next()) {
					Dining tmp = new Dining();
					tmp.setId(result_info.getString("id"));
					tmp.setType(result_info.getString("type"));	
					tmp.setStatus(result_info.getString("status"));
					tmp.setOrderId(result_info.getString("orderId"));
					//tmp.setDishId(result_info.getString("dishId"));
					List.add(tmp);
		          }
		       }
				  catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	  }


}
