package org.contact.sample;
import javax.swing.*;
class Test {

   public static void main (String args[])
   {
        AddressBook adrBookObj = new AddressBook();
        String input;
        int sInt;
    while (true)
    {
       
       input = JOptionPane.showInputDialog("Enter 1 To Add Record  \n Enter 2 To Search Record \n Enter 3 To Delete Record \n Enter 4 To Modify Record \n Enter 5 To Display All Records \n Enter 6 to Exit");
       sInt = Integer.parseInt(input);
      
       
        switch (sInt) {
        
            case 1:
                   adrBookObj.addRecord();
                   break;
                   
            case 2:
                   adrBookObj.searchRecord();
                   break;
                   
            case 3:
                   adrBookObj.deleteRecord();
                   break;
                   
            case 4:
            	
                adrBookObj.modifyRecord();
                break;
                
            case 5:
                
                adrBookObj.allRecord();
                break;
                
            case 6:
                   System.exit(0);
        }
    }//end while
   }// end of main
}// end of class