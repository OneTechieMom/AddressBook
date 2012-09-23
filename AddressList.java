import java.awt.Frame;

import javax.swing.JOptionPane;


/**
 * AddressList.java - performs functions to maintain an address book
 * @author Sarah Heredia
 * @version 11/20/11
 */
public class AddressList 
{
	private ListNode head;
	private ListNode currentNode;
	
	/**
	 * Representation of a node of a singly linked list
	 */
	private class ListNode
	{
		private String 		name;				// Full name
		private String 		tel;				// Telephone number
		private String 		email;				// Email address
		private String 		addr;				// Address
		private String 		dob;				// Date of birth
		private ListNode 	next;				// Pointer to the next node
		
		private ListNode(String name, String tel, String email, String addr, String dob)
		{
			this.name  = name;
			this.tel   = tel;
			this.email = email;
			this.addr  = addr;
			this.dob   = dob;
		} // end of the constructor
		
		public String getName()				{return name;}
		public String getTel() 				{return tel;}
		public String getEmail()			{return email;}
		public String getAddr() 			{return addr;}
		public String getDob() 				{return dob;}
		
		public void setName(String name) 	{this.name = name;}
		public void setTel(String tel) 		{this.tel = tel;}
		public void setEmail(String email) 	{this.email = email;}
		public void setAddr(String addr)	{this.addr = addr;}
		public void getDob(String dob) 		{this.dob = dob;}
		
		public ListNode getNext() 			{return next;}
		public void setNext(ListNode link) 	{this.next = link;}
	} // end of class ListNode
	
	
	/**
	 * Checks to see if there are any names in list
	 * @return true if empty, false otherwise
	 */
	public boolean isEmpty()
	{
		return this.head == null;
	} // end of method isEmpty
	
	
	/**
	 * Adds a new entry to front of list
	 * @param name name of entry
	 * @param tel telephone number of entry
	 * @param email email address of entry
	 * @param addr address of entry
	 * @param dob date of birth of entry
	 */
	public void addToFront(String name, String tel, String email, String addr, String dob)
	{
		ListNode newNode = new ListNode(name, tel, email, addr, dob);
		
		newNode.next = this.head;
		this.head = newNode;
		
	} // end of method addToFront
	
	/**
	 * Simplified addToFront method to use less parameters
	 * @param node one ListNode
	 */
	private void addToFront(ListNode node)
	{
		addToFront(node.getName(), node.getTel(), node.getEmail(), node.getAddr(), node.getDob());
	}
	
	/**
	 * Adds a new entry to back of list
	 * @param name name of entry
	 * @param tel telephone number of entry
	 * @param email email address of entry
	 * @param addr address of entry
	 * @param dob date of birth of entry
	 */
	public void addToBack(String name, String tel, String email, String addr, String dob)
	{
		this.currentNode = this.head;
		if (head == null)
		{
			addToFront(name, tel, email, addr, dob);
		}
		else
		{
			addToBack(currentNode, new ListNode(name, tel, email, addr, dob));
		}
	} // end of method addToBack
	
	/**
	 * Recursive helper method for adding to back of list
	 * @param curr current node
	 * @param newNode node to be added to list
	 */
	private void addToBack(ListNode curr, ListNode newNode)
	{
		if (curr.getNext() != null)
		{
			addToBack(curr.getNext(), newNode);
		}
		else
		{
			curr.setNext(newNode);
		}
	} // end of method addToBack
	
	public String toString()
	{
		if (sizeOf() == 0)
		{
			JOptionPane.showMessageDialog(new Frame("Oops!"), "Address Book is Empty");
		}
		this.currentNode = this.head;
		return toString(currentNode);
	} // end of method toString
	
	/**
	 * Recursion helper method to print nodes in list
	 * @param curr current node
	 * @return String representation of list
	 */
	private String toString(ListNode curr)
	{
		
		if (curr == null)
		{
			return "";
		}
		else
		{
			return output(curr) + "\n\n" + toString(curr.getNext());
		}
	} // end of method toString
	
	/**
	 * String representation of one ListNode
	 * @param elem element to be converted to a String
	 * @return String representation of one ListNode
	 */
	private String output(ListNode elem)
	{
		return  "Name: " + elem.getName() +
				"\nPhone Number: " + elem.getTel() +
				"\nEmail: " + elem.getEmail() +
				"\nAddress: " + elem.getAddr() +
				"\nDate of Birth: " + elem.getDob();
	}
	
