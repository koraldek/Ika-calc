package pl.krasnowski.greeks.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.h2.util.IntArray;
import org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.ParsedSql;

import pl.krasnowski.greeks.model.buildings.*;
import pl.krasnowski.greeks.model.world.*;

@SuppressWarnings("unused")
public class DataParser2 {
	final static int depotCapacity = 32000, WarehouseCapacity = 8000;
	static int lvl, nWood, nMarble, nWine, nCrystal, nSulphur, nSpecial1, nSpecial2, nSpecial3, workers;
	static long nTime;

	public static void main(String[] args) throws IOException {
		// getData(LuxuryResource.class);
		parseIsleTemplates();
	}

	@SuppressWarnings("unchecked")
	public static <E> List<E> getData(Class<?> clazz) {

		int wood = 0, time = 0, marble = 0, crystal = 0, wine = 0, sulphur = 0, special1 = 0, special2 = 0, special3 = 0, people = 0;
		// int nSpecial2 = 0, nSpecial1 = 0, nSpecial3 = 0, nSpecial4 = 0;
		E type;
		List<E> result = new ArrayList<>();

		String[] row, ResultRow;
		File file = new File("./modelData/buildingsData/" + clazz.getSimpleName() + ".txt");
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			// PrintWriter zapis = new PrintWriter("data_input.txt");
			// while (scanner.hasNextLine()) {
			// String txt = scanner.nextLine().replaceAll(",", "");
			// zapis.println(txt);
			// }

			// detects position of class fields Level nWood nMarble nTime maximum citizens
			row = scanner.nextLine().split("	");
			ResultRow = new String[row.length];
			for (int i = 0; i < row.length; i++) {
				if (row[i].equals("nWood"))
					wood = i;
				else if (row[i].equals("nMarble"))
					marble = i;
				else if (row[i].equals("nWine"))
					wine = i;
				else if (row[i].equals("nCrystal"))
					crystal = i;
				else if (row[i].equals("nSulphur"))
					sulphur = i;
				else if (row[i].equals("people"))
					people = i;
				else if (row[i].equals("nTime"))
					time = i;
				else if (row[i].equals("special1") || row[i].equals("s1"))
					special1 = i;
				else if (row[i].equals("special2") || row[i].equals("s2"))
					special2 = i;
				else if (row[i].equals("special3") || row[i].equals("s3"))
					special3 = i;
			}

			while (scanner.hasNextLine()) {
				row = scanner.nextLine().split("	");
				for (int i = 1; i < row.length; i++) {
					if (i == time) {
						// if (Pattern.matches("([0-9]+[a-zA-Z]+( )*)+", row[i]) || ) { // sprawdza czy to tylko liczba
						nTime = 0; // reset time counter
						String timeS[] = row[i].split(" ");
						for (String partTime : timeS) {
							if (Pattern.matches("[0-9]+D", partTime) || Pattern.matches("[0-9]+ +D ", partTime)) {
								partTime = partTime.replace("D", "");
								nTime = 86400 * Long.valueOf(partTime);
							} else if (Pattern.matches("[0-9]+h", partTime)) {
								partTime = partTime.replace("h", "");
								nTime = nTime + 3600 * Long.valueOf(partTime);
							} else if (Pattern.matches("[0-9]+m", partTime)) {
								partTime = partTime.replace("m", "");
								nTime = nTime + 60 * Long.valueOf(partTime);
							} else if (Pattern.matches("[0-9]+s", partTime)) {
								partTime = partTime.replace("s", "");
								nTime = nTime + Long.valueOf(partTime);
							}
						}
					}
				}
				for (int i = 0; i < row.length; i++) {
					row[i] = row[i].replace(" ", "");
					row[i] = row[i].replace(",", "");
					if (row[i].equals("")) // valueOf could throw exception
						row[i] = "0";
				}
				lvl = Integer.valueOf(row[0]);
				nWood = Integer.valueOf(row[wood]);
				nMarble = Integer.valueOf(row[marble]);
				nWine = Integer.valueOf(row[wine]);
				nCrystal = Integer.valueOf(row[crystal]);
				nSulphur = Integer.valueOf(row[sulphur]);
				nSpecial1 = Integer.valueOf(row[special1]);
				nSpecial2 = Integer.valueOf(row[special2]);
				nSpecial3 = Integer.valueOf(row[special3]);
				workers = Integer.valueOf(row[people]);

				result.add((E) DataParser2.toObject(clazz));
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static void getDataFromWiki() throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("data_input.txt"));
		ArrayList<String> l1 = new ArrayList<>();
		ArrayList<String> result = new ArrayList<>();

		// String[] a = input.split("\r\n");
		while (scanner.hasNextLine())
			l1.add(scanner.nextLine());

		// for (String s : l1) {
		// if (!s.equals("") && !s.contains(")") && !s.contains("-")) {
		// result.add(s.replace(",", ""));
		//
		// }
		// }

		// for (String s : a) {
		// if (!s.equals("") && !s.contains(")")) {
		// result.add(s.replace(",", ""));
		// }
		// if (!s.equals("")) {
		// result.add(s.replace(",", ""));
		// }
		// }
		// System.out.println("Size before:" + result.size());

		for (int i = 0; i < l1.size() - 1; i++) {
			String s = l1.get(i);
			if (s.equals("DISPLAYED:")) {
				System.out.println("deleting-> " + s + " , " + l1.get(i + 1));
				l1.remove(i);
				l1.remove(i);
				l1.remove(i + 1);
				// i++;
			}
		}

		System.out.println("Size after:" + result.size());
		for (String s : l1) {
			System.out.println(s);
		}
		scanner.close();
	}

