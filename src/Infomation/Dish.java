package Infomation;

import javafx.beans.property.SimpleStringProperty;

public class Dish {
	private final SimpleStringProperty id = new SimpleStringProperty(); 
	private final SimpleStringProperty name = new SimpleStringProperty(); 
	private final SimpleStringProperty type = new SimpleStringProperty(); 
	private final SimpleStringProperty price = new SimpleStringProperty(); 
	private final SimpleStringProperty elementId = new SimpleStringProperty(); 
	
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
    public String getPrice() {  
        return price.get();  
    }  
    public void setPrice(String id) {  
        this.price.set(id);  
    } 
    public String getElementId() {  
        return elementId.get();  
    }  
    public void setElementId(String id) {  
        this.elementId.set(id);  
    } 

}
