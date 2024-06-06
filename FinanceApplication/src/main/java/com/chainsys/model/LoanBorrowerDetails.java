package com.chainsys.model;
import java.util.Arrays;
public class LoanBorrowerDetails
{
	private int applicationId;
	private String borrowerId;
	private String purposeOfLoan;
	private int salary;
	private String city;
	private String state;
	private int pincode;
	private long accountNo;
	private String panNo;
	private byte[] proof;
	private String status;
	public LoanBorrowerDetails()
	{
		
	}
	public LoanBorrowerDetails(int applicationId,String borrowerId,String purposeOfLoan,int salary,String city,String state,int pincode,long accountNo,String panNo,byte[] proof,String status)
	{
		this.applicationId=applicationId;
		this.borrowerId=borrowerId;
		this.purposeOfLoan=purposeOfLoan;
		this.salary=salary;
		this.city=city;
		this.state=state;
		this.pincode=pincode;
		this.accountNo=accountNo;
		this.panNo=panNo;
		this.proof=proof;
		this.status=status;
	}
	public LoanBorrowerDetails(String borrowerId,String purposeOfLoan,int salary,String city,String state,int pincode,long accountNo,String panNo,byte[] proof,String status)
	{
		this.borrowerId=borrowerId;
		this.purposeOfLoan=purposeOfLoan;
		this.salary=salary;
		this.city=city;
		this.state=state;
		this.pincode=pincode;
		this.accountNo=accountNo;
		this.panNo=panNo;
		this.proof=proof;
		this.status=status;
	}
	public int getApplicationId()
	{
		return applicationId;
	}
	public void setApplicationId(int applicationId)
	{
		this.applicationId = applicationId;
	}
	public String getBorrowerId()
	{
		return borrowerId;
	}
	public void setBorrowerId(String borrowerId)
	{
		this.borrowerId = borrowerId;
	}
	public String getPurposeOfLoan()
	{
		return purposeOfLoan;
	}
	public void setPurposeOfLoan(String purposeOfLoan)
	{
		this.purposeOfLoan = purposeOfLoan;
	}
	public int getSalary()
	{
		return salary;
	}
	public void setSalary(int salary)
	{
		this.salary = salary;
	}
	public String getCity()
	{
		return city;
	}
	public void setCity(String city) 
	{
		this.city = city;
	}
	public String getState()
	{
		return state;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public int getPincode()
	{
		return pincode;
	}
	public void setPincode(int pincode) 
	{
		this.pincode = pincode;
	}
	public long getAccountNo() 
	{
		return accountNo;
	}
	public void setAccountNo(long accountNo) 
	{
		this.accountNo = accountNo;
	}
	public String getPanNo() 
	{
		return panNo;
	}
	public void setPanNo(String panNo) 
	{
		this.panNo = panNo;
	}
	public byte[] getProof() 
	{
		return proof;
	}
	public void setProof(byte[] proof) 
	{
		this.proof = proof;
	}
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}
	@Override
	public String toString()
	{
		return "LoanBorrowerDetails [applicationId=" + applicationId + ", borrowerId=" + borrowerId + ", purposeOfLoan="
				+ purposeOfLoan + ", salary=" + salary + ", city=" + city + ", state=" + state + ", pincode=" + pincode
				+ ", accountNo=" + accountNo + ", panNo=" + panNo + ", proof=" + Arrays.toString(proof) + ", status="
				+ status + "]";
	}
}
