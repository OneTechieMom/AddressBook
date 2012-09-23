import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
/**
 * ListGUI.java - provides a graphical interface to add names to an address book
 * 				- allows printing, reversing order, getting size and search address book
 * @author Sarah Heredia
 * @version 11/20/2011
 */
public class ListGUI 
{
    final static Container pane = new Container();
	final static GridBagConstraints c = new GridBagConstraints();
	final static AddressList list = new AddressList();
	
    /**
     * Creates a graphical interface for address book
     */
    public static void createGUI() 
    {
    	
    	// primitive variables for counting
    	int gridx = 0;
    	int gridy = 0;
    	int labelCount = 0;

    	// labels array
    	JLabel[] labels = 
    		{
    			new JLabel("Address Book"), new JLabel("Add New Name to Address Book"),
    			new JLabel("Name: "), new JLabel("Telephone Number: "),
    			new JLabel("Email Address: "), new JLabel("Address: "),
    			new JLabel("Date of Birth: "), new JLabel("Search Address Book"),
    			new JLabel("Prints all Names in Address Book"), 
    			new JLabel("Reverses Names in Address Book in Reverse"),
    			new JLabel("Reverses Names in Address Book (Does not print)"),
    			new JLabel("Print Number of Names in Address Book"),
    			new JLabel("Find Phone Number By Name"), new JLabel("Find Email By Bane"),
    			new JLabel("Find Name by Phone Number"), new JLabel("Find Date of Birth by Name"),
    			new JLabel("Results")
    		};
    	
    	// textfields
    	final JTextField name 	= new JTextField(30);
    	final JTextField tel 	= new JTextField();
    	final JTextField email 	= new JTextField();
    	final JTextField addr	= new JTextField();
    	final JTextField dob 	= new JTextField();
    	final JTextField pbn 	= new JTextField();
    	final JTextField ebn 	= new JTextField();
    	final JTextField nbp 	= new JTextField();
    	final JTextField dbn 	= new JTextField();
    	
    	// buttons
    	final JButton addFront		= new JButton("Add Name to Front");
    	final JButton addBack 		= new JButton("Add Name to Back");
    	final JButton clear 		= new JButton("Clear Form");
    	final JButton print 		= new JButton("Print");
    	final JButton reversePrint  = new JButton("Reverse Print");
    	final JButton reverse 		= new JButton("Reverse");
    	final JButton size 			= new JButton("Size");
    	final JButton phByName		= new JButton("Search");
    	final JButton emByName 		= new JButton("Search");
    	final JButton nameByPh		= new JButton("Search");
    	final JButton dobByName		= new JButton("Search");
    	final JButton clearSearch	= new JButton("Clear Search Fields");
    	final JButton clearResults	= new JButton("Clear Results");
    	
    	// text area
    	final JTextArea text = new JTextArea(10, 15);
    	
    	// scroll pane
    	JScrollPane scroll = new JScrollPane(text);
    	
    	// pane layout
    	pane.setLayout(new GridBagLayout());
    	pane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
    	c.fill = GridBagConstraints.HORIZONTAL;
    	
    	// address book header
    	addComponentWithGBConstraints(createHeader(labels[labelCount], 24, Color.BLUE, Color.WHITE),
    								  3, gridx, gridy, 40, 40);
    	
    	// add new name header
    	addComponentWithGBConstraints(createHeader(labels[++labelCount], 18, Color.CYAN, Color.BLACK),
    								  3, gridx, ++gridy, 10, 10);
    	
    	// name
    	addComponentWithGBConstraints(createLabel(labels[++labelCount]), 1, gridx, ++gridy, 5, 5); 	 // label
    	addComponentWithGBConstraints(name, 1, ++gridx, gridy, 5, 5);								 // text field
    	gridx = 0;
    	
    	// telephone number
    	addComponentWithGBConstraints(createLabel(labels[++labelCount]), 1, gridx, ++gridy, 5, 5); 	 // label
    	addComponentWithGBConstraints(tel, 1, ++gridx, gridy, 5, 5);								 // text field
    	gridx = 0;
    	
    	// email address
    	addComponentWithGBConstraints(createLabel(labels[++labelCount]), 1, gridx, ++gridy, 5, 5); 	 // label
    	addComponentWithGBConstraints(email, 1, ++gridx, gridy, 5, 5);								 // text field
    	gridx = 0;
    	
    	// address
    	addComponentWithGBConstraints(createLabel(labels[++labelCount]), 1, gridx, ++gridy, 5, 5);   // label
    	addComponentWithGBConstraints(addr, 1, ++gridx, gridy, 5, 5);								 // text field
    	gridx = 0;
    	
    	// date of birth
    	addComponentWithGBConstraints(createLabel(labels[++labelCount]), 1, gridx, ++gridy, 5, 5); 	 // label
    	addComponentWithGBConstraints(dob, 1, ++gridx, gridy, 5, 5);								 // text field
    	gridx = 0;
    	
    	// add name buttons
    	addComponentWithGBConstraints(addFront, 1, gridx, ++gridy, 5, 5);							// button		
    	addComponentWithGBConstraints(addBack, 1, ++gridx, gridy, 5, 5);							// button
    	addComponentWithGBConstraints(clear, 1, ++gridx, gridy, 5, 5);								// button
    	gridx = 0;
    	
    	// search address book header
    	addComponentWithGBConstraints(createHeader(labels[++labelCount], 18, Color.CYAN, Color.BLACK),
				  					  3, gridx, ++gridy, 10, 10);
    	
    	// print all names
    	addComponentWithGBConstraints(print, 1, gridx, ++gridy, 5, 5);								// button	
    	addComponentWithGBConstraints(createLabel(labels[++labelCount]), 2, ++gridx, gridy, 5, 5); 	// label
    	gridx = 0;
    	
    	// reverse print
    	addComponentWithGBConstraints(reversePrint, 1, gridx, ++gridy, 5, 5);						// button	
    	addComponentWithGBConstraints(createLabel(labels[++labelCount]), 2, ++gridx, gridy, 5, 5); 	// label
    	gridx = 0;
    	
    	// reverse
    	addComponentWithGBConstraints(reverse, 1, gridx, ++gridy, 5, 5);							// button	
    	addComponentWithGBConstraints(createLabel(labels[++labelCount]), 2, ++gridx, gridy, 5, 5); 	// label
    	gridx = 0;
    	
    	// size
    	addComponentWithGBConstraints(size, 1, gridx, ++gridy, 5, 5);								// button	
    	addComponentWithGBConstraints(createLabel(labels[++labelCount]), 2, ++gridx, gridy, 5, 5); 	// label
    	gridx = 0;
    	
    	// phone number by name
    	addComponentWithGBConstraints(phByName, 1, gridx, ++gridy, 5, 5);							// button	
    	addComponentWithGBConstraints(createLabel(labels[++labelCount]), 1, ++gridx, gridy, 5, 5); 	// label
    	addComponentWithGBConstraints(pbn, 1, ++gridx, gridy, 5, 5);								// text field
    	gridx = 0;
    	
    	// email by name
    	addComponentWithGBConstraints(emByName, 1, gridx, ++gridy, 5, 5);							// button	
    	addComponentWithGBConstraints(createLabel(labels[++labelCount]), 1, ++gridx, gridy, 5, 5); 	// label
    	addComponentWithGBConstraints(ebn, 1, ++gridx, gridy, 5, 5);								// text field
    	gridx = 0;
    	
    	// name by phone number
    	addComponentWithGBConstraints(nameByPh, 1, gridx, ++gridy, 5, 5);							// button	
    	addComponentWithGBConstraints(createLabel(labels[++labelCount]), 1, ++gridx, gridy, 5, 5); 	// label
    	addComponentWithGBConstraints(nbp, 1, ++gridx, gridy, 5, 5);								// text field
    	gridx = 0;
    	
    	// date of birth by name
    	addComponentWithGBConstraints(dobByName, 1, gridx, ++gridy, 5, 5);							// button	
    	addComponentWithGBConstraints(createLabel(labels[++labelCount]), 1, ++gridx, gridy, 5, 5); 	// label
    	addComponentWithGBConstraints(dbn, 1, ++gridx, gridy, 5, 5);								// text field
    	gridx = 0;
    	
    	// clear search fields button
    	addComponentWithGBConstraints(clearSearch, 1, gridx+2, ++gridy, 5, 5);						// button	
    	gridx = 0;
    	
    	// results header
    	addComponentWithGBConstraints(createHeader(labels[++labelCount], 18, Color.CYAN, Color.BLACK),
    								  3, gridx, ++gridy, 10, 10);
    	
    	//results text area in scroll pane
    	addComponentWithGBConstraints(scroll, 3, gridx, ++gridy, 5, 5);								// text area
    	
    	// clear results button
    	addComponentWithGBConstraints(clearResults, 3, gridx, ++gridy, 5, 5);						// button	
   
    	// button listeners
    	addFront.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent event)
			{
				if(!name.getText().equalsIgnoreCase("") &&
				   !tel.getText().equalsIgnoreCase("") &&
				   !email.getText().equalsIgnoreCase("") &&
				   !addr.getText().equalsIgnoreCase("") &&
				   !dob.getText().equalsIgnoreCase(""))
				{	
					list.addToFront(name.getText(), tel.getText(), email.getText(), 
							        addr.getText(), dob.getText());
					clear.doClick();
				}
				else
				{
					JOptionPane.showMessageDialog(new Frame("Oops!"), 
							"Missing Required Information");
				}
			}
		}); // end action listener for addFront button
    	
    	addBack.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent event)
			{
				if(!name.getText().equalsIgnoreCase("") &&
			       !tel.getText().equalsIgnoreCase("") &&
			       !email.getText().equalsIgnoreCase("") &&
			       !addr.getText().equalsIgnoreCase("") &&
			       !dob.getText().equalsIgnoreCase(""))
				{	
					list.addToBack(name.getText(), tel.getText(), email.getText(), 
								   addr.getText(), dob.getText());
					clear.doClick();
				}
				else
				{
					JOptionPane.showMessageDialog(new Frame("Oops!"), 
							"Missing Required Information");
				}
			}
		}); // end action listener for addBack button
    	
    	clear.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent event)
			{
				name.setText("");
				tel.setText("");
				email.setText("");
				addr.setText("");
				dob.setText("");
			}
		}); // end action listener for clear button
    	
    	print.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent event)
			{
				text.setText(list.toString());
			}
		}); // end action listener for reverse print button
    	
    	reversePrint.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent event)
			{
				text.setText(list.reverseToString());
			}
		}); // end action listener for reverse print button
    	
    	reverse.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent event)
			{
				list.reverse();
			}
		}); // end action listener for reverse button
    	
    	size.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent event)
			{
				text.setText(list.sizeOf() + "");
			}
		}); // end action listener for size button
    	
    	size.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent event)
			{
				text.setText(list.sizeOf() + "");
			}
		}); // end action listener for size button
    	
    	phByName.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent event)
			{
				if (!pbn.getText().equals(""))
				{
					text.setText(list.phoneNumberByName(pbn.getText()));
				}
				else
				{
					JOptionPane.showMessageDialog(new Frame("Oops!"), 
							"Please enter name to be searched");
				}
			}
		}); // end action listener for phone by name button
    	
    	emByName.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent event)
			{
				if (!ebn.getText().equals(""))
				{
					text.setText(list.emailByName(ebn.getText()));
				}
				else
				{
					JOptionPane.showMessageDialog(new Frame("Oops!"), 
							"Please enter name to be searched");
				}
			}
		}); // end action listener for email by name button
    	
    	nameByPh.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent event)
			{
				if (!nbp.getText().equals(""))
				{
					text.setText(list.nameByPhoneNumber(nbp.getText()));
				}
				else
				{
					JOptionPane.showMessageDialog(new Frame("Oops!"), 
							"Please enter phone number to be searched");
				}
			}
		}); // end action listener for name by phone button
    	
    	dobByName.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent event)
			{
				if (!dbn.getText().equals(""))
				{
					text.setText(list.dobByName(dbn.getText()));
				}
				else
				{
					JOptionPane.showMessageDialog(new Frame("Oops!"), 
							"Please enter name to be searched");
				}
			}
		}); // end action listener for dob by phone button
    	
    	clearSearch.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent event)
			{
				pbn.setText("");
				ebn.setText("");
				nbp.setText("");
				dbn.setText("");
			}
		}); // end action listener for clear search button
    	
    	clearResults.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent event)
			{
				text.setText("");
			}
		}); // end action listener for clear results button
    	
    	
    } // end of method createGUI
    
    /**
     * Adds attributes to a label to represent a header 
     * @param label label being adjusted
     * @return same label passed in but prettier!
     */
    private static JLabel createHeader(
    					JLabel 	label, 
    					int 	fontSize, 
    					Color 	bgcolor,
    					Color 	fgcolor)
    {
    	label.setHorizontalAlignment(SwingConstants.CENTER);
    	label.setBorder(BorderFactory.createRaisedBevelBorder());
    	label.setFont(new Font("Times New Roman", 24, fontSize));
    	label.setBackground(bgcolor);
    	label.setForeground(fgcolor);
    	label.setOpaque(true);
    	return label;
    } // end of method createHeader
    
    /**
     * Adds an empty border around label to give padding at edge
     * @param label label being adjust
     * @return label with padding
     */
    private static JLabel createLabel(JLabel label)
    {
    	label.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
    	return label;
    } // end of method createLabel
    
    /**
     * Helper method to simplify GridBag layout
     * @param comp component having GridBag attributes applied
     * @param gridwidth gridwidth amount
     * @param gridx gridx amount
     * @param gridy gridy amount
     * @param ipady y padding amount
     * @param ipadx x padding amount
     */
    private static void addComponentWithGBConstraints(
    						  Component comp,
    						  int	 gridwidth,
    						  int 	 gridx,
    						  int	 gridy,
    						  int 	 ipadx,
    						  int 	 ipady)
    {
    	c.fill = GridBagConstraints.HORIZONTAL;
    	c.gridwidth = gridwidth;
    	c.weightx = 0.5;
    	c.gridx = gridx;
    	c.gridy = gridy;
    	c.ipadx = ipadx;
    	c.ipady = ipady;
    	pane.add(comp, c);
    } // end of method addComponentWithGBConstraints
 
    public static void main(String[] args)
    {
    	JFrame frame = new JFrame("Address Book");
    	createGUI();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setContentPane(pane);
        frame.pack();
        frame.setVisible(true);
    } // end of main method
}