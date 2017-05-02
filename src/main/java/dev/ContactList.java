package dev;


import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

class ContactList implements ActionListener {

	JPanel topPanel, bottomPanel;
	JScrollPane scrollPane;
	JFrame frame;

	JMenuBar menubar = new JMenuBar();;
	JMenu menu = new JMenu();
	JMenuItem menuItem;

	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize = kit.getScreenSize();
	int screenHeight = screenSize.height;
	int screenWidth = screenSize.width;

	Image img = kit.getImage("images/icon.JPG");

	ContactList() {

		frame = new JFrame("Contact List I");
		frame.setSize(680, 200);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(screenWidth / 4, screenHeight / 4);
		frame.setIconImage(img);
		addWidgets();
		frame.show();

	}

	public void addWidgets()

            {
            	   	menubar.add(menu);

       	            menu = new JMenu("Menus");
       	            menuItem = new JMenuItem("Add New Contact");
       	            menu.add(menuItem);
       	            menuItem.addActionListener(this);

       	            menuItem = new JMenuItem("Delete Contact");
       	            menu.add(menuItem);
       	            menuItem.addActionListener(this);

       	            menuItem = new JMenuItem("Query View");
       	            menu.add(menuItem);
       	            menuItem.addActionListener(this);
//
//       	            menuItem = new JMenuItem("Sort Contacts");
//       	            menu.add(menuItem);
//       	            menuItem.addActionListener(this);

       	            menuItem = new JMenuItem("View All Contacts");
       	            menu.add(menuItem);
       	            menuItem.addActionListener(this);

       	            menuItem = new JMenuItem("Save Contacts");
       	            menu.add(menuItem);
       	            menuItem.addActionListener(this);


       	            menubar.add(menu);

       	            menu = new JMenu("Help");

       	            menuItem = new JMenuItem("Help Contents");
       	            menu.add(menuItem);
       	            menuItem.addActionListener(this);

       	            menuItem = new JMenuItem("About");
       	            menu.add(menuItem);
       	            menuItem.addActionListener(this);

       	            menubar.add(menu);

       	            frame.setJMenuBar(menubar);


       	            JPanel topPanel = new JPanel();
                    JPanel bottomPanel = new JPanel();

                    //Add Buttons To Bottom Panel
                    JButton AddNew = new JButton("Add New Contact");
                    JButton DeleteContact = new JButton("Delete Contact");
                    JButton SearchContacts = new JButton("Search Contacts");
                   // JButton SortContacts = new JButton("Sort Contacts");
                    JButton ViewContactList = new JButton("View All Contacts");

                    JLabel label = new JLabel("<HTML><FONT FACE = ARIALSIZE = 2><B>USE BELOW OPTIONS AND THE MENU OPTIONS TO MANAGE CONTACTS");

                    //Add Action Listeners
                    AddNew.addActionListener(this);
                    DeleteContact.addActionListener(this);
                    SearchContacts.addActionListener(this);
                   // SortContacts.addActionListener(this);
                    ViewContactList.addActionListener(this);

                    topPanel.add(label);

                    bottomPanel.add(AddNew);
                    bottomPanel.add(DeleteContact);
                    bottomPanel.add(SearchContacts);
                    //bottomPanel.add(SortContacts);
                    bottomPanel.add(ViewContactList);

                    frame.getContentPane().add(topPanel,
BorderLayout.NORTH);
                    frame.getContentPane().add(bottomPanel,
BorderLayout.SOUTH);
                    frame.setResizable(false);



            }

	public static void main(String args[]) {
		ContactList add = new ContactList();

	}

	OperationHandler oh = new OperationHandler();

