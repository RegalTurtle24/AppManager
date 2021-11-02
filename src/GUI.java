import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class GUI {
	
	private static ArrayList<String> websites = new ArrayList<String>();
	static JFrame f = new JFrame(); 
	private static int count = 0;
	
	public static void main(String[] args) {  
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addButton(f, "new link");		
		visuals(f, websites);
	}  
	
	public static void visuals(JFrame f, ArrayList<String> websites) {
		for(int i = count; i < websites.size(); i++) {
			addButton(f, websites.get(i));
			count++;
		}
		f.setLayout(new GridLayout(4,3, 10, 10));    
		f.setSize(1370,730);    
		f.setVisible(true); 
	}
	
	public static void addButton(JFrame f, String name) {
		JButton temp = new JButton(name);  
		temp.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	//the print statements are temporary; i will call runner here
		    	if(name.equals("new link")) {
		    		System.out.println("creating new link");
		    		createNewLink();
		    	} else {
		    		System.out.println("call runner");
		    	}
		    } 
		});
		f.add(temp);
	}
	
	public static void createNewLink() {
	    JTextField name = new JTextField(10);
	    JTextField websiteLink = new JTextField(10);
	    JTextField username = new JTextField(10);
	    JTextField password = new JTextField(10);

	    JPanel myPanel = new JPanel();
	    myPanel.add(new JLabel("name: "));
	    myPanel.add(name);
	    myPanel.add(Box.createVerticalStrut(15)); 
	    myPanel.add(new JLabel("website link:"));
	    myPanel.add(websiteLink);
	    myPanel.add(Box.createVerticalStrut(15)); 
	    myPanel.add(new JLabel("username: "));
	    myPanel.add(username);
	    myPanel.add(Box.createVerticalStrut(15)); 
	    myPanel.add(new JLabel("password:"));
	    myPanel.add(password);
	    
	    String nameString;
	    String websiteLinkString;
	    String usernameString;
	    String passwordString;

	    int result = JOptionPane.showConfirmDialog(null, myPanel,
	        "Please enter the following information for the new link", JOptionPane.OK_CANCEL_OPTION);
	    if (result == JOptionPane.OK_OPTION) {
	    	nameString = name.getText();
	    	websiteLinkString = websiteLink.getText();
	    	usernameString = username.getText();
	    	passwordString = password.getText();
	    	
	    	System.out.println("name: " + nameString);
	    	System.out.println("website link: " + websiteLinkString);
	    	System.out.println("username: " + usernameString);
	    	System.out.println("password: " + passwordString);
	    	
	    	websites.add(websiteLinkString);
	    	
	    	visuals(f, websites);
	    }
	}
}
