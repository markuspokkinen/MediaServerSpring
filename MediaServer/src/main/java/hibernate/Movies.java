package hibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Movies")
public class Movies implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieId;
	
	@Column(name="moviename")
	private String moviename;
	
	@Column(name="description")
	private String description;

	public Movies(int movieId, String movieName, String description) {
		this.movieId = movieId;
		this.moviename = movieName;
		this.description = description;
	}

	public Movies(String moviename, String description) {
		this.moviename = moviename;
		this.description = description;
	}

	public Movies() {

	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return moviename;
	}

	public void setMovieName(String movieName) {
		moviename = movieName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Movies [movieId=" + movieId + ", moviename=" + moviename + ", description=" + description + "]";
	}
	
	
	
}