	public void actionPerformed(ActionEvent ae)
    	    {
    	        if(ae.getActionCommand() == "Add New Contact")
    	            {
    	                 oh.AddNew();

    	            }

    	        else  if(ae.getActionCommand() == "Search Contacts")
    	            {
    	                 oh.SearchContacts();

    	            }

//    	        else  if(ae.getActionCommand() == "Sort Contacts")
//    	            {
//    	                 oh.SortContacts();
//
//    	            }

    	        else  if(ae.getActionCommand() == "Delete Contact")
    	            {
    	                  oh.DeleteContact();

    	            }

    	        else  if(ae.getActionCommand() == "View All Contacts")
    	            {

    	                  oh.ViewAllContacts();

    	            }

    	        else  if(ae.getActionCommand() == "About")
    	            {
    	                  JOptionPane.showMessageDialog(frame, "ContactList created by Mounika Kolla","About Contact List",JOptionPane.INFORMATION_MESSAGE);

    	            }
    	        else  if(ae.getActionCommand() == "Help Contents")
    	            {
    	                try
    	                 {
    	                     oh.showHelp();
    	                 }
    	                catch(IOException e)
    	                 {
    	                 }

    	            }
    	         else  if(ae.getActionCommand() == "Save Contacts")
    	            {
    	                JFileChooser chooser = new JFileChooser();
    	     	        chooser.setCurrentDirectory(new File("."));
    	     	        chooser.setMultiSelectionEnabled(false);

chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    	     	        chooser.showSaveDialog(frame);
    	     	        FileOutputStream  bfout = null;
    	     	        FileInputStream bfin = null;
    	     	        String filename=null;

    	     	        int p;

    	     	        try
    	     	         {
    	     	             filename = chooser.getSelectedFile().getPath();
    	     	         }
    	     	        catch(Exception e)
    	     	         {
    	     	         }

    	     	        try
    	     	           {
    	     	              bfout = new FileOutputStream(filename + "data.dat");
    	     	           }
    	     	        catch(Exception e)
    	     	           {

    	     	           }
    	     	        try
    	     	          {
    	     	             bfin = new FileInputStream("ddata.dat");
    	     	          }
    	     	        catch(Exception e)
    	     	          {

    	     	          }

    	     	        try
    	     	           {
    	     	           	   do
    	     	           	     {  p = bfin.read();
    	     	           	        if(p!=-1)
    	     	           	            bfout.write(p);
    	     	           	     }while(p!=-1);
    	     	           	}
    	     	         catch(Exception e)
    	     	            {

    	     	            }


    	            }

    	    }

}

class Contact implements Serializable {
	private String FirstName;
	private String LastName;
	private String MiddleName;
	private String Email;
	private String Address;
	private String PhoneNo;
	private String Zipcode;
	private String DOB;

	public void setDetails(String fname, String lname, String mname, String email, String address, String phone,
			String zip, String bday) {
		FirstName = fname;
		LastName = lname;
		MiddleName = mname;
		Email = email;
		Address = address;
		PhoneNo = phone;
		Zipcode = zip;
		DOB = bday;
	}

	public String getFirstName() {
		return FirstName;
	}

	public String getLastName() {
		return LastName;
	}

	public String getMiddleName() {
		return MiddleName;
	}

	public String getEMail() {
		return Email;
	}

	public String getAddress() {
		return Address;
	}

	public String getPhoneNo() {
		return PhoneNo;
	}

	public String getZipcode() {
		return Zipcode ;
	}

	public String getBday() {
		return DOB;
	}

}

class OperationHandler implements ListSelectionListener, ActionListener, Runnable {

	JFrame newFrame;
	JTextField txtFirstName;
	JTextField txtLastName;
	JTextField txtMiddleName;
	JTextField txtEmail;
	JTextField txtAddress;
	JTextField txtPhoneNo;
	JTextField txtZipcode;
	JTextField txtDOB;

	JButton BttnSaveAdded;

	Vector v = new Vector(10, 3);
	int i = 0, k = 0;

	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize = kit.getScreenSize();
	int screenHeight = screenSize.height;
	int screenWidth = screenSize.width;

	Image img = kit.getImage("images/icon.JPG");

	FileInputStream fis;
	ObjectInputStream ois;

	JList list;
	DefaultListModel listModel;
	ListSelectionModel listSelectionModel;

	JRadioButton byfname, bylname;

	Thread t;

	JTable searchTable;

	JTextField txtSearch;

	String columnNames[] = { "First Name", "Last Name", "Middle Name", "Email Address", "Address", "Phone No.", "zipcode",
			"B'day" };

	Object data[][] = new Object[5][8];

	OperationHandler() {

		try {
			fis = new FileInputStream("ddata.dat");
			ois = new ObjectInputStream(fis);
			v = (Vector) ois.readObject();
			ois.close();
		}

		catch (Exception e) {

		}

	}

