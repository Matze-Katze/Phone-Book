import java.awt.event.*;
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
	public static void main(String[]args) {
		phoneBookGUI=new PhoneBookGUI();
	}
	private PhoneBookGUI(){
		phoneBook=new PhoneBook();
		
//		URL iconURL = getClass().getResource("/icon.png");
		ImageIcon icon = new ImageIcon("icon.png");
		JLabel pictureLabel=new JLabel();
		JPanel mainPanel = new JPanel();
		PhoneBookMenuBar phoneBookMenuBar=new PhoneBookMenuBar(phoneBook);
		PhoneBookInserPanel phoneBookInserPanel=new PhoneBookInserPanel(phoneBook);
		PhoneBookSearchDeletePanel phoneBookSearchDeletePanel=new PhoneBookSearchDeletePanel(phoneBook);

        setContentPane(mainPanel);
        
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
		pictureLabel.setIcon(icon);
		
		setJMenuBar(phoneBookMenuBar);
		add(phoneBookInserPanel);
		add(phoneBookSearchDeletePanel);
		add(pictureLabel);

        
		setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		setTitle("PhoneBook");
		setIconImage(icon.getImage());
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);

		new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		};
	}
	public static PhoneBookGUI getPhoneBookGui() {
		if(phoneBookGUI!=null)
			return phoneBookGUI;
		else return phoneBookGUI=new PhoneBookGUI();
	}
}
