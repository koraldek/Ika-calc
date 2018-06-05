package pl.krasnowski.greeks.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// oraz daty na ilosc czasu w sekundach (regexy)
public class IsleDevelopment implements Profit { // TODO: przenieść do osobnej paczki z logiką biznesową

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		// String fileName = "Sawmill_data.csv";

		// List<String[]> SawmillData = readData("Sawmill_data.txt");
		List<String[]> LuxuryGoodsData = readData("LuxuryGoods_data.txt");
		int currSMLvl = 26;
		int currWealthLvl = 17;
		int VMarble = 10;
		int VWood = 5;

		// CalculateProfit("tartak",SawmillData, VWood);
		CalculateProfit("kamieniołom", LuxuryGoodsData, VMarble);
		printData(LuxuryGoodsData);
		// printData(SawmillData);

	}

	public static void CalculateProfit(String objN, List<String[]> dataInput, int Value) {
		for (int i = 1; i < dataInput.size() - 1; i++) {
			double profit = CalculateProfit(
					Integer.valueOf(dataInput.get(i)[3]), // pracownicy teraz
					Integer.valueOf(dataInput.get(i + 1)[3]), // pracownicy na przyszlym poziomie
					Integer.valueOf(dataInput.get(i + 1)[1]), // koszt rozbudowy
					Value);

			System.out.println("Profit rozbudowy " + objN + " " + dataInput.get(i)[0] + "->" + (Integer.valueOf(dataInput.get(i)[0]) + 1) + " wynosi:" + profit + " %.");
		}

	}

	public static double CalculateProfit(double currWorkers, double workersOnNextLvl, double toLvlUp, int resValue) {
		double AdditionalWorkers = (currWorkers - workersOnNextLvl) * 100;
		return ((AdditionalWorkers / toLvlUp) * resValue);
	}

	public static List<String[]> readData(String fileName) throws IOException {
		List<String[]> outList = new ArrayList<String[]>();
		Scanner odczyt = new Scanner(new File(fileName));
		System.out.println("fileName" + fileName);
		int i = 0;
		System.out.println(odczyt.hasNextLine());
		while (odczyt.hasNextLine()) {
			String row = odczyt.nextLine();
			row = row.replace(",", "");
			outList.add(row.split(";"));
			System.out.println(i);
			i++;
		}
		odczyt.close();
		return outList;
	}

	public static void printData(List<String[]> list) {
		for (String[] row : list) {
			for (String col : row) {
				String indent = "                    "; // 20 spaces. Dla zachowania wyglądu.
				indent = indent.substring(0, indent.length() - col.length());
				System.out.print(col + indent);
			}
			System.out.println();
		}
	}

	@SuppressWarnings("unused")
	private static int rowCount(Reader in) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(in);
		String input;
		int count = 0;
		while ((input = bufferedReader.readLine()) != null) {
			count++;
		}
		return count;
	}

	// public void addCity(City city) {
	// if (cities.size() < 16)
	// this.cities.add(city);
	// else
	// System.out.println("There is 16 cities! If you want to create there new city, you must use ambrosia.");
	// }

}