	public void run()
    	   {

    	   	   try
           	    {
           	         FileOutputStream fos = new
FileOutputStream("ddata.dat");
           	         ObjectOutputStream oos = new 
ObjectOutputStream(fos);
                     oos.writeObject(v);
           	         oos.flush();
           	         oos.close();

           	    }
           	   catch(Exception e)
           	    {
           	    	  JOptionPane.showMessageDialog(newFrame, "Error Opening Data File: Could Not Save Contents.", "Error Opening Data File",
JOptionPane.INFORMATION_MESSAGE);
           	    }

    	   }

	public void AddNew() {
		newFrame = new JFrame("Input View");
		newFrame.setSize(220, 250);
		newFrame.setResizable(false);
		newFrame.setIconImage(img);

		JLabel lblFirstName = new JLabel("First Name: ");
		JLabel lblLastName = new JLabel("Last Name: ");
		JLabel lblMiddleName = new JLabel("Middle Name: ");
		JLabel lblEMail = new JLabel("Email: ");
		JLabel lblAddress = new JLabel("Address: ");
		JLabel lblPhoneNo = new JLabel("Phone No: ");
		JLabel lblZipcode = new JLabel("Zipcode: ");
		JLabel lblDOB= new JLabel("BDay: ");
		JLabel lblEmpty1 = new JLabel("");
		JLabel lblEmpty2 = new JLabel("");

		txtFirstName = new JTextField(10);
		txtLastName = new JTextField(10);
		txtMiddleName = new JTextField(10);
		txtEmail = new JTextField(10);
		txtAddress = new JTextField(10);
		txtPhoneNo = new JTextField(10);
		txtZipcode = new JTextField(10);
		txtDOB = new JTextField(10);

		JButton BttnAdd = new JButton("Add New!");
		BttnSaveAdded = new JButton("Save Added!");

		BttnAdd.addActionListener(this);
		BttnSaveAdded.addActionListener(this);
		BttnSaveAdded.setEnabled(false);

		JPanel centerPane = new JPanel();
		JPanel bottomPane = new JPanel();

		centerPane.add(lblFirstName);
		centerPane.add(txtFirstName);
		centerPane.add(lblLastName);
		centerPane.add(txtLastName);
		centerPane.add(lblMiddleName);
		centerPane.add(txtMiddleName);
		centerPane.add(lblEMail);
		centerPane.add(txtEmail);
		centerPane.add(lblAddress);
		centerPane.add(txtAddress);
		centerPane.add(lblPhoneNo);
		centerPane.add(txtPhoneNo);
		centerPane.add(lblZipcode);
		centerPane.add(txtZipcode);
		centerPane.add(lblDOB);
		centerPane.add(txtDOB);
		bottomPane.add(BttnAdd);
		bottomPane.add(BttnSaveAdded);

		centerPane.setLayout(new GridLayout(0, 2));

		newFrame.getContentPane().add(centerPane, BorderLayout.CENTER);

		newFrame.getContentPane().add(bottomPane, BorderLayout.SOUTH);
		newFrame.setLocation(screenWidth / 4, screenHeight / 4);
		newFrame.show();

	}

