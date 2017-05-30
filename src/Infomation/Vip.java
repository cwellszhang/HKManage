package Infomation;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Vip {
	 private final SimpleStringProperty id = new SimpleStringProperty();  
     private final SimpleStringProperty name = new SimpleStringProperty();  
     private final SimpleStringProperty sex = new SimpleStringProperty();  
     private final SimpleStringProperty phone = new SimpleStringProperty();  
     private final SimpleStringProperty address = new SimpleStringProperty(); 
     private final SimpleStringProperty degree = new SimpleStringProperty(); 
     private final SimpleStringProperty time = new SimpleStringProperty(); 
     public String getId() {  
         return id.get();  
     }  
     public void setId(String id) {  
         this.id.set(id);  
     }  
     public String getName() {  
         return name.get();  
     }  
     public void setName(String id) {  
         this.name.set(id);  
     } 
     public String getSex() {  
         return sex.get();  
     }  
     public void setSex(String id) {  
         this.sex.set(id);  
     }
     public String getPhone() {  
         return phone.get();  
     }  
     public void setPhone(String id) {  
         this.phone.set(id);  
     }
     public String getAddress() {  
         return address.get();  
     }  
     public void setAddress(String id) {  
         this.address.set(id);  
     }
     public String getDegree() {  
         return degree.get();  
     }  
     public void setDegree(String id) {  
         this.degree.set(id);  
     }
     public String getTime() {  
         return time.get();  
     }  
     public void setTime(String id) {  
         this.time.set(id);  
     }
}
