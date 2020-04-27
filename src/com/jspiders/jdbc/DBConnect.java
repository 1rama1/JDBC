package com.jspiders.jdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



public class DBConnect {
	public static void main(String[]args){
		Properties props=new Properties();
		FileReader fr=null;
		Connection con=null;
		Statement stmt=null;
		
		String dbquery="ALTER TABLE family.family_members MODIFY COLUMN dateOfBirth varchar(15)";
		
		
		
		try {
			fr=new FileReader("config/dbconstants.Properties");
			
				props.load(fr);
			
			
			String driverclass=props.getProperty("driver","no key found");
			String dburl=props.getProperty("url", "no key found");
			String dbuser=props.getProperty("user", "no key found");
			String dbpwd=props.getProperty("password", "no key found");
			
			
				
					Class.forName(driverclass);
				
				System.out.println("Loaded an dRegistered the driver class");
				
	
				con=DriverManager.getConnection(dburl,props);
			
				System.out.println("DB Connection established"+con);
				
				stmt=con.createStatement( );
				System.out.println("Statement created" +stmt);
				
				boolean result=stmt.execute(dbquery);
				
				System.out.println("database established");
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e1) {
			
            e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
		
	}
	

}
