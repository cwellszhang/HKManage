package application;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Panel;
import javax.swing.JLayeredPane;
import Utils.DBhelper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;

public class LoginPage extends JFrame {
	private JFrame mFrame ;
	private JTextField userText;
	private JPasswordField passwdText;
    private JLabel hintLabel;
    public static String id;
    
/**
 * @wbp.parser.entryPoint
 */
	public LoginPage() {  
        super("Hotel King管理系统");
        this.setSize(800, 800);  
        setLocation(200, 50);
        JLabel backLabel = new JLabel(new ImageIcon("image/FjDg5aWTmopsvS49swMFlxlaM4wd.jpg"));  
        backLabel.setBounds(0, 0, this.getWidth(), this.getHeight());  
        JPanel imagePanel = (JPanel) this.getContentPane();  
        imagePanel.setOpaque(false);  
        imagePanel.setLayout(null);
        this.getLayeredPane().add(backLabel, new Integer(Integer.MIN_VALUE));        
        JLabel userLabel=new JLabel("职工号：");
        JLabel passwdLabel=new JLabel("密码：");
        userLabel.setBounds(520,20,560,40);
        passwdLabel.setBounds(520,40,560,60);
        userText=new JTextField();
        passwdText=new JPasswordField();
        hintLabel=new  JLabel("");
        JButton  loginButton=new JButton("登陆");
        loginButton.addActionListener(new userLogin());
        loginButton.setBounds(590,92,50,30);
        userText.setBounds(520,20,100,40);
        passwdText.setBounds(520,40,100,40);
        userText.setBounds(570,25,150,30);
        passwdText.setBounds(570,52,150,30);
        hintLabel.setBounds(640, 95, 100, 20);
        JPanel loginPanel=new JPanel();
        passwdText.addActionListener(new ActionListener() {  
            @Override  
            public void actionPerformed(ActionEvent e) {  
       
            	login();
               }  
        }); 
        userText.addActionListener(new ActionListener() {  
            @Override  
            public void actionPerformed(ActionEvent e) {  
            
            	login();
               }  
        }); 
        loginPanel.setBounds(0, 0,800, 800);
        loginPanel.setLayout(null);
        this.add(loginPanel);
        loginPanel.setOpaque(false);
        loginPanel.add(userLabel);
        loginPanel.add(passwdLabel);
        loginPanel.add(passwdText);
        loginPanel.add(userText);
        loginPanel.add(loginButton);
        loginPanel.add(hintLabel);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }  
	 private class  userLogin implements ActionListener{  
         public void actionPerformed(ActionEvent e) { 
        	login();
         }     
     }
	 
	 private void login()
	 {
		 try{
	        	DBhelper cn =new DBhelper();
	      	    ResultSet rs =cn.query("select * from employee_info where account='"+userText.getText()+"'");
	      	    Boolean success=false;
	      	    if (rs.next())
	      	    {
	      	       rs.previous();
	      	       while(rs.next()){
	                String passwd =  rs.getString("password");
	                if(passwd.equals(passwdText.getText())){
	                	System.out.println("success");
	                	success =true ;
	                }
	               }
	      	       
	      	       if(success)  
	      	    	   {
	      	    	     rs.previous();
	      	    	     hintLabel.setText("登陆成功");
	      	    	     id =String.valueOf(rs.getInt("id"));
	      	    	     System.out.println(id);
	      	             dispose();
	      	             Main applictaions=new Main();
	      	             applictaions.userlogin();
	      	             
	      	         
	      	    	   }
	      	       else hintLabel.setText("密码错误");
	      	    }
	      	    else 
	      	    {
	                hintLabel.setText("无此职工号");
	      	    }
	      	    rs.close();
	      	    cn.getCon().close();
	        	}catch (Exception e1)
	        	{
	        		e1.printStackTrace();
	        	}
	 }
	 
}