package controller;

import java.util.Scanner;

import hibernate.HibernateConn;
import hibernate.Users;

public class UserContoller {
	private Scanner lukija;
	private HibernateConn hc;

	public UserContoller(Scanner lukija,HibernateConn hc) {
		this.lukija = lukija;
		this.hc = hc;
		
	}

	private void createuser() {
		// luodaan uusi käyttäjä
		System.out.println("Anna Käyttäjä Nimi");
		String newname = lukija.next();
		System.out.println("Anna Salasana");
		String newsalasana = lukija.next();
		String createResp = hc.createUser(newname, newsalasana);
		System.out.println(createResp);
	}
	private Users login() {
		// kirjaudu sisään
		System.out.println("Anna Käyttäjä Nimi");
		String logname = lukija.next();
		System.out.println("Anna Salasana");
		String logsalasana = lukija.next();
		return new Users(logname, logsalasana);
	}

	public Users getuser(int choice) {
		Users user = null;
		
		switch (choice) {
		case 1:
			createuser();
			break;
		case 2:
			Users userinp = login();
			try {
			Users tmpuser = hc.findUser(userinp.getUserName());
			
			if (userinp.getPassword().equals(tmpuser.getPassword())) {
				user = tmpuser;
			} else {
				System.out.println("Käyttäjä nimi tai salasana on väärin");
			}
			}catch(NullPointerException e) {
				System.out.println("Käyttäjää ei löydy");
			}
		}

		return user;
	}
}
