package application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import Infomation.Employer;
import Utils.DBhelper;
public class EmployController implements Initializable{
	   @FXML private Button btn_showall;
	   @FXML private Button btn_search;
	   @FXML private Button btn_add;
	   @FXML private Button btn_delete;
	   @FXML private TableView<Employer> table;
	   @FXML private TableColumn<Employer,String> col_id;
	   @FXML private TableColumn<Employer,String> col_name;
	   @FXML private TableColumn<Employer,Integer> col_sex;
	   @FXML private TableColumn<Employer,Integer> col_priority;
	   @FXML private TableColumn<Employer,String> col_department;
	   @FXML private TableColumn<Employer,String> col_salary;
	   @FXML private TableColumn<Employer,String> col_account;
	   @FXML private TableColumn<Employer,String> col_password;
	   
	   private final ObservableList<Employer> List = FXCollections.observableArrayList(); 
	
	  public static Stage stage_add = new Stage();
	  @Override
	   public void initialize(URL location, ResourceBundle resources) {
	       // TODO (don't really need to do anything here)
		   col_id.setCellValueFactory(new PropertyValueFactory<Employer,String>("userid"));
		   col_name.setCellValueFactory(new PropertyValueFactory<Employer,String>("username"));
		   col_sex.setCellValueFactory(new PropertyValueFactory<Employer,Integer>("sex"));
		   col_priority.setCellValueFactory(new PropertyValueFactory<Employer,Integer>("priority"));
		   
		   col_department.setCellValueFactory(new PropertyValueFactory<Employer,String>("department"));
		   col_account.setCellValueFactory(new PropertyValueFactory<Employer,String>("account"));
		   col_password.setCellValueFactory(new PropertyValueFactory<Employer,String>("password"));
		   col_salary.setCellValueFactory(new PropertyValueFactory<Employer,String>("salary"));
		   
		   table.setItems(List);
	       showall();
	   }
	  public void showall(){
		   List.clear();
		   DBhelper connector = new DBhelper(); 
	       String query= "select * from employee_info";
	       ResultSet result = connector.query(query);
	       try {
	         while (result.next()) {
				System.out.println(result.getString("account"));
				Employer tmp = new Employer();
				tmp.setId(result.getString("id"));
				tmp.setDepartment(result.getString("departmentId"));
				tmp.setSex(result.getInt("sex"));
				tmp.setUsername(result.getString("name"));
				tmp.setAccount(result.getString("account"));
				tmp.setPassword(result.getString("password"));
				tmp.setPriority(result.getInt("priority"));
				tmp.setSalary(result.getString("salary"));
				List.add(tmp);
	          }
	       }
			  catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
		  
	  public void search_info(ActionEvent event){
		  
	  }
      public void  add_info(ActionEvent event){
		   try {
				Parent root = FXMLLoader.load(getClass()
						.getResource("/application/addEmployer.fxml"));
				Scene scene = new Scene(root);
			    stage_add.setTitle("员工信息注册系统");
				stage_add.setScene(scene);
				stage_add.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
	  } 
      public void delete_info(){
		  
	  }
	  

	
	
}