	private static <E> Object toObject(Class<?> clazz) {
		Object result;

		switch (clazz.getSimpleName()) {
		case "Academy": {
			result = new Academy(lvl, nWood, nTime, nCrystal, nSpecial1);
			break;
		}
		case "AlchemistsTower": {
			result = new AlchemistsTower(lvl, nWood, nTime, nMarble, 2 * lvl);
			break;
		}
		case "ArchitectsOffice": {
			result = new ArchitectsOffice(lvl, nWood, nTime, nMarble, lvl);
			break;
		}
		case "Barracks": {
			result = new Barracks(lvl, nWood, nTime, nMarble);
			break;
		}
		case "BlackMarket": {
			result = new BlackMarket(lvl, nWood, nTime, nMarble, nSpecial1);
			break;
		}
		case "CarpentersWorkshop": {
			result = new CarpentersWorkshop(lvl, nWood, nTime, nMarble, lvl);
			break;
		}
		case "Depot": {
			result = new Depot(lvl, nWood, nTime, nMarble, nCrystal, nSulphur, depotCapacity * lvl);
			break;
		}
		case "Embassy": {
			result = new Embassy(lvl, nWood, nTime, nMarble, nSpecial1);
			break;
		}
		case "FireworkTestArea": {
			result = new FireworkTestArea(lvl, nWood, nTime, nMarble, lvl);
			break;
		}
		case "ForestersHouse": {
			result = new ForestersHouse(lvl, nWood, nTime, nMarble, 2 * lvl);
			break;
		}
		case "Glassblower": {
			result = new Glassblower(lvl, nWood, nTime, nMarble, 2 * lvl);
			break;
		}
		case "GovernorsResidence": {
			result = new GovernorsResidence(lvl, nWood, nTime, nWine, nMarble, nCrystal, nSulphur);
			break;
		}
		case "Hideout": {
			result = new Hideout(lvl, nWood, nTime, nMarble);
			break;
		}
		case "LuxuryResource": {
			result = new LuxuryResource(lvl, nWood, nTime, nSpecial1);
			break;
		}
		case "Museum": {
			result = new Museum(lvl, nWood, nMarble, nTime, nSpecial1, nSpecial2);
			break;
		}
		case "Optician": {
			result = new Optician(lvl, nWood, nTime, nMarble, lvl);
			break;
		}
		case "Palace": {
			result = new Palace(lvl, nWood, nTime, nWine, nMarble, nCrystal, nSulphur);
			break;
		}
		case "PirateFortress": {
			result = new PirateFortress(lvl, nWood, nTime, nMarble);
			break;
		}
		case "Sawmill": {
			result = new Sawmill(lvl, nWood, nTime, nSpecial1);
			break;
		}
		case "SeaChartArchive": {
			result = new SeaChartArchive(lvl, nWood, nTime, nMarble);
			break;
		}
		case "Shipyard": {
			result = new Shipyard(lvl, nWood, nTime, nMarble);
			break;
		}
		case "Stonemason": {
			result = new Stonemason(lvl, nWood, nTime, nMarble, 2 * lvl);
			break;
		}
		case "Tavern": {
			result = new Tavern(lvl, nWood, nTime, nMarble, nSpecial1, nSpecial2, nSpecial3);
			break;
		}
		case "Temple": {
			result = new Temple(lvl, nWood, nTime, nCrystal, nSpecial1);
			break;
		}
		case "Townhall": {
			result = new Townhall(lvl, nWood, nTime, nMarble, nSpecial1, (3 + lvl / 4));
			break;
		}
		// case "TownWall": { // added manually
		// result = new TownWall(lvl, nWood, nTime, nMarble, nSpecial1, nSpecial2, nSpecial3, workers);
		// break;
		// }
		case "TradingPort": {
			result = new TradingPort(lvl, nWood, nTime, nMarble, nSpecial1);
			break;
		}
		case "TradingPost": {
			result = new TradingPost(lvl, nWood, nTime, nMarble, nSpecial1, ((1 + lvl) / 2)); // TODO: sprawdzic poprawność zasiegu
			break;
		}
		case "Warehouse": {
			result = new Warehouse(lvl, nWood, nTime, nMarble, WarehouseCapacity * lvl);
			break;
		}
		case "WinePress": {
			result = new WinePress(lvl, nWood, nTime, nMarble, lvl);
			break;
		}
		case "Winery": {
			result = new Winery(lvl, nWood, nTime, nMarble, 2 * lvl);
			break;
		}
		case "Workshop": {
			result = new Workshop(lvl, nWood, nTime, nMarble);
			break;
		}
		default: {
			result = null;
			System.out.println("Class not found...");
			break;
		}

		}
		return result;
	}

