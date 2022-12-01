package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import records.BankRecords;
import records.Records;

public class DaoModel {

		//Declare DB objects 
	DBConnect conn = null;
	Statement stmt = null;

		// constructor
		public DaoModel() { //create db object instance
		 conn = new DBConnect();
	}
		// CREATE TABLE METHOD
		public void createTable() {
		 try {

		 // Open a connection
		 System.out.println("Connecting to database to create Table...");
		 System.out.println("Connected database successfully...");

		 // Execute create query
		 System.out.println("Creating table in given database...");

		 stmt = conn.connect().createStatement();

			 String sql = "CREATE TABLE barrylab4_tab " + 
			              "(pid INTEGER not NULL AUTO_INCREMENT, " + 
			  	        " id VARCHAR(10), " +
					  " income numeric(8,2), " + 
					  " pep VARCHAR(10), " + 
				  " PRIMARY KEY ( pid ))";
		 stmt.executeUpdate(sql);
		 System.out.println("Created table in given database...");
		 conn.connect().close(); //close db connection 
		}catch (SQLException se) { // Handle errors for JDBC
		 se.printStackTrace();
		}
		     }
		public void insertRecords(BankRecords[] robjs) {
			  try {
			  // Execute a query
					
			  System.out.println("Inserting records into the table...");
			  stmt = conn.connect().createStatement();
			  String sql = null;
			  
			  // Include all object data to the database table
			  for (int i = 0; i < robjs.length; ++i) {
		        
	  	  // finish string assignment below to insert all array object data 
		   // (id, income, pep) into your database table
				  
	// add prepared statement
				
			   	
				  sql = "INSERT INTO barrylab4_tab(id, income, pep) " +
						  "VALUES (?,?,?)";
	    try (PreparedStatement pstmt = conn.connect().prepareStatement(sql)){
	    	pstmt.setString(1,robjs[i].getId());
	    	pstmt.setDouble(2,robjs[i].getIncome());
	    	pstmt.setString(3,robjs[i].getPep());
	    	pstmt.executeUpdate();
	    	}
	    	catch (SQLException e){
	    		
	    	e.printStackTrace();
	    	
			  }}
		  conn.connect().close();
			  } catch (SQLException se) { se.printStackTrace();  }
			  System.out.println("Inserts inserted");
		 }// INSERT INTO METHOD

		public ResultSet retrieveRecords() {
			
			 ResultSet rs = null;

			 try {
				stmt = conn.connect().createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			 String sql = "select pid, id,income, pep from barrylab4_tab order by pep desc";
			 try {
				rs = stmt.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 try {
				conn.connect().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return rs;
			}
}
