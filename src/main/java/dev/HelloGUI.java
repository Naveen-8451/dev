package dev;

import javax.swing.JOptionPane;

public class HelloGUI {
	
	public void display(String a){
		
		
		JOptionPane.showMessageDialog(null, "Hello " + a);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HelloGUI obj = new HelloGUI();
		String theName="";
		int i=0;//initialize the array 
		while(i<args.length){//loop until the end of array 
			if(args[i].contains("-n")){
				System.out.println("Name: ");//print each argument out 
				i++;//increment the loop variable
				theName=args[i];
			System.out.println(args[i] + "");
			System.out.println(theName);
			i++;
			}
			String p =JOptionPane.showInputDialog(null, args[i]);
				System.out.println(p);
				if(p.equals(args[i]))
				obj.display(p);
				else
				JOptionPane.showMessageDialog(null, "Wrong Name " + p);
		
	}
		
		//JOptionPane.showMessageDialog(null, "Hello " + p);
        System.exit(0);
	}
	
	
	

}
