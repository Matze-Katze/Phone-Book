import javax.swing.*;
import java.io.*;
import java.awt.event.*;

public class PhoneBookMenuBar
        extends JMenuBar implements ActionListener {

    private PhoneBook phoneBook;

    public PhoneBookMenuBar(PhoneBook pb) {
        phoneBook = pb;
    }

    public void actionPerformed(ActionEvent e) {
        // ...
    }
}