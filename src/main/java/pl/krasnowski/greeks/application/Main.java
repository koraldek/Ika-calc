package pl.krasnowski.greeks.application;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.krasnowski.greeks.model.buildings.TownWall;
import pl.krasnowski.greeks.model.world.Stock;
import pl.krasnowski.greeks.model.world.World;
import pl.krasnowski.greeks.services.BuildingService;

public class Main {
	static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

	static BuildingService bService;

	public static void main(String[] args) throws IOException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.refresh();
		context.scan("pl.krasnowski.greeks");
		bService = (BuildingService) context.getBean(BuildingService.class);
		// sf = context.getBean(SessionFactory.class);
		TownWall townWall = (TownWall) bService.getLvl("TownWall", 10);
		System.out.println(townWall.toString());

		// BuildingService bService = (BuildingService) context.getBean(BuildingService.class);

		// List<ABuilding> bList = bService.listBuildings(Sawmill.class);
		// for (ABuilding b : bList) {
		// System.out.println(res(b));
		// }
//	SpeedWorld sWorld = null;
//		xaxa(sWorld);
		System.out.println("Koniec");
		context.close();
		/*
		 * World world = worldService.getWorld(name,country);
		 * Player player = new Player(name,pass,world);
		 * 
		 */
	}
	
	public static void xaxa(World world) {
		
	}

	// @SuppressWarnings("unused")
	// private static void addEntities() {
	// saveObjects(Academy.class);
	// saveObjects(AlchemistsTower.class);
	// saveObjects(ArchitectsOffice.class);
	// saveObjects(Barracks.class);
	// saveObjects(BlackMarket.class);
	// saveObjects(CarpentersWorkshop.class);
	// saveObjects(Depot.class);
	// saveObjects(Embassy.class);
	// saveObjects(FireworkTestArea.class);
	// saveObjects(ForestersHouse.class);
	// saveObjects(Glassblower.class);
	// saveObjects(GovernorsResidence.class);
	// saveObjects(Hideout.class);
	// saveObjects(LuxuryResource.class);
	// saveObjects(Museum.class);
	// saveObjects(Optician.class);
	// saveObjects(Palace.class);
	// saveObjects(PirateFortress.class);
	// saveObjects(Sawmill.class);
	// saveObjects(SeaChartArchive.class);
	// saveObjects(Shipyard.class);
	// saveObjects(Stonemason.class);
	// saveObjects(Tavern.class);
	// saveObjects(Temple.class);
	// saveObjects(Townhall.class);
	// saveObjects(TownWall.class);
	// saveObjects(TradingPort.class);
	// saveObjects(TradingPost.class);
	// saveObjects(Warehouse.class);
	// saveObjects(WinePress.class);
	// saveObjects(Winery.class);
	// saveObjects(Workshop.class);
	// }

	// public static <cz> void saveObjects(Class<?> clazz) {
	// SessionFactory sessionFactory;
	// sessionFactory = new Configuration().configure() // configures settings from hibernate.cfg.xml
	// .buildSessionFactory();
	// Session session = sessionFactory.openSession();
	// Transaction tx = session.beginTransaction();
	//
	// List<cz> list = DataParser2.getData(clazz);
	// for (cz o : list) {
	// session.save(o);
	// }
	// tx.commit();
	//
	// // @SuppressWarnings("unchecked")
	// // List<cz> result = session.createQuery("FROM " + clazz.getSimpleName()).list();
	// //
	// // for (cz el : result) {
	// // System.out.println(el.toString());
	// // }
	// session.close();
	// sessionFactory.close();
	// }



	public static String res(Object o) {

		StringBuilder result = new StringBuilder();
		String newLine = System.getProperty("line.separator");

		result.append(o.getClass().getSimpleName() + " {");
		result.append(newLine);

		Field[] f1 = o.getClass().getSuperclass().getDeclaredFields(); // returns inherited members.
		Field[] f2 = o.getClass().getDeclaredFields(); // returns all members including private members but not inherited members.
		List<Field> fields = new ArrayList<>();
		fields.addAll(Arrays.asList(f1));
		fields.addAll(Arrays.asList(f2));
		// print field names paired with their values
		for (Field field : fields) {
			result.append("  ");
			try {
				result.append(field.getName());
				result.append(": ");
				field.setAccessible(true); // requires access to private field:
				result.append(field.get(o));
			} catch (IllegalAccessException ex) {
				System.out.println(ex);
			}
			result.append(newLine);
		}
		result.append("}");

		return result.toString();
	}

}


