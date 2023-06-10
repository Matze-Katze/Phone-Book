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
	public static void main(String[]args) {
		new PhoneBookGUI();
	}
	public PhoneBookGUI(){
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
}
