package com.chainsys.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.chainsys.model.AmountDetails;
import com.chainsys.model.User;
import com.chainsys.model.LoanBorrowerDetails;
import com.chainsys.util.ConnectionUtil;
public class BorrowerImplementation implements BorrowerDAO
{
	@Override
	public String checkUser(String email) throws ClassNotFoundException, SQLException
	{
		String password=null;
		Connection connection=ConnectionUtil.getConnection();
		String select="select password from user where email=? && status=? ";
		PreparedStatement prepareStatement = connection.prepareStatement(select);
		prepareStatement.setString(1, email);
		prepareStatement.setInt(2,1);
		ResultSet resultSet = prepareStatement.executeQuery();
		while (resultSet.next()) 
		{
			password = resultSet.getString(1);
		}
		return password;
	}
	@Override
	public List<User> displayBorrowers() throws ClassNotFoundException, SQLException 
	{
		ArrayList<User> list=new ArrayList<>();
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
	public void removeUser(User loan) throws ClassNotFoundException, SQLException 
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
	public void updateUser(User loan) throws ClassNotFoundException, SQLException
	{
		Connection connection=ConnectionUtil.getConnection();
		String update="update user set phone_no=?,location=? where id=? ";
		PreparedStatement prepareStatement=connection.prepareStatement(update);
		prepareStatement.setLong(1,loan.getPhoneNo());
		prepareStatement.setString(2,loan.getLocation());
		prepareStatement.setString(3,loan.getId());
		prepareStatement.executeUpdate();
		connection.close();
	}
	@Override
	public List<User> selectUser(String email) throws ClassNotFoundException, SQLException
	{
		ArrayList<User> list=new ArrayList<>();
		Connection connection=ConnectionUtil.getConnection();
		String select="select id,name,date_of_birth,phone_no,email,location from user where status=? && email=?";
		PreparedStatement prepareStatement=connection.prepareStatement(select);
		prepareStatement.setInt(1, 1);
		prepareStatement.setString(2, email);
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
			User user=new User();
			user.setId(id);
			user.setName(name);
			user.setDateOfBirth(dateOfBirth);
			user.setPhoneNo(phoneNumber);
			user.setEmail(email1);
			user.setLocation(location);
			list.add(user);	
		}
		return list;
	}
	@Override
	public String checkId(String email) throws ClassNotFoundException, SQLException 
	{
		String borrowerId=null;
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
		String insert="insert into customer_details(customer_id,account_no,pan_no,salary,city,state,pincode,proof,status,loan_amount,pay_slip,tenure,is_generate,is_active)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement prepareStatement=connection.prepareStatement(insert);
		prepareStatement.setString(1, loanBorrow.getBorrowerId());
		prepareStatement.setLong(2, loanBorrow.getAccountNo());
		prepareStatement.setString(3, loanBorrow.getPan());
		prepareStatement.setInt(4, loanBorrow.getSalary());
		prepareStatement.setString(5, loanBorrow.getCity());
		prepareStatement.setString(6, loanBorrow.getState());
		prepareStatement.setInt(7, loanBorrow.getPincode());
		prepareStatement.setBytes(8,loanBorrow.getProof());
		prepareStatement.setString(9,loanBorrow.getStatus());
		prepareStatement.setInt(10,loanBorrow.getLoanAmount());
		prepareStatement.setBytes(11,loanBorrow.getPaySlip());
		prepareStatement.setInt(12, loanBorrow.getTenure());
		prepareStatement.setInt(13, 0);
		prepareStatement.setInt(14, 0);
		int row=prepareStatement.executeUpdate();
		connection.close();
		return row;
	}
	@Override
	public List<LoanBorrowerDetails> lenderLoan(String id) throws ClassNotFoundException, SQLException 
	{
		ArrayList<LoanBorrowerDetails> list=new ArrayList<>();
		Connection connection=ConnectionUtil.getConnection();
		String select="select account_id,customer_id,account_no,pan_no,salary,loan_amount,tenure,city,state,pincode,proof,pay_slip,status  from customer_details where customer_id=? && is_active=?";
		PreparedStatement prepareStatement=connection.prepareStatement(select);
		prepareStatement.setString(1, id);
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
			loanBorrower.setTenure(Integer.parseInt(resultSet.getString(7)));
			loanBorrower.setCity(resultSet.getString(8));
			loanBorrower.setState(resultSet.getString(9));
			loanBorrower.setPincode(Integer.parseInt(resultSet.getString(10)));
			loanBorrower.setProof(resultSet.getBytes(11));
			loanBorrower.setPaySlip(resultSet.getBytes(12));
			loanBorrower.setStatus(resultSet.getString(13));
			list.add(loanBorrower);
		}
		return list;
	}
	@Override
	public void updateAppliedLoan(LoanBorrowerDetails loanBorrow) throws ClassNotFoundException, SQLException
	{
		Connection connection=ConnectionUtil.getConnection();
		String update="update customer_details set account_no=?,pan_no=?,salary=?,city=?,state=?,pincode=?,proof=? where customer_id=? ";
		PreparedStatement prepareStatement=connection.prepareStatement(update);
		prepareStatement.setLong(1,loanBorrow.getAccountNo());
		prepareStatement.setString(2,loanBorrow.getPan());
		prepareStatement.setInt(3,loanBorrow.getSalary());
		prepareStatement.setString(4,loanBorrow.getCity());
		prepareStatement.setString(5,loanBorrow.getState());
		prepareStatement.setInt(6,loanBorrow.getPincode());
		prepareStatement.setBytes(7,loanBorrow.getProof());
		prepareStatement.setString(8,loanBorrow.getBorrowerId());
		prepareStatement.executeUpdate();
		connection.close();
	}
	@Override
	public void billGenerate(AmountDetails amount) throws ClassNotFoundException, SQLException 
	{
		Connection connection=ConnectionUtil.getConnection();
		String insert="insert into loan_details(customer_id,date_issued,interest,repayment_period,distribusal_amount,reduction,status)values(?,?,?,?,?,?,?)";
		PreparedStatement prepareStatement=connection.prepareStatement(insert);
		prepareStatement.setString(1, amount.getBorrowerId());
		prepareStatement.setString(2, amount.getDate());
		prepareStatement.setInt(3, amount.getInterest());
		prepareStatement.setInt(4, amount.getTenure());
		prepareStatement.setInt(5, amount.getDistribusalAmount());
		prepareStatement.setInt(6, amount.getReduction());
		prepareStatement.setInt(7, 0);
		prepareStatement.executeUpdate();
		connection.close();
	}
	@Override
	public String checkStatus(int id) throws ClassNotFoundException, SQLException 
	{
		String status=null;
		Connection connection=ConnectionUtil.getConnection();
		String select="select status from customer_details where account_id=?";
		PreparedStatement prepareStatement=connection.prepareStatement(select);
		prepareStatement.setInt(1, id);
		ResultSet resultSet=prepareStatement.executeQuery();
		while(resultSet.next())
		{
			status=resultSet.getString(1);
		}
		return status;
	}
	@Override
	public List<AmountDetails> viewApprovedBill(String id) throws ClassNotFoundException, SQLException 
	{	
		ArrayList<AmountDetails> list=new ArrayList<>();
		Connection connection=ConnectionUtil.getConnection();
		String select="select loan_id,customer_id,date_issued,interest,repayment_period,distribusal_amount,reduction from loan_details where customer_id=? && status=?";
		PreparedStatement prepareStatement=connection.prepareStatement(select);
		prepareStatement.setString(1, id);
		prepareStatement.setInt(2, 0);
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
	public List<LoanBorrowerDetails> searchBorrower(String id) throws ClassNotFoundException, SQLException 
	{
		ArrayList<LoanBorrowerDetails> list=new ArrayList<>();
		Connection connection=ConnectionUtil.getConnection();
		String select="select account_id,customer_id,account_no,pan_no,salary,loan_amount,city,state,pincode,proof,pay_slip,tenure,status  from customer_details where customer_id=? && is_active=?";
		PreparedStatement prepareStatement=connection.prepareStatement(select);
		prepareStatement.setString(1, id);
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
}
