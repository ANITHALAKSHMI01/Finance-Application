package com.chainsys.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.chainsys.util.ConnectionUtil;
public class BorrowerSide 
{
	public static int checkLender(String id) throws SQLException, ClassNotFoundException
	{
		int status=0;
		Connection connection=ConnectionUtil.getConnection();
		String select="select is_active from customer_details where customer_id=?";
		PreparedStatement prepareStatement=connection.prepareStatement(select);
		prepareStatement.setString(1, id);
		ResultSet resultSet=prepareStatement.executeQuery();
		while(resultSet.next())
		{
			status=resultSet.getInt(1);
		}
		connection.close();
		return status;
	}
	public static void updateActive(String id) throws ClassNotFoundException, SQLException
	{
		Connection connection=ConnectionUtil.getConnection();
		String update="update user set active=? where id=? ";
		PreparedStatement prepareStatement=connection.prepareStatement(update);
		prepareStatement.setInt(1,1);
		prepareStatement.setString(2,id);
		prepareStatement.executeUpdate();
		connection.close();
	}
	public static int checkActive(String id) throws ClassNotFoundException, SQLException
	{
		int status=0;
		Connection connection=ConnectionUtil.getConnection();
		String select="select active from user where id=?";
		PreparedStatement prepareStatement=connection.prepareStatement(select);
		prepareStatement.setString(1, id);
		ResultSet resultSet=prepareStatement.executeQuery();
		while(resultSet.next())
		{
			status=resultSet.getInt(1);
		}
		connection.close();
		return status;	
	}
	public static int getLoanId(String id) throws ClassNotFoundException, SQLException
	{
		int loanId=0;
		Connection connection=ConnectionUtil.getConnection();
		String update="select loan_id from loan_details  where customer_id=?";
		PreparedStatement prepareStatement=connection.prepareStatement(update);
		prepareStatement.setString(1, id);
		ResultSet resultSet=prepareStatement.executeQuery();
		while(resultSet.next())
		{
			loanId=resultSet.getInt(1);
		}
		return loanId;	
	}
	public static void removeBill(int id) throws ClassNotFoundException, SQLException
	{
		Connection connection=ConnectionUtil.getConnection();
		String update="update loan_details set status=? where loan_id=?";
		PreparedStatement prepareStatement=connection.prepareStatement(update);
		prepareStatement.setInt(1,1);
		prepareStatement.setInt(2,id);
//		&& status=?
//		prepareStatement.setInt(3, 0);
		prepareStatement.executeUpdate();
		connection.close();
	}
	public static long getAccountNo(String id) throws ClassNotFoundException, SQLException
	{
		long accountNo1=0;
		Connection connection=ConnectionUtil.getConnection();
		String select="select account_no from customer_details where customer_id=?";
		PreparedStatement prepareStatement = connection.prepareStatement(select);
		prepareStatement.setString(1, id);
		ResultSet resultSet = prepareStatement.executeQuery();
		while (resultSet.next()) 
		{
			String accountNo=resultSet.getString(1);
			accountNo1=Long.parseLong(accountNo);
		}
		connection.close();
		return accountNo1;
	}
	public static void addAccount(long accountNo,int amount) throws ClassNotFoundException, SQLException
	{
		Connection connection=ConnectionUtil.getConnection();
		String insert="insert into deposit_account(account_no,total_balance)values(?,?)";
		PreparedStatement prepareStatement = connection.prepareStatement(insert);
		prepareStatement.setLong(1,accountNo);
		prepareStatement.setInt(2, amount);
		prepareStatement.executeUpdate();
		connection.close();
	}
	public static int getAmount(long accountNo) throws ClassNotFoundException, SQLException
	{
		int amount=0;
		Connection connection=ConnectionUtil.getConnection();
		String select="select total_balance from deposit_account where account_no=?";
		PreparedStatement prepareStatement = connection.prepareStatement(select);
		prepareStatement.setLong(1,accountNo);
		ResultSet resultSet = prepareStatement.executeQuery();
		while (resultSet.next()) 
		{
			String amount1=resultSet.getString(1);
			amount=Integer.parseInt(amount1);
		}
		connection.close();
		return amount;	
	}
	public static void updateBalance(int amount,long accountNo) throws ClassNotFoundException, SQLException
	{
		Connection connection=ConnectionUtil.getConnection();
		String update="update deposit_account set total_balance=? where account_no=? ";
		PreparedStatement prepareStatement = connection.prepareStatement(update);
		prepareStatement.setInt(1, amount);
		prepareStatement.setLong(2,accountNo);
		prepareStatement.executeUpdate();
		connection.close();
	}
}
