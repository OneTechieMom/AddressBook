
/**
 * AddressListTestDriver.java - Test Driver for AddressList class
 * @author Sarah Heredia
 * @version 11/20/11
 */
public class AddressListTestDriver
{
	public static void main(String[] args)
	{
		AddressListTestUtil util = new AddressListTestUtil();
			
		// test isEmpty
		//util.testIt(util.testIsEmpty_ReturnsTrue(), true);
			
		// test addToFront
		//util.testaddToFront();	
		
		// test addToBack
		//util.testaddToBack();	
		
		// test toString
		//util.testToString();
			
		// test reverseToString
		//util.testReverseToString();
		
		// test reverse
		//util.testReverse();
		
		// test sizeOf
		//util.testSizeOf();	
		
		// test phoneNumbersByName
		util.testPhoneNumberByName();	
		
		// test emailByName
		util.testEmailByName();
			
		// test nameByPhoneNumber
		util.testNameByPhoneNumber();
		
		// test dobByName
		util.testDobByName();
	}
}
