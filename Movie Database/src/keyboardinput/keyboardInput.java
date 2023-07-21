package keyboardinput;

import java.util.Scanner;

public class keyboardInput {
	// Fields
	private Scanner kb;
	
	// Constructor
	public keyboardInput(){
		kb = new Scanner(System.in);
	}
	
	// Methods
	public String getKeyboardLine(String string) {
		System.out.println(string);
		String kbLine = kb.nextLine();
		return kbLine;
	}
		
		
		
	
	
	/* Call this method before you exit the program! Do NOT close the scanner object inside of getKeyboardLine method! */
	public void closeKeyboard(){
		kb.close();
	}


}
