package application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import Utils.DBhelper;
import Infomation.Employer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class MainController implements Initializable{
	   @FXML private Text txt_id;
	   @FXML private Text txt_name;
	   @FXML private Text txt_gender;
	   @FXML private Text txt_department;
	   @FXML private Text txt_job;
	   @FXML private Text txt_priority;
//	   private Main application;
//	   
//	   public void setApp(Main application){  
//	        this.application = application;  
//	    }  
	   @Override
	   public void initialize(URL location, ResourceBundle resources) {
	       // TODO (don't really need to do anything here)

		   DBhelper connector = new DBhelper(); 
	       String query= "select * from employee_info where id="+LoginPage.id;
	       ResultSet result = connector.query(query);
	       try {
	         while (result.next()) {
				System.out.println(result.getString("account"));
			     txt_id.setText(result.getString("id"));
			     txt_name.setText(result.getString("name"));
			     String sex= result.getString("sex");
			     if(sex==null){
			          txt_gender.setText("男");
			     }else if (sex.equals("1")) { 
			          txt_gender.setText("女");
			     }else{
			    	 txt_gender.setText("男");
			     }
			     txt_department.setText(result.getString("departmentId"));
			     txt_priority.setText(result.getString("priority"));
	          }
	       }
			  catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }
}
