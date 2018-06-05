package pl.krasnowski.greeks.aTest;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.krasnowski.greeks.services.NotificationService;

@Controller
public class PostsController {
	@Autowired
	private PostService postService;

	@Autowired
	private NotificationService notifyService;

	@RequestMapping("/posts/view/{id}")
	public String view(@PathVariable("id") Long id, Model model, HttpServletRequest req) {
	//	 req.getSession().removeAttribute("siteNotificationMessages");

		Post post = postService.findById(id);
		if (post == null) {
			notifyService.addErrorMessage("Cannot find post #" + id);
			return "redirect:/";
		}
		model.addAttribute("post", post);
		return "posts/view";
	}
}
