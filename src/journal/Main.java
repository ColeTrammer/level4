package journal;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	static ReverseJournal journal;
	static Scanner kb;
	static boolean encrypt;
	
	public static void main(String[] args) {
		if (args.length > 0) {
			journal = new ReverseJournal(args[0]);
			
			encrypt = false;
			if (args.length > 1 && args[1].equals("-encrypt")) {
				encrypt = true;
			}
			
			System.out.println("Type exit to exit and read to read and write to write and delete to delete and overwrite to make a overwrite entry.");
			
			kb = new Scanner(System.in);
			
			String next = kb.nextLine();
			while (!next.equals("exit")) {
				if (next.equals("write")) {
					newEntry();
				}
				if (next.equals("overwrite")) {
					deleteEntry();
					journal = new ReverseJournal(".journal.txt");
					newEntry();
				}
				if (next.equals("read")) {
					readEntry();
				}
				if (next.equals("delete")) {
					deleteEntry();
				}
				next = kb.nextLine();
			}
			
			kb.close();
		}
	}
	
	static void newEntry() {
		String next = kb.nextLine();
		String input = "";
		while (!next.equals(":wq")) {
			if (encrypt)
				input += journal.encrypt(next + "\n"); 
			else
				input += next + "\n";
			next = kb.nextLine();
		}
		try {
			journal.addEntry(input, encrypt);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	static void deleteEntry() {
		journal.delete();
	}
	
	static void readEntry() {
		try {
			System.out.print(journal.readEntry());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
