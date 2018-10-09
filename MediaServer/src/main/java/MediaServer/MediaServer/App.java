package MediaServer.MediaServer;

import java.util.Scanner;

import hibernate.HibernateConn;
import hibernate.Users;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Scanner lukija = new Scanner(System.in);
		HibernateConn hc = new HibernateConn();
		// LoginController lc = new LoginController(hc);
		// hc.createUser("root", "root");
		int k;
		do {
			System.out.println("1. luo uusi käyttäjä \n2. kirjaudu sisään \n3. Lopeta");
			k = lukija.nextInt();
			switch (k) {
			case 1:
				// luodaan uusi käyttäjä
				System.out.println("Anna Käyttäjä Nimi");
				String newname = lukija.next();
				System.out.println("Anna Salasana");
				String newsalasana = lukija.next();
				String createResp = hc.createUser(newname, newsalasana);
				System.out.println(createResp);
				break;
			case 2:
				// kirjaudu sisään
				System.out.println("Anna Käyttäjä Nimi");
				String logname = lukija.next();
				System.out.println("Anna Salasana");
				String logsalasana = lukija.next();
	
				Users loguser = hc.findUser(logname);

				if(logsalasana.equals(loguser.getPassword())) {
					//Profiilit
					System.out.println("1: luo uusi profiili \n2. valitse olemassa oleve profiili");
					int p = lukija.nextInt();
					switch (p) {
					case 1:
						
						break;
					case 2:
						
						break;
					default:
						break;
					}
				}else {
					System.out.println("käyttäjä tai salasana on väärin");
				}
				break;
			case 3:
				System.out.println("Ohjelma lopetettu");
				break;
			default:
				break;
			}

		} while (k != 3);
		lukija.close();
	}
}
