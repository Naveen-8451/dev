package dev;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Tutorial1 extends JFrame {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JFrame frame = new JFrame("HelloWorldSwing");
	//JTextField jt = new JTextField(20);
	JButton button = new JButton("Enter");
	JTextField textfield = new JTextField(30);
	

	public Tutorial1() {
		setTitle("GUI based hello world");
		setVisible(true);
		setSize(400, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		

		panel.add(textfield);
		textfield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = textfield.getText();
				label.setText(input);
			}
		});

		panel.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = textfield.getText();
				label.setText(input);
			}
		});

		panel.add(label);
		add(panel);

	}

	public static void main(String[] args) {
		Tutorial1 t = new Tutorial1();
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
	}
}
