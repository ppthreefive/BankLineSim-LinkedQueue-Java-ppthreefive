package com.phillippham.bank_line_simulation;

import java.text.DecimalFormat;

public class BankLine
{
	// Class level references
	private QueueInterface<Customer> line;
	private int numberOfArrivals, numberServed, totalTimeWaited, maxWaitTime, maxLineSize;
	
	// Constructor
	public BankLine()
	{
		this.line = new LinkedQueue<Customer>();
		reset();
	}
	
	/**
	 * Simulates a waiting line with one bank teller.
	 * 
	 * @param duration The number of simulated minutes.
	 * @param arrivalProbability A real number between 0 and 1, and the probability that
	 * 		the customer arrives at a given time
	 * @param maxTransactionTime The longest transaction time for a customer.
	 * @throws InterruptedException
	 */
	public void simulate(int duration, double arrivalProbability, int maxTransactionTime)
	{
		int transactionTimeLeft = 0;
		
		for (int clock = 0; clock < duration; clock++)
		{
			// Show the current time
			System.out.printf("Current time: 1:%02d%n", clock);
			
			if(Math.random() < arrivalProbability)
			{
				// We have a customer since randomizer produced a number in our probability range
				this.numberOfArrivals++;
				int transactionTime = (int)(Math.random() * maxTransactionTime + 1);
				
				Customer nextArrival = new Customer(this.numberOfArrivals, clock, transactionTime);
				
				this.line.enqueue(nextArrival);
				
				System.out.printf("Customer %d enters line at 1:%02d. Transaction time is %d.%n",
						nextArrival.getCustomerNumber(), clock, nextArrival.getTransactionTime());
				
				if(this.line.size() > this.maxLineSize)
				{
					this.maxLineSize = this.line.size();
				}
			}
			
			// Pull next customer if, and only if, current transaction is completed.
			if(transactionTimeLeft > 0)
			{
				// Take a minute off of the current transaction time
				transactionTimeLeft--;
			}
			else if(!this.line.isEmpty())
			{
				Customer nextCustomer = this.line.dequeue();
				transactionTimeLeft = nextCustomer.getTransactionTime() - 1;
				
				int timeWaited = clock - nextCustomer.getArrivalTime();
				this.totalTimeWaited += timeWaited;
				this.numberServed++;
				
				if(timeWaited > this.maxWaitTime)
				{
					this.maxWaitTime = timeWaited;
				}
				
				System.out.println("Customer " + nextCustomer.getCustomerNumber() + " begins service at time "
						+ clock + ". Time waited was " + timeWaited + ".");
				
				// Wait for a few seconds
				try
				{
					Thread.sleep(2000); // 2000 milliseconds
				}
				catch(InterruptedException ex){}
			}
		}
	}

	/**
	 * Displays summary results of the simulation
	 */
	public void displayResults()
	{
		DecimalFormat df = new DecimalFormat("0.0");
		System.out.println("\nNumber of customers served: " + this.numberServed);
		double averageTimeWaited = (double)(this.totalTimeWaited) / this.numberServed;
		System.out.println("Average time waited: " + df.format(averageTimeWaited));
		System.out.println("Maximum time waited: " + df.format(this.maxWaitTime));
		System.out.println("Maximum line size: " + this.maxLineSize);
		System.out.println("Number of customers who are still in line: " + line.size());
	}
	
	private void reset()
	{
		// Reset everything
		this.line.clear();
		this.numberOfArrivals = 0;
		this.numberServed = 0;
		this.totalTimeWaited = 0;
		this.maxWaitTime = 0;
		this.maxLineSize = 0;
	}
}