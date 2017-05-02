package dev;

/*
Hello World Applet Example
This java example shows how to create and run Hello World Java Applet.
*/


/*
Hello World Applet Example
This java example shows how to create and run Hello World Java Applet.
*/



import java.applet.*;
import java.awt.*;
import java.awt.event.*;


public class HelloWorld extends Applet {

  private TextField input;
  private Label output;
  
  
  
  public void init () {
   
	  Frame title = (Frame)this.getParent().getParent();
	  title.setTitle("GUI BASED HELLO WORLD");
	  setSize(500, 100);
     // Construct the TextFields
	  this.input = new TextField();
	  this.input.setText("Try Entering the data");
	  this.input.setSize(300, 400);
	  Button b = new Button("Print");
	  this.output = new Label();
;     // add the button to the layout
     	this.add(input);
     	this.add(b);
     	this.add(output);
    
     Hello ca = new Hello(input,output);
     b.addActionListener(ca);
     this.input.addActionListener(ca);

     // notice that ActionEvents produced by output are ignored.
   
   }

}


class Hello implements ActionListener {
  private TextField in;
  private Label out ;

  public Hello(TextField in,Label out) {
   
	  
	  this.in = in;
	  this.in.setText("your text displays here");
	  this.in.setSize(300, 400);
	  
	  this.out = out;
   
  }

  public void actionPerformed(ActionEvent ae) {
    String s = in.getText();
    this.out.setText("\n"+s);
    this.out.setSize(500,25);
    this.out.setAlignment(0);;

  }

  
  
}
