import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AttributeSet.ColorAttribute;

import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class PhoneBookMenuBar extends JMenuBar implements ActionListener {

    private PhoneBook phoneBook;
    private JMenu menu = new JMenu("File");
    private JMenuItem menuItemSave = new JMenuItem("Save PhoneBook...   ");
    private JMenuItem menuItemLoad = new JMenuItem("Load PhoneBook...   ");
    private JMenuItem menuItemQuit = new JMenuItem("Quit PhoneBook");
    
    public PhoneBookMenuBar(PhoneBook pb) {
        phoneBook = pb;
        menuItemSave.addActionListener(this);
        menuItemLoad.addActionListener(this);
        menuItemQuit.addActionListener(this);
        menuItemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        menuItemLoad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        menuItemQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
       
        add(menu);
        menu.add(menuItemSave);
        menu.add(menuItemLoad);
        menu.addSeparator();
        menu.add(menuItemQuit);
        menu.addActionListener(this);
        setOpaque(true);
//        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(200, 20));
        setToolTipText("the Person reading this is Dumb");
        add(new JMenu("menu"));
    }

    public void actionPerformed(ActionEvent e) {
        Component source=(Component) e.getSource();
        if(source==menuItemLoad) {
        	JFileChooser chooser = new JFileChooser();
        	FileNameExtensionFilter filter = new FileNameExtensionFilter("txt files","txt");
        	File workingDirectory = new File(System.getProperty("user.dir"));
        	chooser.setCurrentDirectory(workingDirectory);
        	chooser.setFileFilter(filter);
            if(chooser.showOpenDialog(PhoneBookGUI.getPhoneBookGUI())==JFileChooser.APPROVE_OPTION)
            	phoneBook.read(chooser.getSelectedFile());
            PhoneBookGUI.getPhoneBookGUI().getPhoneBookSearchDeletePanel().updateOutput();
        }
        if(source==menuItemSave) {
        	JFileChooser chooser = new JFileChooser();
        	FileNameExtensionFilter filter = new FileNameExtensionFilter("txt files","txt");
        	File workingDirectory = new File(System.getProperty("user.dir"));
        	chooser.setCurrentDirectory(workingDirectory);
        	chooser.setFileFilter(filter);
            if(chooser.showSaveDialog(PhoneBookGUI.getPhoneBookGUI())==JFileChooser.APPROVE_OPTION) {
            	String chosenFileName=chooser.getSelectedFile().getName();
            	if(chosenFileName.contains(".txt"))
            		phoneBook.save(chooser.getSelectedFile());
            	else
            		phoneBook.save(new File(chosenFileName+".txt"));
            }
        }
        if(source==menuItemQuit) {
        	PhoneBookGUI.getPhoneBookGUI().dispatchEvent(new WindowEvent(PhoneBookGUI.getPhoneBookGUI(), WindowEvent.WINDOW_CLOSING));
        }
    }
}