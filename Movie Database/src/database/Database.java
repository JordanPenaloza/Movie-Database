package database;
import java.util.ArrayList;
import java.util.StringTokenizer;

import fileread.fileRead;
import movie.Movie;

public class Database {
	// Fields
	private ArrayList<Movie> movies;
	
	// Constructor
	public Database(String filename){
		movies = new ArrayList<>();
		fileRead fr = new fileRead(filename);
		for(int i = 0; i < fr.getNumberOfLines(); i++){
			String raw = fr.getLine(i);

			StringTokenizer st = new StringTokenizer(raw, "*");
			do {
				String title = st.nextToken();
				int year = Integer.parseInt(st.nextToken());
				String director = st.nextToken();
				String actor1 = st.nextToken();				
				String actor2 = st.nextToken();				
				int runtime = Integer.parseInt(st.nextToken());
				Movie m = new Movie(title, actor1, actor2, director, year, runtime);
				movies.add(m);
				
				
			}
			while(st.hasMoreTokens());
			
			
		}
	}
	
	// Methods
	public void addEntry(Movie newEntry){
		movies.add(newEntry);
	
	}
	
	public void searchByTitle(String title){
		boolean found = false;
		for (Movie movie : movies) {
			if (title.equals(movie.getTitle())) {				
				System.out.println("Actors: " + movie.getActor1() + ", " + movie.getActor2());
				System.out.println("Year: " + movie.getYear());
				System.out.println("Director: " + movie.getDirector());				
				System.out.println("Runtime: " + movie.getRuntime());
				found = true;
			}
			 
			 }
		if (!found ) {
			 System.out.println("Title not found... try again. ");
			
			
		}
		
	}
	
	public void searchByActor(String actor){
		boolean found = false;
		for(Movie movie : movies) {
			if (actor.equals(movie.getActor1()) || actor.equals(movie.getActor2())) {
				System.out.println("Actor has been in the movie(s): " + movie.getTitle());
				found = true;
		}
	}
		if (!found) {
		System.out.println("Actor not found in any movie... try again ");
			
			
		}
		
	}
	
	public void searchByDirector(String director){
		boolean found = false;
		for(Movie movie : movies) {
			if(director.equals(movie.getDirector())) {
				System.out.println("Movie titles this director has been in: " + movie.getDirector());
				found = true;
			}
		}
		if(found == false) {
		System.out.println("No movies with this director found... try again ");
		}
	}
public void searchByYear(int year){
	boolean found = false;
	for(Movie movie : movies) {
		if(year == movie.getYear()) {
			System.out.println("Movie titles released this year are: " + movie.getTitle());
			found = true;
		}
	}
	if(found == false) {
	System.out.println("No movies released in that year... try again ");
	}
}
	
	public void searchByRuntime(int runtime){
		boolean found = false;
		for(Movie movie : movies) {
			if(runtime == movie.getRuntime()) {
				System.out.println("Movie titles with this runtime are: " + movie.getTitle());
				found = true;
			}
		}
		if(found == false) {
		System.out.println("No movies with this runtime found... try again ");
		}
	}
}
