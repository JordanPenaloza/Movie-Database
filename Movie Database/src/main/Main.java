package main;
import database.Database;
import fileread.fileRead;
import filewrite.fileWrite;
import keyboardinput.keyboardInput;
import movie.Movie;

import java.util.ArrayList;



import commands.Commands;

public class Main {


	public static void main(String[] args) {
		System.out.println("Jordan Penaloza's Movie Database");
		fileRead fr = new fileRead("db.txt");
		ArrayList<String> lines = new ArrayList<String>();
		for (int i = 0; i < fr.getNumberOfLines(); i++){
			  String line = fr.getLine(i);
			  lines.add(line);
		}
				Commands ins = new Commands();
				ins.commands();
			  keyboardInput kb = new keyboardInput();
		        fileWrite fw = new fileWrite("db.txt");
		        
				
				for(String fileWrite : lines) {
		        	fw.writeLine(fileWrite);
		        }
				Database db = new Database("db.txt");
				String command = "";
				while (!command.equals("quit")) {
					System.out.println("");					
					command = kb.getKeyboardLine("Enter Command: ");
					switch(command) {
	                case"new entry":
	                    String title = kb.getKeyboardLine("Enter title: ");
	                    if(title.length() >= 3) {
	                    int year = Integer.parseInt(kb.getKeyboardLine("Enter year: "));	                    String dir = kb.getKeyboardLine("Enter director: ");
	                    String act1 = kb.getKeyboardLine("Enter actor 1: ");
	                    String act2 = kb.getKeyboardLine("Enter actor 2: ");

	                    int runtime = Integer.parseInt(kb.getKeyboardLine("Enter runtime in minutes: "));

	                    fw.writeLine(title + "*" + year + "*" + dir + "*" + act1 + "*" + act2 + "*" + runtime);
	                    Movie mov = new Movie(title, act2, dir, act1, year, runtime);
	                    db.addEntry(mov);
	                    }
	                    break; 
	                case"total lines":
	                	System.out.println(fr.getNumberOfLines() + " total lines in file");
	                	break;          
	                case"search by year":
	                	int searchYear = Integer.parseInt(kb.getKeyboardLine("Enter year: "));
	                	db.searchByYear(searchYear);
	                	break;
	                case"search by actor":
	                	String searchActor = kb.getKeyboardLine("Enter actor: ");
	                	db.searchByActor(searchActor);
	                	break;               	
	                case"search by runtime":
	                	int searchRun = Integer.parseInt(kb.getKeyboardLine("Enter runtime (in minutes): "));
	                	db.searchByRuntime(searchRun);
	                	break;               
	                case"search by director":
	                	String searchDir = kb.getKeyboardLine("Enter director: ");
	                	db.searchByDirector(searchDir);
	                	break;
	                	
	                case"search by title":
	                	String searchTitle = kb.getKeyboardLine("Enter title: ");
	                	db.searchByTitle(searchTitle);
	                	break;
	            }       
	        }
	        fw.saveFile();
	        kb.closeKeyboard();
	    }
		
	}