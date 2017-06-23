package Infomation;

import javafx.beans.property.SimpleStringProperty;

public class stock {
	 private final SimpleStringProperty id = new SimpleStringProperty();  
     private final SimpleStringProperty name = new SimpleStringProperty();  
     private final SimpleStringProperty type = new SimpleStringProperty();  
     
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
     public String getType() {  
         return type.get();  
     }  
     public void setType(String id) {  
         this.type.set(id);  
     }  
}

