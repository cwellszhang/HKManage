package Infomation;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;  

public class Finance {

		 private final SimpleStringProperty id = new SimpleStringProperty();  
	     private final SimpleStringProperty month = new SimpleStringProperty();  
	     private final SimpleStringProperty season = new SimpleStringProperty();  
	     private final SimpleStringProperty year = new SimpleStringProperty();  
	     private final SimpleStringProperty financecol = new SimpleStringProperty(); 
	     private final SimpleStringProperty pay = new SimpleStringProperty(); 
	     private final SimpleStringProperty income = new SimpleStringProperty(); 
	     private final SimpleStringProperty type = new SimpleStringProperty(); 
	     
	     public String getId() {  
	         return id.get();  
	     }  
	     public void setId(String id) {  
	         this.id.set(id);  
	     }  
	     public String getMonth() {  
	         return month.get();  
	     } 
	     
	     public void setMonth(String id) {  
	         this.month.set(id);  
	     }  
	     public String getYear() {  
	         return year.get();  
	     } 
	     
	     public void setYear(String id) {  
	         this.year.set(id);  
	     }  
	     public String getSeason() {  
	         return season.get();  
	     }     
	     public void setSeason(String id) {  
	         this.season.set(id);  
	     }  
	     public String getFinancecol() {  
	         return financecol.get();  
	     } 
	     public void setFinancecol(String id) {  
	         this.financecol.set(id);  
	     }  
	     public String getPay() {  
	         return pay.get();  
	     } 
	     public void setPay(String id) {  
	         this.pay.set(id);  
	     }  
	     public String getIncome() {  
	         return income.get();  
	     } 
	     public void setIncome(String id) {  
	         this.income.set(id);  
	     }  
	     public String getType() {  
	         return type.get();  
	     } 
	     public void setType(String id) {  
	         this.type.set(id);  
	     } 
}