	private ArrayList<ArrayList<String>> parseDataFromWiki() throws FileNotFoundException {
		Scanner sc1, sc2, sc3;
		sc1 = new Scanner(new File("koszt rozbudowy tartaku.txt"));
		sc2 = new Scanner(new File("czas budowy tartaku.txt"));
		sc3 = new Scanner(new File("pracownikow tartaku.txt"));

		ArrayList<Scanner> scanners = new ArrayList<>();
		scanners.add(sc1);
		scanners.add(sc2);
		scanners.add(sc3);
		ArrayList<String> nWood = new ArrayList<>();
		ArrayList<String> nTime = new ArrayList<>();
		ArrayList<String> workers = new ArrayList<>();
		ArrayList<ArrayList<String>> lists = new ArrayList<>();
		lists.add(nWood);
		lists.add(nTime);
		lists.add(workers);

		int scID = 0;
		for (ArrayList<String> al : lists) {
			while (scanners.get(scID).hasNextLine()) {
				al.add(scanners.get(scID).nextLine());
			}
			scID++;
			// System.out.println(x);
		}
		sc1.close();
		sc2.close();
		sc3.close();

		System.out.println("nWood");
		for (int i = 0; i < nWood.size() - 1; i++) {
			System.out.println("lvl:" + (i + 1) + "	nWood:" + nWood.get(i) + "	nTime:" + nTime.get(i) + "	workers:" + workers.get(i));
		}

		return lists;
	}

	private void stuffForTownWall() {
		// hp , armor, dmg, acc
		// if (lvl > 0) {
		// nSpecial1 = nSpecial1 + 50;
		// nSpecial2 = nSpecial2 + 4;
		// if (lvl == 1) {
		// nSpecial1 = 150;
		// nSpecial2 = 4;
		// nSpecial3 = 12;
		// nSpecial4 = 30;
		// } else if (lvl < 10)
		// nSpecial3 = nSpecial3 + 2;
		//
		// if (lvl == 10) {
		// nSpecial3 = 80;
		// nSpecial4 = 50;
		// }
		// if (lvl > 10 && lvl < 20)
		// nSpecial3 = nSpecial3 + 5;
		// if (lvl == 20) {
		// nSpecial3 = 250;
		// nSpecial4 = 80;
		// }
		// if (lvl > 20)
		// nSpecial3 = nSpecial3 + 10;
		//
		// }

	}

	public static List<IsleTemplate> parseIsleTemplates() throws IOException {
		List<IsleTemplate> result = new ArrayList<>();
		List<String> wrongWondersCoords = new ArrayList<>();

		int lineNumber = 0, wrongWonder = 0;
		String[] row = new String[4];
		File file = new File("isleTemplate2.txt");
		Scanner scanner;
		Scanner scanner2 = new Scanner(System.in);
		scanner = new Scanner(file);
		while (scanner.hasNextLine() || lineNumber < 10) {

			row = scanner.nextLine().split("	");
			System.out.println(++lineNumber + ":columns:" + row.length);
			//
			// for (String col : row) {
			// System.out.print("Col:" + col + " /");
			// }
			Wonder wonder = null;
			Stock stock = null;
			switch (row[2]) {
			case "Crystal": {
				stock = Stock.CRYSTAL;
				break;
			}
			case "Wine": {
				stock = Stock.WINE;
			}
			case "Marble": {
				stock = Stock.MARBLE;
				break;
			}
			case "Sulphur": {
				stock = Stock.SULPHUR;
				break;
			}
			default: {
				System.out.println("WRONG Stock NAME!");
				break;
			}
			}
			switch (row[3]) {
			case "POSEIDON": {
				wonder = Wonder.POSEIDON;
				break;
			}
			case "HERMES": {
				wonder = Wonder.HERMES;
				break;
			}
			case "HEPHAISTOS": {
				wonder = Wonder.HEPHAISTOS;
				break;
			}
			case "ARES": {
				wonder = Wonder.ARES;
				break;
			}
			case "HADES": {
				wonder = Wonder.HADES;
				break;
			}
			case "ATHENE": {
				wonder = Wonder.ATHENE;
				break;
			}
			case "COLOSSUS": {
				wonder = Wonder.COLOSSUS;
				break;
			}
			case "DEMETER": {
				wonder = Wonder.DEMETER;
				break;
			}
			default: {
				System.out.println("WRONG WONDER NAME!");
				wrongWonder++;
				wrongWondersCoords.add(row[1]);
				break;
			}
			}
			result.add(new IsleTemplate(row[0], row[1], stock, wonder));
		}
		scanner.close();
		scanner2.close();
		int x = 0;
		for (IsleTemplate it : result) {
			System.out.println(++x + ":" + it.toString());
		}
		x = 0;
		for (String it : wrongWondersCoords) {
			System.out.println(++x + ":" + it);
		}
		System.out.println("Wrong wonders:" + wrongWonder);
		return result;
	}
}
