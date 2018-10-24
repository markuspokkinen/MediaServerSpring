package hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateConn {
	private EntityManager em;

	public HibernateConn() {
		em = openConnectionToDataBase();
	}

	public void close() {
		em.close();
	}

	private EntityManager openConnectionToDataBase() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MediaServer");
		System.out.println("EMF kehitetty");
		EntityManager em = emf.createEntityManager();
		return em;
	}

	// Profiles
	public List<Profiles> getProfiles(int userId) {
		String query = "From users_Profiles where users_id = " + userId;
		em.getTransaction().begin();
		List<Profiles> profiles = em.createQuery(query).getResultList();
		em.getTransaction().commit();
		em.clear();

		return profiles;
	}

	public void createprofile(String profileName, Users user) {
		Profiles prof = new Profiles(profileName);
		user.getProfiles().add(prof);

		em.getTransaction().begin();
		em.merge(user);
		em.getTransaction().commit();
		em.clear();

	}

	public void removeprofile(Profiles prof) {
		em.getTransaction().begin();
		em.createQuery("DELETE Profiles where id= :id").setParameter("id", prof.getProfileID()).executeUpdate();
		em.getTransaction().commit();
		em.clear();
	}

	public void addmovietoProfile(Movies movie, Profiles profiles) {
		profiles.getMovieFav().add(movie);
		em.getTransaction().begin();
		em.persist(profiles);
		em.getTransaction().commit();
		em.clear();
	}
	public void removemoviefromProfile(Movies movie, Profiles profile) {
		profile.getMovieFav().remove(movie);
		em.getTransaction().begin();
		em.persist(profile);
		em.getTransaction().commit();
		em.clear();
	}

	// Users
	public Users findUser(String user) {
		List<Users> listUsers = null;
		Users resUser = null;
		em.getTransaction().begin();
		String query = "FROM users WHERE username ='" + user + "'";
		listUsers = em.createQuery(query).getResultList();
		em.getTransaction().commit();
		if (listUsers.size() > 0) {
			resUser = listUsers.get(0);
		}
		em.clear();
		return resUser;
	}

	public String createUser(String username, String password) {
		if (findUser(username) == null) {
			Users user = new Users(username, password);
			Profiles prof = new Profiles(username);
			user.getProfiles().add(prof);

			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();

			em.clear();

			return "Käyttäjä lisätty";
		} else {
			return "Käyttäjä on jo olemassa";
		}
	}

	// Movies
	public List<Movies> getAllMovies() {
		List<Movies> movies = null;
		String query = "SELECT m FROM Movies m";
		em.getTransaction().begin();
		movies = em.createQuery(query).getResultList();
		em.getTransaction().commit();
		em.clear();
		return movies;
	}

	public void addMovie(String moviename, String description) {
		Movies movie = new Movies(moviename, description);
		em.getTransaction().begin();
		em.persist(movie);
		em.getTransaction().commit();
		em.clear();
	}

	public List<Movies> searchmovie(String moviename) {
		List<Movies> sear = null;
		String query = "FROM Movies WHERE moviename LIKE :moviename";
		em.getTransaction().begin();
		sear = em.createQuery(query).setParameter("moviename", "%"+moviename+"%").getResultList();
		em.getTransaction().commit();
		em.clear();
		return sear;
	}
	public Movies searchMoviebyID(int id) {
		String query = "FROM Movies WHERE movieId ="+id;
		em.getTransaction().begin();
		Movies m = (Movies) em.createQuery(query).getSingleResult();
		em.getTransaction().commit();
		em.clear();
		return m;
	}

}
