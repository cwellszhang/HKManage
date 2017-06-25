package application;

import java.net.URL;
import java.util.ResourceBundle;

import Infomation.Employer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class FianceController implements Initializable  {
		   @FXML private Button btn_salary;
		   @FXML private Button btn_output;
		   @FXML private Button btn_income;
		   @FXML private Button btn_season;
		   @FXML private PieChart chart;
		   @FXML private LineChart linechart;
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			
		}
		
		public void show_salary(){
		  
		        ObservableList<PieChart.Data> pieChartData =
		                FXCollections.observableArrayList(
		                new PieChart.Data("总经理", 25000),
		                new PieChart.Data("部门经理", 15000),
		                new PieChart.Data("前台", 8000),
		                new PieChart.Data("服务员", 9000),
		                new PieChart.Data("厨师", 13000),
		                new PieChart.Data("清洁人员", 6000));
		        chart.setData(pieChartData);
		        chart.setTitle("员工工资分布");
		        chart.setVisible(true);
		        linechart.setVisible(false);
		        
		}
		
		public void show_income(){

	        ObservableList<PieChart.Data> pieChartData =
	                FXCollections.observableArrayList(
	                new PieChart.Data("餐饮部门", 25000),
	                new PieChart.Data("娱乐设施", 15000),
	                new PieChart.Data("客房", 8000),
	                new PieChart.Data("停车收费", 9000),
	                new PieChart.Data("预定费用", 13000),
	                new PieChart.Data("固定收入", 6000));
	        chart.setData(pieChartData);
	        chart.setTitle("员工工资分布");
	        chart.setVisible(true);
	        linechart.setVisible(false);
	        
	
		}
		public void show_output(){
	  
	        ObservableList<PieChart.Data> pieChartData =
	                FXCollections.observableArrayList(
	                new PieChart.Data("餐饮部门", 20000),
	                new PieChart.Data("娱乐设施", 4000),
	                new PieChart.Data("客房", 4000),
	                new PieChart.Data("停车场维护", 3000),
	                new PieChart.Data("固定支出", 13000));
	        chart.setData(pieChartData);
	        chart.setTitle("员工工资分布");
	        chart.setVisible(true);
	        linechart.setVisible(false);
	        
		}
		public void show_season(){
//			       Stage stage = new Stage();
//			        stage.setTitle("Line Chart Sample");
			        final CategoryAxis xAxis = new CategoryAxis();
			        final NumberAxis yAxis = new NumberAxis();
			         xAxis.setLabel("Month");
;			       
			        linechart.setTitle("Income Monitoring, 2017");
			                          
			        XYChart.Series series1 = new XYChart.Series();
			        series1.setName("餐饮业务");
			        
			        series1.getData().add(new XYChart.Data("Jan", 23));
			        series1.getData().add(new XYChart.Data("Feb", 14));
			        series1.getData().add(new XYChart.Data("Mar", 15));
			        series1.getData().add(new XYChart.Data("Apr", 24));
			        series1.getData().add(new XYChart.Data("May", 34));
			        series1.getData().add(new XYChart.Data("Jun", 36));
			        series1.getData().add(new XYChart.Data("Jul", 22));
			        series1.getData().add(new XYChart.Data("Aug", 45));
			        series1.getData().add(new XYChart.Data("Sep", 43));
			        series1.getData().add(new XYChart.Data("Oct", 17));
			        series1.getData().add(new XYChart.Data("Nov", 29));
			        series1.getData().add(new XYChart.Data("Dec", 25));
			        
			        XYChart.Series series2 = new XYChart.Series();
			        series2.setName("客房业务");
			        series2.getData().add(new XYChart.Data("Jan", 33));
			        series2.getData().add(new XYChart.Data("Feb", 34));
			        series2.getData().add(new XYChart.Data("Mar", 25));
			        series2.getData().add(new XYChart.Data("Apr", 44));
			        series2.getData().add(new XYChart.Data("May", 39));
			        series2.getData().add(new XYChart.Data("Jun", 16));
			        series2.getData().add(new XYChart.Data("Jul", 55));
			        series2.getData().add(new XYChart.Data("Aug", 54));
			        series2.getData().add(new XYChart.Data("Sep", 48));
			        series2.getData().add(new XYChart.Data("Oct", 27));
			        series2.getData().add(new XYChart.Data("Nov", 37));
			        series2.getData().add(new XYChart.Data("Dec", 29));
			        
			        XYChart.Series series3 = new XYChart.Series();
			        series3.setName("娱乐设施等");
			        series3.getData().add(new XYChart.Data("Jan", 44));
			        series3.getData().add(new XYChart.Data("Feb", 35));
			        series3.getData().add(new XYChart.Data("Mar", 36));
			        series3.getData().add(new XYChart.Data("Apr", 33));
			        series3.getData().add(new XYChart.Data("May", 31));
			        series3.getData().add(new XYChart.Data("Jun", 26));
			        series3.getData().add(new XYChart.Data("Jul", 22));
			        series3.getData().add(new XYChart.Data("Aug", 25));
			        series3.getData().add(new XYChart.Data("Sep", 43));
			        series3.getData().add(new XYChart.Data("Oct", 44));
			        series3.getData().add(new XYChart.Data("Nov", 45));
			        series3.getData().add(new XYChart.Data("Dec", 44));
			        
    			     
			        linechart.getData().clear();
			        linechart.getData().addAll(series1, series2, series3);
			        
			        chart.setVisible(false);
			        linechart.setVisible(true);
			   
			 
		}
		   
}
