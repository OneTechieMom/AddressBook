
public class AddressListTestUtil 
{
	private AddressList getAL()
	{
		return new AddressList();
	}
	
	public boolean testIsEmpty_ReturnsTrue()
	{
		AddressList list = this.getAL();
		
		return list.isEmpty();
	}
	
	public void testaddToFront()
	{
		AddressList list = this.getAL();
		
		list.addToFront("Sarah", "540-589-6328", "sheredia1207@front.com",
						"610 Sunset Ave, Troutville, Va 24175", "05-07-1984");
		
		list.addToFront("Pam", "540-992-3679", "pam@front.net", 
		               "578 Sunset Ave., Troutville, VA 24175", "???????");
		
		System.out.println(list.toString());
	}
	
	public void testaddToBack()
	{
		AddressList list = this.getAL();
		
		list.addToBack("Sarah", "540-589-6328", "sheredia1207@back.com",
				"610 Sunset Ave, Troutville, Va 24175", "05-07-1984");
		
		list.addToBack("Pam", "540-992-3679", "pam@back.net", 
				        "578 Sunset Ave., Troutville, VA 24175", "???????");
		
		System.out.println(list.toString());
	}
	
	public void testToString()
	{
		AddressList list = this.getAL();
		
		list.addToFront("Sarah", "540-589-6328", "sheredia1207@toString.com",
				"610 Sunset Ave, Troutville, Va 24175", "05-07-1984");
		
		list.addToFront("Pam", "540-992-3679", "pam@toString.net", 
				        "578 Sunset Ave., Troutville, VA 24175", "???????");
		
		System.out.println(list.toString());
	}
	
	public void testReverseToString()
	{
		AddressList list = this.getAL();
		
		list.addToFront("Sarah", "540-589-6328", "sheredia1207@reverseToString.com",
				"610 Sunset Ave, Troutville, Va 24175", "05-07-1984");
		
		list.addToFront("Pam", "540-992-3679", "pam@reverseToString.net", 
				        "578 Sunset Ave., Troutville, VA 24175", "???????");
		
		System.out.println(list.reverseToString());
	}
	
	public void testReverse()
	{
		AddressList list = this.getAL();
		
		list.addToFront("Sarah", "540-589-6328", "sheredia1207@reverse.com",
						"610 Sunset Ave, Troutville, Va 24175", "05-07-1984");
			
		list.addToFront("Sandy", "540-589-6328", "sheredia1207@reverse.com",
						"610 Sunset Ave, Troutville, Va 24175", "05-07-1984");
		
		list.addToFront("Pam", "540-992-3679", "pam@reverse.net", 
				        "578 Sunset Ave., Troutville, VA 24175", "???????");
		
		System.out.println(list.reverse().toString());
	}
	
	public void testSizeOf()
	{
		AddressList list = this.getAL();
		
		list.addToFront("Sarah", "540-589-6328", "sheredia1207@reverseToString.com",
						"610 Sunset Ave, Troutville, Va 24175", "05-07-1984");
		
		list.addToFront("Pam", "540-992-3679", "pam@reverseToString.net", 
				        "578 Sunset Ave., Troutville, VA 24175", "???????");
		
		System.out.println(list.sizeOf());
	}
	
	public void testPhoneNumberByName()
	{
		AddressList list = this.getAL();
		
		list.addToFront("Sarah", "540-589-6328", "sheredia1207@reverseToString.com",
						"610 Sunset Ave, Troutville, Va 24175", "05-07-1984");
		
		
		list.addToFront("Pam", "540-992-3679", "pam@reverseToString.net", 
				        "578 Sunset Ave., Troutville, VA 24175", "???????");
		
		System.out.println(list.phoneNumberByName("Sarah"));
	}
	
	public void testEmailByName()
	{
		AddressList list = this.getAL();
		
		list.addToFront("Sarah", "540-589-6328", "sheredia1207@reverseToString.com",
						"610 Sunset Ave, Troutville, Va 24175", "05-07-1984");
		
		
		list.addToFront("Pam", "540-992-3679", "pam@reverseToString.net", 
				        "578 Sunset Ave., Troutville, VA 24175", "???????");
		
		System.out.println(list.emailByName("Sarah"));
	}
	
	public void testNameByPhoneNumber()
	{
		AddressList list = this.getAL();
		
		list.addToFront("Sarah", "540-589-6328", "sheredia1207@reverseToString.com",
						"610 Sunset Ave, Troutville, Va 24175", "05-07-1984");
		
		
		list.addToFront("Pam", "540-992-4139", "pam@reverseToString.net", 
				        "578 Sunset Ave., Troutville, VA 24175", "???????");
		
		System.out.println(list.nameByPhoneNumber("540-992-4139"));
	}
	
	public void testDobByName()
	{
		AddressList list = this.getAL();
		
		list.addToFront("Sarah", "540-589-6328", "sheredia1207@reverseToString.com",
						"610 Sunset Ave, Troutville, Va 24175", "05-07-1984");
		
		
		list.addToFront("Pam", "540-992-3679", "pam@reverseToString.net", 
				        "578 Sunset Ave., Troutville, VA 24175", "???????");
		
		System.out.println(list.dobByName("Sarah"));
	}
	
	public void testIt(boolean results, boolean actual)
	{
		if (results == actual)
			System.out.println("Passed!");
		else
			System.out.println("Failed! UH OH!");
	}
}
