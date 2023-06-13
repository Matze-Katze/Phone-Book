import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class PhoneBookInserPanel
        extends JPanel implements ActionListener {

    private PhoneBook phoneBook;
    private JTextField pbInsertName;
    private JTextField pbInsertPrefix;
    private JTextField pbInsertTelNr;
    private JButton buttonInsert;

    public PhoneBookInserPanel(PhoneBook pb) {
    	phoneBook = pb;
        
		JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3, 1));
		panel1.add(new JLabel("Name"));
		panel1.add(new JLabel("Prefix"));
		panel1.add(new JLabel("TelephoneNr"));
		
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3, 1)); 
        pbInsertName = new JTextField("", 20);
        panel2.add(pbInsertName);
        pbInsertPrefix = new JTextField("", 20);
        panel2.add(pbInsertPrefix);
        pbInsertTelNr = new JTextField("", 20);
        panel2.add(pbInsertTelNr);

        this.setBorder(BorderFactory.createTitledBorder("Insert"));
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.add(panel1);
        this.add(panel2);
        buttonInsert = new JButton("Insert");
        this.add(buttonInsert);
        buttonInsert.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
    	if(pbInsertName.getText().equals("")||pbInsertName.getText().contains(" ")) {
    		pbInsertName.setText("Not a valid Name");
    		return;
    	}
    	try{
    		Double.parseDouble(pbInsertTelNr.getText());
    	}
    	catch(Exception ex) {
    		pbInsertTelNr.setText("Not  a valid TelNumber");
    		return;
    	}
        if(!phoneBook.insert(pbInsertName.getText(), pbInsertPrefix.getText(), pbInsertTelNr.getText()))
        	pbInsertName.setText("name: \""+pbInsertName.getText()+"\" already exists");
        else PhoneBookGUI.getPhoneBookGUI().getPhoneBookSearchDeletePanel().updateOutput();
    }
}