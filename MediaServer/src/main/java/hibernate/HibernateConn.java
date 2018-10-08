package hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class HibernateConn {
	public HibernateConn() {
		
	}

	private EntityManager openConnectionToDataBase() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MediaServer");
		System.out.println("EMF kehitetty");
		EntityManager em = emf.createEntityManager();
		
		return em;
	}
	public List<Users[]> findUser(String user) {
		EntityManager em = openConnectionToDataBase();
		Query k = em.createQuery("SELECT * from Users WHERE Email ="+user);
		List<Users[]> tulos = k.getResultList();
		em.close();
		return tulos;
	}
	
	
}
