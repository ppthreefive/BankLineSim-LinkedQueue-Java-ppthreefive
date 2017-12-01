package com.phillippham.bank_line_simulation;

/**
 * A class of runtime exception that is thrown by methods to indicate that
 * a queue is currently empty.
 * @author Phillip Pham
 *
 */
public class EmptyQueueException extends RuntimeException
{
	public EmptyQueueException()
	{
		super("<ERROR: Queue is currently empty.>");
	}
	
	public EmptyQueueException(String message)
	{
		super(message);
	}
}