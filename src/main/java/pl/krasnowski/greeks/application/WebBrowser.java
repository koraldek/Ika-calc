package pl.krasnowski.greeks.application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.print.Doc;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;

public class WebBrowser {

	public static void main(String[] args) throws IOException {
		String homePage = "https://youtube.com";
		Connection.Response respPage = Jsoup.connect(homePage).method(Connection.Method.GET).execute();
		Document doc = Jsoup.parse(homePage);
		String respBody = respPage.body();
		// Document doc = Jsoup.parse(homePage);

		

		System.out.println(doc.getAllElements().size());
		Element element = doc.getAllElements().get(3);
		System.out.println("Tagname:" + element.tagName());

		Element element2 = element.getAllElements().get(0);
		System.out.println("result:" + element2.tagName());
		Element element3 = element2.getAllElements().get(0);
		System.out.println("result:" + element3.tagName());
		String dsa = "\"div id=\\\"page\\\" class=\\\"site\\\"\"";
		List<String> childList = new ArrayList<>();
		NodeVisitor myNodeVisitor = new MyNodeVisitor(childList);
		NodeTraversor traversor = new NodeTraversor(myNodeVisitor);

		int x = 0;
		for (Element el : doc.select("a[ href]")) {
			x++;
			System.out.println("=================" + x + "=========================\n");

			// skorzystac z serwisu, ktory robi update/ tworzy encje w bazie danych
			// System.out.println("tag:" + el.nodeName() + " ,id=" + el.id() + " ,class=" + el.className()); // tylko tagi
			System.out.println(el.className());
		}

		// Element firstDiv = doc.select("div").first();
		Element firstDiv = doc.getAllElements().get(3);
		if (firstDiv == null) {
			System.err.println("Unable to find any div.");
		} else {
			traversor.traverse(firstDiv);

			for (String child : childList) {
				System.out.println(child);
			}
		}
	}


}
