package pl.krasnowski.greeks.application;

import java.io.File;
import java.io.FileNotFoundException;
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

import pl.krasnowski.greeks.model.buildings.ABuilding;
import pl.krasnowski.greeks.model.buildings.Townhall;

@SuppressWarnings("unused")
public class DataParser {

	public static void main(String[] args) {
		getData();
	}

	@SuppressWarnings("unchecked")
	public static <E> List<E> getData() {
		E type;
		List<Townhall> testList = new ArrayList<>();
		List<E> list = new ArrayList<>();

		String[] rows;
		File file = new File("data_input.txt");
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			// PrintWriter zapis = new PrintWriter("data_input.txt");
			// while (scanner.hasNextLine()) {
			// String txt = scanner.nextLine().replaceAll(",", "");
			// zapis.println(txt);
			// }

			while (scanner.hasNextLine()) {
				rows = scanner.nextLine().split("	");
				long nTime = 0;

				for (String attribute : rows) {

					if (Pattern.matches("([0-9]+[a-zA-Z]+( )*)+", attribute)) { // sprawdza czy to tylko liczba
						nTime = 0; // reset time
						String time[] = attribute.split(" ");
						// TEST
						for (String xString : time) {
							System.out.println(xString);
						}
						// TEST
						for (String partTime : time) {
							if (Pattern.matches("[0-9]+D", partTime)) {
								partTime = partTime.replace("D", "");
								nTime = 86400 * Long.valueOf(partTime);
							}
							if (Pattern.matches("[0-9]+h", partTime)) {
								partTime = partTime.replace("h", "");
								nTime = nTime + 3600 * Long.valueOf(partTime);
							}
							if (Pattern.matches("[0-9]+m", partTime)) {
								partTime = partTime.replace("m", "");
								nTime = nTime + 60 * Long.valueOf(partTime);
							}
							if (Pattern.matches("[0-9]+s", partTime)) {
								partTime = partTime.replace("s", "");
								nTime = nTime + Long.valueOf(partTime);
							}
						}
					}

				}
				for (int i = 0; i < rows.length; i++) {
					rows[i] = rows[i].replace(" ", "");
					if (rows[i].equals("")) // valueOf could throw exception
						rows[i] = "0";
				}

				int lvl = Integer.valueOf(rows[0]);
				int nWood = Integer.valueOf(rows[1]);
				int nMarble = Integer.valueOf(rows[2]);
				int nWine = 0;
				int nCrystal = 0;
				int nSulphur = 0;
				int special1 = Integer.valueOf(rows[4]);
				// int special2 = Integer.valueOf(rows[5]);
				// int special3 = Integer.valueOf(rows[6]);

				// int special1 = Integer.valueOf(rows[3]);
				// int special2 = Integer.valueOf(rows[4]);

				list.add((E) new Townhall(lvl, nWood, nTime, nMarble, special1, special1));

				// testList.add(new Townhall(lvl, nWood, nMarble, (int) nTime, special2));
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		for (E o : list) {
			System.out.println(((ABuilding) o).getLvl() + " | " + ((ABuilding) o).getnWood() + " | " + ((ABuilding) o).getnTime() + " | ");
		}

		// for (Townhall o : testList) {
		// System.out.println(o.getLvl() + " | " + o.getnWood() + " | " + o.getnTime() + " | " + o.getnMarble() + " | " + o.getMaxCitizen() + " | ");
		// }
		return list;
	}

}
