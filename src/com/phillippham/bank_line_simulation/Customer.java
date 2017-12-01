package com.phillippham.bank_line_simulation;

public class Customer
{
	// Attributes
	private String name;
	private int arrivalTime, transactionTime, customerNumber;
	
	// Constructors
	public Customer()
	{
		this.name = "Unknown";
		this.customerNumber = 0;
		this.arrivalTime = 0;
		this.transactionTime = 0;
	}
	
	public Customer(String name, int customerNumber)
	{
		this();
		this.name = name;
		this.customerNumber = customerNumber;
	}
	
	public Customer(String name, int customerNumber, int arrivalTime, int transactionTime)
	{
		this(name, customerNumber);
		this.arrivalTime = arrivalTime;
		this.transactionTime = transactionTime;
	}
	
	public Customer(int customerNumber, int arrivalTime, int transactionTime)
	{
		this("Unknown", customerNumber, arrivalTime, transactionTime);
	}
	
	// Accessors
	public String getName()
	{
		return name;
	}

	public int getArrivalTime()
	{
		return arrivalTime;
	}

	public int getTransactionTime()
	{
		return transactionTime;
	}

	public int getCustomerNumber()
	{
		return customerNumber;
	}

	// Mutators
	public void setName(String name)
	{
		this.name = name;
	}

	public void setArrivalTime(int arrivalTime)
	{
		this.arrivalTime = arrivalTime;
	}

	public void setTransactionTime(int transactionTime)
	{
		this.transactionTime = transactionTime;
	}

	public void setCustomerNumber(int customerNumber)
	{
		this.customerNumber = customerNumber;
	}

	public String toString()
	{
		return "Customer [name=" + name + ", arrivalTime=" + arrivalTime + ", transactionTime=" + transactionTime
				+ ", customerNumber=" + customerNumber + "]";
	}
}
