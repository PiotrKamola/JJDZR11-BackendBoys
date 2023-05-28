package pl.isa.backendBoys.zgubaAppWeb.rest;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    UserController userController;

    @GetMapping("")
    public String userMenu(Model model) {
        model.addAttribute(userController);
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
    public String loginUser(Model model, @ModelAttribute UserToLogin userToLogin) {
        model.addAttribute(userToLogin);
        return "login";
    }

    @PostMapping("/loggedIn")
    public String loggedIn(Model model, @ModelAttribute UserToLogin userToLogin) {
        model.addAttribute(userToLogin);
        model.addAttribute(userController);
        if (userController.loginUser(userToLogin.getLogin(), userToLogin.getPassword())) {
            System.out.println(userToLogin.getLogin());
            System.out.println(userToLogin.getPassword());
            return "loggedIn";
        } else {
            return "NOTloggedIn";
        }
    }

    @GetMapping("/logout")
    public String logout(){
        userController.logout();
        return "logout";
    }

}
