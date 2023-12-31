package movie;

public class Movie {
	// Fields
	private String title;
	private String actor1;
	private String actor2;
	private String director;
	private int year;
	private int runtimeMinutes;
	
	// Constructor
	public Movie(String title, String actor1, String actor2, String director, int year, int runtimeMinutes){
		this.title = title;
		this.actor1 = actor1;
		this.actor2 = actor2;
		this.director = director;
		this.year = year;
		this.runtimeMinutes = runtimeMinutes;
		
	}
	
	// Methods
	public String getTitle(){
		return title;
		
	}
	
	public String getActor1(){
		return actor1;
		
	}
	
	public String getActor2(){
		return actor2;
		
	}
	
	public String getDirector(){
		return director;
		
	}
	
	public int getYear(){
		return year;
		
	}
	
	public int getRuntime(){
		return runtimeMinutes;
		
	}
	

	}

