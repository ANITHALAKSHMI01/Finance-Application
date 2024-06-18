package com.chainsys.dao;
import java.sql.SQLException;
import java.util.List;
import com.chainsys.model.User;
import com.chainsys.model.LoanBorrowerDetails;
public interface AdminDAO 
{
	void user(User user) throws ClassNotFoundException, SQLException;
	List<User> displayDetails() throws ClassNotFoundException, SQLException;
	List<LoanBorrowerDetails> viewlendersDetail() throws ClassNotFoundException, SQLException;
	void updateStatus(LoanBorrowerDetails loan) throws ClassNotFoundException, SQLException;
	List<LoanBorrowerDetails>  viewProof(String id) throws ClassNotFoundException, SQLException;
	List<LoanBorrowerDetails>  viewPaySlip(String id) throws ClassNotFoundException, SQLException;
	void approveBorrower(LoanBorrowerDetails loan) throws ClassNotFoundException, SQLException;
	void sendBill(String id) throws ClassNotFoundException, SQLException;
	List<LoanBorrowerDetails>  searchStatus(String status) throws ClassNotFoundException, SQLException;
	int totalRegisteredBorrowers() throws ClassNotFoundException, SQLException;
	int totalLenders() throws ClassNotFoundException, SQLException;
	int totalApprovedLenders() throws ClassNotFoundException, SQLException;
	void removeBorrower(int id)throws ClassNotFoundException, SQLException;
}

