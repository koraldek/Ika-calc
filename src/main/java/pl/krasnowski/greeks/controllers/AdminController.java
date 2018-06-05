package pl.krasnowski.greeks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.krasnowski.greeks.model.world.World;
import pl.krasnowski.greeks.services.AccountsService;
import pl.krasnowski.greeks.services.WorldService;

@Controller
// @RequestMapping("/admin")
public class AdminController {

	@Autowired
	WorldService wService;

	@Autowired
	AccountsService aService;

	@RequestMapping("/admin")
	public String admin(Model model) {
		model.addAttribute(new World());
		System.err.println("admin...");
		return "/admin/home";
	}

	@PostMapping("/admin/world/create")
	public String createWorld(@ModelAttribute World world) {
		System.err.println("admin - create post");
		System.out.println(world.toString());
		wService.createWorld(world);
		return "/admin/home";
	}

	@GetMapping("/admin/worlds")
	public String showWorlds(Model model) {
		model.addAttribute("worlds", wService.getWorlds());
		System.err.println("showWorlds controller");
		return "/admin/home";
	}

	// @Mapping("/admin/world/{id}")
	public String editWorld() { // TODO: coś z id w url'u
		System.err.println("showWorlds controller");
		return "/admin/home";
	}



}
