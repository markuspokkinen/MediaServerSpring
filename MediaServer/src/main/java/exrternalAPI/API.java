package exrternalAPI;

import java.io.IOException;
import java.net.URL;

public class API {
	private static String apiID_url = "https://api.themoviedb.org/3/movie/";
	private static String apiKey = "?api_key=d6d6fca6e513373972e1653239fa2dc3";
	private static String apiSearch_url = "https://api.themoviedb.org/3/search/movie/?api_key=d6d6fca6e513373972e1653239fa2dc3";

	public static Object searchMovie(String param) throws IOException {
		System.out.println(param);
		String res = "";
		URL url = new URL(apiSearch_url + "&query=" + param);
		System.out.println(url);
		return res;
	}
}
