package application;

import java.net.URL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

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
import Infomation.purchase;
import Utils.DBhelper;

public class purchaseController implements Initializable{
	   @FXML private Button btn_search;
	   @FXML private Button btn_add;
	   @FXML private Button btn_del;
	   @FXML private Button btn_showall;	   
	   @FXML private TableView<purchase> table;
	   @FXML private TableColumn<purchase,String> col_id;
	   @FXML private TableColumn<purchase,String> col_name;
	   @FXML private TableColumn<purchase,String> col_type;
	   @FXML private TableColumn<purchase,String> col_require;
	   @FXML private TableColumn<purchase,String> col_price;
	  
	   private final static ObservableList<purchase> List = FXCollections.observableArrayList(); 
	   
	    public static Stage stage_add = new Stage();
	    
	    @Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
				   col_id.setCellValueFactory(new PropertyValueFactory<purchase,String>("id"));
				   col_name.setCellValueFactory(new PropertyValueFactory<purchase,String>("name"));
				   col_type.setCellValueFactory(new PropertyValueFactory<purchase,String>("type"));
				   col_require.setCellValueFactory(new PropertyValueFactory<purchase,String>("requirement"));
				   col_price.setCellValueFactory(new PropertyValueFactory<purchase,String>("price"));
				   table.setItems(List);
				   showall();
			   }
		
		      public static void refresh(){
		    	   List.clear();
				   DBhelper connector = new DBhelper();  
			       String query= "select * from dish_material_pur";
			       ResultSet result = connector.query(query);
			       try {
			         while (result.next()) {
							purchase tmp = new purchase();
						    tmp.setId(result.getString("id"));
						    tmp.setName(result.getString("name"));
						    tmp.setType(result.getString("type"));
						    tmp.setRequire(result.getString("requirement"));
						    tmp.setPrice(result.getString("price"));
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
	    	   String query= "select * from dish_material_pur";
		       ResultSet result = connector.query(query);
		       try {
			         while (result.next()) {
							purchase tmp = new purchase();
						    tmp.setId(result.getString("id"));
						    tmp.setName(result.getString("name"));
						    tmp.setType(result.getString("type"));
						    tmp.setRequire(result.getString("requirement"));
						    tmp.setPrice(result.getString("price"));
							List.add(tmp);
			         }
			       }
			       catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		  }
		  
		  public void add_material(){
			  try {
					Parent root = FXMLLoader.load(getClass()
							.getResource("/application/Addpurchase.fxml"));
					Scene scene = new Scene(root);
				    stage_add.setTitle("进货管理界面");
					stage_add.setScene(scene);
					stage_add.show();
				} catch(Exception e) {
					e.printStackTrace();
				}
		  }
		  
		  public void del_material(){
	 	  TextInputDialog dialog = new TextInputDialog();

	 	  dialog.setTitle("进货管理界面");
	 	  dialog.setHeaderText("删除提示");
	 	  dialog.setContentText("请输入需要删除的食材名称:");
	 	  String name=null;
   	      // Traditional way to get the response value.
   	      Optional<String> result = dialog.showAndWait();
   	      if (result.isPresent()){
   	    	  name = result.get();
   	    	  System.out.println("Your name: " + result.get());
   	      }
   	      DBhelper connector = new DBhelper(); 
	      String delete= "delete from dish_material_pur where name='"+ name+"'";
	      connector.execute(delete);
	      showall();
	 	  // The Java 8 way to get the response value (with lambda expression).
//	 	  result.ifPresent(name -> System.out.println("Your name: " + name));
		  }
		  
		  public void search_material(ActionEvent event){
			  TextInputDialog dialog = new TextInputDialog();

	    	  dialog.setTitle("进货管理系统");
	    	  dialog.setHeaderText("查找提示");
	    	  dialog.setContentText("请输入需要查找的食材名称:");
	    	  String name=null;
	    	  // Traditional way to get the response value.
	    	  Optional<String> result = dialog.showAndWait();
	    	  if (result.isPresent()){
	    		  name = result.get();
	    	      System.out.println("Your name: " + result.get());
	    	  }
	    	  DBhelper connector = new DBhelper(); 
		      String query= "select * from dish_material_pur where name='"+ name+"'";
		      ResultSet result_info = connector.query(query);
		      List.clear();
	    	  try {
			         while (result_info.next()) {
							purchase tmp = new purchase();
						    tmp.setId(result_info.getString("id"));
						    tmp.setName(result_info.getString("name"));
						    tmp.setType(result_info.getString("type"));
						    tmp.setRequire(result_info.getString("requirement"));
						    tmp.setPrice(result_info.getString("price"));
							List.add(tmp);
			         }
	    	  }
	    	  catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		  }
}
