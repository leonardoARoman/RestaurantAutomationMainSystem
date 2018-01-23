package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MySqlManager {
	// Instance variable to access mysql database
	private String url = "jdbc:mysql://localhost:3306/AutomatedRestaurant";
	private String myDriver = "org.gjt.mm.mysql.Driver";
	private String u_name = "root";
	private String pass = "LEoking1987";
	private static MySqlManager mysql = null;
	
	private MySqlManager() {}
	
	public static MySqlManager getInstance() {
		if(mysql == null)
			mysql = new MySqlManager();
		
		return mysql;
	}
	
	public ArrayList<String> getFastFood() {
		ArrayList<String> fastfood = new ArrayList<String>();
		//Accessing DBMS
		try {
			Class.forName(myDriver);
			Connection connection = DriverManager.getConnection(url, u_name, pass);
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("select item, price from menu where section = 'fast food' ");
			while(rs.next()) {
				fastfood.add(rs.getString("item")+", "+rs.getString("price"));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage()+": Error!");
		}	
		return fastfood;
	}
	
	public ArrayList<String> getSpecials() {
		ArrayList<String> specials = new ArrayList<String>();
		//Accessing DBMS
		try {
			Class.forName(myDriver);
			Connection connection = DriverManager.getConnection(url, u_name, pass);
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("select item, price from menu where section = 'specials' ");
			while(rs.next()) {
				specials.add(rs.getString("item")+", "+rs.getString("price"));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage()+": Error!");
		}	
		return specials;
	}
	
	public ArrayList<String> getDesert() {
		ArrayList<String> deserts = new ArrayList<String>();
		//Accessing DBMS
		try {
			Class.forName(myDriver);
			Connection connection = DriverManager.getConnection(url, u_name, pass);
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("select item, price from menu where section = 'desert' ");
			while(rs.next()) {
				deserts.add(rs.getString("item")+", "+rs.getString("price"));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage()+": Error!");
		}	
		return deserts;
	}
	
	public ArrayList<String> getDrinks() {
		ArrayList<String> drinks = new ArrayList<String>();
		//Accessing DBMS
		try {
			Class.forName(myDriver);
			Connection connection = DriverManager.getConnection(url, u_name, pass);
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("select item, price from menu where section = 'drinks' ");
			while(rs.next()) {
				drinks.add(rs.getString("item")+", "+rs.getString("price"));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage()+": Error!");
		}	
		return drinks;
	}
	
	public ArrayList<String> getRervations(){
		// make changes:
		return null;
	}
	
	public void makeReservation(String name, String lastname, String phone, Date time) {
		// Implement here:
	}
}
