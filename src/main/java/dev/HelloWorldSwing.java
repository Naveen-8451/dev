package dev;

import java.util.Scanner;
//import java.awt.BorderLayout;
//import java.util.*;
import javax.swing.*;        
public class HelloWorldSwing {
	private static String name = "";
	/**
	 *  * Create the GUI and show it.  For thread safety,
	 * this method should be invoked from the
	 * event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		//Create and set up the window.
		JFrame frame = new JFrame("GUI based Hello World");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Add the ubiquitous "Hello World" label.
		JLabel label = new JLabel("Hello World "+ name);
		frame.getContentPane().add(label);
		//Display the window.
		
		frame.pack();
		frame.setVisible(true);
	}
	public static void inputmethod(String s)
	{
		// Prompt the user
		name=s;
		//System.out.print( "Type some data for the program as input: " );
		//Scanner in = new Scanner(System.in);
		//name= in.nextLine();
		while(name.matches(s)){
			// Display the input back to the user.
			
			System.out.println( "nothing has been entered as input");
			//name=in.nextLine();
		}
	}// end main method
	
	public static void main(String[] args) {
		
		String theName="";
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		//processing arguments 
		int i=0;//initialize the array 
		while(i<args.length){//loop until the end of array 
			if(args[i].contains("-n")){
				System.out.println("Name: ");//print each argument out 
				i++;//increment the loop variable
				theName=args[i];
			}
			System.out.println(args[i] + "");
			i++;
		}
		System.out.println();//terminate the line 
		inputmethod(theName);
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}