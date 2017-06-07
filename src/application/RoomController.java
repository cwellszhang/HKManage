package application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import Infomation.Employer;
import Infomation.Vip;
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
	   @FXML private Button btn_search;
	   @FXML private Button btn_add;
	   @FXML private Button btn_delete;
	   @FXML private TableView<Vip> table;
	   @FXML private TableColumn<Vip,String> col_id;
	   @FXML private TableColumn<Vip,String> col_name;
	   @FXML private TableColumn<Vip,String> col_sex;
	   @FXML private TableColumn<Vip,String> col_tel;
	   @FXML private TableColumn<Vip,String> col_address;
	   @FXML private TableColumn<Vip,String> col_degree;
	   @FXML private TableColumn<Vip,String> col_time;
	   
	   private final static ObservableList<Vip> List = FXCollections.observableArrayList(); 
		
       public static Stage stage_add = new Stage();
       
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
//			   col_id.setCellValueFactory(new PropertyValueFactory<Employer,String>("id"));
			   col_name.setCellValueFactory(new PropertyValueFactory<Vip,String>("name"));
			   col_sex.setCellValueFactory(new PropertyValueFactory<Vip,String>("sex"));
			   col_tel.setCellValueFactory(new PropertyValueFactory<Vip,String>("phone"));
			   col_address.setCellValueFactory(new PropertyValueFactory<Vip,String>("address"));
			   col_degree.setCellValueFactory(new PropertyValueFactory<Vip,String>("degree"));
			   col_time.setCellValueFactory(new PropertyValueFactory<Vip,String>("time"));
			   table.setItems(List);
		       showall();
		   }
	
	      public static void refresh(){
	    	   List.clear();
			   DBhelper connector = new DBhelper(); 
		       String query= "select * from member_info";
		       ResultSet result = connector.query(query);
		       try {
		         while (result.next()) {

					Vip tmp = new Vip();
					tmp.setId(result.getString("id"));
					tmp.setName(result.getString("name"));
					tmp.setSex(result.getString("sex"));
					tmp.setPhone(result.getString("phone"));
					tmp.setAddress(result.getString("address"));
					tmp.setDegree(result.getString("degree"));
					tmp.setTime(result.getString("startTime"));
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
		       String query= "select * from member_info";
		       ResultSet result = connector.query(query);
		       try {
		         while (result.next()) {

					Vip tmp = new Vip();
					tmp.setId(result.getString("id"));
					tmp.setName(result.getString("name"));
					tmp.setSex(result.getString("sex"));
					tmp.setPhone(result.getString("phone"));
					tmp.setAddress(result.getString("address"));
					tmp.setDegree(result.getString("degree"));
					tmp.setTime(result.getString("startTime"));
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
							.getResource("/application/addVip.fxml"));
					Scene scene = new Scene(root);
				    stage_add.setTitle("贵宾信息注册系统");
					stage_add.setScene(scene);
					stage_add.show();
				} catch(Exception e) {
					e.printStackTrace();
				}
		  }
		  public void del_info(){
	    	  TextInputDialog dialog = new TextInputDialog();

	    	  dialog.setTitle("会员管理系统");
	    	  dialog.setHeaderText("删除提示");
	    	  dialog.setContentText("请输入需要删除的会员姓名:");
	    	  String name=null;
	    	  // Traditional way to get the response value.
	    	  Optional<String> result = dialog.showAndWait();
	    	  if (result.isPresent()){
	    		  name = result.get();
	    	      System.out.println("Your name: " + result.get());
	    	  }
	    	  DBhelper connector = new DBhelper(); 
		      String delete= "delete from member_info where name='"+ name+"'";
		      connector.execute(delete);
		      showall();
	    	  // The Java 8 way to get the response value (with lambda expression).
//	    	  result.ifPresent(name -> System.out.println("Your name: " + name));
		  }
		  public void search_info(){
			  TextInputDialog dialog = new TextInputDialog();

	    	  dialog.setTitle("会员管理系统");
	    	  dialog.setHeaderText("查找提示");
	    	  dialog.setContentText("请输入需要查找的会员姓名:");
	    	  String name=null;
	    	  // Traditional way to get the response value.
	    	  Optional<String> result = dialog.showAndWait();
	    	  if (result.isPresent()){
	    		  name = result.get();
	    	      System.out.println("Your name: " + result.get());
	    	  }
	    	  DBhelper connector = new DBhelper(); 
		      String query= "select * from member_info where name='"+ name+"'";
		      ResultSet result_info = connector.query(query);
		      List.clear();
		      try {
			         while (result_info.next()) {
						Vip tmp = new Vip();
						tmp.setId(result_info.getString("id"));
						tmp.setName(result_info.getString("name"));
						tmp.setSex(result_info.getString("sex"));
		
						tmp.setAddress(result_info.getString("address"));
						tmp.setPhone(result_info.getString("phone"));
						tmp.setTime(result_info.getString("startTime"));
						tmp.setDegree(result_info.getString("degree"));
						List.add(tmp);
			          }
			       }
					  catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		  }

	   
	   
}
