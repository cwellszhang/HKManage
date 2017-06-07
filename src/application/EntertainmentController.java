package application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

import Infomation.Entertainment;
import Infomation.Park;
import Utils.DBhelper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

public class EntertainmentController implements Initializable {
	   @FXML private Button btn_showall;
	   @FXML private Button btn_search;
	   @FXML private Button btn_add;
	   @FXML private Button btn_delete;
	   @FXML private Button btn_ktvshow;
	   @FXML private Button btn_gymshow;
	   @FXML private TableView<Entertainment> table;
	   @FXML private TableColumn<Entertainment,Integer> col_id;
	   @FXML private TableColumn<Entertainment,String> col_type;
	   @FXML private TableColumn<Entertainment,String> col_clientName;
	   @FXML private TableColumn<Entertainment,String> col_clientPhone;
	   @FXML private TableColumn<Entertainment,String> col_endTime;
	   @FXML private TableColumn<Entertainment,String> col_startTime;
	   @FXML private TableColumn<Entertainment,Double> col_price;
	   @FXML private TableColumn<Entertainment,Integer> col_status;
	   @FXML private TableColumn<Entertainment,Boolean> col_opt=new TableColumn<>("Action");
	   private static final ObservableList<Entertainment> List = FXCollections.observableArrayList();
	   public static Stage stage_add=new Stage();
	   @Override
	   public void initialize(URL location, ResourceBundle resources) {
	       // TODO (don't really need to do anything here)
		   col_id.setCellValueFactory(new PropertyValueFactory<Entertainment,Integer>("id"));
		   col_type.setCellValueFactory(new PropertyValueFactory<Entertainment,String>("type"));
		   col_price.setCellValueFactory(new PropertyValueFactory<Entertainment,Double>("price"));
		   col_status.setCellValueFactory(new PropertyValueFactory("status_w"));
		   col_clientName.setCellValueFactory(new PropertyValueFactory<Entertainment,String>("clientName"));
		   col_clientPhone.setCellValueFactory(new PropertyValueFactory<Entertainment,String>("clientPhone"));
		   col_endTime.setCellValueFactory(new PropertyValueFactory<Entertainment,String>("endTime"));
		   col_startTime.setCellValueFactory(new PropertyValueFactory<Entertainment,String>("startTime"));
		   col_opt.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Entertainment, Boolean>, ObservableValue<Boolean>>() {
			      @Override public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Entertainment, Boolean> features) {
			        return new SimpleBooleanProperty(false);
			      }
			    });
		   col_opt.setCellFactory(new Callback<TableColumn<Entertainment, Boolean>, TableCell<Entertainment, Boolean>>() {
			      @Override public TableCell<Entertainment, Boolean> call(TableColumn<Entertainment, Boolean> personBooleanTableColumn) {
			        return new optCell();
			      }
			    });
		   
		   table.setItems(List);
	       showall();
	   }
	   
	       private class optCell extends TableCell<Entertainment, Boolean> {
	 		  // final Button optButton       = new Button("完成");
	 		  // final StackPane paddedButton = new StackPane();
	 		   final Button optButton_s       = new Button("开始");
	 		  final Button optButton_e      = new Button("结束");
	 		   optCell( ) {
	 			   optButton_e.setOnAction(new EventHandler<ActionEvent>(){
	 	                @Override
	 	                public void handle(ActionEvent t) {
	 			    	  try{
	 			    	  DBhelper connector = new DBhelper(); 
	 		              Integer id=table.getItems().get(optCell.this.getIndex()).getId();
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
	 				      String typeTmp=table.getItems().get(optCell.this.getIndex()).getType();
	 				      double price=0.0;
	 				      if(typeTmp.equals("GYM"))   price= (Math.floor(hour)*25)+25;
	 				      else price = (Math.floor(hour)*50)+50;
	 				      String finish= "UPDATE entertainment_order SET `status`='1',`endTime`='"+endTime+"',`price`='"+price+"' WHERE `id`='"+id+"'";
	 	       		      connector.execute(finish);
	 	       		      showall();
	 	       		      
	 			    	  }catch(Exception e){    }
	 	                }
	 			  });
	 	                
	 			    	 optButton_s.setOnAction(new EventHandler<ActionEvent>(){
	 	 	                @Override
	 	 	                public void handle(ActionEvent t) {
	 	 			    	  try{
	 	 			    	  DBhelper connector = new DBhelper(); 
	 	 		              Integer id=table.getItems().get(optCell.this.getIndex()).getId();
	 	 		              SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 	 		             
	 	 		              Date start=new Date();
	 	 				       String startTime = dateFormat.format( start); 
	 	 				      String finish= "UPDATE entertainment_order SET `status`='0',`startTime`='"+startTime+"' WHERE `id`='"+id+"'";
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
	 	            if(!empty &&  (table.getItems().get(optCell.this.getIndex()).getStatus() ==-1) ){
	 	                setGraphic(optButton_s);
	 	            }
	 	           if(!empty &&  (table.getItems().get(optCell.this.getIndex()).getStatus() ==0) ){
	 	                setGraphic(optButton_e);
	 	            }
	 	            
	 	        }
	       }
	   
	   
	   
	   public  void  showall(){
		   List.clear();
		   DBhelper connector = new DBhelper(); 
	       String query= "select * from entertainment_order";
	       ResultSet result = connector.query(query);
	       try {
	         while (result.next()) {
				//System.out.println(result.getString("account"));
				Entertainment tmp = new Entertainment();
				tmp.setId(result.getInt("id"));
				tmp.setType(result.getString("type"));
				Integer statusTmp=result.getInt("status");
				tmp.setStatus(statusTmp);
				tmp.setPrice(result.getDouble("price"));
				tmp.setEndTime(result.getString("endTime"));
				tmp.setStartTime(result.getString("startTime"));
				tmp.setClientName(result.getString("clientName"));
				tmp.setClientPhone(result.getString("clientPhone"));
				if(statusTmp==-1) tmp.setStatus_w("预定");
				else if (statusTmp==0) tmp.setStatus_w("未完成");
				     else tmp.setStatus_w("完成");
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

	    	  dialog.setTitle("娱乐订单系统");
	    	  dialog.setHeaderText("查找提示");
	    	  dialog.setContentText("请输入需要查找的客户名字:");
	    	  String clientName=null;
	    	  // Traditional way to get the response value.
	    	  Optional<String> result = dialog.showAndWait();
	    	  if (result.isPresent()){
	    		  clientName = result.get();
	    	      //System.out.println("Your name: " + result.get());
	    	  }
	    	  DBhelper connector = new DBhelper(); 
		      String query= "select * from entertainment_order where clientName='"+clientName+"'";
		      ResultSet result_info = connector.query(query);
		      List.clear();
		      try {
			         while (result_info.next()) {
			        	 Entertainment tmp = new Entertainment();
							tmp.setId(result_info.getInt("id"));
							tmp.setType(result_info.getString("type"));
							Integer statusTmp=result_info.getInt("status");
							tmp.setStatus(statusTmp);
							tmp.setPrice(result_info.getDouble("price"));
							tmp.setEndTime(result_info.getString("endTime"));
							tmp.setStartTime(result_info.getString("startTime"));
							tmp.setClientName(result_info.getString("clientName"));
							tmp.setClientPhone(result_info.getString("clientPhone"));
							if(statusTmp==-1) tmp.setStatus_w("预定");
							else if (statusTmp==0) tmp.setStatus_w("未完成");
							     else tmp.setStatus_w("完成");
							List.add(tmp);
			          }
			         table.refresh();
			       }
					  catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		  }
	   public void delete_order(){
		   TextInputDialog dialog = new TextInputDialog();

	    	  dialog.setTitle("娱乐订单系统");
	    	  dialog.setHeaderText("删除提示");
	    	  dialog.setContentText("请输入需要删除的订单号:");
	    	  String orderId=null;
	    	  // Traditional way to get the response value.
	    	  Optional<String> result = dialog.showAndWait();
	    	  if (result.isPresent()){
	    		  orderId = result.get();
	    	     
	    	  }
	    	  DBhelper connector = new DBhelper(); 
		      String delete= "delete from entertainment_order where id='"+ orderId+"'";
		      connector.execute(delete);
		      showall();
		      table.refresh();
	   }
	   public void add_order(){
		   try {
				Parent root = FXMLLoader.load(getClass()
						.getResource("/application/AddEntertainment.fxml"));
				Scene scene = new Scene(root);
			    stage_add.setTitle("娱乐订单预定");
				stage_add.setScene(scene);
				stage_add.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
	   }
	   public void showgym(){
		   List.clear();
		   DBhelper connector = new DBhelper(); 
	       String query= "select * from entertainment_order where type= 'GYM'";
	       ResultSet result = connector.query(query);
	       try {
	         while (result.next()) {
				//System.out.println(result.getString("account"));
				Entertainment tmp = new Entertainment();
				tmp.setId(result.getInt("id"));
				tmp.setType(result.getString("type"));
				Integer statusTmp=result.getInt("status");
				tmp.setStatus(statusTmp);
				tmp.setPrice(result.getDouble("price"));
				tmp.setEndTime(result.getString("endTime"));
				tmp.setStartTime(result.getString("startTime"));
				tmp.setClientName(result.getString("clientName"));
				tmp.setClientPhone(result.getString("clientPhone"));
				if(statusTmp==-1) tmp.setStatus_w("预定");
				else if (statusTmp==0) tmp.setStatus_w("未完成");
				     else tmp.setStatus_w("完成");
				List.add(tmp);
	          }
	         table.refresh();
	       }
			  catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }
	   public void showktv(){
		   List.clear();
		   DBhelper connector = new DBhelper(); 
	       String query= "select * from entertainment_order where type = 'KTV'";
	       ResultSet result = connector.query(query);
	       try {
	         while (result.next()) {
				//System.out.println(result.getString("account"));
				Entertainment tmp = new Entertainment();
				tmp.setId(result.getInt("id"));
				tmp.setType(result.getString("type"));
				Integer statusTmp=result.getInt("status");
				tmp.setStatus(statusTmp);
				tmp.setPrice(result.getDouble("price"));
				tmp.setEndTime(result.getString("endTime"));
				tmp.setStartTime(result.getString("startTime"));
				tmp.setClientName(result.getString("clientName"));
				tmp.setClientPhone(result.getString("clientPhone"));
				if(statusTmp==-1) tmp.setStatus_w("预定");
				else if (statusTmp==0) tmp.setStatus_w("未完成");
				     else tmp.setStatus_w("完成");
				List.add(tmp);
	          }
	         table.refresh();
	       }
			  catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }
}
