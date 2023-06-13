import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.text.JTextComponent;

import java.util.List;

public class PhoneBookSearchDeletePanel
        extends JPanel implements ActionListener {

	private PhoneBook phoneBook;
    private JTextField nameSearch;
    private JTextField prefixSearch;
    private JButton buttonDelete;
    private JComboBox comboBox;
    private JTextArea outputText;
    private JScrollPane scrollPane;
    public static final int EXACT_SEARCH=0,PREFIX_SEARCH=1,DELETE=2;


    public PhoneBookSearchDeletePanel(PhoneBook pb) {
    	phoneBook = pb;
    	JPanel searchPanel=new JPanel();
		JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2, 1));
		panel1.add(new JLabel("Name"));
		panel1.add(new JLabel("Prefix"));
		
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(2, 1)); 
        nameSearch = new JTextField("", 20);
        nameSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) { updateOutput(); }
		});
        panel2.add(nameSearch);
        prefixSearch = new JTextField("", 20);
        prefixSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) { updateOutput(); }
		});
        panel2.add(prefixSearch);


        searchPanel.setBorder(BorderFactory.createTitledBorder("Search/Delete"));
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.LINE_AXIS));
        searchPanel.add(panel1);
        searchPanel.add(panel2);
        String[] comboString= {"Exact Search","Prefix-Search","Delete"};
        comboBox=new JComboBox(comboString);
        comboBox.addActionListener((ActionEvent e)->updateOutput());
        searchPanel.add(comboBox);
        buttonDelete = new JButton("Delete");
        searchPanel.add(buttonDelete);
        buttonDelete.addActionListener(this);
//        buttonDelete.setEnabled(false);
        
        JPanel outputPanel=new JPanel();
        outputText=new JTextArea("",30,60);
        outputText.setEditable(false);
        scrollPane=new JScrollPane(outputText);
        outputPanel.setBorder(BorderFactory.createTitledBorder("Output"));
        outputPanel.add(scrollPane);
        add(searchPanel);
        add(outputPanel);
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        comboBox.setSelectedIndex(PREFIX_SEARCH);
    }
    public void updateOutput() {
    	outputText.setText("");
        buttonDelete.setEnabled(false);
    	switch(comboBox.getSelectedIndex()) {
    	
	    	case PREFIX_SEARCH: 
	    		if(prefixSearch.getText().length()==0)
			    	for(String s:phoneBook.prefixSearch(nameSearch.getText()))
			    		outputText.append(s+'\n');
	    		else for(String s:phoneBook.prefixSearch(nameSearch.getText()+" "+prefixSearch.getText()))
		    		outputText.append(s+'\n');
	    		outputText.setForeground(Color.BLACK);
	    	break;
	    	
	    	case EXACT_SEARCH:
	    		outputText.append(phoneBook.exactSearch( nameSearch.getText(), prefixSearch.getText() ));
	    		outputText.setForeground(Color.BLACK);
    		break;
    		
	    	case DELETE:
	            buttonDelete.setEnabled(true);
	    		if(phoneBook.exactSearch( nameSearch.getText(), prefixSearch.getText() )!=null)
	    			outputText.append("Deletion of:"+nameSearch.getText()+" "+prefixSearch.getText()
	    			+" "+phoneBook.exactSearch( nameSearch.getText(), prefixSearch.getText() ));
	    		outputText.setForeground(Color.RED);
    	}	
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonDelete&&comboBox.getSelectedIndex()==DELETE) {
        	if(phoneBook.remove(nameSearch.getText(), prefixSearch.getText()))
        		outputText.setText("Deletion of: " + nameSearch.getText() + " " + prefixSearch.getText() + " SUCCESSFULL!");
        }
    }
}