	public void SearchContacts()
           {
           	   newFrame = new JFrame("Search Contacts");
               newFrame.setSize(700,220);
               newFrame.setLocation(screenWidth/4, screenHeight/4);
               newFrame.setIconImage(img);
               newFrame.setResizable(false);

               JPanel topPane = new JPanel();
               JLabel label1 = new JLabel("Search Contacts by First Name or Last Name or Both Spaced Via a Single Space:");
               topPane.add(label1);

               JPanel centerPane = new JPanel();
               JLabel label2 = new JLabel("Search String:");
               txtSearch = new JTextField(20);
               JButton bttnSearch = new JButton("Search!");
               bttnSearch.addActionListener(this);
               JButton bttnCancel = new JButton("Cancel");
               bttnCancel.addActionListener(this);
               centerPane.add(label2);
               centerPane.add(txtSearch);
               centerPane.add(bttnSearch);
               centerPane.add(bttnCancel);

               searchTable = new JTable(data,columnNames);
               JScrollPane scrollPane = new JScrollPane(searchTable);
               searchTable.setPreferredScrollableViewportSize(new
Dimension(500, 90));

newFrame.getContentPane().add(scrollPane,BorderLayout.SOUTH);

               newFrame.getContentPane().add(topPane, 
BorderLayout.NORTH);
               newFrame.getContentPane().add(centerPane,
BorderLayout.CENTER);
               newFrame.show();
           }

//	public void SortContacts() {
//		newFrame = new JFrame("Sort Contacts");
//		newFrame.setSize(250, 160);
//		newFrame.setLocation(screenWidth / 4, screenHeight / 4);
//		newFrame.setIconImage(img);
//		newFrame.setResizable(false);
//
//		byfname = new JRadioButton("By First Name");
//		byfname.setActionCommand("By First Name");
//		byfname.setSelected(true);
//
//		bylname = new JRadioButton("By Last Name");
//		bylname.setActionCommand("By Last Name");
//
//		ButtonGroup group = new ButtonGroup();
//		group.add(byfname);
//		group.add(bylname);
//
//		JPanel topPane = new JPanel();
//		JLabel label = new JLabel("Sort Contacts By:");
//		topPane.add(label);
//
//		JPanel pane = new JPanel(new GridLayout(0, 1));
//		pane.add(byfname);
//		pane.add(bylname);
//
//		JPanel bottomPane = new JPanel();
//		JButton sortBttn = new JButton("Sort Contacts");
//		JButton cancelBttn = new JButton("Cancel");
//		bottomPane.add(sortBttn);
//		bottomPane.add(cancelBttn);
//		sortBttn.addActionListener(this);
//		cancelBttn.addActionListener(this);
//
//		newFrame.getContentPane().add(topPane, BorderLayout.NORTH);
//		newFrame.getContentPane().add(pane, BorderLayout.CENTER);
//		newFrame.getContentPane().add(bottomPane, BorderLayout.SOUTH);
//
//		newFrame.show();
//
//	}

	public void DeleteContact() {
		String fname, lname;
		newFrame = new JFrame("Delete Contact");
		newFrame.setSize(300, 300);
		newFrame.setLocation(screenWidth / 4, screenHeight / 4);
		newFrame.setIconImage(img);

		JPanel centerPane = new JPanel();
		listModel = new DefaultListModel();

		Contact contact = new Contact();

		for (int l = 0; l < v.size(); l++) {
			contact = (Contact) v.elementAt(l);

			fname = contact.getFirstName();
			lname = contact.getLastName();
			listModel.addElement(fname + " " + lname);

		}

		list = new JList(listModel);

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSelectionModel = list.getSelectionModel();
		listSelectionModel.addListSelectionListener(this);

		JScrollPane listScrollPane = new JScrollPane(list);

		JPanel topPane = new JPanel();
		JLabel label = new JLabel("Current Contacts:");
		topPane.add(label);

		JPanel bottomPane = new JPanel();

		JButton bttnDelete = new JButton("Delete Selected");
		bottomPane.add(bttnDelete);
		bttnDelete.addActionListener(this);

		JButton bttnCancel = new JButton("Cancel");
		bottomPane.add(bttnCancel);
		bttnCancel.addActionListener(this);

		newFrame.getContentPane().add(topPane, BorderLayout.NORTH);
		newFrame.getContentPane().add(listScrollPane, BorderLayout.CENTER);
		newFrame.getContentPane().add(bottomPane, BorderLayout.SOUTH);

		newFrame.show();

	}

	public void ViewAllContacts()
           {

           	        newFrame = new JFrame("All Contacts In The Contact List");
                    newFrame.setSize(600,300);
                    newFrame.setIconImage(img);

                    Contact con = new Contact();


           	        String columnNames[] = { "First Name",
                                          "Last Name",
                                          "Middle Name",
                                          "Email Address",
                                          "Address",
                                          "Phone No.",
                                          "Zipcode",
                                          "B'day"
                                         };



                    Object data[][]= new Object[v.size()][8];


                    for(int j=0;j<v.size();j++)
                            {

                                 con = (Contact) v.elementAt(k);

                                 data[j][0] = con.getFirstName();
                                 data[j][1] = con.getLastName();
                                 data[j][2] = con.getMiddleName();
                                 data[j][3] = con.getEMail();
                                 data[j][4] = con.getAddress();
                                 data[j][5] = con.getPhoneNo();
                                 data[j][6] = con.getZipcode();
                                 data[j][7] = con.getBday();

                                 k++;

                            }
                     k=0;

                     JTable abtable = new JTable(data,columnNames);
                     JScrollPane scrollPane = new JScrollPane(abtable);
                     abtable.setPreferredScrollableViewportSize(new
Dimension(500, 370));

                     JPanel pane = new JPanel();
                     JLabel label = new JLabel("Contacts Currently In The Contact List");
                     pane.add(label);


newFrame.getContentPane().add(pane,BorderLayout.SOUTH);
                     newFrame.getContentPane().add(scrollPane,
BorderLayout.CENTER);
                     newFrame.setLocation(screenWidth/4, 
screenHeight/4);
                     newFrame.show();




           }

