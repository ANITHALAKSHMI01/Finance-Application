package com.chainsys.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.chainsys.model.User;
import com.chainsys.model.LoanBorrowerDetails;
import com.chainsys.util.ConnectionUtil;
public class AdminImplementation implements AdminDAO
{
	@Override
	public void user(User user) throws ClassNotFoundException, SQLException 
	{
		Connection connection=ConnectionUtil.getConnection();
		String insert="insert into user(id,name,category,date_of_birth,phone_no,email,password,location,status,active)values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement prepareStatement=connection.prepareStatement(insert);
		prepareStatement.setString(1, user.getId());
		prepareStatement.setString(2, user.getName());
		prepareStatement.setString(3, user.getRole());
		prepareStatement.setString(4, user.getDateOfBirth());
		prepareStatement.setLong(5, user.getPhoneNo());
		prepareStatement.setString(6, user.getEmail());
		prepareStatement.setString(7, user.getPassword());
		prepareStatement.setString(8, user.getLocation());
		prepareStatement.setInt(9, 1);
		prepareStatement.setInt(10, 0);
		prepareStatement.executeUpdate();
		connection.close();
	}
	@Override
	public List<User> displayDetails() throws ClassNotFoundException, SQLException
	{
		ArrayList<User> list=new ArrayList<>();
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
			User loan=new User();
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
	public List<LoanBorrowerDetails> viewlendersDetail() throws ClassNotFoundException, SQLException 
	{
		ArrayList<LoanBorrowerDetails> list=new ArrayList<>();
		Connection connection=ConnectionUtil.getConnection();
		String select="select account_id,customer_id,account_no,pan_no,salary,loan_amount,city,state,pincode,proof,pay_slip,tenure,status  from customer_details where is_generate=? && is_active=?";
		PreparedStatement prepareStatement=connection.prepareStatement(select);
		prepareStatement.setInt(1, 0);
		prepareStatement.setInt(2, 0);
		ResultSet resultSet=prepareStatement.executeQuery();
		while(resultSet.next())
		{
			LoanBorrowerDetails loanBorrower=new LoanBorrowerDetails();
			loanBorrower.setApplicationId(Integer.parseInt(resultSet.getString(1)));
			loanBorrower.setBorrowerId(resultSet.getString(2));
			loanBorrower.setAccountNo(Long.parseLong(resultSet.getString(3)));
			loanBorrower.setPan(resultSet.getString(4));
			loanBorrower.setSalary(Integer.parseInt(resultSet.getString(5)));
			loanBorrower.setLoanAmount(Integer.parseInt(resultSet.getString(6)));
			loanBorrower.setCity(resultSet.getString(7));
			loanBorrower.setState(resultSet.getString(8));
			loanBorrower.setPincode(Integer.parseInt(resultSet.getString(9)));
			loanBorrower.setProof(resultSet.getBytes(10));
			loanBorrower.setPaySlip(resultSet.getBytes(11));
			loanBorrower.setTenure(Integer.parseInt(resultSet.getString(12)));
			loanBorrower.setStatus(resultSet.getString(13));
			list.add(loanBorrower);
		}
		return list;
	}
	@Override
	public List<LoanBorrowerDetails> searchStatus(String status) throws ClassNotFoundException, SQLException 
	{
		ArrayList<LoanBorrowerDetails> list=new ArrayList<>();
		Connection connection=ConnectionUtil.getConnection();
		String select="select account_id,customer_id,account_no,pan_no,salary,loan_amount,city,state,pincode,proof,pay_slip,tenure,status  from customer_details where status=? && is_active=?";
		PreparedStatement prepareStatement=connection.prepareStatement(select);
		prepareStatement.setString(1, status);
		prepareStatement.setInt(2, 0);
		ResultSet resultSet=prepareStatement.executeQuery();
		while(resultSet.next())
		{
			LoanBorrowerDetails loanBorrower=new LoanBorrowerDetails();
			loanBorrower.setApplicationId(Integer.parseInt(resultSet.getString(1)));
			loanBorrower.setBorrowerId(resultSet.getString(2));
			loanBorrower.setAccountNo(Long.parseLong(resultSet.getString(3)));
			loanBorrower.setPan(resultSet.getString(4));
			loanBorrower.setSalary(Integer.parseInt(resultSet.getString(5)));
			loanBorrower.setLoanAmount(Integer.parseInt(resultSet.getString(6)));
			loanBorrower.setCity(resultSet.getString(7));
			loanBorrower.setState(resultSet.getString(8));
			loanBorrower.setPincode(Integer.parseInt(resultSet.getString(9)));
			loanBorrower.setProof(resultSet.getBytes(10));
			loanBorrower.setPaySlip(resultSet.getBytes(11));
			loanBorrower.setTenure(Integer.parseInt(resultSet.getString(12)));
			loanBorrower.setStatus(resultSet.getString(13));
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
	public List<LoanBorrowerDetails> viewPaySlip(String id) throws ClassNotFoundException, SQLException
	{
		ArrayList<LoanBorrowerDetails> list=new ArrayList<>();
		Connection connection=ConnectionUtil.getConnection();
		String select="select pay_slip  from customer_details where customer_id=?";
		PreparedStatement prepareStatement=connection.prepareStatement(select);
		prepareStatement.setString(1,id);
		ResultSet resultSet=prepareStatement.executeQuery();
		LoanBorrowerDetails loan=new LoanBorrowerDetails();
		while(resultSet.next())
		{
			loan.setPaySlip(resultSet.getBytes(1));
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
