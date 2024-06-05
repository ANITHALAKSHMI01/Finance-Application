package com.chainsys.model;
public class LoanApp
{
	String id;
	String name;
	String category;
	String dateOfBirth;
	long phoneNo;
	String email;
	String password;
	String location;
	public LoanApp()
	{
		
	}
	public LoanApp(String id,String name,String category,String dateOfBirth,long phoneNo,String email,String password,String location)
	{
		this.id=id;
		this.name=name;
		this.category=category;
		this.dateOfBirth=dateOfBirth;
		this.phoneNo=phoneNo;
		this.email=email;
		this.password=password;
		this.location=location;
	}
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getCategory()
	{
		return category;
	}
	public void setCategory(String category)
	{
		this.category = category;
	}
	public String getDateOfBirth()
	{
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}
	public long getPhoneNo()
	{
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo)
	{
		this.phoneNo = phoneNo;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getLocation() 
	{
		return location;
	}
	public void setLocation(String location)
	{
		this.location = location;
	}
	@Override
	public String toString() 
	{
		return "LoanApp [id=" + id + ", name=" + name + ", category=" + category + ", dateOfBirth=" + dateOfBirth
				+ ", phoneNo=" + phoneNo + ", email=" + email + ", password=" + password + ", location=" + location
				+ "]";
	}
}
