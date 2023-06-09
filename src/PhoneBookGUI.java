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
		
		// Menuleiste einbauen:
        // ...
		
		// Einfuegen- und  SuchenLoeschenPanel einbauen:
		JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        // ...
        
        setContentPane(mainPanel);
		pictureLabel.setIcon(icon);
		mainPanel.add(pictureLabel);
        
		setLayout(new BoxLayout(mainPanel, 1));
		setTitle("PhoneBook");
		setIconImage(icon.getImage());
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);

        // mainPanel mit Umrandung versehen und das
        
        
		new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		};
	}
}
