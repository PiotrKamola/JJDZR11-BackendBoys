package pl.isa.backendBoys.zgubaAppWeb.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.isa.backendBoys.zgubaAppWeb.user.User;
import pl.isa.backendBoys.zgubaAppWeb.user.UserController;

@Controller
@RequestMapping("api/user")
public class WebUserConroller {
    final UserController userController = new UserController();

    @GetMapping("")
    public String userMenu() {
        return "userMenu";
    }

    @GetMapping("/register")
    public String registerUser(Model model) {
        model.addAttribute("userToAdd", new User());
        return "register";
    }

    @PostMapping("/addedNewUser")
    public String addNewUser(Model model, @ModelAttribute User userToAdd) {
        userController.registerUser(userToAdd);
        model.addAttribute(userToAdd);
        userToAdd.nicePrint();
        return "addedNewUser";
    }

    @GetMapping("/login")
    public String loginUser(Model model, @ModelAttribute User userToLogin) {
        userController.registerUser(userToLogin);
        return "login";
    }
}
