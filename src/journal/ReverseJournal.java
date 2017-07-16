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
    void addEntry(String entry) throws FileNotFoundException {
 		try {
 			FileWriter fw = new FileWriter(journal, true);
	    	PrintWriter out = new PrintWriter(fw);
	    	out.print(encrypt(new Date().toString() + "\n") + entry + encrypt("-----------------------------\n"));
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
    	while (in.hasNextLine()) {
    		out += in.nextLine() + "\n";
    	}
    	in.close();
    	return decrypt(out);
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


