package model.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.ButtonAction;

public class DbOperations 
{

    private Connection conn;
    private  String url;
    private  String dbName;
    private  String driver;
    private  String userName;
    private  String password;
	private Statement statement;
	private PreparedStatement prepareStatement;
	private ResultSet resultSet;
	
	private static final String SQL_ADD = "INSERT INTO btnAction VALUES(?, ?, ?, ?, ?)";
	private static final String SQL_SELECT_ALL = "SELECT * FROM btnAction";
	
    public DbOperations() {

        conn = null;
        url = "jdbc:mysql://localhost:8080/";
        dbName = "vt";
        driver = "com.mysql.jdbc.Driver";
        userName = "root";
        password = "";
        statement = null;
    }
    
    public Connection getConnection()
    {
    	
    	try 
    	{
			return DriverManager.getConnection(url,userName,password);
		} 
    	catch (SQLException e) 
    	{
    		System.out.println("hata mesajý:"+e.getMessage());
			return null;
		}
    }
    
	public boolean add(ButtonAction btn) 
	{
		boolean isAdd = false;
		
		try
		{
			prepareStatement = this.getConnection().prepareStatement(SQL_ADD);
			prepareStatement.setString(1, btn.getButtonId());
			prepareStatement.setString(2, btn.getButtonName());
			prepareStatement.setString(3, btn.getBrowser());
			prepareStatement.setString(4, btn.getUrl());
			prepareStatement.setString(5, btn.getDateTime());
			prepareStatement.executeQuery();
			isAdd = true;
		}
		catch(SQLException exception)
		{
			System.out.println("hata mesajý:"+exception.getMessage());
		}
		
		return isAdd;
	}

	public List<ButtonAction> herkesiCek(String id, String name, String browser, String url, String dateTime) throws SQLException
	{
		List<ButtonAction> btnActs = new ArrayList<ButtonAction>();
		 ButtonAction btnAct;
		statement = getConnection().createStatement();
		resultSet = statement.executeQuery(SQL_SELECT_ALL);
		while (resultSet.next()) 
		{
			btnActs.add(btnAct = new ButtonAction( id, name, browser, url, dateTime) );
		}
		
		return btnActs;
	}


}
