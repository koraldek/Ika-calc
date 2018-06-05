package pl.krasnowski.greeks.application;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

public class HTTPConnectionImpl implements HTTPConnection {
	final protected String C_SessionKey1 = "ikariam";
	final protected String C_SessionKey2 = "PHPSESSID";
	protected String C_SessionValue1, C_SessionValue2, resp, url, username, password, respPage; // cookies values

	private Map<String, String> loggedReqHeaders = new HashMap<String, String>();
	private Map<String, String> loggedReqCookies = new HashMap<String, String>();
	private Map<String, String> loggedForm = new HashMap<String, String>();

	private Map<String, String> reqHeaders;
	private Map<String, String> reqCookies;
	private Map<String, String> respHeaders;
	private Map<String, String> respCookies;

	// final static Logger debugLog = Logger.getLogger("debugLogger");
	// final static Logger resultLog = Logger.getLogger("resultsLogger");

	public HTTPConnectionImpl(String url) {
		this.url = url;
		this.initializeVariables();
	}

	public static void main(String[] args) throws InterruptedException, IOException {

		String ikariamURL = "https://pl.ikariam.gameforge.com/";

		HTTPConnectionImpl conn = new HTTPConnectionImpl(ikariamURL);
		// debugLog.debug("==========================================\nInitializing Variables...");

		String loggedPage = conn.loginToServer(conn.getUsername(), conn.getPassword());

		System.out.println(loggedPage);

		for (Map.Entry<String, String> entry : conn.getLoggedReqCookies().entrySet()) {
			System.out.println("Key:" + entry.getKey() + " Value:" + entry.getValue() + ", \n");
		}

	}

	public String sendGET(String url, Map<String, String> reqHeaders, Map<String, String> reqCookies, Map<String, String> reqParams) throws IOException {
		String respBody;
		Connection.Response respPage;

		if (reqParams == null) // data maps cannot be empty
			if (reqCookies.isEmpty())
				respPage = Jsoup.connect(url).method(Connection.Method.GET).data(reqHeaders).execute();
			else
				respPage = Jsoup.connect(url).method(Connection.Method.GET).data(reqHeaders).cookies(reqCookies).execute();
		else if (reqCookies.isEmpty())
			respPage = Jsoup.connect(url).method(Connection.Method.GET).data(reqHeaders).data(reqParams).execute();
		else
			respPage = Jsoup.connect(url).method(Connection.Method.GET).data(reqHeaders).data(reqParams).cookies(reqCookies).execute();

		respBody = respPage.body();
		// Get the response cookies & headers
		this.setRespCookies(respPage.cookies());
		this.setRespHeaders(respPage.headers());

		return respBody;
	}

	public String sendPOST(String url, Map<String, String> reqHeaders, Map<String, String> reqCookies, Map<String, String> reqParams) throws IOException {
		String respBody;
		Connection.Response respPage;

		if (reqParams == null) // data maps cannot be empty
			if (reqCookies.isEmpty())
				respPage = Jsoup.connect(url).method(Connection.Method.GET).data(reqHeaders).execute();
			else
				respPage = Jsoup.connect(url).method(Connection.Method.GET).data(reqHeaders).cookies(reqCookies).execute();
		else if (reqCookies.isEmpty())
			respPage = Jsoup.connect(url).method(Connection.Method.GET).data(reqHeaders).data(reqParams).execute();
		else
			respPage = Jsoup.connect(url).method(Connection.Method.GET).data(reqHeaders).data(reqParams).cookies(reqCookies).execute();

		respBody = respPage.body();
		// Get the response cookies & headers
		this.setRespCookies(respPage.cookies());
		this.setRespHeaders(respPage.headers());

		return respBody;
	}

	@SuppressWarnings("unused") // TODO: zmienic na aktualizowanie sie
	private String updateGlobalData(String url, Map<String, String> reqHeaders, Map<String, String> reqCookies, Map<String, String> reqParams) throws Exception {
		String respBody;

		Connection.Response respPage = Jsoup.connect(url).method(Connection.Method.GET).data(reqHeaders).cookies(reqCookies).data(reqParams).followRedirects(true).execute();

		// Get the response cookies & headers
		setRespCookies(respPage.cookies());
		setRespHeaders(respPage.headers());

		// Get response document
		return respPage.body();
	}

