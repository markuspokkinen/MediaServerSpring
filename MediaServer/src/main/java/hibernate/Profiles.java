package hibernate;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="Profiles")
@Table(name = "Profiles")
public class Profiles implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int profileID;

	@Column(name = "profileName")
	private String profileName;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "movieFav")
	private List<Movies> MovieFav;

	public Profiles(String profileName) {
		this.profileName = profileName;
	}

	public Profiles() {

	}

	public int getProfileID() {
		return profileID;
	}

	public void setProfileID(int profileID) {
		this.profileID = profileID;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public List<Movies> getMovieFav() {
		return MovieFav;
	}

	public void setMovieFav(List<Movies> movieFav) {
		MovieFav = movieFav;
	}

}
