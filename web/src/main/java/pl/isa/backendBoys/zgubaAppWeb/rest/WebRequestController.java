package pl.isa.backendBoys.zgubaAppWeb.rest;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.isa.backendBoys.zgubaAppWeb.request.Request;
import pl.isa.backendBoys.zgubaAppWeb.request.RequestController;

@Controller
@Service
@RequestMapping("api/request")
public class WebRequestController {

    final RequestController requestController = new RequestController();

    @GetMapping("/submitted")
    public String submittedRequest(Model model){
        return "submittedRequest";
    }

    @PostMapping("/submitted")
    public String addNewRequest(Model model, @ModelAttribute Request requestToAdd){
        requestController.addRequest(requestToAdd);
        model.addAttribute(requestToAdd);
        requestToAdd.nicePrint();
        return "submittedRequest";
    }

    @GetMapping("/add")
    public String addRequest(Model model) {
        model.addAttribute("requestToAdd", new Request());
        model.addAttribute("enum", Request.LostOrFound.class.getName());
        return "addRequest";
    }

}
