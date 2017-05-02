package org.contact.sample;

import javax.swing.*;

import java.util.*;
class AddressBook {
	
	 boolean t1 , t2,t3;
   ArrayList<PersonInfo> persons;
   
   //constructor
    public AddressBook ( ) {
    	
        persons = new ArrayList<PersonInfo>();
    }
	 
   
    public void addRecord( ) {
    	
	   String name = JOptionPane.showInputDialog("Enter name");
	   String add = JOptionPane.showInputDialog("Enter address");
       String pNum = JOptionPane.showInputDialog("Enter phone no");
     
        PersonInfo p = new PersonInfo(name, add, pNum);
   
         persons.add(p);
   }
   
   
    public void searchRecord ()
    {
     if(persons.isEmpty()==false){
    	 
    	String var = JOptionPane.showInputDialog("Enter Name To Search ");
    	 
       for (int i=0; i< persons.size(); i++) 
       {
    	   
         PersonInfo p = (PersonInfo)persons.get(i);
             if ( var.equals(p.name) ) 
             { 
            	     t1=true;
            	 
                      p.print();         
                }  
           
      } // end for
       
          if(!(t1==true)){
            	 
            	 JOptionPane.showMessageDialog(null, "Record Not found");
          }  
          
     }
          else{
        	  	
          		JOptionPane.showMessageDialog(null, "....Sorry ther is No any record ....");
          }
          
          
    	
    } // end searchPerson

  //Delete the specific person from the record
    
    public void deleteRecord () {
    	
    	if(!(persons.isEmpty())){
    		
    	String var = JOptionPane.showInputDialog("Enter Name To Delete ");
         	
        for (int i=0; i< persons.size(); i++)
        {
            PersonInfo p = (PersonInfo)persons.get(i);
            
                if ( var.equals(p.name) )
                {
                	t3=true;
                    persons.remove(i);
                    JOptionPane.showInputDialog("Record is Deleted ");
                }
            }
        if(!(t3==true)){
    		
   		 JOptionPane.showMessageDialog(null, "Record Not found");
   	}
   	
        
    	}
    	else{
    		
    		JOptionPane.showMessageDialog(null, "....SOrry ther is No any record ....");
    	}
      }
    
 // TO display all the records   
    
    public void allRecord(){
    	
    	if(persons.size()==0){
    		
    		JOptionPane.showMessageDialog(null, "....SOrry No record is Found....");
    	}
    	
       for (int i=0; i< persons.size(); i++)
         {
             PersonInfo p = (PersonInfo)persons.get(i);
             
             JOptionPane.showMessageDialog(null, " Record No:"+(i+1) +"\n\nName: " + p.name + "\n Address: " + p.address + "\n phone no: " + p.phoneNum);
                 
             }
         }
    
   // Modify records. 
    public void modifyRecord(){
    	if(persons.isEmpty()==false){
    		
    	String var = JOptionPane.showInputDialog("Enter Name To Modify ");
    	for (int i=0; i< persons.size(); i++)
        {
            PersonInfo p = (PersonInfo)persons.get(i);
            
                if ( var.equals(p.name) )
                {
                	 t2=true;
                	 p.print();
                	
                    persons.remove(i);
                    
                    String name = JOptionPane.showInputDialog("Enter new Name Last one is : " + p.name);
             	     String add = JOptionPane.showInputDialog("Enter new address Last one is : "+p.address);
                    String pNum = JOptionPane.showInputDialog("Enter new phone no. last one is : "+p.phoneNum);
                  
                     PersonInfo p1 = new PersonInfo(name, add, pNum);
                     persons.add(p1);
                     p1.print();
                }
            }
    	
    	if(!(t2==true)){
    		
    		 JOptionPane.showMessageDialog(null, "Record Not found");
    	}
    	
    	}
    	else{
    		JOptionPane.showMessageDialog(null, "....SOrry ther is No any record ....");
    		
    	}
    	
        }
    
    }//end of class