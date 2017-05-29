package Infomation;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;  
public class Employer {
	 private final SimpleStringProperty userid = new SimpleStringProperty();  
     private final SimpleStringProperty username = new SimpleStringProperty();  
     private final SimpleIntegerProperty sex = new SimpleIntegerProperty();  
     private final SimpleIntegerProperty priority = new SimpleIntegerProperty();  
     private final SimpleStringProperty department = new SimpleStringProperty(); 
     private final SimpleStringProperty account = new SimpleStringProperty(); 
     private final SimpleStringProperty password = new SimpleStringProperty(); 
     private final SimpleStringProperty salary = new SimpleStringProperty(); 
     private final SimpleStringProperty entryDate = new SimpleStringProperty(); 
     private final SimpleStringProperty birthday = new SimpleStringProperty(); 
     
     public String getId() {  
         return userid.get();  
     }  
     
     public void setId(String id) {  
         this.userid.set(id);  
     }  
     public String getUsername() {  
         return username.get();  
     }  
     public void setUsername(String username) {  
         this.username.set(username);  
     }  
     public Integer getSex() {  
         return sex.get();  
     }  
     public void setSex(Integer i) {  
         this.sex.set(i);  
     }  
     
     public Integer getPriority() {  
         return priority.get();  
     }  
     public void setPriority(Integer i) {  
         this.priority.set(i);  
     }  
     public void setDepartment(String id) {  
         this.department.set(id);  
     }  
     public String getDepartment() {  
         return department.get();  
     }  
     public void setAccount(String id) {  
         this.account.set(id);  
     }  
     public String getAccount() {  
         return account.get();  
     }  
     public void setPassword(String id) {  
         this.password.set(id);  
     }  
     public String getPassword() {  
         return password.get();  
     }  
     public void setSalary(String id) {  
         this.salary.set(id);  
     }  
     public String getSalary() {  
         return salary.get();  
     }  
     public void setEntrydate(String id) {  
         this.entryDate.set(id);  
     }  
     public String getEntryDate() {  
         return entryDate.get();  
     } 
     public void setBirthday(String id) {  
         this.birthday.set(id);  
     }  
     public String getBirthday() {  
         return birthday.get();  
     }  
}
