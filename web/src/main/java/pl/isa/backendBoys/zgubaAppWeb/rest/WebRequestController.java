package pl.isa.backendBoys.zgubaAppWeb.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.isa.backendBoys.zgubaAppWeb.request.Request;
import pl.isa.backendBoys.zgubaAppWeb.request.RequestController;
import pl.isa.backendBoys.zgubaAppWeb.request.RequestMenu;
import pl.isa.backendBoys.zgubaAppWeb.search.SearchController;

import java.util.List;

@Controller
@RequestMapping("api/request")
public class WebRequestController {

    final RequestController requestController = new RequestController();
    final SearchController searchController = new SearchController();

    @GetMapping("/submitted")
    public String submittedRequest(Model model) {
        return "submittedRequest";
    }

    @PostMapping("/submitted")
    public String addNewRequest(Model model, @ModelAttribute Request requestToAdd) {
        RequestMenu requestMenu = new RequestMenu();
        model.addAttribute(requestToAdd);
        requestToAdd.setRequesterLogin(requestMenu.loggedUserLogin);
        requestController.addRequest(requestToAdd);
        requestToAdd.nicePrint();
        return "submittedRequest";
    }

    @GetMapping("/add")
    public String addRequest(Model model) {
        model.addAttribute("requestToAdd", new Request());
        model.addAttribute("enum", Request.LostOrFound.class.getName());
        return "addRequest";
    }

    @GetMapping("/all")
    public String allRequests(Model model) {
        model.addAttribute("allRequests", requestController.getAllRequests());
        return "allRequests";
    }

    @PostMapping("/search")
    public String search(Model model, @ModelAttribute SearchHelp searchWord) {
        model.addAttribute(searchWord);

        List<Request> searchList = searchController.searchByWord(requestController.getAllRequests(), searchWord.getSearchWord());
        for (Request req : searchList) {
            req.nicePrint();
            System.out.println("---");
        }

        model.addAttribute("allRequests", searchList);

        return "allRequests";
    }
}
