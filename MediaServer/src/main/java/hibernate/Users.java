package hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity(name="users")
@Table(name="users")
public class Users implements Serializable {
 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Profiles> profiles = new ArrayList<Profiles>();

	
	
	public Users(int id, String username, String password, List<Profiles> profiles) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.profiles = profiles;
	}

	public Users(String userName, String password) {
		this.username = userName;
		this.password = password;
	}

	public Users() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Profiles> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<Profiles> profiles) {
		this.profiles = profiles;
	}
}
