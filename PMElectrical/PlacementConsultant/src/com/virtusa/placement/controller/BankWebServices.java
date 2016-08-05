package com.virtusa.placement.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;


public class BankWebServices  {
	public boolean paid = false;
	String card_type, card_number, err_msg = "Transaction Failed";
	int c_pin, max_limit, balance;
	Date dd;
	public String transaction(String type, String number, int pin,String date,int amount) {
		
		try 
		{
			SimpleDateFormat formatter = new SimpleDateFormat("MMM-yyyy");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@MT-TESTORADB:1521:oracl","ssampathkumar","sen");
			PreparedStatement pst = conn.prepareStatement("select * from bank_service where card_number=?");
			pst.setString(1, number);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				card_type = rs.getString(2);
				c_pin = rs.getInt(5);
				dd = rs.getDate(6);
				max_limit = rs.getInt(7);
				balance = rs.getInt(8);				
			}
			
			if(card_type == null)
			{
				err_msg = "Enter Your Valid credit card which is in Force";
			}
			else
			{
			if(card_type.equalsIgnoreCase(type))
			{
				if(c_pin == pin)
				{
					if(date.equalsIgnoreCase(formatter.format(dd)))
					{
						if(amount<max_limit)
						{
							if(amount<balance)
							{
								balance = balance - amount;
								paid = true;
								update(number,balance);
								//System.out.println("transaction over");
							}
							else
							{
								//System.out.println("Your card has low balance");
								err_msg = "Your card has low balance";
							}													
						}
						else
						{
							//System.out.println("This card's Maximum limit is crossed. Please give less amount");
							err_msg = "This card's Maximum limit is crossed. Please give less amount";
						}
					}
					else
					{
						//System.out.println("The expiry date is not correct");
						err_msg = "The expiry date is not correct";
					}
				}
				else
				{
					//System.out.println("The pin number provided is not correct");
					err_msg = "The pin number provided is not correct";
				}
			}
			else
			{
				//System.out.println("The Card does not belong to "+card_type+" type");
				err_msg = "The Card does not belong to "+card_type+" type";
			}
			}
			pst.close();
			conn.close();	
		} 
		catch(ClassNotFoundException e) 
		{
			System.out.println("There is an internal Class not Found error");
		} 
		catch (SQLException e) 
		{
			System.out.println("There is a problem in connection. Please get your Administrator's Help.");
		}
		finally
		{
			
		}
		if(paid == true)
			return "Transaction Completed";
		else 
			return err_msg;
	} 
	
	public void update(String number, int bal)
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@MT-TESTORADB:1521:oracl","ssampathkumar","sen");
			PreparedStatement pst = conn.prepareStatement("update bank_service set balance = ? where card_number = ?");
			pst.setInt(1, bal);
			pst.setString(2, number);
			int c = pst.executeUpdate();
			System.out.println(c);
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
