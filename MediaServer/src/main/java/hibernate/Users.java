package hibernate;

import java.io.Serializable;

import javax.persistence.*;

@Entity(name="users")
@Table(name="users")
public class Users implements Serializable {
 

	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="password")
	private String password;

	public Users(int id,String userName, String password) {
		this.id = id;
		this.userName = userName;
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
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	
	
}
