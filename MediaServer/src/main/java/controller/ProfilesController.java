package controller;

import java.util.List;
import java.util.Scanner;

import hibernate.HibernateConn;
import hibernate.Profiles;
import hibernate.Users;

public class ProfilesController {
	private Users user;
	private Scanner lukija;
	private HibernateConn hc;

	public ProfilesController(Scanner lukija,HibernateConn hc,Users user) {
		this.lukija = lukija;
		this.hc = hc;
		this.user = user;
	}
	
	private void createprofile() {
		System.out.println("Anna profiilin nimi: ");
		String profiilinNimi = lukija.next();
		hc.createprofile(profiilinNimi, user);
	}
	
	private void removeprofile(List<Profiles> profiles) {
		System.out.println("valiste poistettava profiili: ");
		for (int i = 0; i < profiles.size(); i++) {
			System.out.println(i + ". " + profiles.get(i).getProfileName());
		}
		int pp = lukija.nextInt();
		Profiles poistettava = profiles.get(pp);
		hc.removeprofile(poistettava);
	}

	public Profiles getprofile() {
		Profiles profile = null;
		List<Profiles> profiles = user.getProfiles();
		
		
		System.out.println("valiste profiili: ");
		for (int i = 0; i < profiles.size(); i++) {
			System.out.println(i + ". " + profiles.get(i).getProfileName());
		}
		System.out.println("tai " + profiles.size() + ". luodakeen uuden profiilin, "+(profiles.size()+1)+". poista profiili, "+(profiles.size()+2)+". Kirjauduakseen ulos");

		int p = lukija.nextInt();
		if (p < profiles.size()) {
			// valitaan profiilip
			System.out.println("profiili valitiin");
			return profiles.get(p);
			
		} else if(p == profiles.size()) {
			//uusi profiili
			createprofile();
			getprofile();
		}else if(p == (profiles.size()+1)){
			//poista profiili
			removeprofile(profiles);
			getprofile();
		}else if(p == (profiles.size()+2)){
			//poistu
		}
		return profile;
	}

}