	/**
	 * Prints list in reverse, does not alter order of list
	 * @return string representation of list in reverse
	 */
	public String reverseToString()
	{
		if (sizeOf() == 0)
		{
			JOptionPane.showMessageDialog(new Frame("Oops!"), "Address Book is Empty");
		}
		this.currentNode = this.head;
		return reverseToString(currentNode);
	
	} // end of method reverseToString
	
	/**
	 * Recursive helper method to print list in reverse
	 * @param curr current listnode
	 * @return String representation of list in reverse
	 */
	private String reverseToString(ListNode curr)
	{
		if (curr == null)
		{
			return "";
		}
		else
		{
			return reverseToString(curr.getNext()) + "\n\n" +  output(curr);
		}
	} // end of method reverseToString
	
	/**
	 * Physically reverses the order of list
	 * @return reversed AddressList
	 */
	public AddressList reverse()
	{ 
		if (sizeOf() == 0)
		{
			JOptionPane.showMessageDialog(new Frame("Oops!"), "Address Book is Empty");
		}
		this.currentNode = this.head;
		return reverse(currentNode, new AddressList());
	} // end of method reverse
	
	/**
	 * Recursive helper method to reverse order of list
	 * @param curr current listnode
	 * @param newAL new addresslist
	 * @return reversed list
	 */
	private AddressList reverse(ListNode curr, AddressList newAL)
	{
		if (curr == null)
		{
			return newAL;
		}
		newAL.addToFront(curr);
		newAL = reverse(curr.getNext(), newAL);
		return newAL;
	} // end of method reverse
	
	/**
	 * Determines how many entries are in list
	 * @return number of entries in list
	 */
	public int sizeOf()
	{
		this.currentNode = this.head;
		return sizeOf(currentNode);
	} // end of method sizeOf
	
	/**
	 * Recursive helper method to determine how many entries are in list
	 * @param curr current listnode
	 * @return number of entries in list
	 */
	private int sizeOf(ListNode curr)
	{
		if (curr == null)
		{
			return 0;
		}
		else
		{
			return 1 + sizeOf(curr.getNext());
		}
	} // end of method sizeOf
	
	/**
	 * Returns phone number of given name 
	 * @param name name to be searched
	 * @return phone number for name, 
	 *         if not found returns "No matching data"
	 */
	public String phoneNumberByName(String name)
	{
		this.currentNode = this.head;
		return phoneNumberByName(name, currentNode);
	} // end of method phoneNumberByName
	
	private String phoneNumberByName(String needed, ListNode curr)
	{
		if (curr == null) return "No matching data";
		if (curr.getName().equalsIgnoreCase(needed))
		{
			return curr.getTel();
		}
		return phoneNumberByName(needed, curr.getNext());
	} // end of method phoneNumberByName
	
	/**
	 * Returns email address of given name
	 * @param name name to be searched
	 * @return email address for name,
	 * 		   if not found returns "No matching data"
	 */
	public String emailByName(String name)
	{
		this.currentNode = this.head;
		return emailByName(name, currentNode);
	} // end of method emailByName
	
	private String emailByName(String needed, ListNode curr)
	{
		if (curr == null) return "No matching data";
		if (curr.getName().equalsIgnoreCase(needed))
		{
			return curr.getEmail();
		}
		return emailByName(needed, curr.getNext());
	} // end of method emailByName
	
	/**
	 * Returns name associated with given phone number
	 * @param name phone number to be searched
	 * @return name for phone number,
	 * 		   if not found returns "No matching data"
	 */
	public String nameByPhoneNumber(String tel)
	{
		this.currentNode = this.head;
		return nameByPhoneNumber(tel, currentNode);
	} // end of method nameByPhoneNumber
	
	private String nameByPhoneNumber(String needed, ListNode curr)
	{
		if (curr == null) return "No matching data";
		if (curr.getTel().equalsIgnoreCase(needed))
		{
			return curr.getName();
		}
		return nameByPhoneNumber(needed, curr.getNext());
	} // end of method nameByPhoneNumber
	
	/**
	 * Returns name associated with given date of birth
	 * @param name date of birth to be searched
	 * @return name for date of birth,
	 * 		   if not found returns "No matching data"
	 */
	public String dobByName(String name)
	{
		this.currentNode = this.head;
		return dobByName(name, currentNode);
	} // end of method dobByName
	
	private String dobByName(String needed, ListNode curr)
	{
		if (curr == null) return "No matching data";
		if (curr.getName().equalsIgnoreCase(needed))
		{
			return curr.getDob();
		}
		return dobByName(needed, curr.getNext());
	} // end of method dobByName
}// end of class AddressList
