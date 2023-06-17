package pl.isa.backendBoys.zgubaAppWeb.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.isa.backendBoys.zgubaAppWeb.user.UserController;

@Controller
@RequestMapping("")
public class WebMenuController {

    final
    UserController userController;

    public WebMenuController(UserController userController) {
        this.userController = userController;
    }

    @GetMapping("")
    public String menu(Model model) {
        model.addAttribute("searchWord", new SearchHelp());
        model.addAttribute("loggedUser", userController.getLoggedUserEmail());
        model.addAttribute("content", "index");
        return "main";
    }
}
