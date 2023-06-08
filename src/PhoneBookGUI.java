import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PhoneBookGUI extends JFrame implements ActionListener{

	public static void main(String[]args) {
//		PhoneBook phoneBook=new PhoneBook();
//		phoneBook.insert("luk","2","124");
		new PhoneBookGUI();
	}
	public PhoneBookGUI(){
		URL iconURL = getClass().getResource("/icon.png");
		ImageIcon icon = new ImageIcon(iconURL);
		setIconImage(icon.getImage());
		JLabel contentpane=new JLabel();
		contentpane.setIcon(icon);
		add(contentpane);

		JButton hola=new JButton("hola");
		hola.addActionListener((ActionEvent e)->{System.out.println("hi ho");});
		getContentPane().add(new JLabel("heohetiuehtIsabtigb"));
		getContentPane().add(hola);
		setLayout(new BoxLayout(getContentPane(), 1));
		pack();
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}