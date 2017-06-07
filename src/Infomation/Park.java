package Infomation;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
public class Park {
	 private final SimpleIntegerProperty orderId = new SimpleIntegerProperty();  
     private final SimpleStringProperty carId = new SimpleStringProperty();  
     private final SimpleStringProperty startTime = new SimpleStringProperty();  
     private final SimpleStringProperty endTime = new SimpleStringProperty();  
     private final SimpleDoubleProperty price = new SimpleDoubleProperty(); 
     private final SimpleIntegerProperty status = new SimpleIntegerProperty(); 
     private final StringProperty status_w = new SimpleStringProperty();
     //private final Number status = new Number();
     public Integer getOrderId() {  
         return orderId.get();  
     }  
     
     public void setOrderId(Integer id) {  
         this.orderId.set(id);  
     }  
     
     public String getCarId() {  
         return carId.get();  
     }  
     
     public void setCarId(String carId) {  
         this.carId.set(carId);  
     }  
     public String getStartTime() {  
         return startTime.get();  
     }  
     
     public void setStartTime(String startTime) {  
         this.startTime.set(startTime);  
     }  
     public String getEndTime() {  
         return endTime.get(); 
     }  
     public void setEndTime(String endTime) {  
         this.endTime.set(endTime);  
     }  
     public Double getPrice() {  
         return price.get();  
     }  
     
     public void setPrice(Double price) {  
         this.price.set(price);  
     }  
     public Integer getStatus() {  
         return status.get();  
     }  
     
     public void setStatus(Integer status) {  
         this.status.set(status);  
     }  
     public StringProperty statusProperty() {
         return status_w;
     }
     public void setStatus_w(String status_w) {
         this.status_w.set(status_w);
     }
     public String getStatus_w(){
         return status_w.get();
     }  
     
     
}
