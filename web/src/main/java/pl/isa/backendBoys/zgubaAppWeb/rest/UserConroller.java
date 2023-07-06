package pl.isa.backendBoys.zgubaAppWeb.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.isa.backendBoys.zgubaAppWeb.search.SearchHelp;
import pl.isa.backendBoys.zgubaAppWeb.user.User;
import pl.isa.backendBoys.zgubaAppWeb.user.UserDto;
import pl.isa.backendBoys.zgubaAppWeb.user.UserService;

@Controller
@RequestMapping("user")
public class UserConroller {

    final UserService userService;

    public UserConroller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginUser(Model model, @ModelAttribute UserDto userDto) {
        model.addAttribute("searchWord", new SearchHelp());
        model.addAttribute(userDto);
        model.addAttribute("showError", false);
        model.addAttribute("content", "login");
        return "main";
    }

    @PostMapping("/login")
    public String loggedUser(Model model, @ModelAttribute UserDto userDto) {
        model.addAttribute("searchWord", new SearchHelp());
        model.addAttribute(userDto);
        model.addAttribute(userService);
        if (userService.loginUser(userDto.getLogin(), userDto.getPassword())) {
            model.addAttribute("loggedUserEmail", userService.getLoggedUserEmail());
            model.addAttribute("content", "loggedIn");
        } else {
            model.addAttribute("showError", true);
            model.addAttribute("content", "login");
        }
        return "main";

    }

    @GetMapping("/logout")
    public String logout(Model model) {
        model.addAttribute("searchWord", new SearchHelp());
        userService.logout();
        model.addAttribute("content", "logout");
        return "main";
    }

    @GetMapping("/register")
    public String registerUser(Model model) {
        model.addAttribute("searchWord", new SearchHelp());
        model.addAttribute("userToAdd", new User());
        model.addAttribute("showError", false);
        model.addAttribute("content", "register");
        return "main";
    }

    @PostMapping("/register")
    public String registerWrongUser(Model model, @ModelAttribute User userToAdd) {
        model.addAttribute("searchWord", new SearchHelp());
        model.addAttribute("userToAdd", new User());
        if (userService.isLoginTaken(userToAdd.getLoginEmail())) {
            model.addAttribute("showError", true);
            model.addAttribute("content", "register");
        } else {
            model.addAttribute("showError", false);
            userService.registerUser(userToAdd);
            model.addAttribute("content", "addedNewUser");
        }
        return "main";
    }

    @GetMapping("/panel")
    public String userPanel(Model model) {
        model.addAttribute("loggedUserEmail", userService.getLoggedUserEmail());
        model.addAttribute("searchWord", new SearchHelp());
        model.addAttribute("content", "userPanel");
        return "main";
    }


    @GetMapping("/panel/showUserData")
    public String showUserData(Model model) {
        String loggedUserEmail = userService.getLoggedUserEmail();
        User loggedUser = userService.getUserByLogin(loggedUserEmail);
        model.addAttribute("loggedUserEmail", loggedUserEmail);
        model.addAttribute("userToModify", loggedUser);
        model.addAttribute("searchWord", new SearchHelp());
        model.addAttribute("modify", false);
        model.addAttribute("content", "userPanel_userData");
        return "main";
    }

    @GetMapping("/panel/changeUserData")
    public String getChangeUserData(Model model, @ModelAttribute User userToModify) {
        String loggedUserEmail = userService.getLoggedUserEmail();
        User loggedUser = userService.getUserByLogin(loggedUserEmail);
        model.addAttribute("loggedUserEmail", loggedUserEmail);
        model.addAttribute("userToModify", loggedUser);
        model.addAttribute("searchWord", new SearchHelp());
        model.addAttribute("modify", true);
        model.addAttribute("content", "userPanel_userData");
        return "main";
    }
    @PostMapping("/panel/changeUserData")
    public String postChangeUserData(Model model, @ModelAttribute User userToModify) {
        String loggedUserEmail = userService.getLoggedUserEmail();
        User loggedUser = userService.getUserByLogin(loggedUserEmail);
        model.addAttribute("loggedUserEmail", loggedUserEmail);
        model.addAttribute("searchWord", new SearchHelp());
        model.addAttribute("modify", true);

        if (loggedUser.getPassword().equals(userToModify.getPassword())) {
            userService.changeUserName(loggedUser, userToModify.getName());
            userService.changeUserCity(loggedUser, userToModify.getCity());
            userService.changeUserContactNumber(loggedUser, userToModify.getContactNumber());

            model.addAttribute("userToModify", loggedUser);
            model.addAttribute("content", "userPanel_userData_modified");
        } else {
            model.addAttribute("userToModify", userToModify);
            model.addAttribute("showError", true);
            model.addAttribute("content", "userPanel_userData");
        }

        return "main";
    }


    @GetMapping("/panel/logindata")
    public String showLoginData(Model model) {
        String loggedUserEmail = userService.getLoggedUserEmail();
        User loggedUser = userService.getUserByLogin(loggedUserEmail);
        model.addAttribute("loggedUserEmail", loggedUserEmail);
        model.addAttribute("userToModify", loggedUser);
        model.addAttribute("searchWord", new SearchHelp());
        model.addAttribute("modify", false);
        model.addAttribute("content", "userPanel_loginData");
        return "main";
    }

    @GetMapping("/panel/logindata/change")
    public String ChangeloginDataGet(Model model) {
        String loggedUserEmail = userService.getLoggedUserEmail();
        User loggedUser = userService.getUserByLogin(loggedUserEmail);
        model.addAttribute("loggedUserEmail", loggedUserEmail);
        model.addAttribute("userToModify", loggedUser);
        model.addAttribute("searchWord", new SearchHelp());
        model.addAttribute("modify", true);
        model.addAttribute("content", "userPanel_loginData");
        return "main";
    }

    @PostMapping("/panel/logindata/change")
    public String ChangeloginDataPost(Model model, @ModelAttribute User userToModify) {
        String loggedUserEmail = userService.getLoggedUserEmail();
        User loggedUser = userService.getUserByLogin(loggedUserEmail);
        model.addAttribute("loggedUserEmail", loggedUserEmail);
        model.addAttribute("searchWord", new SearchHelp());
        model.addAttribute("modify", true);

        if (userService.isLoginTaken(userToModify.getLoginEmail())) {
            model.addAttribute("userToModify", userToModify);
            model.addAttribute("showErrorLogin", true);
            model.addAttribute("content", "userPanel_loginData");
            return "main";
        }

        if (loggedUser.getPassword().equals(userToModify.getPassword())) {
            userService.changeUserLogin(loggedUser, userToModify.getLoginEmail());
            userService.changeUserPassword(loggedUser, userToModify.getPassword());

            model.addAttribute("userToModify", loggedUser);
            model.addAttribute("content", "userPanel_loginData_modified");
        } else {
            model.addAttribute("userToModify", userToModify);
            model.addAttribute("showErrorPassword", true);
            model.addAttribute("content", "userPanel_loginData");
        }

        return "main";
    }

//    @PostMapping("/register")
//    public String registerWrongUser(Model model, @ModelAttribute User userToAdd) {
//        model.addAttribute("searchWord", new SearchHelp());
//        model.addAttribute("userToAdd", new User());
//        if (userService.isLoginTaken(userToAdd.getLoginEmail())) {
//            model.addAttribute("showError", true);
//            model.addAttribute("content", "register");
//        } else {
//            model.addAttribute("showError", false);
//            userService.registerUser(userToAdd);
//            model.addAttribute("content", "addedNewUser");
//        }
//        return "main";
//    }


}
