package pl.krasnowski.greeks.model.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fasterxml.jackson.annotation.JsonView;

public class AjaxController {

	List<Zdarzenie> events;
	List<User> users;

	// @ResponseBody, not necessary, since class is annotated with @RestController
	// @RequestBody - Convert the json data into object (SearchCriteria) mapped by field name.
	// @JsonView(Views.Public.class) - Optional, limited the json data display to client.
	@JsonView(Views.Public.class)
	@RequestMapping(value = "/search/api/getSearchResult")
	public AjaxResponseBody getSearchResultViaAjax(@RequestBody SearchCriteria search) {
		AjaxResponseBody result = new AjaxResponseBody();

		if (isValidSearchCriteria(search)) {
			List<User> users = findByUserNameOrEmail(search.getUsername(), search.getPassword());

			if (users.size() > 0) {
				result.setCode("200");
				result.setMsg("");
			} else {
				result.setCode("204");
				result.setMsg("No user!");
			}

		} else {
			result.setCode("400");
			result.setMsg("Search criteria is empty!");
		}

		// AjaxResponseBody will be converted into json format and send back to client.
		return result;
	}

	private boolean isValidSearchCriteria(SearchCriteria search) {

		boolean valid = true;

		if (search == null) {
			valid = false;
		}

		if ((StringUtils.isEmpty(search.getUsername())) && (StringUtils.isEmpty(search.getPassword()))) {
			valid = false;
		}

		return valid;
	}

	@JsonView(Views.Public.class)
	@RequestMapping(value = "/search/api/getPosition")
	public AjaxResponseBody getPositiontViaAjax(@RequestBody PositionCriteria positionInput) {

		AjaxResponseBody result = new AjaxResponseBody();

		if (isValidPositionCriteria(positionInput)) {
			String opis = "Position X:" + positionInput.getPosX() + " || Position Y:" + positionInput.getPosY();
			Zdarzenie zdarzenie = new Zdarzenie(new Date(), opis);
			events.add(zdarzenie);
			System.err.println(zdarzenie);
			if (users.size() > 0) {
				result.setCode("200");
				result.setMsg("");
			} else {
				result.setCode("204");
				result.setMsg("No user!");
			}

		} else {
			result.setCode("400");
			result.setMsg("Position is empty!");
		}

		// AjaxResponseBody will be converted into json format and send back to client.
		return result;
	}

	private boolean isValidPositionCriteria(PositionCriteria search) {

		boolean valid = true;

		if (search == null) {
			valid = false;
		}

		if (((search.getPosX()) == 0.0) && (StringUtils.isEmpty(search.getPosY() == 0.0))) {
			valid = false;
		}

		return valid;
	}

	// Init some users for testing
	@PostConstruct
	private void iniDataForTesting() {
		users = new ArrayList<>();
		events = new ArrayList<>();

		User user1 = new User("mkyong", "pass123", "mkyong@yahoo.com", "012-1234567", "address 123");
		User user2 = new User("yflow", "pass456", "yflow@yahoo.com", "016-7654321", "address 456");
		User user3 = new User("laplap", "pass789", "mkyong@yahoo.com", "012-111111", "address 789");
		users.add(user1);
		users.add(user2);
		users.add(user3);

	}

	// Simulate the search function
	private List<User> findByUserNameOrEmail(String username, String email) {
		List<User> result = new ArrayList<User>();

		for (User user : users) {
			if ((!StringUtils.isEmpty(username)) && (!StringUtils.isEmpty(email))) {
				if (username.equals(user.getUsername()) && email.equals(user.getEmail())) {
					result.add(user);
					continue;
				} else
					continue;
			}
			if (!StringUtils.isEmpty(username)) {
				if (username.equals(user.getUsername()))
					result.add(user);
			}

			if (!StringUtils.isEmpty(email)) {
				if (email.equals(user.getEmail()))
					result.add(user);
			}
		}
		return result;
	}
}
