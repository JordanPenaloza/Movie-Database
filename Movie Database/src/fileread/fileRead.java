package fileread;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class fileRead {
	// Fields
	private ArrayList<String> lines;
	
	// Constructor
	public fileRead(String filename){
		lines = new ArrayList<>();
		try { BufferedReader buffread = new BufferedReader(new FileReader(filename));
		String readLine;
		while((readLine = buffread.readLine()) != null) {
			lines.add(readLine);
			
		}
		buffread.close();
		}
		catch(IOException error) {
			error.printStackTrace();
		}
	}
	
	// Methods
	public int getNumberOfLines(){
		int numLines = lines.size();
		return numLines;
	
	}
	
	public String getLine(int index){
		String line = lines.get(index);
		return line;
		
	}
}
