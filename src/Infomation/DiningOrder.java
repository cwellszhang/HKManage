package Infomation;

import javafx.beans.property.SimpleStringProperty;

public class DiningOrder {
	private final SimpleStringProperty id = new SimpleStringProperty(); 
	private final SimpleStringProperty tableId = new SimpleStringProperty(); 
	private final SimpleStringProperty clientName = new SimpleStringProperty(); 
	private final SimpleStringProperty clientPhone = new SimpleStringProperty(); 
	private final SimpleStringProperty clientNumber = new SimpleStringProperty(); 
	private final SimpleStringProperty dishId = new SimpleStringProperty(); 
	private final SimpleStringProperty price = new SimpleStringProperty(); 
	private final SimpleStringProperty type = new SimpleStringProperty(); 
	private final SimpleStringProperty status = new SimpleStringProperty(); 
	private final SimpleStringProperty waiterName = new SimpleStringProperty(); 
	private final SimpleStringProperty startTime = new SimpleStringProperty(); 
	private final SimpleStringProperty endTime = new SimpleStringProperty(); 

	
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

    public String getClientName() {  
        return clientName.get();  
    }  
    public void setClientName(String id) {  
        this.clientName.set(id);  
    } 
    
    public String getClientPhone() {  
        return clientPhone.get();  
    }  
    public void setClientPhone(String id) {  
        this.clientPhone.set(id);  
    } 
    
    public String getClientNumber() {  
        return clientNumber.get();  
    }  
    public void setClientNumber(String id) {  
        this.clientNumber.set(id);  
    } 
    
    public String getDishId() {  
        return dishId.get();  
    }  
    public void setDishId(String id) {  
        this.dishId.set(id);  
    } 
    
    public String getPrice() {  
        return price.get();  
    }  
    public void setPrice(String id) {  
        this.price.set(id);  
    } 
    
    public String getType() {  
        return type.get();  
    }  
    public void setType(String id) {  
        this.type.set(id);  
    } 
    
    public String getStatus() {  
        return status.get();  
    }  
    public void setStatus(String id) {  
        this.status.set(id);  
    } 
    
    public String getWaiterName() {  
        return waiterName.get();  
    }  
    public void setWaiterName(String id) {  
        this.waiterName.set(id);  
    } 
    
    public String getStartTime() {  
        return startTime.get();  
    }  
    public void setStartTime(String id) {  
        this.startTime.set(id);  
    } 
    
    public String getEndTime() {  
        return endTime.get();  
    }  
    public void setEndTime(String id) {  
        this.endTime.set(id);  
    } 
}
