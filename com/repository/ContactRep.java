package com.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.contact.dto.Contacts;


public class ContactRep {
	public static ContactRep repInstance;
	public boolean flag=false;
	private ContactRep() {
		startConnect();
	}
	
	public static ContactRep getInstance() {
		if(repInstance==null) {
			repInstance=new ContactRep();
			
		}
		return repInstance;
	}
	
	private Connection conn;
	
	
	private void startConnect() {
		String url = "jdbc:mysql://localhost:3306/Contact";
		String username = "root";
		String password ="Selvam@20";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conn =  DriverManager.getConnection(url,username,password);
//			System.out.println("Connected successfully..");
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	private void endConnection(){
        try{
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
	public List<Contacts> searchContact(String key) {
		
		String query="select * from peoples where username=? OR phoneNum = ?";
		List<Contacts> searchcontacts=new ArrayList<>();
		try {
		
		   PreparedStatement stmt = conn.prepareStatement(query);
		   stmt.setString(2,key);
		   stmt.setString(1,key);
		   ResultSet rs=stmt.executeQuery();
		   while(rs.next()) {
			   if(rs.getString("username")==null) {
				   flag=false;
				   break;
			   }
			   long phoneNum1=Long.parseLong(rs.getString("phoneNum"));
			   Contacts temp=new Contacts(rs.getString("username"),phoneNum1,rs.getString("address"),rs.getString("favstate"));
			   searchcontacts.add(temp);
			   flag=true;		   
		   }
		   return searchcontacts;		   
		}
		catch(SQLException e){
			e.getMessage();
		}		
		return  null;
	}

	public boolean deleteContact(String name) {
		String query= "DELETE FROM peoples where username=?";
		try {
			PreparedStatement stmt = this.conn.prepareStatement(query);
			stmt.setString(1, name);
			int rows=stmt.executeUpdate();
            if (rows > 0) {
                return true;
			}
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public void deleteAllContact() {
		String query="truncate table peoples";
		try {
		   PreparedStatement stmt = this.conn.prepareStatement(query);
		   stmt.executeUpdate();
		   
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
						
	}
	
	public boolean insertContact(String name, long phoneNo, String address, String fav) {
		String query = "INSERT INTO peoples (username, phoneNum, address,favState) VALUES (?, ?, ?,?)";
		
		try {
			PreparedStatement stmt = this.conn.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setString(2, String.valueOf(phoneNo));
			stmt.setString(3, address);
			stmt.setString(4, fav);
			
			int rowsInserted = stmt.executeUpdate();
			if (rowsInserted > 0) {
                
                return true;
			}		
		}
		catch(SQLException e) {
		  System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean editContactByNum(long phoneNo, String name) {
		String query = "Update peoples set username=? where phoneNum= ?";
		try {
		    PreparedStatement stmt = this.conn.prepareStatement(query);
		    stmt.setString(1, name);
		    stmt.setString(2, String.valueOf(phoneNo));
		    int rowsInserted = stmt.executeUpdate();
			if (rowsInserted > 0) {
                
                return true;
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean editContactByName(String name,long phoneNo) {
		String query = "Update peoples set phoneNum=? where username= ?";
		try {
		    PreparedStatement stmt = this.conn.prepareStatement(query);
		    stmt.setString(1, String.valueOf(phoneNo));
		    stmt.setString(2, name);
		    int rowsInserted = stmt.executeUpdate();
			if (rowsInserted > 0) {
                
                return true;
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}

