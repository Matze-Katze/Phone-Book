import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AttributeSet.ColorAttribute;

import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class PhoneBookMenuBar extends JMenuBar implements ActionListener {

    private PhoneBook phoneBook;
    private JMenu menu = new JMenu("File");
    private JMenuItem menuItemSave = new JMenuItem(" Save...   ");
    private JMenuItem menuItemLoad = new JMenuItem(" Load...   ");
    
    public PhoneBookMenuBar(PhoneBook pb) {
        phoneBook = pb;
//        phoneBook.insert("leon", "32", "1234536");
        menuItemSave.addActionListener((ActionEvent e)->{
        	 FileDialog chooser = new FileDialog(new Frame(), "choose the desired path to save to", FileDialog.SAVE);
             chooser.setVisible(true);
             String filename = chooser.getFile();
             if(filename != null)
            	 if(filename.contains(".txt"))
            		 phoneBook.save(new File(chooser.getDirectory()+filename));
            	 else
            		 phoneBook.save(new File(chooser.getDirectory()+filename+".txt"));
        });
        menuItemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.VK_CONTROL));
        
        menuItemLoad.addActionListener(this);
       
        add(menu);
        menu.add(menuItemSave);
        menu.add(menuItemLoad);
        menu.addActionListener(this);
        setOpaque(true);
//        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(200, 20));
        setToolTipText("the Person reading this is Dumb");
        add(new JMenu("menu"));
    }

    public void actionPerformed(ActionEvent e) {
        Component source=(Component) e.getSource();
        if(source==menu)
        	System.out.println("menu got clicked");
        System.out.println("something clicked");
        if(source==menuItemLoad) {
        	JFileChooser open = new JFileChooser();
        	FileNameExtensionFilter filter = new FileNameExtensionFilter("txt");
        	open.setFileFilter(filter);
        }
    }
}