	public void showHelp() throws IOException
           {

                String title = "Help Contents";
                String data = "";
                FileInputStream fishelp = null;
                int i;

                newFrame = new JFrame(title);
                newFrame.setSize(401, 400);
                newFrame.setResizable(false);
                newFrame.setLocation(screenWidth/4, screenHeight/4);
                newFrame.setIconImage(img);

                JTextArea textArea = new JTextArea(5,20);
                textArea.setLineWrap(true);
                textArea.setEditable(false);

                try
                  {
                  	  fishelp= new FileInputStream("help/help.txt");
                  }
                catch(Exception e)
                  {
                  	  JOptionPane.showMessageDialog(newFrame, "Help File not Found.", "Help File Not Found", JOptionPane.INFORMATION_MESSAGE);
                  }

                do
                 {
                 	 i = fishelp.read();
                 	 if(i!=1)
                 	     data = data + (char) i;
                 } while(i!=-1);

                fishelp.close();

                textArea.setText(data);

                JPanel bottomPane = new JPanel();
                JButton button = new JButton("Ok");
                bottomPane.add(button);
                button.addActionListener(this);

                JPanel topPane = new JPanel();
                JLabel label = new JLabel(title);
                topPane.add(label);

                JScrollPane scrollPane = new JScrollPane(textArea);

                
newFrame.getContentPane().add(topPane,BorderLayout.NORTH);
                newFrame.getContentPane().add(scrollPane);

newFrame.getContentPane().add(bottomPane,BorderLayout.SOUTH);

                newFrame.show();


           }

