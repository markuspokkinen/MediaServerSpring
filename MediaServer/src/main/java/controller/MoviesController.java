package controller;

import java.util.List;
import java.util.Scanner;

import hibernate.HibernateConn;
import hibernate.Movies;

public class MoviesController {

	private HibernateConn hc;
	private Scanner lukija;

	public MoviesController(HibernateConn hc, Scanner lukija) {
		this.hc = hc;
		this.lukija = lukija;
	}

	private String movieparser(Movies m) {
		return "ID: " + m.getMovieId() + " Name: " + m.getMovieName() + " Description: " + m.getDescription();
	}

	private String[] getAllMovies() {

		List<Movies> alldata = hc.getAllMovies();
		String[] elokuvat = new String[alldata.size()];
		for (int i = 0; i < alldata.size(); i++) {
			elokuvat[i] = movieparser(alldata.get(i));
		}

		return elokuvat;
	}

	private String[] searchByname(String query) {
		String[] res;
		List<Movies> alldata = hc.searchmovie(query);
		res = new String[alldata.size()];
		for (int i = 0; i < alldata.size(); i++) {
			res[i] = movieparser(alldata.get(i));
		}
		return res;
	}

	private void addMovie(String moviename, String description) {
		hc.addMovie(moviename, description);
	}

	private String findByID(int id) {
		Movies res = hc.searchMoviebyID(id);
		return movieparser(res);
	}

	public void moviesCont(int e) {
		switch (e) {
		case 1:
			// kaikki elovuvat
			String[] allmovi = getAllMovies();
			for (String s : allmovi) {
				System.out.println(s);
			}
			break;
		case 2:
			// hae nimen perusteella
			System.out.println("Anna haettavan elokuvan nimi: ");
			String query = lukija.next();
			String[] search = searchByname(query);
			for (String s : search) {
				System.out.println(s);
			}
			break;
		case 3:
			// hae id:n perusteella
			System.out.println("Anna haettavan elokuvan ID: ");
			int movieid = lukija.nextInt();
			System.out.println(findByID(movieid));
			break;
		case 4:
			// lisää elokuva
			lukija.nextLine(); 
			System.out.println("Anna elokuvan nimi: ");
			String moviename = lukija.nextLine();
			System.out.println("Anna elokuvan selostus");
			String description = lukija.nextLine();
			addMovie(moviename, description);
			break;
		
		default:
			break;
		}
	}
}
