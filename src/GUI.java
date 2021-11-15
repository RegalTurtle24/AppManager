import java.util.ArrayList;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI {
	
	private static LinkManager websites;
	static JFrame f;
	private static int count;
	
	public GUI() {
		websites = new LinkManager();
		f = new JFrame();
		count = 0;
	}
	
	public void run() { 
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//stuff here to call sam's class
		addButton(f, "new link");		
		visuals(f);
	}  
	
	//creating the buttons
	public void visuals(JFrame f) {
		ArrayList<QuickLinks> copySites  = new ArrayList<QuickLinks>(websites.getHashMap().values());
		for(int i = count; i < copySites.size(); i++) {
				addButton(f, copySites.get(i).getName());
				count++;
		}
		f.setLayout(new GridLayout(4,3, 10, 10));    
		f.setSize(1370,730);    
		f.setVisible(true); 
	}
	
	//adding a button
	public void addButton(JFrame f, String name) {
		JButton temp = new JButton(name);  
		temp.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	//the print statements are temporary; i will call other classes here
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
	
	//creating a new link
	public void createNewLink() {
	    JTextField name = new JTextField(10);
	    JTextField websiteLink = new JTextField(10);
	    JTextField username = new JTextField(10);
	    JTextField password = new JTextField(10);

	    JPanel myPanel = new JPanel();
	    myPanel.add(new JLabel("name: "));
	    myPanel.add(name);
	    myPanel.add(Box.createVerticalStrut(15)); 
	    myPanel.add(new JLabel("website link (to login page):"));
	    myPanel.add(websiteLink);
	    myPanel.add(Box.createVerticalStrut(15)); 
	    myPanel.add(new JLabel("username: "));
	    myPanel.add(username);
	    myPanel.add(Box.createVerticalStrut(15)); 
	    myPanel.add(new JLabel("password:"));
	    myPanel.add(password);
	    
	    //stuff to give to runner:
	    String nameString;
	    String websiteLinkString;
	    String usernameString;
	    String passwordString;

	    //where to input stuff for a new link
	    int result = JOptionPane.showConfirmDialog(null, myPanel,
	        "Please enter the following information for the new link", JOptionPane.OK_CANCEL_OPTION);
	    if (result == JOptionPane.OK_OPTION) {
	    	nameString = name.getText();
	    	websiteLinkString = websiteLink.getText();
	    	usernameString = username.getText();
	    	passwordString = password.getText();
	    	
	    	//temporary
	    	System.out.println("name: " + nameString);
	    	System.out.println("website link: " + websiteLinkString);
	    	System.out.println("username: " + usernameString);
	    	System.out.println("password: " + passwordString);
	    	
	    	//add a linkmanager link using the above fields.
	    	
	    	websites.addLink(new QuickLinks(usernameString, 
	    									passwordString, 
	    									nameString, 
	    									websiteLinkString));
	    	
	    	visuals(f);
	    }
	}
}
