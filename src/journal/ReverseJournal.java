package journal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author keith
 *
 */
public class ReverseJournal {
	
	File journal;
	
	public ReverseJournal(String fp) {
		journal = new File(fp);
	}
	
    /**
     *
     * @throws FileNotFoundException
     */
    void addEntry(String entry, boolean encrypt) throws FileNotFoundException {
 		try {
 			FileWriter fw = new FileWriter(journal, true);
	    	PrintWriter out = new PrintWriter(fw);
	    	if (encrypt) {
	    		out.print(encrypt("*encrypted*\n") + encrypt(new Date().toString() + "\n") + entry + encrypt("-----------------------------\n"));
	    	} else {
	    		out.print(new Date().toString() + "\n" + entry + "-----------------------------\n");
	    	}
	    	out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    /**
     *
     * @throws FileNotFoundException
     */
    String readEntry() throws FileNotFoundException {
    	Scanner in = new Scanner(journal);
    	String out = "";
    	boolean decrypt = false;
    	while (in.hasNextLine()) {
    		String line = in.nextLine();
    		if (line.equals(encrypt("*encrypted*"))) {
    			decrypt = true;
    			continue;
    		} else if (line.equals("-----------------------------")) {
    			decrypt = false;
    		}
    		if (decrypt) {
    			out += decrypt(line);
    		} else {
    			out += line + "\n";
    		}
    	}
    	in.close();
    	return out;
   	}

    /**
     *
     * @param in
     */
    String encrypt(String in) {
    	StringBuilder s = new StringBuilder(in);
    	s.reverse();
    	
    	return s.toString();
    }

    /**
     *
     * @param in
     * @return
     */
    String decrypt(String in) { 
    	String[] lines = in.split("\n");
    	String out = "";
    	
    	for (int i = 0; i < lines.length; i++) {
    		StringBuilder s = new StringBuilder(lines[i]);
    		s.reverse();
    		out += s.toString() + "\n";
    	}
    	
    	return out;
    }

	void delete() {
		journal.delete();
	}

}


