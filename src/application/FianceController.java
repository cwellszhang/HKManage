package application;

import java.net.URL;
import java.util.ResourceBundle;

import Infomation.Employer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class FianceController implements Initializable{
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
		   
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			
		}
		   
}
