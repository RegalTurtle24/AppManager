import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class GUI {
	private static LinkManager websites;
	static JFrame f;

	public GUI() {
		websites = new LinkManager();
		f = new JFrame();
	}

	public void run() {
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// stuff here to call sam's class
		addButton(f, "new link");
		setPresets(f);
	}

	// creating the buttons, should only be called once
	public void setPresets(JFrame f) {
		ArrayList<QuickLinks> websitesList = new ArrayList<QuickLinks>(websites.getHashMap().values());

		for (int i = 0; i < websitesList.size(); i++) {
			addButton(f, websitesList.get(i).getName());
		}
		f.setLayout(new GridLayout(4, 3, 10, 10));
		f.setSize(1370, 730);
		f.setVisible(true);
	}

	// adding a button
	public void addButton(JFrame f, String name) {
		JButton temp = new JButton(name);
		temp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// the print statements are temporary; i will call other classes here
				if (name.equals("new link")) {
					System.out.println("creating new link");
					createNewLink();
				} else {
//					System.out.println("call runner");
					System.out.println(temp.getText());
				}
			}
		});
		f.add(temp);
	}

	// creating a new link
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

		// stuff to give to runner:
		String nameString;
		String websiteLinkString;
		String usernameString;
		String passwordString;

		// where to input stuff for a new link
		int result = JOptionPane.showConfirmDialog(null, myPanel,
				"Please enter the following information for the new link", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			nameString = name.getText();
			websiteLinkString = websiteLink.getText();
			usernameString = username.getText();
			passwordString = password.getText();

		
//			creates a quicklink to add to linkmanager, then adds the button that was
//			input by the user if the button doesn't already exist and refreshes the screen
			if(!NewQuickLink.createNewQuickLink(usernameString, passwordString, websiteLinkString, nameString, websites)){
				addButton(f, nameString);
				f.validate();
			}			
		}
	}
}