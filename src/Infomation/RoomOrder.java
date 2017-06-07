package Infomation;

import javafx.beans.property.SimpleStringProperty;

public class RoomOrder {
	private final SimpleStringProperty id = new SimpleStringProperty(); 
	private final SimpleStringProperty roomId = new SimpleStringProperty(); 
	private final SimpleStringProperty type = new SimpleStringProperty(); 
	private final SimpleStringProperty status = new SimpleStringProperty(); 
	private final SimpleStringProperty clientName1 = new SimpleStringProperty(); 
	private final SimpleStringProperty clientID1 = new SimpleStringProperty(); 
	private final SimpleStringProperty clientName2 = new SimpleStringProperty(); 
	private final SimpleStringProperty clientID2 = new SimpleStringProperty(); 
	private final SimpleStringProperty clientPhone = new SimpleStringProperty(); 
	private final SimpleStringProperty price = new SimpleStringProperty(); 
	private final SimpleStringProperty breakfast = new SimpleStringProperty(); 
	private final SimpleStringProperty service = new SimpleStringProperty(); 
	private final SimpleStringProperty day = new SimpleStringProperty(); 
	private final SimpleStringProperty startTime = new SimpleStringProperty(); 
	private final SimpleStringProperty endTime = new SimpleStringProperty(); 
	
	
    public String getId() {  
        return id.get();  
    }  
    public void setId(String id) {  
        this.id.set(id);  
    } 
    
    public String getRoomId() {  
        return roomId.get();  
    }  
    public void setRoomId(String id) {  
        this.roomId.set(id);  
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
    
    public String getClientName1() {  
        return clientName1.get();  
    }  
    public void setClientName1(String id) {  
        this.clientName1.set(id);  
    } 
    
    public String getClientID1() {  
        return clientID1.get();  
    }  
    public void setClientID1(String id) {  
        this.clientID1.set(id);  
    } 
    
    public String getClientName2() {  
        return clientName2.get();  
    }  
    public void setClientName2(String id) {  
        this.clientName2.set(id);  
    } 
    
    public String getClientID2() {  
        return clientID2.get();  
    }  
    public void setClientID2(String id) {  
        this.clientID2.set(id);  
    } 
    
    public String getClientPhone() {  
        return clientPhone.get();  
    }  
    public void setClientPhone(String id) {  
        this.clientPhone.set(id);  
    } 
    
    public String getPrice() {  
        return price.get();  
    }  
    public void setPrice(String id) {  
        this.price.set(id);  
    }
    
    public String getBreakfast() {  
        return breakfast.get();  
    }  
    public void setBreakfast(String id) {  
        this.breakfast.set(id);  
    }
    
    public String getService() {  
        return service.get();  
    }  
    public void setService(String id) {  
        this.service.set(id);  
    }
    
    public String getDay() {  
        return day.get();  
    }  
    public void setDay(String id) {  
        this.day.set(id);  
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
