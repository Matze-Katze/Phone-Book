import java.awt.event.*;
import java.io.File;
import java.net.URL;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.EventListenerList;

public class PhoneBookGUI extends JFrame{
	private PhoneBook phoneBook;
	private static PhoneBookGUI phoneBookGUI=null;
	PhoneBookMenuBar phoneBookMenuBar;
	PhoneBookInserPanel phoneBookInserPanel;
	PhoneBookSearchDeletePanel phoneBookSearchDeletePanel;
	public static void main(String[]args) {
		phoneBookGUI=new PhoneBookGUI();
//		phoneBookGUI.phoneBook.read(new File("PhoneBookWith420Names.txt"));
//		phoneBookGUI.updateOutput();
	}
	private PhoneBookGUI(){
		phoneBook=new PhoneBook();
		
		ImageIcon icon = new ImageIcon("icon.png");
//		JLabel pictureLabel=new JLabel();
//		pictureLabel.setIcon(icon);
//		add(pictureLabel);

		JPanel mainPanel = new JPanel();
		phoneBookMenuBar=new PhoneBookMenuBar(phoneBook);
		phoneBookInserPanel=new PhoneBookInserPanel(phoneBook);
		phoneBookSearchDeletePanel=new PhoneBookSearchDeletePanel(phoneBook);

        setContentPane(mainPanel);
        
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
		
		setJMenuBar(phoneBookMenuBar);
		add(phoneBookInserPanel);
		add(phoneBookSearchDeletePanel);

        
		setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		setTitle("PhoneBook");
		setIconImage(icon.getImage());
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);

	}
	public void updateOutput() {
		phoneBookGUI.phoneBookSearchDeletePanel.updateOutput();
	}
	public static PhoneBookGUI getPhoneBookGUI() {
		if(phoneBookGUI!=null)
			return phoneBookGUI;
		else return phoneBookGUI=new PhoneBookGUI();
	}
}
