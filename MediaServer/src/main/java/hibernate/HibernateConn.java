package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.exception.JDBCConnectionException;

public class HibernateConn {

	private Session OpenConnectionToDataBase() {
		SessionFactory sessFac = null;

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		System.out.println("Configuration tiedosto ladattu");

		try {
			sessFac = new MetadataSources(registry).buildMetadata().buildSessionFactory();

		} catch (Exception e) {
			e.printStackTrace();
		}

		Session sess = sessFac.openSession();
		return sess;
	}
}
