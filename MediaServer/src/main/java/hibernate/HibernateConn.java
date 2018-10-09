package hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import hibernate.Users;

public class HibernateConn {

	private EntityManager openConnectionToDataBase() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MediaServer");
		System.out.println("EMF kehitetty");
		EntityManager em = emf.createEntityManager();

		return em;
	}

	public Users findUser(String user) {
		EntityManager em = openConnectionToDataBase();
		List<Users> listUsers = null;
		Users resUser = null;
		em.getTransaction().begin();
		String query = "FROM users WHERE username = " + "'" + user + "'";
		listUsers = em.createQuery(query).getResultList();
		em.getTransaction().commit();
		if(listUsers.size()>0) {
			resUser = listUsers.get(0);
		}
		return resUser;
	}

	public List<Profiles> getProfiles(int userId) {
		String query = "From profiles where Userid = " + userId;
		EntityManager em = openConnectionToDataBase();
		em.getTransaction().begin();
		return em.createQuery(query).getResultList();
	}

	public String createUser(String username, String password) {
		if (findUser(username) == null) {
			Users user = new Users(username, password);
			Profiles prof = new Profiles(username);
			user.getProfiles().add(prof);

			EntityManager em = openConnectionToDataBase();
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			em.close();
			return "Käyttäjä lisätty";
		} else {
			return "Käyttäjä on jo olemassa";
		}
	}

	public void createprofile(String profileName, String username) {
		Users user = findUser(username);
		Profiles prof = new Profiles(profileName);
		user.getProfiles().add(prof);

		EntityManager em = openConnectionToDataBase();

		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();

		em.close();
	}

}
