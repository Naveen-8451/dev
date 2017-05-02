package org.hadoop.sample.application;

import javax.swing.*;



import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
 
public class Registration extends JFrame implements ActionListener 
  { 
	JLabel l1, l2, l3, l4, l5, l6, l7, l8,l9,l10,l11,l12;
    JTextField tf1, tf2,tf3,tf4,tf5, tf6, tf7,tf8,tf9;
    JComboBox<String> Combo1;
    JTextArea ta1;
    JButton btn1, btn2;
 
    public void  Registration1()
     {
        
        l1 = new JLabel("Input View:");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));
 
        l2 = new JLabel("First Name:");//t1
        l3 = new JLabel("Last Name:");//t2
        l4 = new JLabel("Middle Name:");//t3
        l5 = new JLabel("Street1:");//t4
        l6 = new JLabel("Street2:");//t5
        l7 = new JLabel("City:");//t6
        l8 = new JLabel("State");//List
        l9 = new JLabel("Zip:");//t7
        l10 = new JLabel("Email:");//t8
        l11 = new JLabel("Phone No:");//t9 
        l12 = new JLabel("Note:");
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        Combo1 = new JComboBox<String>();
        tf7 = new JTextField();
        tf8 = new JTextField();
        tf9 = new JTextField();
        ta1 = new JTextArea();
        
 
        btn1 = new JButton("Submit");
        btn2 = new JButton("Clear");
 
        btn1.addActionListener(this);
        btn2.addActionListener(this);
 
        l1.setBounds(100, 30, 400, 30);
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        l4.setBounds(80, 150, 200, 30);
        l5.setBounds(80, 190, 200, 30);
        l6.setBounds(80, 230, 200, 30);
        l7.setBounds(80, 270, 200, 30);
        l8.setBounds(80, 310, 200, 30);
        l9.setBounds(80, 350, 200, 30);
        l10.setBounds(80, 390, 200, 30);
        l11.setBounds(80, 430, 200, 30);
        l12.setBounds(80,470,200,30);
        tf1.setBounds(300, 70, 200, 30);
        tf2.setBounds(300, 110, 200, 30);
        tf3.setBounds(300, 150, 200, 30);
        tf4.setBounds(300, 190, 200, 30);
        tf5.setBounds(300, 230, 200, 30);
        tf6.setBounds(300, 270, 200, 30);
        Combo1.setBounds(300, 310, 200, 30);
        Combo1.addItem("Select State");
        Combo1.addItem("AL Alabama");
        Combo1.addItem("AK Alaska");
        Combo1.addItem("AZ Arizona");
        Combo1.addItem("AR Arkansas");
        Combo1.addItem("CA California");
        Combo1.addItem("CO Colorado");
        Combo1.addItem("CT Connecticut");
        Combo1.addItem("DE Delaware");
        Combo1.addItem("DC District Of Columbia");
        Combo1.addItem("FL Florida");
        Combo1.addItem("GA Georgia");
        Combo1.addItem("HI Hawaii");
        Combo1.addItem("ID Idaho");
        Combo1.addItem("IL Illinois");
        Combo1.addItem("IN Indiana");
        Combo1.addItem("IA Iowa");
        Combo1.addItem("KS Kansas");
        Combo1.addItem("KY Kentucky");
        Combo1.addItem("LA Louisiana");
        Combo1.addItem("ME Maine");
        Combo1.addItem("MD Maryland");
        Combo1.addItem("MA Massachusetts");
        Combo1.addItem("MI Michigan");
        Combo1.addItem("MN Minnesota");
        Combo1.addItem("MS Mississippi");
        Combo1.addItem("MO Missouri");
        Combo1.addItem("MT Montana");
        Combo1.addItem("NE Nebraska");
        Combo1.addItem("NV Nevada");
        Combo1.addItem("NH New Hampshire");
        Combo1.addItem("NJ New Jersey");
        Combo1.addItem("NM New Mexico");
        Combo1.addItem("NY New York");
        Combo1.addItem("NC North Carolina");
        Combo1.addItem("ND North Dakota");
        Combo1.addItem("OH Ohio");
        Combo1.addItem("OK Oklahoma");
        Combo1.addItem("OR Oregon");
        Combo1.addItem("PA Pennsylvania");
        Combo1.addItem("RI Rhode Island");
        Combo1.addItem("SC South Carolina");
        Combo1.addItem("SD South Dakota");
        Combo1.addItem("TN Tennessee");
        Combo1.addItem("TX Texas");
        Combo1.addItem("UT Utah");
        Combo1.addItem("VT Vermont");
        Combo1.addItem("VA Virginia");
        Combo1.addItem("WA Washington");
        Combo1.addItem("WV West Virginia");
        Combo1.addItem("WI Wisconsin");
        Combo1.addItem("WY Wyoming");
        tf7.setBounds(300, 350, 200, 30);
        tf8.setBounds(300, 390, 200, 30);
        tf9.setBounds(300, 430, 200, 30);
        ta1 = new JTextArea ();
        ta1.setBounds(300, 470, 200, 30);

        
        btn1.setBounds(100, 590, 200, 30);
        btn2.setBounds(100, 630, 200, 30);
 
        add(l1);
        add(l2);
        add(tf1);
        add(l3);
        add(tf2);
        add(l4);
        add(tf3);
        add(l5);
        add(tf4);
        add(l6);
        add(tf5);
        add(l7);
        add(tf6);
        add(l8);
        add(Combo1);
        add(l9);
        add(tf7);
        add(l10);
        add(tf8);
        add(l11);
        add(tf9);
        add(l12);
        add(ta1);
        add(btn1);
        add(btn2);
        setSize(800, 800);
        setLayout(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Registration Form in Java");
        setVisible(true);
    }
 
    public void actionPerformed(ActionEvent e) 
     {
        if (e.getSource() == btn1)
         {
            //int x = 0;
            String s1 = tf1.getText();
            System.out.println(s1);
            String s2 = tf2.getText();
            String s3 = tf3.getText();
            String s4 = tf4.getText();
            String s5 = tf5.getText();
            String s6 = Combo1.getSelectedItem().toString();
            String s7 = tf6.getText();
            String s8 = tf7.getText();
            String s9 = tf8.getText();
            String s10 = tf9.getText();
            String s11 = ta1.getText();
            BufferedWriter writer;
            try {
            	writer = new BufferedWriter(new FileWriter("contacts1.txt",true));
                writer.write(s1 + "," + s2 + "," + s3 + "," + s4 + "," + s5 + "," + s6 + "," + s7 + "," + s8 + "," + s9 + "," + s10 + "," +s11);
                writer.newLine();
                writer.close();
                JFrame frame = new JFrame("List View");
                JMenuBar menuBar = new JMenuBar();
        		frame.setJMenuBar(menuBar);
        		
        		
        		//File Menu
        		
        		JMenu file1 = new JMenu("File");
        		menuBar.add(file1);

        		JMenuItem New = new JMenuItem("New");
        		file1.add(New);
        		New.addActionListener(new ActionListener() {
        		   
        		    public void actionPerformed(ActionEvent actionEvent) {
        		    	Registration1();
        		    }
        		});
        		
        	 
        		
        		JMenuItem open = new JMenuItem("open");
        		file1.add(open);
        		open.addActionListener(new ActionListener() {
         		   
        		    public void actionPerformed(ActionEvent actionEvent) {
        		    	JFileChooser fileChooser = new JFileChooser();
        		        int returnValue = fileChooser.showOpenDialog(null);
        		        if (returnValue == JFileChooser.APPROVE_OPTION) {
        		          File selectedFile = fileChooser.getSelectedFile();
        		          System.out.println(selectedFile.getName());
        		    	}
        		        
        		    	 
        		    	
        		    }
        		});
        	
        		JMenuItem save = new JMenuItem("save");
        		file1.add(save);
        		save.addActionListener(new ActionListener() {
        			
          		    public void actionPerformed(ActionEvent actionEvent) {
          		    	JFrame parentFrame = new JFrame();
          		    	JFileChooser fileChooser = new JFileChooser();
          		    	fileChooser.setDialogTitle("Specify a file to save");
          		    	int userSelection = fileChooser.showSaveDialog(parentFrame);
          		    	if (userSelection == JFileChooser.APPROVE_OPTION) {
          		    	    File fileToSave = fileChooser.getSelectedFile();
          		    	    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
          		    	}
        		    	
        		    }
        		    
            });
        		
        		
        		JMenuItem about = new JMenuItem("About");
        		file1.add(about);
        		
        		
        		//Edit Menu

        		JMenu Edit = new JMenu("Edit");
        		menuBar.add(Edit);
        		
        		
        		
        		/*JMenuItem Add = new JMenuItem("Add");
        		file1.add(Add);
        		
        		JMenuItem remove = new JMenuItem("Remove");
        		file1.add(remove);
        		
        		JMenuItem Modify = new JMenuItem("Modify");
        		file1.add(Modify);
        		*/
        		
        		
        		
        		//Help Menu
        		JMenu Help = new JMenu("Help");
        		menuBar.add(Help);
        		
        		
        		
        		
        		//Logging Menu
        		JMenu Logging = new JMenu("Logging");
        		menuBar.add(Logging);

        		JMenuItem Add = new JMenuItem("Add");
        		Logging.add(Add);
        		Add.addActionListener(new ActionListener() {
         		   
        		    public void actionPerformed(ActionEvent actionEvent) {
        		    	Registration1();
        		    }
        		});
        		
        		
        		JMenuItem remove = new JMenuItem("Remove");
        		Logging.add(remove);
        		remove.addActionListener(new ActionListener() {
          		   
        		    public void actionPerformed(ActionEvent actionEvent) {
        		    	
        		    
        		    	
        		       	
        		    }
        		});
        		
        		
        		JMenuItem Modify = new JMenuItem("Modify");
        		Logging.add(Modify);
        		
        		
        		
                
        		frame.setVisible(true);
        		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		frame.setSize(500,500);
        		frame.setLayout(new FlowLayout());
        	
        		//frame.add(list);
        		
        		
        		try
        		{
            		File file = new File("contacts1.txt");
            		FileReader fr = new FileReader(file);
            		BufferedReader br = new BufferedReader(fr);
            		String line = "";
            		//System.out.println("Catalog:");
            		
        		    while((line = br.readLine()) != null)
        		    { 
        		    	String[] values = line.split(",");
        		    	Object rowData[][] = { {values[0],values[1],values[2],values[3],values[4],values[5],values[6],values[7],values[8],values[9],values[10]}};    
        		    	    Object columnNames[] = { "FirstName", "LastName","Middle Name","Street1","Stree2","City","State","Zipcode","email","phne","Note"};
        		    	    JTable table = new JTable(rowData, columnNames);

        		    	    JScrollPane scrollPane = new JScrollPane(table);
        		    	    frame.add(scrollPane, BorderLayout.CENTER);
        		    	    frame.setSize(300, 150);
        		    	    frame.setVisible(true);
        		  	
        		    	//list.add(line);
        		    	
        		    }
        		    br.close();
        		}
        		catch(IOException e2)
        		{
        		    System.out.println("Error opening file");
        		}
            } catch(FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            
         }
        
     }
    
    public static void main(String args[])
   {
    	Registration obj = new Registration();
       obj.Registration1();
    }
}