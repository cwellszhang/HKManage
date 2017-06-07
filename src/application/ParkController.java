package application;

import javafx.fxml.Initializable;
import Infomation.Employer;
import Infomation.Park;
import Utils.DBhelper;
import java.net.URL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.Date; 
import java.util.Calendar; 
import java.text.SimpleDateFormat; 
import javafx.util.Callback;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
public class ParkController implements Initializable{
	@FXML private Button btn_showall;
	   @FXML private Button btn_search;
	   @FXML private Button btn_add;
	   @FXML private Button btn_delete;
	   @FXML private TableView<Park> table;
	   @FXML private TableColumn<Park,Integer> col_id;
	   @FXML private TableColumn<Park,String> col_carId;
	   @FXML private TableColumn<Park,Double> col_price;
	   @FXML private TableColumn<Park,Integer> col_status;
	   @FXML private TableColumn<Park,String> col_endTime;
	   @FXML private TableColumn<Park,String> col_startTime;
	   @FXML private TableColumn<Park,Boolean> col_opt=new TableColumn<>("Action");
	   
	   //public static Stage stage_add = new Stage();
	   private static final ObservableList<Park> List = FXCollections.observableArrayList();
	   @Override
	   public void initialize(URL location, ResourceBundle resources) {
	       // TODO (don't really need to do anything here)
		   col_id.setCellValueFactory(new PropertyValueFactory<Park,Integer>("orderId"));
		   col_carId.setCellValueFactory(new PropertyValueFactory<Park,String>("carId"));
		   col_price.setCellValueFactory(new PropertyValueFactory<Park,Double>("price"));
		   col_status.setCellValueFactory(new PropertyValueFactory("status_w"));
		   col_endTime.setCellValueFactory(new PropertyValueFactory<Park,String>("endTime"));
		   col_startTime.setCellValueFactory(new PropertyValueFactory<Park,String>("startTime"));
		   col_opt.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Park, Boolean>, ObservableValue<Boolean>>() {
			      @Override public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Park, Boolean> features) {
			        return new SimpleBooleanProperty(false);
			      }
			    });
		   col_opt.setCellFactory(new Callback<TableColumn<Park, Boolean>, TableCell<Park, Boolean>>() {
			      @Override public TableCell<Park, Boolean> call(TableColumn<Park, Boolean> personBooleanTableColumn) {
			        return new optCell();
			      }
			    });
		   
		   table.setItems(List);
	       showall();
	   }
	   private class optCell extends TableCell<Park, Boolean> {
		  // final Button optButton       = new Button("完成");
		  // final StackPane paddedButton = new StackPane();
		   final Button optButton       = new Button("完成");
		   optCell( ) {
			  
			   optButton.setOnAction(new EventHandler<ActionEvent>(){

	                @Override
	                public void handle(ActionEvent t) {
	                 
			    	  try{
			    	  DBhelper connector = new DBhelper(); 
		              Integer orderId=table.getItems().get(optCell.this.getIndex()).getOrderId();
		              SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		          
		              Date end=new Date();
				       String endTime = dateFormat.format( end);
			    	 // Date end=dateFormat.parse(endTime);
				      String startTime=table.getItems().get(optCell.this.getIndex()).getStartTime();
			    	  Date start=dateFormat.parse(startTime.substring(0, 4)+"/"+startTime.substring(5, 7)+"/"+startTime.substring(8, 19));
			    	  long diff = end.getTime() - start.getTime();
			    	  System.out.println(diff);
				      double hour = diff/(1000*60*60);
				      System.out.println(hour);
				      double price= (Math.floor(hour)*3)+3;
				      String finish= "UPDATE park_order SET `status`='1',`endTime`='"+endTime+"',`perPrice`='"+price+"' WHERE `id`='"+orderId+"'";
	       		      connector.execute(finish);
	       		      showall();
	       		      
			    	  }catch(Exception e){    }
			    	  
	       		      
	       		     
	       		     // table.getItems().get(optCell.this.getIndex()).setStatus(1);
	       		      
	                }
	            });
		   }
		   @Override
	        protected void updateItem(Boolean t, boolean empty) {
	            super.updateItem(t, empty);
	            if(!empty &&  (table.getItems().get(optCell.this.getIndex()).getStatus() ==0) ){
	                setGraphic(optButton);
	            }
	        }
	   }
	   
	   public void showall(){
		   List.clear();
		   DBhelper connector = new DBhelper(); 
	       String query= "select * from park_order";
	       ResultSet result = connector.query(query);
	       try {
	         while (result.next()) {
				//System.out.println(result.getString("account"));
				Park tmp = new Park();
				tmp.setOrderId(result.getInt("id"));
				tmp.setCarId(result.getString("carNumber"));
				Integer statusTmp=result.getInt("status");
				tmp.setStatus(statusTmp);
				tmp.setPrice(result.getDouble("perPrice"));
				tmp.setEndTime(result.getString("endTime"));
				tmp.setStartTime(result.getString("startTime"));
				if(statusTmp==1) tmp.setStatus_w("完成");
				else tmp.setStatus_w("未完成");
				List.add(tmp);
	          }
	         table.refresh();
	       }
			  catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
	   
	   public void search_order(ActionEvent event){
			  TextInputDialog dialog = new TextInputDialog();

	    	  dialog.setTitle("车库管理系统");
	    	  dialog.setHeaderText("查找提示");
	    	  dialog.setContentText("请输入需要查找的车牌号:");
	    	  String carId=null;
	    	  // Traditional way to get the response value.
	    	  Optional<String> result = dialog.showAndWait();
	    	  if (result.isPresent()){
	    		  carId = result.get();
	    	      //System.out.println("Your name: " + result.get());
	    	  }
	    	  DBhelper connector = new DBhelper(); 
		      String query= "select * from park_order where carNumber='"+ carId+"'";
		      ResultSet result_info = connector.query(query);
		      List.clear();
		      try {
			         while (result_info.next()) {
			        		Park tmp = new Park();
							tmp.setOrderId(result_info.getInt("id"));
							tmp.setCarId(result_info.getString("carNumber"));
							Integer statusTmp=result_info.getInt("status");
							tmp.setStatus(statusTmp);
							tmp.setPrice(result_info.getDouble("perPrice"));
							tmp.setEndTime(result_info.getString("endTime"));
							tmp.setStartTime(result_info.getString("startTime"));
							if(statusTmp==1) tmp.setStatus_w("完成");
							else tmp.setStatus_w("未完成");
							List.add(tmp);
			          }
			         table.refresh();
			       }
					  catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		  }
	   public void  add_order(ActionEvent event){
		   TextInputDialog dialog = new TextInputDialog();

	    	  dialog.setTitle("车库管理系统");
	    	  dialog.setHeaderText("添加提示");
	    	  dialog.setContentText("请输入需要添加的车辆车牌号:");
	    	  String carId=null;
	    	  // Traditional way to get the response value.
	    	  Optional<String> result = dialog.showAndWait();
	    	  if (result.isPresent()){
	    		  carId = result.get();
	    		  
	    		  DBhelper connector = new DBhelper(); 
		    	  Double price=3.0;
		    	  Integer status=0;
		    	  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		    	  String startTime = dateFormat.format( new Date());
		    	  String insert= "insert into park_order (carNumber,startTime,status)"
		            		+ " values ('"+carId+"','"+startTime+"',"+status+")";
		            connector.execute(insert);
			      showall();
			      table.refresh();
	    	  }
	    	  
	    	  // The Java 8 way to get the response value (with lambda expression).
//	    	  result.ifPresent(name -> System.out.println("Your name: " + name));
		  }
	  
	   public void delete_order(){
	    	  TextInputDialog dialog = new TextInputDialog();

	    	  dialog.setTitle("车库管理系统");
	    	  dialog.setHeaderText("删除提示");
	    	  dialog.setContentText("请输入需要删除的订单号:");
	    	  String orderId=null;
	    	  // Traditional way to get the response value.
	    	  Optional<String> result = dialog.showAndWait();
	    	  if (result.isPresent()){
	    		  orderId = result.get();
	    	     
	    	  }
	    	  DBhelper connector = new DBhelper(); 
		      String delete= "delete from park_order where id='"+ orderId+"'";
		      connector.execute(delete);
		      showall();
		      table.refresh();
	    	  // The Java 8 way to get the response value (with lambda expression).
//	    	  result.ifPresent(name -> System.out.println("Your name: " + name));
		  }
}