	public String loginToServer(String username, String password) throws InterruptedException, IOException { // wyciaganie url metody php z formularza

		String ikariamURL_login = "https://s31-pl.ikariam.gameforge.com/index.php?action=loginAvatar&function=login";
		String resp = "Not initialized page!";
		Map<String, String> homepageCookies = new HashMap<String, String>();
		Map<String, String> loginReqHeaders = new HashMap<String, String>();
		Map<String, String> loginReqCookies = new HashMap<String, String>();
		Map<String, String> loginForm = new HashMap<String, String>();
		Random r = new Random();

		homepageCookies.put("__utma", "61068397.201959253.1506409383.1506411590.1506426775.3");
		homepageCookies.put("__utmc", "61068397");
		homepageCookies.put("__utmz", "61068397.1506426775.3.2.utmcsr=s31-pl.ikariam.gameforge.com|utmccn=(referral)|utmcmd=referral|utmcct=/");
		homepageCookies.put("s31-pl.ikariam.gameforge.com", "myEmail@gmail.com");
		homepageCookies.put("lastLogin_pl", "s31-pl.ikariam.gameforge.com");
		homepageCookies.put("__utmb", "61068397.2.10.1506426775");
		homepageCookies.put("__utmt", "1");

		loginReqHeaders.put("Host", "pl.ikariam.gamefo2rge.com");
		loginReqHeaders.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:55.0) Gecko/20100101 Firefox/55.0");
		loginReqHeaders.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		loginReqHeaders.put("Accept-Language", "pl,en-US;q=0.7,en;q=0.3");
		loginReqHeaders.put("Accept-Encoding", "gzip, deflate, br");
		loginReqHeaders.put("DNT", "1");
		loginReqHeaders.put("Connection", "keep-alive");
		loginReqHeaders.put("Upgrade-Insecure-Requests", "1");
		// after first login to page
		loginReqCookies.put("__auc", "9d45cab415ebcff02a34c05aea7");
		loginReqCookies.put(
				"pc_idt",
				"AID0uN9y09-8M4TWmwPI2rb9QeU2IoGCCAtPdEapz3s--3JYi6WEknGKGQVoCe5uAxCmvKwuZS-5-CXtnoZe29GAfyx3-YbywWTGHxIHexVv36rtPY8_J6WIG5R4oF_iQc0L90nrbsPh74oFenNRfI2d6KWxkkBc66vdPg");
		loginReqCookies.put("__asc", "f9fb8e5715ec3c3c3304f09e196");

		loginForm.put("uni_url", "s34-en.ikariam.gameforge.com");
		loginForm.put("name", username);
		loginForm.put("password", password);
		loginForm.put("pwat_uid", "");
		loginForm.put("pwat_checksum", "");
		loginForm.put("startPageShown", "1");
		loginForm.put("detectedDevice", "1");
		loginForm.put("kid", "");

