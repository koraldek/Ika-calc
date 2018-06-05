package pl.krasnowski.greeks.application;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

public class Logowanko {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		StringBuilder result = new StringBuilder();
	//	String url = "https://pl.ikariam.gameforge.com/";

// beda dwie operacje pobrania danych o budynkach,miastach i wyspach. Pierwsze: zdobycie pozycji budynku i hrefa, by móc wejsc do bud/m/w,
//drugi do update'a
		int x = 0;
		String htmlCity = null;
		Document doc = Jsoup.parse(htmlCity);
//System.out.println(doc.getElementsByTag("body").attr("id")); // sprawdz jaki to jest widok: city,island, czy world

		Elements eContainer = doc.getElementsByTag("body");
		Element eContainer2 = doc.getElementById("container");

		List<Node> childNodes = eContainer2.childNodes();
		Elements children = eContainer2.children();

		Element locations = eContainer2.getElementById("locations");
		
	//	locations.select("div[class^=position]")
		for (Element el : doc.select("div[class~=(position)[0-9]{1,2} building")) {
			x++;
			System.out.println("=================" + x + "=========================\n");
			
			// skorzystac z serwisu, ktory robi update albo tworzy encje w bazie danych
//			System.out.println("tag:" + el.nodeName() + " ,id=" + el.id() + " ,class=" + el.className()); // tylko tagi
			System.out.println(el.className());
		}

		Random r = new Random();
		while (true) {
			Thread.sleep(500);
			System.out.println(r.nextInt(20)*100);
		}
	//	System.out.println();
	}
//	StringBuilder sbBuilder = new StringBuilder();
//	final String spaces = "                                   "; //for straight indent (35 spaces)
//	for (Map.Entry<String, String> entry : homepageCookies.entrySet()) {
//
//		System.err.println(  spaces.length() - entry.getKey().length()  );
//		sbBuilder.append("Key:" + entry.getKey() + spaces.substring( 0, spaces.length() - entry.getKey().length()  ) + "Value:" + entry.getValue() + "\n");
//	}
//
//	System.out.println(sbBuilder.toString());
}