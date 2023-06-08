import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PhoneBook extends JFrame implements ActionListener{

	public static void main(String[]args) {
		new PhoneBook();
	}
	public PhoneBook(){
		URL iconURL = getClass().getResource("/icon.png");
		ImageIcon icon = new ImageIcon(iconURL);
		setIconImage(icon.getImage());
		JLabel contentpane=new JLabel();
		contentpane.setIcon(icon);
		contentpane.add(new JButton("hola"));
		add(contentpane);
		pack();
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
