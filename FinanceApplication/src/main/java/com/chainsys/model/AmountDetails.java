package com.chainsys.model;
public class AmountDetails 
{
	private int loanId;
	private String borrowerId;
	private int loanAmount;
	private int reduction;
	private String date;
	private int interest;
	private int tenure;
	private int distribusalAmount;
	private int status;
	public AmountDetails(String borrowerId,int loanId,int loanAmount,String date,int reduction,int interest,int tenure,int distribusalAmount)
	{
		this.borrowerId=borrowerId;
		this.loanId=loanId;
		this.loanAmount=loanAmount;
		this.date=date;
		this.reduction=reduction;
		this.interest=interest;
		this.tenure=tenure;
		this.distribusalAmount=distribusalAmount;
	}
	public AmountDetails()
	{
		
	}
	public int getLoanId()
	{
		return loanId;
	}
	public void setLoanId(int loanId)
	{
		this.loanId = loanId;
	}
	public String getBorrowerId()
	{
		return borrowerId;
	}
	public void setBorrowerId(String borrowerId)
	{
		this.borrowerId = borrowerId;
	}
	public int getLoanAmount()
	{
		return loanAmount;
	}
	public void setLoanAmount(int loanAmount)
	{
		this.loanAmount = loanAmount;
	}
	public String getDate()
	{
		return date;
	}
	public void setDate(String date)
	{
		this.date = date;
	}
	public int getInterest() 
	{
		return interest;
	}
	public void setInterest(int interest) 
	{
		this.interest = interest;
	}
	public int getTenure()
	{
		return tenure;
	}
	public void setTenure(int tenure)
	{
		this.tenure = tenure;
	}
	public int getDistribusalAmount()
	{
		return distribusalAmount;
	}
	public void setDistribusalAmount(int distribusalAmount) 
	{
		this.distribusalAmount = distribusalAmount;
	}
	public int getReduction()
	{
		return reduction;
	}
	public void setReduction(int reduction) 
	{
		this.reduction = reduction;
	}
	public int getStatus() 
	{
		return status;
	}
	public void setStatus(int status) 
	{
		this.status = status;
	}
	@Override
	public String toString()
	{
		return "AmountDetails [loanId=" + loanId + ", borrowerId=" + borrowerId + ", loanAmount=" + loanAmount
				+ ", reduction=" + reduction + ", date=" + date + ", interest=" + interest + ", tenure=" + tenure
				+ ", distribusalAmount=" + distribusalAmount + ", status=" + status + "]";
	}
}
