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

    final
    UserController userController;

    public WebUserConroller(UserController userController) {
        this.userController = userController;
    }

    @GetMapping("")
    public String userMenu(Model model) {
        model.addAttribute(userController);
        return "userMenu";
    }

    @GetMapping("/register")
    public String registerUser(Model model) {
        model.addAttribute("userToAdd", new User());
        model.addAttribute("showError" ,false);
        return "register";
    }

    @PostMapping("/register")
    public String registerWrongUser(Model model, @ModelAttribute User userToAdd) {
        model.addAttribute("userToAdd", new User());
        if(userController.isLoginTaken(userToAdd.getLoginEmail())){
            model.addAttribute("showError" ,true);
            return "register";
        }else{
            model.addAttribute("showError" ,false);
            userController.registerUser(userToAdd);
            return "addedNewUser";
        }
    }

    @GetMapping("/login")
    public String loginUser(Model model, @ModelAttribute UserToLogin userToLogin) {
        model.addAttribute(userToLogin);
        model.addAttribute("showError" ,false);
        return "login";
    }

    @PostMapping("/login")
    public String logegdUser(Model model, @ModelAttribute UserToLogin userToLogin) {
        model.addAttribute(userToLogin);
        model.addAttribute(userController);
        if (userController.loginUser(userToLogin.getLogin(), userToLogin.getPassword())) {
            return "loggedIn";
        } else {
            model.addAttribute("showError" ,true);
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(){
        userController.logout();
        return "logout";
    }

}
