package com.chainsys.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.chainsys.model.LoanApp;
import com.chainsys.model.LoanBorrowerDetails;
import com.chainsys.util.ConnectionUtil;
public class AdminImplementation implements AdminDAO
{
	public static String password;
	@Override
	public void addUser(LoanApp loan) throws ClassNotFoundException, SQLException 
	{
		Connection connection=ConnectionUtil.getConnection();
		String insert="insert into user(id,name,category,date_of_birth,phone_no,email,password,location,status,active)values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement prepareStatement=connection.prepareStatement(insert);
		prepareStatement.setString(1, loan.getId());
		prepareStatement.setString(2, loan.getName());
		prepareStatement.setString(3, loan.getCategory());
		prepareStatement.setString(4, loan.getDateOfBirth());
		prepareStatement.setLong(5, loan.getPhoneNo());
		prepareStatement.setString(6, loan.getEmail());
		prepareStatement.setString(7, loan.getPassword());
		prepareStatement.setString(8, loan.getLocation());
		prepareStatement.setInt(9, 1);
		prepareStatement.setInt(10, 0);
		prepareStatement.executeUpdate();
		connection.close();
	}
	@Override
	public String checkAdmin(String email) throws ClassNotFoundException, SQLException 
	{
		Connection connection=ConnectionUtil.getConnection();
		String select="select password from user where email=? && category=? && status=?";
		PreparedStatement prepareStatement = connection.prepareStatement(select);
		prepareStatement.setString(1, email);
		prepareStatement.setString(2,"Admin");
		prepareStatement.setInt(3, 1);
		ResultSet resultSet = prepareStatement.executeQuery();
		while (resultSet.next()) 
		{
			password = resultSet.getString(1);
		}
		System.out.println(password);
		return password;
	}
	@Override
	public List<LoanApp> displayDetails() throws ClassNotFoundException, SQLException
	{
		ArrayList<LoanApp> list=new ArrayList<>();
		Connection connection=ConnectionUtil.getConnection();
		String select="select id,name,date_of_birth,phone_no,email,location from user where category=? && status=?";
		PreparedStatement prepareStatement=connection.prepareStatement(select);
		prepareStatement.setString(1, "Admin");
		prepareStatement.setInt(2, 1);
		ResultSet resultSet=prepareStatement.executeQuery();
		while(resultSet.next())
		{
			String id=resultSet.getString(1);
			String name=resultSet.getString(2);
			String dateOfBirth=resultSet.getString(3);
			String phoneNo=resultSet.getString(4);
			String email=resultSet.getString(5);
			String location=resultSet.getString(6);
			long phoneNumber=Long.parseLong(phoneNo);
			LoanApp loan=new LoanApp();
			loan.setId(id);
			loan.setName(name);
			loan.setDateOfBirth(dateOfBirth);
			loan.setPhoneNo(phoneNumber);
			loan.setEmail(email);
			loan.setLocation(location);
			list.add(loan);	
		}
		return list;
	}
	@Override
	public List<LoanApp> selectAdmin(String email) throws ClassNotFoundException, SQLException
	{
		ArrayList<LoanApp> list=new ArrayList<>();
		Connection connection=ConnectionUtil.getConnection();
		String select="select id,name,date_of_birth,phone_no,email,location from user where category=? && status=? && email=?";
		PreparedStatement prepareStatement=connection.prepareStatement(select);
		prepareStatement.setString(1, "Admin");
		prepareStatement.setInt(2, 1);
		prepareStatement.setString(3, email);
		ResultSet resultSet=prepareStatement.executeQuery();
		while(resultSet.next())
		{
			String id=resultSet.getString(1);
			String name=resultSet.getString(2);
			String dateOfBirth=resultSet.getString(3);
			String phoneNo=resultSet.getString(4);
			String email1=resultSet.getString(5);
			String location=resultSet.getString(6);
			long phoneNumber=Long.parseLong(phoneNo);
			LoanApp loan=new LoanApp();
			loan.setId(id);
			loan.setName(name);
			loan.setDateOfBirth(dateOfBirth);
			loan.setPhoneNo(phoneNumber);
			loan.setEmail(email1);
			loan.setLocation(location);
			list.add(loan);	
		}
		return list;
	}
	@Override
	public List<LoanBorrowerDetails> viewlendersDetail() throws ClassNotFoundException, SQLException 
	{
		ArrayList<LoanBorrowerDetails> list=new ArrayList<>();
		Connection connection=ConnectionUtil.getConnection();
		String select="select account_id,customer_id,purpose,account_no,pan_no,salary,loan_amount,city,state,pincode,proof,status  from customer_details where is_generate=? && is_active=?";
		PreparedStatement prepareStatement=connection.prepareStatement(select);
		prepareStatement.setInt(1, 0);
		prepareStatement.setInt(2, 0);
		ResultSet resultSet=prepareStatement.executeQuery();
		while(resultSet.next())
		{
			LoanBorrowerDetails loanBorrower=new LoanBorrowerDetails();
			loanBorrower.setApplicationId(Integer.parseInt(resultSet.getString(1)));
			loanBorrower.setBorrowerId(resultSet.getString(2));
			loanBorrower.setPurposeOfLoan(resultSet.getString(3));
			loanBorrower.setAccountNo(Long.parseLong(resultSet.getString(4)));
			loanBorrower.setPanNo(resultSet.getString(5));
			loanBorrower.setSalary(Integer.parseInt(resultSet.getString(6)));
			loanBorrower.setLoanAmount(Integer.parseInt(resultSet.getString(7)));
			loanBorrower.setCity(resultSet.getString(8));
			loanBorrower.setState(resultSet.getString(9));
			loanBorrower.setPincode(Integer.parseInt(resultSet.getString(10)));
			loanBorrower.setProof(resultSet.getBytes(11));
			loanBorrower.setStatus(resultSet.getString(12));
			list.add(loanBorrower);
		}
		return list;
	}
	@Override
	public List<LoanBorrowerDetails> searchStatus(String status) throws ClassNotFoundException, SQLException 
	{
		ArrayList<LoanBorrowerDetails> list=new ArrayList<>();
		Connection connection=ConnectionUtil.getConnection();
		String select="select account_id,customer_id,purpose,account_no,pan_no,salary,loan_amount,city,state,pincode,proof,status  from customer_details where status=? && is_active=?";
		PreparedStatement prepareStatement=connection.prepareStatement(select);
		prepareStatement.setString(1, status);
		prepareStatement.setInt(2, 0);
		ResultSet resultSet=prepareStatement.executeQuery();
		while(resultSet.next())
		{
			LoanBorrowerDetails loanBorrower=new LoanBorrowerDetails();
			loanBorrower.setApplicationId(Integer.parseInt(resultSet.getString(1)));
			loanBorrower.setBorrowerId(resultSet.getString(2));
			loanBorrower.setPurposeOfLoan(resultSet.getString(3));
			loanBorrower.setAccountNo(Long.parseLong(resultSet.getString(4)));
			loanBorrower.setPanNo(resultSet.getString(5));
			loanBorrower.setSalary(Integer.parseInt(resultSet.getString(6)));
			loanBorrower.setLoanAmount(Integer.parseInt(resultSet.getString(7)));
			loanBorrower.setCity(resultSet.getString(8));
			loanBorrower.setState(resultSet.getString(9));
			loanBorrower.setPincode(Integer.parseInt(resultSet.getString(10)));
			loanBorrower.setProof(resultSet.getBytes(11));
			loanBorrower.setStatus(resultSet.getString(12));
			list.add(loanBorrower);
		}
		return list;
	}
	@Override
	public void updateStatus(LoanBorrowerDetails loan) throws ClassNotFoundException, SQLException 
	{
		Connection connection=ConnectionUtil.getConnection();
		String update="update customer_details set status=? where customer_id=? ";
		PreparedStatement prepareStatement=connection.prepareStatement(update);
		prepareStatement.setString(1,loan.getStatus());
		prepareStatement.setString(2,loan.getBorrowerId());
		prepareStatement.executeUpdate();
		connection.close();
	}
	@Override
	public List<LoanBorrowerDetails> viewProof(String id) throws ClassNotFoundException, SQLException
	{
		ArrayList<LoanBorrowerDetails> list=new ArrayList<>();
		Connection connection=ConnectionUtil.getConnection();
		String select="select proof  from customer_details where customer_id=?";
		PreparedStatement prepareStatement=connection.prepareStatement(select);
		prepareStatement.setString(1,id);
		ResultSet resultSet=prepareStatement.executeQuery();
		LoanBorrowerDetails loan=new LoanBorrowerDetails();
		while(resultSet.next())
		{
			loan.setProof(resultSet.getBytes(1));
			list.add(loan);
		}
		return list;
	}
	@Override
	public void approveBorrower(LoanBorrowerDetails loan) throws ClassNotFoundException, SQLException 
	{
		Connection connection=ConnectionUtil.getConnection();
		String update="update customer_details set status=? where account_id=? ";
		PreparedStatement prepareStatement=connection.prepareStatement(update);
		prepareStatement.setString(1,loan.getStatus());
		prepareStatement.setInt(2,loan.getApplicationId());
		prepareStatement.executeUpdate();
		connection.close();
	}
	@Override
	public void sendBill(String id) throws ClassNotFoundException, SQLException
	{
		Connection connection=ConnectionUtil.getConnection();
		String update="update customer_details set is_generate=? where customer_id=? ";
		PreparedStatement prepareStatement=connection.prepareStatement(update);
		prepareStatement.setInt(1,1);
		prepareStatement.setString(2,id);
		prepareStatement.executeUpdate();
		connection.close();
	}
	@Override
	public int totalRegisteredBorrowers() throws ClassNotFoundException, SQLException
	{
		int total=0;
		Connection connection=ConnectionUtil.getConnection();
		String select="select count(*) from user where category=?";
		PreparedStatement prepareStatement=connection.prepareStatement(select);
		prepareStatement.setString(1, "Borrower");
		ResultSet resultSet=prepareStatement.executeQuery();
		while(resultSet.next())
		{
			total=resultSet.getInt(1);
		}
		connection.close();
		return total;
	}
	@Override
	public int totalLenders() throws ClassNotFoundException, SQLException 
	{
		int total=0;
		Connection connection=ConnectionUtil.getConnection();
		String select="select count(*) from customer_details";
		PreparedStatement prepareStatement=connection.prepareStatement(select);
		ResultSet resultSet=prepareStatement.executeQuery();
		while(resultSet.next())
		{
			total=resultSet.getInt(1);
		}
		connection.close();
		return total;
	}
	@Override
	public int totalApprovedLenders() throws ClassNotFoundException, SQLException 
	{
		int total=0;
		Connection connection=ConnectionUtil.getConnection();
		String select="select count(*) from customer_details where status=?";
		PreparedStatement prepareStatement=connection.prepareStatement(select);
		prepareStatement.setString(1, "Approved");
		ResultSet resultSet=prepareStatement.executeQuery();
		while(resultSet.next())
		{
			total=resultSet.getInt(1);
		}
		connection.close();
		return total;
	}
	@Override
	public void removeBorrower(int id) throws ClassNotFoundException, SQLException 
	{
		Connection connection=ConnectionUtil.getConnection();
		String update="update customer_details set is_active=? where account_id=? ";
		PreparedStatement prepareStatement=connection.prepareStatement(update);
		prepareStatement.setInt(1,1);
		prepareStatement.setInt(2,id);
		prepareStatement.executeUpdate();
		connection.close(); 
	}
}
