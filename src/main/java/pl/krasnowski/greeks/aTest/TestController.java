package pl.krasnowski.greeks.aTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.krasnowski.greeks.application.Product;
import pl.krasnowski.greeks.model.buildings.ABuilding;
import pl.krasnowski.greeks.model.buildings.TownWall;
import pl.krasnowski.greeks.services.BuildingService;

@Controller
public class TestController {
	
//	   /*---Add new book---*/
//	   @PostMapping("/world")
//	   public ResponseEntity<?> save(@RequestBody World world) {
//	      long id = wService.save(world);
//	      return ResponseEntity.ok().body("New Book has been saved with ID:" + id);
//	   }
	
	/*
	 * ===============d===============================
	 */
    
    
	@Autowired
	private BuildingService buildingService;

	@RequestMapping(value = "/buildings", method = RequestMethod.GET)
	public String listBuildings(Model model) {
		List<ABuilding> bList = new ArrayList<ABuilding>();
		bList = this.buildingService.listBuildings(TownWall.class);

		model.addAttribute("listBuildings", bList);
		return "buildings";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String messages(Model model) {
		Product x = new Product("Ciepla kupa", 159, new Date());
		model.addAttribute("product", x);
		return "test";
	}
    
    
    

}