package gui;

import java.util.List;
import java.util.Scanner;

import controller.FavController;
import controller.MoviesController;
import controller.ProfilesController;
import controller.UserContoller;
import hibernate.HibernateConn;
import hibernate.Movies;
import hibernate.Profiles;
import hibernate.Users;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Scanner lukija = new Scanner(System.in);
		HibernateConn hc = new HibernateConn();

		UserContoller uc;
		ProfilesController pc;
		MoviesController mc;
		FavController fc;

		Users user = null;
		Profiles profile = null;

		int k = 0;
		do {
			if (user == null) {
				System.out.println("1. luo uusi käyttäjä \n"
						+ "2. kirjaudu sisään\n"
						+ "3. Lopeta Ohjelma");
				k = lukija.nextInt();
				uc = new UserContoller(lukija, hc);
				user = uc.getuser(k);
			}
			if (user != null) {
				//System.out.println(user);
				// Profiilit
				if (profile == null) {
					pc = new ProfilesController(lukija, hc, user);
					profile = pc.getprofile();
					if (profile == null) {
						user = null;
					}
				}
				if (profile != null) {
					// elokuva
					String vaito = "1. Selaa kaikkia elokuvia \n"
							+ "2.hae elokuvaa nimen perusteella \n"
							+ "3.Hae ID Perusteella \n"
							+ "4.Uusi Elokuva\n"
							+ "5.Selaa elokuvia suosikeissa \n"
							+ "6.Lisää elokuva suosikeihin \n"
							+ "7 Poista elokuva suosikeista \n"
							+ "8.vaihda profiilia \n"
							+ "9.Kirjaudu ulos";
					System.out.println(vaito);
					int e = lukija.nextInt();
					mc = new MoviesController(hc, lukija);
					fc = new FavController(hc,profile);
					mc.moviesCont(e);
					
					switch (e) {
					case 5:
						//selaa suosikkeja
						fc.allMovies();
						break;
					case 6:
						//Lisää elokuva suosikkeihin
						System.out.println("Anna elokuvan id");
						int movid = lukija.nextInt();
						fc.addmovieToProfile(movid);
						System.out.println("Elokuva lisätty");
						break;
					case 7:
						//Poista elokuva suosikeista
						System.out.println("Anna elokuvan id");
						int remid = lukija.nextInt();
						fc.remove(remid);
					case 8:
						//vaihda profiili
						profile = null;
						break;
					case 9:
						// kirjaudu ulos
						profile = null;
						user = null;
						break;
					default:
						break;
					}
					
					
				}
			}
		} while (k != 3);
		lukija.close();
		hc.close();
		System.out.println("Ohjelma lopetettu");
		System.exit(0);
		
	}
}
