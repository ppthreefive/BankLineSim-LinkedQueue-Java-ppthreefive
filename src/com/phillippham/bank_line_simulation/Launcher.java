package com.phillippham.bank_line_simulation;

public class Launcher
{

	public static void main(String[] args)
	{
		// Create a BankLine object and simulate the BankLine
		BankLine b1 = new BankLine();
		b1.simulate(10, 0.5, 1);
		b1.displayResults();
		
		System.exit(0);
	}

}
