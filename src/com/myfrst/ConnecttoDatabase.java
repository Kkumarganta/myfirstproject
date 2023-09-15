package com.myfrst;
import java.sql.*;
import java.sql.Connection;

public class ConnecttoDatabase {
	    public static void main(String[] args) {
	        // JDBC connection parameters
	        String url = "jdbc:mysql://localhost:3306/myprofile";
	        String username = "root";
	        String password = "0705";

	        // Step 1: Load the JDBC driver
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	            return;
	        }

	        // Step 2: Establish a connection
	        try (Connection conn = DriverManager.getConnection(url, username, password)) {

	            // Step 3: Create a statement
	            Statement stmt = conn.createStatement();

	            // Step 4: Execute SQL queries or statements
	            //String sql = "SELECT * FROM table1";
	//            String sql = "insert into table1 values(2,'jay',26,143)";
	  //          ResultSet rs = stmt.executeQuery(sql);
	            String sql1 = "INSERT INTO table1 (id, name,age,phoneNumber) VALUES (3, 'jayaraaa',233,4444)";
	           int rowsAffected = stmt.executeUpdate(sql1);
	            System.out.println(rowsAffected + " row(s) affected.");
	            String sql = "SELECT * FROM table1";
	            ResultSet rs = stmt.executeQuery(sql);
	             
	            //Step 5: Process the results
	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String name = rs.getString("name");
	                int age =rs.getInt("age");
	                int phoneNumber=rs.getInt("phoneNumber");
	                System.out.println("ID: " + id + ", Name: " + name + ", age: " + age + ", phonenumber: ");
	            }

	            // Step 6: Close the connection and resources
	            rs.close();
	            stmt.close();

	        } 
	        catch (SQLException e) {
	        	e.printStackTrace();
	        }
	    }
}







