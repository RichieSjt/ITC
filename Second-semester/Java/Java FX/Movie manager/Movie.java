import java.io.Serializable;

public class Movie implements Serializable{
	private String title, director, duration, year, classification;
	
	public Movie() {
		title = "";
		director = "";
		duration = "";
		year = "";
		classification = "";
	}
	
	public String toString() {
		return title + " (" + year + ")";
	}
	
	public boolean equals(Object obj) {
		System.out.println("Comparing " + this + " with " + obj);
		if (!(obj instanceof Movie))
			return false;
		Movie m = (Movie)obj;
		return m != null && m.title.equals(this.title);
	}
	
	public void setTitle(String title) throws EmptyFieldException{
		if (title == null || title.length() == 0)
			throw new EmptyFieldException ("The title cannot be null");
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setDirector(String director) throws EmptyFieldException{
		if (director == null || director.length() == 0)
			throw new EmptyFieldException ("The director cannot be null");
		this.director = director;
	}
	
	public String getDirector() {
		return director;
	}
	
	public void setDuration(String duration) throws EmptyFieldException{
		if (duration == null || duration.length() == 0)
			throw new EmptyFieldException ("The duration cannot be null");
		this.duration = duration;
	}
	
	public String getDuration() {
		return duration;
	}
	
	public void setYear(String year) throws EmptyFieldException{
		if (year == null || year.length() == 0)
			throw new EmptyFieldException ("The year cannot be null");
		this.year = year;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setClassification(String classification) throws EmptyFieldException{
		if (classification == null || classification.length() == 0)
			throw new EmptyFieldException ("The title cannot be null");
		this.classification = classification;
	}
	
	public String getClassification() {
		return classification;
	}
}