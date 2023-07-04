package pl.isa.backendBoys.zgubaAppWeb.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.isa.backendBoys.zgubaAppWeb.search.SearchHelp;
import pl.isa.backendBoys.zgubaAppWeb.user.UserService;

@Controller
@RequestMapping("")
public class MainController {

    final
    UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String menu(Model model) {
        model.addAttribute("searchWord", new SearchHelp());
        model.addAttribute("loggedUser", userService.getLoggedUserEmail());
        model.addAttribute("content", "index");
        return "main";
    }

    @GetMapping("/about")
    public String aboutZguba(Model model) {
        model.addAttribute("searchWord", new SearchHelp());
        model.addAttribute("loggedUser", userService.getLoggedUserEmail());
        model.addAttribute("content", "about");
        return "main";
    }



}
