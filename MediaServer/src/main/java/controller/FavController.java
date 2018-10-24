package controller;

import hibernate.HibernateConn;
import hibernate.Movies;
import hibernate.Profiles;

public class FavController {
	private Profiles prof;
	private HibernateConn hc;

	public FavController(HibernateConn hc, Profiles prof) {
		this.hc = hc;
		this.prof = prof;
	}

	private String movieparser(Movies m) {
		return "ID: " + m.getMovieId() + " Name: " + m.getMovieName() + " Description: " + m.getDescription();
	}

	public void allMovies() {
		for (Movies m : prof.getMovieFav()) {
			System.out.println(m.toString());
		}
	}

	public void addmovieToProfile(int id) {
		Movies newmov = hc.searchMoviebyID(id);
		hc.addmovietoProfile(newmov, prof);
	}
	public void remove(int id) {
		Movies mov = hc.searchMoviebyID(id);
		hc.removemoviefromProfile(mov, prof);
	}

}
