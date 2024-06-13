package com.chainsys.dao;
import java.sql.SQLException;
import java.util.List;
import com.chainsys.model.LoanApp;
import com.chainsys.model.LoanBorrowerDetails;
public interface AdminDAO 
{
	void addUser(LoanApp loan) throws ClassNotFoundException, SQLException;
	String checkAdmin(String password) throws ClassNotFoundException, SQLException;
	List<LoanApp> displayDetails() throws ClassNotFoundException, SQLException;
	List<LoanApp> selectAdmin(String email) throws ClassNotFoundException, SQLException;
	List<LoanBorrowerDetails> viewlendersDetail() throws ClassNotFoundException, SQLException;
	void updateStatus(LoanBorrowerDetails loan) throws ClassNotFoundException, SQLException;
	List<LoanBorrowerDetails>  viewProof(String id) throws ClassNotFoundException, SQLException;
	void approveBorrower(LoanBorrowerDetails loan) throws ClassNotFoundException, SQLException;
	void sendBill(String id) throws ClassNotFoundException, SQLException;
	List<LoanBorrowerDetails>  searchStatus(String status) throws ClassNotFoundException, SQLException;
	int totalRegisteredBorrowers() throws ClassNotFoundException, SQLException;
	int totalLenders() throws ClassNotFoundException, SQLException;
	int totalApprovedLenders() throws ClassNotFoundException, SQLException;
	void removeBorrower(int id)throws ClassNotFoundException, SQLException;
}

