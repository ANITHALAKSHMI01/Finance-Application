package com.chainsys.dao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;

import com.chainsys.model.AmountDetails;
import com.chainsys.model.LoanApp;
import com.chainsys.model.LoanBorrowerDetails;
import com.chainsys.util.ConnectionUtil;
public class BorrowerImplementation implements BorrowerDAO
{
	public static String password,borrowerId,status;
	@Override
	public String checkBorrower(String email) throws ClassNotFoundException, SQLException
	{
		Connection connection=ConnectionUtil.getConnection();
		String select="select password from user where email=? && category=? && status=? ";
		PreparedStatement prepareStatement = connection.prepareStatement(select);
		prepareStatement.setString(1, email);
		prepareStatement.setString(2,"Borrower");
		prepareStatement.setInt(3,1);
		ResultSet resultSet = prepareStatement.executeQuery();
		while (resultSet.next()) 
		{
			password = resultSet.getString(1);
		}
		return password;
	}
	@Override
	public List<LoanApp> displayBorrowers() throws ClassNotFoundException, SQLException 
	{
		ArrayList<LoanApp> list=new ArrayList<>();
		Connection connection=ConnectionUtil.getConnection();
		String select="select id,name,date_of_birth,phone_no,email,location from user where category=? && status=?";
		PreparedStatement prepareStatement=connection.prepareStatement(select);
		prepareStatement.setString(1, "Borrower");
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
	public void removeUser(LoanApp loan) throws ClassNotFoundException, SQLException 
	{
		Connection connection=ConnectionUtil.getConnection();
		String update="update user set status=? where id=? ";
		PreparedStatement prepareStatement=connection.prepareStatement(update);
		prepareStatement.setInt(1,0);
		prepareStatement.setString(2,loan.getId());
		prepareStatement.executeUpdate();
		connection.close();
	}
	@Override
	public void updateUser(LoanApp loan) throws ClassNotFoundException, SQLException
	{
		System.out.println(loan.getId()+loan.getLocation()+loan.getEmail()+loan.getName()+loan.getPhoneNo());
		Connection connection=ConnectionUtil.getConnection();
		String update="update user set name=?,phone_no=?,email=?,location=? where id=? ";
		PreparedStatement prepareStatement=connection.prepareStatement(update);
		prepareStatement.setString(1,loan.getName());
		prepareStatement.setLong(2,loan.getPhoneNo());
		prepareStatement.setString(3,loan.getEmail());
		prepareStatement.setString(4,loan.getLocation());
		prepareStatement.setString(5,loan.getId());
		prepareStatement.executeUpdate();
		connection.close();
	}
	@Override
	public List<LoanApp> selectBorrower(String email) throws ClassNotFoundException, SQLException
	{
		ArrayList<LoanApp> list=new ArrayList<>();
		Connection connection=ConnectionUtil.getConnection();
		String select="select id,name,date_of_birth,phone_no,email,location from user where category=? && status=? && email=?";
		PreparedStatement prepareStatement=connection.prepareStatement(select);
		prepareStatement.setString(1, "Borrower");
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
	public String checkId(String email) throws ClassNotFoundException, SQLException 
	{
		Connection connection=ConnectionUtil.getConnection();
		String select="select id from user where email=? && category=? && status=?";
		PreparedStatement prepareStatement = connection.prepareStatement(select);
		prepareStatement.setString(1, email);
		prepareStatement.setString(2,"Borrower");
		prepareStatement.setInt(3,1);
		ResultSet resultSet = prepareStatement.executeQuery();
		while (resultSet.next()) 
		{
			borrowerId = resultSet.getString(1);
		}
		return borrowerId;
	}
	@Override
	public int addLender(LoanBorrowerDetails loanBorrow) throws ClassNotFoundException, SQLException
	{
		Connection connection=ConnectionUtil.getConnection();
		String insert="insert into customer_details(customer_id,purpose,account_no,pan_no,salary,city,state,pincode,proof,status,loan_amount)values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement prepareStatement=connection.prepareStatement(insert);
		prepareStatement.setString(1, loanBorrow.getBorrowerId());
		prepareStatement.setString(2, loanBorrow.getPurposeOfLoan());
		prepareStatement.setLong(3, loanBorrow.getAccountNo());
		prepareStatement.setString(4, loanBorrow.getPanNo());
		prepareStatement.setInt(5, loanBorrow.getSalary());
		prepareStatement.setString(6, loanBorrow.getCity());
		prepareStatement.setString(7, loanBorrow.getState());
		prepareStatement.setInt(8, loanBorrow.getPincode());
		prepareStatement.setBytes(9,loanBorrow.getProof());
		prepareStatement.setString(10,loanBorrow.getStatus());
		prepareStatement.setInt(11,loanBorrow.getLoanAmount());
		int row=prepareStatement.executeUpdate();
		connection.close();
		return row;
	}
	@Override
	public List<LoanBorrowerDetails> lenderLoan(String id) throws ClassNotFoundException, SQLException 
	{
		ArrayList<LoanBorrowerDetails> list=new ArrayList<>();
		Connection connection=ConnectionUtil.getConnection();
		String select="select account_id,customer_id,purpose,account_no,pan_no,salary,loan_amount,city,state,pincode,proof,status  from customer_details where customer_id=?";
		PreparedStatement prepareStatement=connection.prepareStatement(select);
		prepareStatement.setString(1, id);
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
	public void updateAppliedLoan(LoanBorrowerDetails loanBorrow) throws ClassNotFoundException, SQLException
	{
		Connection connection=ConnectionUtil.getConnection();
		String update="update customer_details set purpose=?,account_no=?,pan_no=?,salary=?,city=?,state=?,pincode=?,proof=? where customer_id=? ";
		PreparedStatement prepareStatement=connection.prepareStatement(update);
		prepareStatement.setString(1,loanBorrow.getPurposeOfLoan());
		prepareStatement.setLong(2,loanBorrow.getAccountNo());
		prepareStatement.setString(3,loanBorrow.getPanNo());
		prepareStatement.setInt(4,loanBorrow.getSalary());
		prepareStatement.setString(5,loanBorrow.getCity());
		prepareStatement.setString(6,loanBorrow.getState());
		prepareStatement.setInt(7,loanBorrow.getPincode());
		prepareStatement.setBytes(8,loanBorrow.getProof());
		prepareStatement.setString(9,loanBorrow.getBorrowerId());
		prepareStatement.executeUpdate();
		connection.close();
	}
	@Override
	public void billGenerate(AmountDetails amount) throws ClassNotFoundException, SQLException 
	{
		Connection connection=ConnectionUtil.getConnection();
		String insert="insert into loan_details(customer_id,date_issued,interest,tenure,distribusal_amount,reduction)values(?,?,?,?,?,?)";
		PreparedStatement prepareStatement=connection.prepareStatement(insert);
		prepareStatement.setString(1, amount.getBorrowerId());
		prepareStatement.setString(2, amount.getDate());
		prepareStatement.setInt(3, amount.getInterest());
		prepareStatement.setInt(4, amount.getTenure());
		prepareStatement.setInt(5, amount.getDistribusalAmount());
		prepareStatement.setInt(6, amount.getReduction());
		prepareStatement.executeUpdate();
		connection.close();
	}
	@Override
	public List<AmountDetails> viewBill(String id) throws ClassNotFoundException, SQLException 
	{
		ArrayList<AmountDetails> list=new ArrayList<>();
		Connection connection=ConnectionUtil.getConnection();
		String select="select loan_id,customer_id,date_issued,interest,tenure,distribusal_amount,reduction from loan_details where customer_id=?";
		PreparedStatement prepareStatement=connection.prepareStatement(select);
		prepareStatement.setString(1, id);
		ResultSet resultSet=prepareStatement.executeQuery();
		while(resultSet.next())
		{
			AmountDetails amount=new AmountDetails();
			amount.setLoanId(Integer.parseInt(resultSet.getString(1)));
			amount.setBorrowerId(resultSet.getString(2));
			amount.setDate(resultSet.getString(3));
			amount.setInterest(Integer.parseInt(resultSet.getString(4)));
			amount.setTenure(Integer.parseInt(resultSet.getString(5)));
			amount.setDistribusalAmount(Integer.parseInt(resultSet.getString(6)));
			amount.setReduction(Integer.parseInt(resultSet.getString(7)));
			list.add(amount);
		}
		return list;
	}
	@Override
	public String checkStatus(String id) throws ClassNotFoundException, SQLException 
	{
		Connection connection=ConnectionUtil.getConnection();
		String select="select status from customer_details where customer_id=?";
		PreparedStatement prepareStatement=connection.prepareStatement(select);
		prepareStatement.setString(1, id);
		ResultSet resultSet=prepareStatement.executeQuery();
		while(resultSet.next())
		{
			status=resultSet.getString(1);
		}
		return status;
	}
}
