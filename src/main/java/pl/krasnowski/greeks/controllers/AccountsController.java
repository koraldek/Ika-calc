package pl.krasnowski.greeks.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fasterxml.jackson.annotation.JsonView;

import pl.krasnowski.greeks.model.api.AjaxResponseBody;
import pl.krasnowski.greeks.model.api.Views;
import pl.krasnowski.greeks.model.forms.LoginForm;
import pl.krasnowski.greeks.model.forms.RegisterForm;
import pl.krasnowski.greeks.model.users.Player;
import pl.krasnowski.greeks.model.world.World;
import pl.krasnowski.greeks.services.AccountsService;
import pl.krasnowski.greeks.services.NotificationService;
import pl.krasnowski.greeks.services.WorldService;

//@RestController("/user")
@Controller
@Scope("request")
public class AccountsController {
	final static Logger debugLog = LoggerFactory.getLogger("debugLogger");
	final static Logger resultLog = LoggerFactory.getLogger("resultsLogger");

	@Autowired
	AccountsService accountsService;
	@Autowired
	WorldService worldService;

	@Autowired
	List<World> worldsList;

	@Autowired
	private NotificationService notifyService;
	@Autowired
	private Player player;


	@GetMapping(value = "/login")
	public String LoginPageGet(LoginForm loginForm) {
		return "/accounts/login";
	}

	@PostMapping(value = "/login")
	public String loginPage(@Valid LoginForm loginForm, BindingResult bindingResult) {
		System.out.println(loginForm.toString());
		if (bindingResult.hasErrors()) {
			notifyService.addErrorMessage("Please fill the form correctly!");
			return "/accounts/login";
		}

		if (accountsService.validateServerAccount(loginForm)) {
			notifyService.addInfoMessage("Login successful");
			player = (Player) accountsService.loginToServer(loginForm);
			return "redirect:/";
		} else {
			notifyService.addErrorMessage("Invalid login!");
			return "accounts/login";
		}
	}

	@GetMapping(value = "/register")
	public String RegisterPageGet(Model model ) {
		 model.addAttribute("worldsList", worldsList);
		 model.addAttribute("registerForm", new RegisterForm());
		 
		return "accounts/register";
	}

	@PostMapping(value = "/register")
	public String registerToServer(@Valid RegisterForm registerForm, BindingResult bindingResult) {
		System.out.println("Signing up user:" + registerForm.toString());
		player = accountsService.registerToServer(registerForm);

		if (player.equals(null)) {
			notifyService.addErrorMessage("Failed to register user.");
			return "accounts/register";
		} else {
			notifyService.addInfoMessage("Register successful");
		}

		if (registerForm.getRegisterToGame())
			player = accountsService.registerToGame((Player) player);
		return "redirect:/";
	}

	@JsonView(Views.Public.class)
	@RequestMapping(value = "/search/api/login")
	public AjaxResponseBody loginToServer2(@RequestBody LoginForm loginForm) {
		System.out.println("loginToserver2:" + loginForm.toString());

		AjaxResponseBody result = new AjaxResponseBody();
		// HttpSession session = req.getSession();
		// if (session.isNew())
		// debugLog.info("Creating new session for user:" + loginCriteria.getUsername() + ", session ID:" + session.getId());

		if (accountsService.validateServerAccount(loginForm)) {
			player = (Player) accountsService.loginToServer(loginForm);
			result.setCode("200");
			result.setMsg("");
		} else {
			result.setCode("400");
			result.setMsg("Wrong username or password!");
		}
		// AjaxResponseBody will be converted into json format and send back to client.
		return result;
	}

	// Init some users for testing
	@PostConstruct
	private void iniDataForTesting() {
		// users = new ArrayList<>();
		// events = new ArrayList<>();
		//
		// User user1 = new User("mkyong", "pass123", "mkyong@yahoo.com", "012-1234567", "address 123");
		// User user2 = new User("yflow", "pass456", "yflow@yahoo.com", "016-7654321", "address 456");
		// User user3 = new User("laplap", "pass789", "mkyong@yahoo.com", "012-111111", "address 789");
		// User user4 = new User("adam", "123", "korald@yahoo.com", "012-111111", "address 789");
		// users.add(user1);
		// users.add(user2);
		// users.add(user3);
		// users.add(user4);
	}



}
