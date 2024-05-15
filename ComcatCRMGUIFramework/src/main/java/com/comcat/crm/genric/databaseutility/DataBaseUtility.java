package com.comcat.crm.genric.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection con;
/*public void getDbconnection(String url,String username,String password) throws SQLException {
	try {
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
  con= DriverManager.getConnection(url,username,password);
	}catch(Exception e) {
	}
}*/

public void getDbconnection() throws SQLException {
	try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con= DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects","root@%","root");
	}catch(Exception e) {
	}
}
public void closeDbconnection() {
	try {
		con.close();
	}
	catch(Exception e) {}
}

public ResultSet executeSelectQuery(String Query) {
	ResultSet result=null;
	try {
	Statement stat=con.createStatement();
	result =stat.executeQuery(Query);
}catch(Exception e) {
}
	return result;
}
public int executenonSelectQuery(String Query) {
	int result =0;
	try {
		Statement stat=con.createStatement();
		 stat.executeUpdate(Query);
	}catch(Exception e) {
		
	}
	return result;
	}
}
	


