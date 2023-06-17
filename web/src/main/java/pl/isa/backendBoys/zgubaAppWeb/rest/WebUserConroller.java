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
@RequestMapping("user")
public class WebUserConroller {

    final
    UserController userController;

    public WebUserConroller(UserController userController) {
        this.userController = userController;
    }

    @GetMapping("/login")
    public String loginUser(Model model, @ModelAttribute UserToLogin userToLogin) {
        model.addAttribute("searchWord", new SearchHelp());
        model.addAttribute(userToLogin);
        model.addAttribute("showError" ,false);
        model.addAttribute("content", "login");
        return "main";
    }

    @PostMapping("/login")
    public String logegdUser(Model model, @ModelAttribute UserToLogin userToLogin) {
        model.addAttribute("searchWord", new SearchHelp());
        model.addAttribute(userToLogin);
        model.addAttribute(userController);
        if (userController.loginUser(userToLogin.getLogin(), userToLogin.getPassword())) {
            model.addAttribute("loggedUser", userController.getLoggedUserEmail());
            model.addAttribute("content", "loggedIn");
            return "main";
        } else {
            model.addAttribute("showError" ,true);
            model.addAttribute("content", "login");
            return "main";
        }
    }

    @GetMapping("/logout")
    public String logout(Model model){
        model.addAttribute("searchWord", new SearchHelp());
        userController.logout();
        model.addAttribute("content", "logout");
        return "main";
    }

    @GetMapping("/register")
    public String registerUser(Model model) {
        model.addAttribute("searchWord", new SearchHelp());
        model.addAttribute("userToAdd", new User());
        model.addAttribute("showError" ,false);
        model.addAttribute("content", "register");
        return "main";
    }

    @PostMapping("/register")
    public String registerWrongUser(Model model, @ModelAttribute User userToAdd) {
        model.addAttribute("searchWord", new SearchHelp());
        model.addAttribute("userToAdd", new User());
        if(userController.isLoginTaken(userToAdd.getLoginEmail())){
            model.addAttribute("showError" ,true);
            model.addAttribute("content", "register");
            return "main";

        }else{
            model.addAttribute("showError" ,false);
            userController.registerUser(userToAdd);
            model.addAttribute("content", "addedNewUser");
            return "main";
        }
    }
}
