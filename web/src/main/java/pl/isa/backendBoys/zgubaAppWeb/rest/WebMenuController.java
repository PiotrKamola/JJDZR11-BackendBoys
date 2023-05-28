package pl.isa.backendBoys.zgubaAppWeb.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.isa.backendBoys.zgubaAppWeb.request.RequestMenu;

@Controller
@RequestMapping("")
public class WebMenuController {
    RequestMenu requestMenu = new RequestMenu();

    @GetMapping("")
    public String menu(Model model) {
        model.addAttribute("searchWord", new SearchHelp());
        model.addAttribute(requestMenu);
//        requestToAdd.setRequesterLogin(requestMenu.loggedUserLogin);
        System.out.println();
        return "menu";
    }
}
