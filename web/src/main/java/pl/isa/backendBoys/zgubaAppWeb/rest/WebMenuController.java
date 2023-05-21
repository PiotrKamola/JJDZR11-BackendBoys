package pl.isa.backendBoys.zgubaAppWeb.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class WebMenuController {


    @GetMapping("")
    public String menu(Model model) {
        model.addAttribute("searchWord", new searchHelp());
        System.out.println();
        return "menu";
    }
}
