package pl.isa.backendBoys.zgubaAppWeb.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.isa.backendBoys.zgubaAppWeb.search.SearchHelp;
import pl.isa.backendBoys.zgubaAppWeb.user.UserService;

@Controller
@RequestMapping("")
public class MainController {

    final UserService userService;
    //wywalic userservice aw rzucic jedynie zmiennaa loggedUserEmail i tam sie odniesc dotego
    // sprobowac zrobic klase gdzie bede tylko  przekazywal model i go wzbogacał

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String menu(Model model) {
        model.addAttribute("searchWord", new SearchHelp());
        model.addAttribute("loggedUserEmail", userService.getLoggedUserEmail());
        model.addAttribute("content", "index");
        return "main";
    }

    @GetMapping("/about")
    public String aboutZguba(Model model) {
        model.addAttribute("searchWord", new SearchHelp());
        model.addAttribute("loggedUserEmail", userService.getLoggedUserEmail());
        model.addAttribute("content", "about");
        return "main";
    }



}
