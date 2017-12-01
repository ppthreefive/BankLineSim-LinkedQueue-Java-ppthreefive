package com.phillippham.bank_line_simulation;

/*
 * Interface --> Class with only abstract methods and constants.
 * 	You cannot create an object using an Interface,
 * 	and you have to implement the Interface, similar to the ActionListener.
 */
public interface QueueInterface<T>
{
	/**
	 * Adds a new entry to the back of this queue.
	 * @param newEntry an object to be added.
	 */
	public void enqueue(T newEntry); // Abstract, so no body
	
	/**
	 * Removes and returns the entry at the front of this queue.
	 * @return The object at the front of the queue.
	 * @throws EmptyQueueException is thrown if the queue is empty.
	 */
	public T dequeue() throws EmptyQueueException;
	
	/**
	 * Returns the entry at the front of the queue, but does not remove the entry.
	 * @return the object at the front of the queue.
	 * @throws EmptyQueueException is thrown if the queue is empty.
	 */
	public T first() throws EmptyQueueException;
	
	/**
	 * Detects whether this queue is empty or not.
	 * @return True if the queue is empty, otherwise, False if the queue has objects.
	 */
	public boolean isEmpty();
	
	/**
	 * Removes all entries from this queue.
	 */
	public void clear();
	
	/**
	 * Counts all the entries in the queue.
	 * @return Number of entries in this queue.
	 */
	public int size();
}