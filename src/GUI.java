import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class GUI {
	public static void main(String[] args) {  
		
		JFrame f=new JFrame();  
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// creating buttons and adding actionlistener manually (will be done automatically later)
		JButton b1=new JButton("1");   
		b1.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    		System.out.println("lol");
		    } 
		});
		
	    JButton b2=new JButton("2");    
	    JButton b3=new JButton("3");    
	    JButton b4=new JButton("4");    
	    JButton b5=new JButton("5");    
	    JButton b6=new JButton("6");  
	    JButton b7=new JButton("new link");    

   
	     // adding buttons to the frame manually (will be done automatically later)       
	    f.add(b1); f.add(b2); f.add(b3);  
	    f.add(b4); f.add(b5); f.add(b6); f.add(b7);
	  
	    // setting grid layout of 3 rows and 3 columns    
	    f.setLayout(new GridLayout(4,3, 10, 10));    
	    f.setSize(1370,730);    
	    f.setVisible(true); 	
		

	}  
}
