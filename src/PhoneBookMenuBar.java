import javax.swing.*;
import javax.swing.border.EmptyBorder;
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
    }

    public void actionPerformed(ActionEvent e) {
        Component source=(Component) e.getSource();
        if(source==menuItemLoad) {
        	JFileChooser chooser = new JFileChooser();
        	FileNameExtensionFilter filter = new FileNameExtensionFilter("txt files","txt");
        	File workingDirectory = new File(System.getProperty("user.dir"));
        	chooser.setCurrentDirectory(workingDirectory);
        	chooser.setFileFilter(filter);
            if(chooser.showOpenDialog(PhoneBookGUI.getInstance())==JFileChooser.APPROVE_OPTION)
            	phoneBook.read(chooser.getSelectedFile());
            PhoneBookGUI.getInstance().updateOutput();
        }
        if(source==menuItemSave) {
        	JFileChooser chooser = new JFileChooser();
        	FileNameExtensionFilter filter = new FileNameExtensionFilter("txt files","txt");
        	File workingDirectory = new File(System.getProperty("user.dir"));
        	chooser.setCurrentDirectory(workingDirectory);
        	chooser.setFileFilter(filter);
            if(chooser.showSaveDialog(PhoneBookGUI.getInstance())==JFileChooser.APPROVE_OPTION) {
            	String chosenFileName=chooser.getSelectedFile().getName();
            	if(chosenFileName.contains(".txt"))
            		phoneBook.save(chooser.getSelectedFile());
            	else
            		phoneBook.save(new File(chosenFileName+".txt"));
            }
        }
        if(source==menuItemQuit) {
        	JDialog quitDialog=new JDialog(PhoneBookGUI.getInstance(),"Quit for Sure?",true);
        	JPanel panel=new JPanel();
        	JButton yesButton=new JButton("yes");
        	JButton noButton=new JButton("no");
        	yesButton.addActionListener(event->
        		PhoneBookGUI.getInstance().dispatchEvent(new WindowEvent(quitDialog, WindowEvent.WINDOW_CLOSING))
        		);
        	noButton.addActionListener(event->
        		quitDialog.dispatchEvent(new WindowEvent(quitDialog, WindowEvent.WINDOW_CLOSING))
        			);
        	panel.add(noButton);
        	panel.add(yesButton);
        	panel.setLayout(new GridLayout(1,2,20,20));
        	panel.setBorder(new EmptyBorder(10,10,10,10));
        	quitDialog.add(panel);
        	quitDialog.setLocationRelativeTo(PhoneBookGUI.getInstance());
        	quitDialog.pack();
        	quitDialog.setVisible(true);
        }
    }
}