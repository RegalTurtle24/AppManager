import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class GUI {
	
	private static ArrayList<String> websites = new ArrayList<String>();
	static JFrame f;
	private static int count;
	
	// purpose: creates instance of GUI, while also setup frame and count
	// input: nothing
	// output: GUI, JFrame, and count of 0
	public GUI() {
		f = new JFrame();
		count = 0;
	}
	
	// purpose: makes sure that GUI closes when exited out, also
	// sets up buttons for AP Classroom, Pearson's Mastering Biology, and creating new link
	// input: is run
	// output: GUI with buttons for AP Classroom, Pearson's Mastering Biology, and creating new Links
	public void run() {  
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//presets
		websites.add("AP Classroom");
		websites.add("Pearson's Mastering Biology");
		//stuff here to call sam's class
		addButton(f, "new link");		
		visuals(f, websites);
	}  

	// purpose: creates buttons on GUI for links current listed in the websites Arraylist
	// input: JFrame, website arrayList
	// output: buttons for website displayed on GUI
	public void visuals(JFrame f, ArrayList<String> websites) {
		for(int i = count; i < websites.size(); i++) { 
			addButton(f, websites.get(i));
			count++;
		}
		f.setLayout(new GridLayout(4,3, 10, 10));  
		f.setSize(1370,730);    
		f.setVisible(true); 
	}
	
	// purpose: creates a button that can either create new links or call other methods
	// this method also insures that buttons and links are deleted with shift-click
	// input: JFrame, button name
	// output: functioning buttons that can access websites or create new links
	public void addButton(JFrame f, String name) {
		JButton temp = new JButton(name);  
		temp.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	//the print statements are temporary; i will call other classes here
		    	if(name.equals("new link")) {
		    		System.out.println("creating new link");
		    		createNewLink();
		    	} else if (e.getModifiers() == 17) {
		    		f.remove(temp);
		    		websites.remove(name);
		    		visuals(f, websites);
		    	} else {
		    		System.out.println("call runner");
		    	}
		    } 
		});
		f.add(temp);
	}
	
	// purpose: prompts user to create new link
	// input: name, link, username, password
	// output: button with new quicklink
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
	    	
	    	websites.add(nameString);
	    	
	    	visuals(f, websites);
	    }
	}
}
