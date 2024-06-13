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
}
