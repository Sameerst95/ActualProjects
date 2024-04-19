package com.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class DataBaseUtility {
	
	Connection conn;

	public  void getConnection() throws SQLException {
		// step1: Register Driver
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);

		// Step2: Get Connection for database
		conn= DriverManager.getConnection(IPathConstant.dbUrl, IPathConstant.dbUserName, IPathConstant.dbPassword);
	}
	
	public void getDataFromDB(String query ,int columIndex,String expData) throws SQLException {
		
		// Step3: Create Statement
		Statement st = conn.createStatement();

		
		// Step4: Execute query/ Update query

		ResultSet result = st.executeQuery(query);

		while (result.next()) 
		{
              String actualData=result.getString(columIndex) ;
              System.out.println(actualData);
              if(actualData.contains(expData)) {
            	  
            	  System.out.println("--Data is present --");
            	  return;
              }
		}
		System.out.println("--Data is Not present --");

		
	}
	
	public void closeConnection() throws SQLException {
		conn.close();
	}
	
	public static void main(String[] args) throws SQLException {
		DataBaseUtility db=new DataBaseUtility();
		
		db.getConnection();
	    db.getDataFromDB("select * from rmg;", 3, "sdet55");
	}

}
