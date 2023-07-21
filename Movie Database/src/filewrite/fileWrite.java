/* READ THIS!: The idea behind this class is that we save the "writeBuffer" in memory but do not actually write the file to disk until someone calls the 
 * "saveFile" method. The reason for this is for performance and to prevent keeping an open file pointer (which is poor form and risky) */

package filewrite;

import java.util.ArrayList;
import java.io.*;

public class fileWrite {
	// Fields
	private ArrayList<String> writeBuffer;
	private String filename;
	
	// Constructor
	public fileWrite(String filename){
		this.filename = filename;			// Save filename for later
		writeBuffer = new ArrayList<>();
	}
	
	//Methods
	public void writeLine(String newLine){
		writeBuffer.add(newLine);
		
		
	}
	
	public void saveFile(){
		try {
			FileWriter fw = new FileWriter(filename);
			BufferedWriter bw = new BufferedWriter(fw);
			for ( String f: writeBuffer) {
				bw.write(f);
				bw.write('\n');
			}
			bw.close();
		} catch (IOException e) {
			System.out.println("No File Found");
		}
		
		
		
	}
}
