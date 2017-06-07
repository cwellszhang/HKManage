package Infomation;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;  
public class Entertainment {
	 private final SimpleIntegerProperty id = new SimpleIntegerProperty();  
     private final SimpleStringProperty type = new SimpleStringProperty();  
     private final SimpleStringProperty clientName = new SimpleStringProperty();  
     private final SimpleStringProperty clientPhone = new SimpleStringProperty();  
     private final SimpleStringProperty startTime = new SimpleStringProperty();  
     private final SimpleStringProperty endTime = new SimpleStringProperty();  
     private final SimpleDoubleProperty price = new SimpleDoubleProperty(); 
     private final SimpleIntegerProperty status = new SimpleIntegerProperty(); 
     private final StringProperty status_w = new SimpleStringProperty();
     public Integer getId() {  
         return id.get();  
     }  
     
     public void setId(Integer id) {  
         this.id.set(id);  
     }  
     public String getType() {  
         return type.get();  
     }  
     
     public void setType(String type) {  
         this.type.set(type);  
     }  
     public String getClientName() {  
         return clientName.get();  
     }  
     
     public void setClientName(String clientName) {  
         this.clientName.set(clientName);  
     }  
     public String getClientPhone() {  
         return clientPhone.get(); 
     }  
     public void setClientPhone(String clientPhone) {  
         this.clientPhone.set(clientPhone);  
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
