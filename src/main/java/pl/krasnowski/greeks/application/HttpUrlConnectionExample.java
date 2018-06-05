package pl.krasnowski.greeks.application;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HttpUrlConnectionExample {

	private static List<String> cookies;
	private HttpsURLConnection conn;
	private final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:55.0) Gecko/20100101 Firefox/55.0";

	public static void main(String[] args) throws Exception {

		// String url = "https://accounts.google.com/ServiceLoginAuth";
		String url = "https://pl.ikariam.gameforge.com/";
	//	String loggedPage = "https://s31-pl.ikariam.gameforge.com/index.php?action=loginAvatar&function=login";
		String loggedPage = "https://s31-pl.ikariam.gameforge.com/index.php?view=updateGlobalData&startPageShown=1&detectedDevice=1&cityId=54019&backgroundView=city&currentCityId=54019&actionRequest=f745b07c8748f9658858b8a731fef5f9&ajax=1";
		
		HttpUrlConnectionExample http = new HttpUrlConnectionExample();

		// make sure cookies is turn on
		CookieHandler.setDefault(new CookieManager());

		// http.cookies.add(arg0)

		// // 1. Send a "GET" request, so that you can extract the form's data.
		Document doc = Jsoup.connect("https://pl.ikariam.gameforge.com/").get();


		String page = http.GetPageContent(url);
		String postParams = http.getFormParams(page, "xyz@gmail.com", "1234");

		// // 2. Construct above post's content and then send a POST request for
		// // authentication
		http.sendPost(url, postParams);
		//
		// // 3. success then go to gmail.
		String result = http.GetPageContent(loggedPage);
		System.out.println("RESULT...");
		// System.out.println(result);

	}

	private void sendPost(String url, String postParams) throws Exception {

		URL obj = new URL(url);
		conn = (HttpsURLConnection) obj.openConnection();

		// Acts like a browser
		conn.setUseCaches(false);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Host", "s31-pl.ikariam.gameforge.com");
		conn.setRequestProperty("User-Agent", USER_AGENT);
		conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		conn.setRequestProperty("Accept-Language", "pl,en-US;q=0.7,en;q=0.3");
		conn.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("Content-Length", Integer.toString(postParams.length()));
		conn.setRequestProperty("Referer", "https://pl.ikariam.gameforge.com/index.php?logout=1");
		if (cookies != null)
			for (String cookie : HttpUrlConnectionExample.cookies) {
				conn.addRequestProperty("Cookie", cookie.split(";", 1)[0]);
			}
		conn.setRequestProperty("Cookie",
				"__auc=655ad38415c788466dc1d9c1b87; pc_idt=AKSiENOFey6YQmGvAXe0n7sAFuI89Htj-TM5cArDu7dWHrLWo0ASVuphOCxIAVGB0_LqsiTnpGVEeP-rU1McHvnbdOrNIKZGOcWo8Xkcjs_FG7LpE5Ea9cPmiRUN4QZXtcYRY3WgvLLGpVTIROR1e5l6D2D0q6ZCoCD7SA; ik_global=notes%3D0%3Bcontains%3Dfunction%28g%29%7Bvar%20e%3Bpath%3D/%3Bnotes_x%3D614px%3Bnotes_y%3D97.5667px%3Bnotes_width%3D480px%3Bnotes_height%3D0px%3Bpath=/; PHPSESSID=c1klficqpa4simv0eb6ipb7mc6; ikariam_loginMode=0; ik_friendslist_27125=page%3D0%3Bcontains%3Dfunction%28g%29%7Bvar%20e%3Bpath%3D/%3Bpath=/; ik_video_player=volume%3D0%3Bcontains%3Dfunction%28g%29%7Bvar%20e%3Bpath%3D/%3Bpath=/; ikariam=27125_ba3f66cf3ba9c9e8669f99f27361e0a3; __asc=3becdbb215e9a22febaffb2adeb");
		conn.setRequestProperty("DNT", "1");
		conn.setRequestProperty("Connection", "keep-alive");
		conn.setRequestProperty("Upgrade-Insecure-Requests", "1");

		conn.setDoOutput(true);
		conn.setDoInput(true);

		// Send post request
		DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
		wr.writeBytes(postParams);
		wr.flush();
		wr.close();

		int responseCode = conn.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + postParams);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		// System.out.println(response.toString());

	}

	private String GetPageContent(String url) throws Exception {

		URL obj = new URL(url);
		conn = (HttpsURLConnection) obj.openConnection();

		// default is GET
		conn.setRequestMethod("GET");

		conn.setUseCaches(false);

		// act like a browser
		conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:55.0) Gecko/20100101 Firefox/55.0");
		conn.setRequestProperty("Accept-Language", "pl,en-US;q=0.7,en;q=0.3");
		conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		conn.setRequestProperty("Host", "s31-pl.ikariam.gameforge.com");

		conn.setRequestProperty("Connection", "close");
		conn.setRequestProperty("Content-Type", "text/html; charset=utf-8");
		if (cookies != null) {
			for (String cookie : HttpUrlConnectionExample.cookies) {
				conn.addRequestProperty("Cookie", cookie.split(";", 1)[0]);
			}
		}
		int responseCode = conn.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// Get the response cookies
		setCookies(conn.getHeaderFields().get("Set-Cookie"));

		System.out.println(response.toString());
		return response.toString();
	}

	public String getFormParams(String html, String username, String password) throws UnsupportedEncodingException {
		StringBuilder result = new StringBuilder();

		System.out.println("Extracting form's data...");

		Document doc = Jsoup.parse(html);
	//	String cookie = "\"__auc=655ad38415c788466dc1d9c1b87; pc_idt=AJ-O1SefziTq4en8moGH3c9serr0gK_T31S_RKDNe9Nw0PdzIxHfESsY7heAmk-MknBV4msFjQJ9SScGSF2SjK6qRyjZKNJqy0po7mDeYMKCsnFgSK9KgyPYn0y4lGh8kwWQ0ecxSEQsCWMc2EdIYMNo1txD5qOf8Z7IbA; ik_global=notes%3D0%3Bcontains%3Dfunction%28g%29%7Bvar%20e%3Bpath%3D/%3Bnotes_x%3D614px%3Bnotes_y%3D97.5667px%3Bnotes_width%3D480px%3Bnotes_height%3D0px%3Bpath=/; PHPSESSID=7vfq5f9p5t89nma6c7319k6c26; ikariam_loginMode=0; ik_video_player=volume%3D100%3Bcontains%3Dfunction%28g%29%7Bvar%20e%3Bpath%3D/%3Bpath=/; __asc=c21ff74515e86cbb58d3cca9baf\")\r\n";
		try {
			// Document doc2 = Jsoup.connect(html).header("Accept", "text/html, */*; q=0.01").header("Accept-Encoding", "gzip,deflate,sdch")
			// .header("Accept-Language", "ru-RU,ru;q=0.8,en-US;q=0.6,en;q=0.4").header("Connection", "keep-alive").header("Cookie", cookie).header("Host", "s31-pl.ikariam.gameforge.com")
			// .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.57 Safari/537.36")
			// // .cookie(genUrl(),cookie)
			// .get();

			Element loginform = doc.getElementById("loginForm");
			Elements inputElements = loginform.getElementsByTag("input");
			List<String> paramList = new ArrayList<String>();
			for (Element inputElement : inputElements) {
				String key = inputElement.attr("name");
				String value = inputElement.attr("value");

				if (key.equals("name"))
					value = username;
				else if (key.equals("password"))
					value = password;
				paramList.add(key + "=" + URLEncoder.encode(value, "UTF-8"));
			}

			// build parameters list
			for (String param : paramList) {
				if (result.length() == 0) {
					result.append(param);
				} else {
					result.append("&" + param);
				}
			}
		} catch (IOException e) {
			System.out.println("IO exception!")
			e.printStackTrace();
		}

		return result.toString();
	}

	public List<String> getCookies() {
		return cookies;
	}

	public void setCookies(List<String> cookies) {
		HttpUrlConnectionExample.cookies = cookies;
	}

	public static void printCookies() {
		System.out.println("Cookies:");
		for (String cookie : cookies)
			System.out.println(cookie);
	}



}