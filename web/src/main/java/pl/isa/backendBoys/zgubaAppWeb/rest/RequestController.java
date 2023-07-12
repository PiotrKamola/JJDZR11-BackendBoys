package pl.isa.backendBoys.zgubaAppWeb.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.isa.backendBoys.zgubaAppWeb.database.MySqlService;
import pl.isa.backendBoys.zgubaAppWeb.request.Request;
import pl.isa.backendBoys.zgubaAppWeb.request.RequestService;
import pl.isa.backendBoys.zgubaAppWeb.search.SearchHelp;
import pl.isa.backendBoys.zgubaAppWeb.search.SearchService;
import pl.isa.backendBoys.zgubaAppWeb.user.UserService;

import java.util.List;

@Controller
@RequestMapping("request")
public class RequestController {

    private final UserService userService;
    private final RequestService requestService;
    private final SearchService searchService;
    private final MySqlService mySqlService;

    public RequestController(RequestService requestService,
                                SearchService searchService,
                                UserService userService,
                                MySqlService mySqlService) {
        this.requestService = requestService;
        this.searchService = searchService;
        this.userService = userService;
        this.mySqlService = mySqlService;
    }

    @GetMapping("/all")
    public String allRequests(Model model) {
        model.addAttribute("searchWord", new SearchHelp());
        model.addAttribute("allRequests", requestService.getAllRequests());
        model.addAttribute("loggedUserEmail", userService.getLoggedUserEmail());
        model.addAttribute("content", "allRequests");
        return "main";
    }

    @GetMapping("/mineRequests")
    public String mineRequests(Model model, @ModelAttribute SearchHelp searchWord) {
        model.addAttribute("loggedUserEmail", userService.getLoggedUserEmail());
        List<Request> searchList = searchService.searchByWord(requestService.getAllRequests(), userService.getLoggedUserEmail());

        model.addAttribute("allRequests", searchList);
        model.addAttribute("searchWord", new SearchHelp());
        model.addAttribute("content", "allRequests");
        return "main";

    }
    @GetMapping("/submitted")
    public String submittedRequest(Model model) {
        model.addAttribute("searchWord", new SearchHelp());
        model.addAttribute("loggedUserEmail", userService.getLoggedUserEmail());
        model.addAttribute("content", "submittedRequest");
        return "main";
    }

    @PostMapping("/submitted")
    public String addNewRequest(Model model, @ModelAttribute Request requestToAdd) {
        model.addAttribute("searchWord", new SearchHelp());
        model.addAttribute(requestToAdd);
        model.addAttribute("loggedUserEmail", userService.getLoggedUserEmail());
        requestToAdd.setUser(userService.getUserByLogin(userService.getLoggedUserEmail()));
        requestService.addRequest(requestToAdd);
        mySqlService.addNewRequest(requestToAdd);
        model.addAttribute("content", "submittedRequest");
        return "main";
    }

    @GetMapping("/add")
    public String addRequest(Model model) {
        model.addAttribute("searchWord", new SearchHelp());
        model.addAttribute("requestToAdd", new Request());
        model.addAttribute("loggedUserEmail", userService.getLoggedUserEmail());
        model.addAttribute("enum", Request.LostOrFound.class.getName());
        model.addAttribute("content", "addRequest");
        return "main";
    }


    @PostMapping("/search")
    public String search(Model model, @ModelAttribute SearchHelp searchWord) {
        model.addAttribute(searchWord);
        model.addAttribute("loggedUserEmail", userService.getLoggedUserEmail());
        List<Request> searchList = searchService.searchByWord(requestService.getAllRequests(), searchWord.getSearchWord());

        model.addAttribute("allRequests", searchList);
        model.addAttribute("searchWord", new SearchHelp());
        model.addAttribute("String", searchWord.getSearchWord());
        model.addAttribute("Integer", searchList.size());
        model.addAttribute("content", "allRequests");
        return "main";

    }
}
