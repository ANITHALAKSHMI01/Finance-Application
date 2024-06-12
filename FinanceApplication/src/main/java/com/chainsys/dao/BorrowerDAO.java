package com.chainsys.dao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.Part;

import com.chainsys.model.AmountDetails;
import com.chainsys.model.LoanApp;
import com.chainsys.model.LoanBorrowerDetails;
public interface BorrowerDAO
{
	String checkBorrower(String email) throws ClassNotFoundException, SQLException;
	List<LoanApp> displayBorrowers() throws ClassNotFoundException, SQLException;
	void removeUser(LoanApp loan) throws ClassNotFoundException, SQLException;
	void updateUser(LoanApp loan) throws ClassNotFoundException, SQLException;
	List<LoanApp> selectBorrower(String email) throws ClassNotFoundException, SQLException;
	String checkId(String id) throws ClassNotFoundException, SQLException;
	int addLender(LoanBorrowerDetails loanBorrow) throws ClassNotFoundException, SQLException, IOException;
	List<LoanBorrowerDetails> lenderLoan(String id) throws ClassNotFoundException, SQLException;
	void updateAppliedLoan(LoanBorrowerDetails loanBorrow) throws ClassNotFoundException, SQLException;
	void billGenerate(AmountDetails amount) throws ClassNotFoundException, SQLException;
	List<AmountDetails> viewBill(String id) throws ClassNotFoundException, SQLException;
	String checkStatus(int id) throws ClassNotFoundException, SQLException;
	List<AmountDetails> viewApprovedBill(String id) throws ClassNotFoundException, SQLException;
}