		this.sendGET(this.url, loginReqHeaders, homepageCookies, null);
		Thread.sleep(r.nextInt(20) * 100); // wait between requests
		try {
			resp = this.sendPOST(ikariamURL_login, loginReqHeaders, loginReqCookies, loginForm);
		} catch (Exception e) {
			System.out.println("Unable to send POST to:" + ikariamURL_login);
			e.printStackTrace();
		}
		this.loggedReqCookies.putAll(this.respCookies); // Add cookies from "Set-Cookie" to next request
		this.respPage = resp;
		// resultLog.debug(resp);
		return resp;
	}

	private void initializeVariables() {
		reqHeaders = new HashMap<String, String>();
		reqCookies = new HashMap<String, String>();
		respHeaders = new HashMap<String, String>();
		respCookies = new HashMap<String, String>();
		loggedReqHeaders = new HashMap<String, String>();
		loggedReqCookies = new HashMap<String, String>();
		loggedForm = new HashMap<String, String>();

		this.loggedReqHeaders.put("Host", "pl.ikariam.gameforge.com");
		this.loggedReqHeaders.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:55.0) Gecko/20100101 Firefox/55.0");
		this.loggedReqHeaders.put("Accept", "*/*");
		this.loggedReqHeaders.put("Accept-Language", "pl,en-US;q=0.7,en;q=0.3");
		this.loggedReqHeaders.put("Accept-Encoding", "gzip, deflate, br");
		this.loggedReqHeaders.put("DNT", "1");
		this.loggedReqHeaders.put("Connection", "keep-alive");
		this.loggedReqHeaders.put("Upgrade-Insecure-Requests", "1");
		this.loggedReqHeaders.put("Content-Length", "0");
		this.loggedReqHeaders.put("X-Requested-With", "XMLHttpRequest");
		this.loggedReqHeaders.put("Referer", "https://s31-pl.ikariam.gameforge.com/index.php?action=loginAvatar&function=login");

		this.loggedForm.put("view", "updateGlobalData");
		this.loggedForm.put("detectedDevice", "1");
		this.loggedForm.put("cityId", "54019");
		this.loggedForm.put("backgroundView", "city");
		this.loggedForm.put("currentCityId", "54019");
		// this.loggedForm.put("actionRequest", "ea4aade88487935999cb20ed9c50d6d5");
		this.loggedForm.put("ajax", "1");

		this.loadUserData("userdata.properties");
	}

	private static String printHeadersOrCookies(Map<String, String> inputMap) {
		StringBuilder sbBuilder = new StringBuilder();
		final String spaces = "                                   "; // for straight indent (35 spaces)
		for (Map.Entry<String, String> entry : inputMap.entrySet()) {
			sbBuilder.append("Key:" + entry.getKey() + spaces.substring(0, spaces.length() - entry.getKey().length()) + "Value:" + entry.getValue() + "\n");
		}
		return sbBuilder.toString();
	}

	private void loadUserData(String filename) {
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = HTTPConnectionImpl.class.getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				System.out.println("Sorry, unable to find " + filename);
				return;
			}
			// load a properties file from class path, inside static method
			prop.load(input);

			this.setUsername(prop.getProperty("username"));
			this.setPassword(prop.getProperty("password"));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public Map<String, String> getReqHeaders() {
		return reqHeaders;
	}

	public void setReqHeaders(Map<String, String> reqHeaders) {
		this.reqHeaders = reqHeaders;
	}

	public Map<String, String> getRespHeaders() {
		return respHeaders;
	}

	public void setRespHeaders(Map<String, String> respHeaders) {
		this.respHeaders = respHeaders;
	}

	public Map<String, String> getReqCookies() {
		return reqCookies;
	}

	public void setReqCookies(Map<String, String> reqCookies) {
		this.reqCookies = reqCookies;
	}

	public Map<String, String> getRespCookies() {
		return respCookies;
	}

	public void setRespCookies(Map<String, String> respCookies) {
		this.respCookies = respCookies;
	}

	private String getUsername() {
		return username;
	}

	private void setUsername(String username) {
		this.username = username;
	}

	private String getPassword() {
		return password;
	}

	private void setPassword(String password) {
		this.password = password;
	}

	public Map<String, String> getLoggedReqHeaders() {
		return loggedReqHeaders;
	}

	public void setLoggedReqHeaders(Map<String, String> loggedReqHeaders) {
		this.loggedReqHeaders = loggedReqHeaders;
	}

	public Map<String, String> getLoggedReqCookies() {
		return loggedReqCookies;
	}

	public void setLoggedReqCookies(Map<String, String> loggedReqCookies) {
		this.loggedReqCookies = loggedReqCookies;
	}

	public Map<String, String> getLoggedForm() {
		return loggedForm;
	}

	public void setLoggedForm(Map<String, String> loggedForm) {
		this.loggedForm = loggedForm;
	}

}
