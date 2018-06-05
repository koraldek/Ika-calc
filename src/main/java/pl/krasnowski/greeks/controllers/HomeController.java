package pl.krasnowski.greeks.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.krasnowski.greeks.aTest.Post;
import pl.krasnowski.greeks.aTest.PostService;

@Controller
public class HomeController {
	@Autowired
	private PostService postService;



	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}

	@RequestMapping("/")
	public String index(Model model) {
		List<Post> latest5Posts = postService.findLatest5();
		model.addAttribute("latest5posts", latest5Posts);

		List<Post> latest3Posts = latest5Posts.stream().limit(3).collect(Collectors.toList());
		model.addAttribute("latest3posts", latest3Posts);
		return "index";
	}

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@RequestMapping("/user")
	public String user() {
		return "user";
	}

	@RequestMapping("/about")
	public String about() {
		return "about";
	}

	@GetMapping("/403")
	public String error403() {
		return "error/403";
	}

}
