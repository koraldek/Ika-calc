package pl.krasnowski.greeks.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataParser3 {

	public static void main(String[] args) throws FileNotFoundException {
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
	//		System.out.println("lvl:" + (i + 1) + "	nWood:" + nWood.get(i) + "	nTime:" + nTime.get(i) + "	workers:" + workers.get(i));
			System.out.println((i + 1) + "	" + nWood.get(i) + "	" + nTime.get(i) + "	" + workers.get(i));
		}

			
	}

}
