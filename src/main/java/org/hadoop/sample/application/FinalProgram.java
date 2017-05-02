package org.hadoop.sample.application;

import java.awt.*; //declare packages needed
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.JMenuBar;

public class FinalProgram extends JFrame implements ActionListener {

	static JFrame frame;

	public void actionPerformed(ActionEvent e) {

		String answer = (e.getActionCommand());

		if (answer == "Get Data") {

			JInternalFrame iFrame = new JInternalFrame("Get Data . ", false, true, false, false);
			iFrame.setLayout(new GridLayout(8, 2));

			JLabel label1 = new JLabel("First Name");
			JLabel label2 = new JLabel("Last Name");
			JLabel label3 = new JLabel("Street");
			JLabel label4 = new JLabel("City");
			JLabel label5 = new JLabel("State");
			JLabel label6 = new JLabel("Zip");
			JLabel label7 = new JLabel("Phone");
			JLabel label8 = new JLabel("Click Button to Submit Form -->");

			JTextField textfield1 = new JTextField(10);
			JTextField textfield2 = new JTextField(10);
			JTextField textfield3 = new JTextField(10);
			JTextField textfield4 = new JTextField(10);
			JTextField textfield5 = new JTextField(10);
			JTextField textfield6 = new JTextField(10);
			JTextField textfield7 = new JTextField(10);
			JButton button1 = new JButton("Submit Data"); // here is the 'Submit
															// Data' button

			textfield1.addActionListener(this); // add actionlisteners to each
												// textfield to later grab the
												// info
			textfield2.addActionListener(this);
			textfield3.addActionListener(this);
			textfield4.addActionListener(this);
			textfield5.addActionListener(this);
			textfield6.addActionListener(this);
			textfield7.addActionListener(this);
			button1.addActionListener(this); // add an actionlistener to our
												// 'Submit Data' button, maybe
												// I'm missing a getSource()
												// here?

			// textfield1.setSize(10, 10);

			iFrame.add(label1);
			iFrame.add(textfield1);
			iFrame.add(label2);
			iFrame.add(textfield2);
			iFrame.add(label3);
			iFrame.add(textfield3);
			iFrame.add(label4);
			iFrame.add(textfield4);
			iFrame.add(label5);
			iFrame.add(textfield5);
			iFrame.add(label6);
			iFrame.add(textfield6);
			iFrame.add(label7);
			iFrame.add(textfield7);
			iFrame.add(label8);
			iFrame.add(button1);

			try {
				String directoryName = "c:\\javacode\\Notepad"; // variable
																// holding
																// directory
																// information
				String fileName = "program.txt"; // variable holding text file
													// name information, this
													// text file is completely
													// empty, waiting for the
													// textField information
				File output = new File(directoryName, fileName); // File object
																	// containing
																	// our
																	// directory
																	// and file
																	// information
				output.createNewFile(); // create the file if there isn't one
										// already

				if (!output.isFile()) { // generate error message if one cannot
										// be created
					System.out.println("File creation of" + output.getPath() + "failed");
					return;
				}

				// put an if statement here, so that IF the 'Submit Data' button
				// has been pressed, take the data from the textFields and write
				// them to file (run the code within the brackets)

				BufferedWriter out = new BufferedWriter(new FileWriter(output.getPath(), true));

				// Here I create the code to grab the actions(grab the text)
				// from the textFields and store them into variables OR into an
				// array

				// after I have created my container to hold the information for
				// my various textFields, then I want to create a for loop to go
				// through each textField and write that information to a text
				// file, separating each textField on its own line
				out.close();
			}

			catch (IOException d) {
				System.out.println("Error writing to file " + d);
			}

			iFrame.setSize(200, 500);
			iFrame.setVisible(true);

			add(iFrame);

		}

		if (answer == "Display Data") {

			JInternalFrame iFrame = new JInternalFrame("Display Data . ", false, true, false, false);

			JTextArea text = new JTextArea();
			JScrollPane scroller = new JScrollPane();
			scroller.getViewport().add(text);

			iFrame.getContentPane().add(scroller);
			iFrame.setSize(200, 150);
			iFrame.setVisible(true);
			add(iFrame);
		}

	}

	public FinalProgram() {
		super("Menu Example");

		JMenuBar jmb = new JMenuBar();
		JMenu file = new JMenu("Functions");
		JMenuItem item;
		file.add(item = new JMenuItem("Get Data"));
		item.addActionListener(this);
		file.add(item = new JMenuItem("Display Data"));
		item.addActionListener(this);

		jmb.add(file);

		//addWindowListener(new ExitListener());
		setJMenuBar(jmb);
	}

	public static void main(String[] args) {

		FinalProgram window = new FinalProgram();
		window.setTitle("Final Program");
		window.setSize(600, 600);
		window.setVisible(true);

	}
}
