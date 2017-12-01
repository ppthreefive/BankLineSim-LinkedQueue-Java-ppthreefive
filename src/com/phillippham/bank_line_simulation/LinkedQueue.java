package com.phillippham.bank_line_simulation;

public class LinkedQueue<T> implements QueueInterface<T>
{
	// Class level references
	private Node head, tail;
	int count = 0;
	
	public LinkedQueue()
	{
		this.head = null;
		this.tail = null;
	}
	
	// Behaviors
	@Override
	public void enqueue(T newEntry)
	{
		// Add a Node to the LinkedList
		Node newNode = new Node(newEntry);
		
		if(isEmpty())
		{
			this.head = newNode;
			this.tail = newNode;
		}
		else
		{
			newNode.setPrevious(this.tail);
			this.tail.setNext(newNode);
			this.tail = newNode;
		}
		
		// Increment the count
		this.count++;
	}

	@Override
	public T dequeue() throws EmptyQueueException
	{
		T frontData;
		
		// Check to see if the queue is empty
		if(isEmpty())
		{
			throw new EmptyQueueException();
		}
		else
		{
			frontData = first();
			this.head = this.head.getNext();
			
			if(this.head != null)
			{
				this.head.setPrevious(null);
			}
			else
			{
				this.tail = null;
			}
		}
		
		// Decrement the count
		this.count--;
		
		return frontData;
	}

	@Override
	public T first() throws EmptyQueueException
	{
		// Get data from the head node
		if(isEmpty())
		{
			throw new EmptyQueueException();
		}
		else
		{
			return this.head.getData();
		}
	}

	@Override
	public boolean isEmpty()
	{
		// Check to see if the queue is empty
		return this.head == null || this.count == 0;
	}

	@Override
	public void clear()
	{
		// Release all Node objects
		this.head = null;
		this.tail = null;
	}
	
	@Override
	public int size()
	{
		return this.count;
	}
	
	@Override
	public String toString()
	{
		// Check to see if the LinkedQueue is empty
		if(isEmpty()) // isEmpty() == true
		{
			return "LinkedQueue is empty.";
		}
		else
		{	
			// Print all of the data
			Node current = this.head;
			String output = "";
			
			while(current != null)
				{
					output += current.getData() + "\n";
					current = current.getNext();
				}
			
			return output;
		}
	}
	
	private class Node
	{
		private T data; // Data the Node
		private Node next, previous;
		
		private Node()
		{
			this.data = null;
			this.next = null;
			this.previous = null;
		}
		
		private Node(T data)
		{
			this.data = data;
			this.next = null;
			this.previous = null;
		}

		private T getData()
		{
			return data;
		}

		private void setData(T data)
		{
			this.data = data;
		}

		private Node getNext()
		{
			return next;
		}

		private void setNext(Node next)
		{
			this.next = next;
		}

		private Node getPrevious()
		{
			return previous;
		}

		private void setPrevious(Node previous)
		{
			this.previous = previous;
		}	
	} 
}