	public void actionPerformed(ActionEvent ae)
           {


           	  if(ae.getActionCommand() == "Add New!")
           	       {

           	            if(txtFirstName.getText().equals("") &&
txtLastName.getText().equals("") && txtMiddleName.getText().equals("") &&
txtEmail.getText().equals("") && txtAddress.getText().equals("") &&
txtPhoneNo.getText().equals("") && txtZipcode.getText().equals("") &&
txtDOB.getText().equals(""))
           	                {
           	                     
JOptionPane.showMessageDialog(newFrame,
"Entries Empty! Fill in the required entries to save Contact.", "Entries Empty", JOptionPane.INFORMATION_MESSAGE);

           	                  }

           	            else
           	               {
           	                   Contact contact = new Contact();

contact.setDetails(txtFirstName.getText(),txtLastName.getText(),txtMiddleName.getText(),txtEmail.getText(),txtAddress.getText(),txtPhoneNo.getText(),txtZipcode.getText(),txtDOB.getText());
           	                   v.addElement(contact);
           	                   txtFirstName.setText("");
           	                   txtLastName.setText("");
           	                   txtMiddleName.setText("");
           	                   txtEmail.setText("");
           	                   txtAddress.setText("");
           	                   txtPhoneNo.setText("");
           	                   txtZipcode.setText("");
           	                   txtDOB.setText("");

           	                   if(BttnSaveAdded.isEnabled() == false)
           	                        BttnSaveAdded.setEnabled(true);
           	              }



           	       }
           	   else if(ae.getActionCommand() == "Save Added!")
           	       {

           	       	 saveVector();
           	       	 newFrame.setVisible(false);


           	       }
           	    else if(ae.getActionCommand() == "Ok")
           	       {
           	            newFrame.setVisible(false);

           	       }
           	    else if(ae.getActionCommand() == "Delete Selected")
           	       {

           	            int index;
           	            try
           	              {

           	                 index = list.getSelectedIndex();

           	                 if(index==-1)
           	                   {

JOptionPane.showMessageDialog(newFrame, "Select a Contact first to delete it.", "Select a Contact First", JOptionPane.INFORMATION_MESSAGE);
                               }

                             else
                              {

                              	    int n =
JOptionPane.showConfirmDialog(newFrame, "Are you sure you want to delete the selected Contact?", "Are you sure?", JOptionPane.YES_NO_OPTION);


                                    if (n == JOptionPane.YES_OPTION)
                                        {
                                  	         listModel.remove(index);
                                         	 v.removeElementAt(index);
           	                                 saveVector();
           	                                 newFrame.show();


                                        }
                                     else if (n == JOptionPane.NO_OPTION)
                                        {

                                        }

           	                  }

           	               }
           	             catch(Exception e)
           	               {

           	               }

           	       }
           	    else if(ae.getActionCommand() == "Cancel")
           	       {

           	            newFrame.setVisible(false);
           	       }
           	    else if(ae.getActionCommand() == "Search!")
           	       {
           	            String SearchStr;
           	            SearchStr = txtSearch.getText();
           	            boolean flag=false;
           	            Contact con = new Contact();
           	            int c=0;

           	            for(int t=0;t<5;t++)
           	               {
           	               	   data[t][0] = "";
           	                   data[t][1] = "";
           	                   data[t][2] = "";
           	                   data[t][3] = "";
           	                   data[t][4] = "";
           	                   data[t][5] = "";
           	                   data[t][6] = "";
           	                   data[t][7] = "";
           	               }

                        for(int t=0;t<v.size();t++)
                            {

                                 con = (Contact) v.elementAt(t);


if(SearchStr.equalsIgnoreCase(con.getFirstName()) ||
SearchStr.equalsIgnoreCase(con.getLastName()) ||
SearchStr.equalsIgnoreCase(con.getFirstName() + " " + con.getLastName()))
                                    {
                                    	flag=true;

                                        data[c][0] = con.getFirstName();
                                        data[c][1] = con.getLastName();
                                        data[c][2] = con.getMiddleName();
                                        data[c][3] = con.getEMail();
                                        data[c][4] = con.getAddress();
                                        data[c][5] = con.getPhoneNo();
                                        data[c][6] = con.getZipcode();
                                        data[c][7] = con.getBday();
                                        searchTable = new
JTable(data,columnNames);
                                        newFrame.setSize(700,221);
                                        newFrame.setSize(700,220);

                                        if(c<5)
                                             c++;
                                    }

                            }


           	             if(flag)
           	                {
           	                   JOptionPane.showMessageDialog(newFrame,
"Contact Found!", "Search Result!", JOptionPane.INFORMATION_MESSAGE);
           	                }

           	             else
           	                {
           	                   JOptionPane.showMessageDialog(newFrame,"No Such Contact Found!", "Search Result!", JOptionPane.INFORMATION_MESSAGE);
           	                }


           	       }
           	    else if(ae.getActionCommand() == "Sort Contacts")
           	       {

                     if(byfname.isSelected())
                       {
                           Contact contact1 = new Contact();
                           Contact contact2 = new Contact();
                           Contact temp = new Contact();
                           int l,m;

                           for(l=0;l<v.size()-1;l++)
                             {
                               for(m=l+1;m<v.size();m++)
                                 {
                                 	contact1 = (Contact) v.elementAt(l);
                                  	contact2 = (Contact) v.elementAt(m);


if(contact1.getFirstName().compareTo(contact2.getFirstName()) > 0)
                                 	    {
                     	                   temp = (Contact) 
                     	                		   v.elementAt(m);
                     	                   v.setElementAt(v.elementAt(l),m);
                     	                   v.setElementAt(temp,l);
                     	                }

                                 }
                              }

                           saveVector();
           	            }
           	          else
           	            {

                           Contact contact1 = new Contact();
                           Contact contact2 = new Contact();
                           Contact temp = new Contact();
                           int l,m;

                           for(l=0;l<v.size()-1;l++)
                             {
                               for(m=l+1;m<v.size();m++)
                                 {
                                 	contact1 = (Contact) v.elementAt(l);
                                  	contact2 = (Contact) v.elementAt(m);


if(contact1.getLastName().compareTo(contact2.getLastName()) > 0)
                                 	    {
                     	                   temp = (Contact) v.elementAt(m);
                     	                   v.setElementAt(v.elementAt(l),m);
                     	                   v.setElementAt(temp,l);
                     	                }

                                 }
                              }

                           saveVector();
           	            }

           	          newFrame.setVisible(false);
           	      }


           }

	public void saveVector() {
		t = new Thread(this, "Save Vector Thread");
		t.start();

	}

	public void valueChanged(ListSelectionEvent lse) {

	}

}
