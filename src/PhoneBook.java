import java.io.*;
import java.io.PrintWriter;
import java.util.*;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhoneBook {
	NavigableMap<String,String> phoneBookMap = new TreeMap<>();
	
	boolean insert(String name, String prefix, String telNr) {
		String uName=getUniqueName(name,prefix);
		if(phoneBookMap.containsKey(uName)||name==null||prefix==null||telNr==null)
			return false;
		phoneBookMap.put(uName,telNr);
		return true;
	}
	
	boolean remove(String name, String prefix) {
		String uName=getUniqueName(name,prefix);
		if(!phoneBookMap.containsKey(uName))
			return false;
		phoneBookMap.remove(uName);
		return true;
	}
	
	String exactSearch(String name, String prefix) {
		String uName=getUniqueName(name,prefix);
		return phoneBookMap.get(uName);
	}
	
	List<String> prefixSearch(String str){
		List<String> result=new LinkedList<>();
		if(str.length()==0) {
			for(var x:phoneBookMap.entrySet())
				result.add(x.getKey()+" "+x.getValue());
			return result;
		}	
		char lastChar=str.charAt(str.length()-1);
		lastChar++;
		StringBuilder sb=new StringBuilder(str);
		sb.setCharAt(sb.length()-1, lastChar);
		for(var x:phoneBookMap.subMap(str, sb.toString()).entrySet())
			result.add(x.getKey()+" "+x.getValue());
		return result;
	}
	public void read(File f) {
        LineNumberReader in = null;
        try {
            phoneBookMap.clear();
            in = new LineNumberReader(new FileReader(f));
            String line;
            while ((line = in.readLine()) != null) {
                String[] sf = line.split(" ");
                if (sf.length == 2) {
                    insert(sf[0], "", sf[1]); // empty Prefix
                } else if (sf.length == 3) {
                    insert(sf[0], sf[1], sf[2]);
                }
            }
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(PhoneBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void save(File f) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(f);
            for (Entry<String, String> eintrag : phoneBookMap.entrySet()) {
                String s = eintrag.getKey().replace('#', ' ') + " " + eintrag.getValue();
                out.println(s);
            }
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(PhoneBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void print(List<String> strList) {
        for (String s : strList)
            System.out.println(s);
    }

    public static void main(String[] args)
        throws FileNotFoundException, IOException {
        
    	PhoneBook phoneBook = new PhoneBook();
        phoneBook.read(new File("PhoneBookWith420Names.txt"));

        System.out.println(phoneBook.exactSearch("Oliver",""));
        System.out.println();

        print(phoneBook.prefixSearch("H"));
        System.out.println();
        
        print(phoneBook.prefixSearch(""));
        System.out.println();

        phoneBook.insert("Oliver","1","33245");
        phoneBook.insert("Oliver","2","23423");
        phoneBook.insert("Oliver","3","87655");
        phoneBook.remove("Oliver","2");

        print(phoneBook.prefixSearch("Ol"));
        System.out.println();
       
        phoneBook.save(new File("test.txt"));
    }
	String getUniqueName(String name, String zusatz) {
		return name+" "+zusatz;
	}
}