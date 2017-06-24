package application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import Infomation.Dish;
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

public class DishController implements Initializable{
	   @FXML private Button btn_showall;
	   @FXML private Button btn_reserve;
	   @FXML private Button btn_search;
	   @FXML private Button btn_add;
	   @FXML private Button btn_delete;
	   @FXML private TableView<Dish> table;
	   @FXML private TableColumn<Dish,String> col_id;
	   @FXML private TableColumn<Dish,String> col_type;
	   @FXML private TableColumn<Dish,String> col_name;
	   @FXML private TableColumn<Dish,String> col_price;
	   @FXML private TableColumn<Dish,String> col_elementId;
	   
	   private final static ObservableList<Dish> List = FXCollections.observableArrayList(); 
		
    public static Stage stage_add = new Stage();
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
			   col_id.setCellValueFactory(new PropertyValueFactory<Dish,String>("id"));
			   col_type.setCellValueFactory(new PropertyValueFactory<Dish,String>("type"));
			   col_name.setCellValueFactory(new PropertyValueFactory<Dish,String>("name"));
			   col_price.setCellValueFactory(new PropertyValueFactory<Dish,String>("price"));
			   col_elementId.setCellValueFactory(new PropertyValueFactory<Dish,String>("elementId"));
			   table.setItems(List);
		       showall();
		   }
	
	      public static void refresh(){
	    	   List.clear();
			   DBhelper connector = new DBhelper(); 
		       String query= "select * from dish_info";
		       ResultSet result = connector.query(query);
		       try {
		         while (result.next()) {
					Dish tmp = new Dish();
					tmp.setId(result.getString("id"));
					tmp.setType(result.getString("type"));
					tmp.setName(result.getString("name"));
					tmp.setPrice(result.getString("price"));
					tmp.setElementId(result.getString("elementId"));
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
	       String query= "select * from dish_info";
	       ResultSet result = connector.query(query);
	       try {
	         while (result.next()) {

				Dish tmp = new Dish();
				tmp.setId(result.getString("id"));
				tmp.setType(result.getString("type"));
				tmp.setName(result.getString("name"));
				tmp.setPrice(result.getString("price"));
				tmp.setElementId(result.getString("elementId"));
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
					  .getResource("/UIResource/DishReserve.fxml"));
			  Scene scene = new Scene(root);
			  stage_add.setTitle("点菜界面");
			  stage_add.setScene(scene);
			  stage_add.show();
		  } catch(Exception e) {
			  e.printStackTrace();
		  }
	  }
	  public void add_info(){
		  try {
				Parent root = FXMLLoader.load(getClass()
						.getResource("/UIResourceUIResource/AddDish.fxml"));
				Scene scene = new Scene(root);
			    stage_add.setTitle("菜单管理界面");
				stage_add.setScene(scene);
				stage_add.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
	  }
	  public void del_info(){
 	  TextInputDialog dialog = new TextInputDialog();

 	  dialog.setTitle("菜单管理界面");
 	  dialog.setHeaderText("删除提示");
 	  dialog.setContentText("请输入需要删除的菜品编号:");
 	  String id=null;
 	  // Traditional way to get the response value.
 	  Optional<String> result = dialog.showAndWait();
 	  if (result.isPresent()){
 		  id = result.get();
 	      System.out.println("Your id: " + result.get());
 	  }
 	  DBhelper connector = new DBhelper(); 
	      String delete= "delete from dish_info where id='"+ id+"'";
	      connector.execute(delete);
	      showall();
 	  // The Java 8 way to get the response value (with lambda expression).
// 	  result.ifPresent(name -> System.out.println("Your name: " + name));
	  }
	  public void search_info(){
		  TextInputDialog dialog = new TextInputDialog();

 	  dialog.setTitle("菜单管理界面");
 	  dialog.setHeaderText("查找提示");
 	  dialog.setContentText("请输入需要查找的菜品编号:");
 	  String id=null;
 	  // Traditional way to get the response value.
 	  Optional<String> result = dialog.showAndWait();
 	  if (result.isPresent()){
 		  id = result.get();
 	      System.out.println("Your id: " + result.get());
 	  }
 	  DBhelper connector = new DBhelper(); 
	      String query= "select * from dish_info where id='"+ id+"'";
	      ResultSet result_info = connector.query(query);
	      List.clear();
	      try {
		         while (result_info.next()) {
					Dish tmp = new Dish();
					tmp.setId(result_info.getString("id"));
					tmp.setType(result_info.getString("type"));
					tmp.setName(result_info.getString("name"));
					tmp.setPrice(result_info.getString("price"));
					tmp.setElementId(result_info.getString("elementId"));
					List.add(tmp);
		          }
		       }
				  catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	  }
}
