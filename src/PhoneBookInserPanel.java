import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class PhoneBookInserPanel
        extends JPanel implements ActionListener {

    private PhoneBook phoneBook;
    private JTextField pbInsertName;
    private JTextField pbInsertSupplement;
    private JTextField pbInsertTelNr;
    private JButton buttonInsert;

    public PhoneBookInserPanel(PhoneBook pb) {
    	phoneBook = pb;
        
		JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3, 1));
		panel1.add(new JLabel("Name"));
		panel1.add(new JLabel("Supplement"));
		panel1.add(new JLabel("TelephoneNr"));
		
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3, 1)); 
        pbInsertName = new JTextField("", 20);
        panel2.add(pbInsertName);
        pbInsertSupplement = new JTextField("", 20);
        panel2.add(pbInsertSupplement);
        pbInsertTelNr = new JTextField("", 20);
        panel2.add(pbInsertTelNr);

        Border border = BorderFactory.createTitledBorder("Insert");
        this.setBorder(border);
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.add(panel1);
        this.add(panel2);
        buttonInsert = new JButton("Insert");
        this.add(buttonInsert);
        buttonInsert.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        // ...
    }
}