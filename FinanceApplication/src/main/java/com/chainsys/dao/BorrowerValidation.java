package com.chainsys.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.chainsys.util.ConnectionUtil;
public class BorrowerValidation 
{
	public static  List checkEmail() throws ClassNotFoundException, SQLException 
	{
		ArrayList list=new ArrayList<>();
		Connection connection=ConnectionUtil.getConnection();
		String select="select email from user where category=? && status=?";
		PreparedStatement prepareStatement = connection.prepareStatement(select);
		prepareStatement.setString(1,"Borrower");
		prepareStatement.setInt(2, 1);
		ResultSet resultSet = prepareStatement.executeQuery();
		while (resultSet.next()) 
		{
			String email=resultSet.getString(1);
			list.add(email);
		}
		return list;
	}
	public static  List checkPhoneNo() throws ClassNotFoundException, SQLException 
	{
		ArrayList list=new ArrayList<>();
		Connection connection=ConnectionUtil.getConnection();
		String select="select phone_no from user where category=? && status=?";
		PreparedStatement prepareStatement = connection.prepareStatement(select);
		prepareStatement.setString(1,"Borrower");
		prepareStatement.setInt(2, 1);
		ResultSet resultSet = prepareStatement.executeQuery();
		while (resultSet.next()) 
		{
			String phoneNo=resultSet.getString(1);
			long phoneNo1=Long.parseLong(phoneNo);
			list.add(phoneNo1);;
		}
		return list;
	}
	public static  List checkPassword() throws ClassNotFoundException, SQLException 
	{
		ArrayList list=new ArrayList<>();
		Connection connection=ConnectionUtil.getConnection();
		String select="select password from user where category=? && status=?";
		PreparedStatement prepareStatement = connection.prepareStatement(select);
		prepareStatement.setString(1,"Borrower");
		prepareStatement.setInt(2, 1);
		ResultSet resultSet = prepareStatement.executeQuery();
		while (resultSet.next()) 
		{
			String password=resultSet.getString(1);
			list.add(password);;
		}
		return list;
	}
}
