package Infomation;

import javafx.beans.property.SimpleStringProperty;

public class DishOrder {
	private final SimpleStringProperty id = new SimpleStringProperty(); 
	private final SimpleStringProperty tableId = new SimpleStringProperty(); 
	private final SimpleStringProperty dishId = new SimpleStringProperty(); 
	private final SimpleStringProperty name = new SimpleStringProperty(); 
	private final SimpleStringProperty type = new SimpleStringProperty(); 
	private final SimpleStringProperty number = new SimpleStringProperty(); 
	private final SimpleStringProperty status = new SimpleStringProperty(); 
	
	public String getId() {  
        return id.get();  
    }  
    public void setId(String id) {  
        this.id.set(id);  
    } 
    public String getTableId() {  
        return tableId.get();  
    }  
    public void setTableId(String id) {  
        this.tableId.set(id);  
    } 
    public String getDishId() {  
        return dishId.get();  
    }  
    public void setDishId(String id) {  
        this.dishId.set(id);  
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
    public String getNumber() {  
        return number.get();  
    }  
    public void setNumber(String id) {  
        this.number.set(id);  
    } 
    public String getStatus() {  
        return status.get();  
    }  
    public void setStatus(String id) {  
        this.status.set(id);  
    } 

}
