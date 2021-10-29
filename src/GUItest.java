import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.junit.Test;

public class GUItest {
	@Test
	void buttonPressed() {
		GUI gui = new GUI();
		JFrame f = new JFrame();
		gui.visuals(f);
		JButton test = new JButton("test");
		if((test.getModel()).isPressed()) {
	        System.out.println("the button is pressed");
		}
		fail("Not implemented yet");
	}
	

}
