package pl.isa.BackendBoys.ZgubaAppWeb.rest;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.isa.BackendBoys.request.Request;
import pl.isa.BackendBoys.request.RequestController;

@Controller
@Service
@RequestMapping("api/request")
public class WebRequestController {

    RequestController requestController = new RequestController();

    @GetMapping("/submitted")
    public String submittedRequest(Model model){
        //model.addAttribute("requestToAdd", new Request());
        return "submittedRequest";
    }

    @PostMapping("/submitted")
    public String addNewRequest(Model model, @ModelAttribute Request requestToAdd){
        //model.addAttribute("requestToAdd", new Request());
//        System.out.println(requestToAdd.getRequesterLogin());
//        System.out.println(requestToAdd);
        //requestController.addRequest(requestToAdd);
        model.addAttribute(requestToAdd);
        requestToAdd.nicePrint();
        return "submittedRequest";
    }

    @GetMapping("/add")
    public String addRequest(Model model) {
        //Request requestToAdd = new Request();
        model.addAttribute("requestToAdd", new Request());
        model.addAttribute("enum", Request.LostOrFound.class.getName());
        return "addRequest";
    }

//    @PostMapping("/submitted")
//    public String submittedRequest(@ModelAttribute Request requestToAdd, Model model){
//        RequestController requestController = new RequestController();
//        System.out.println(requestToAdd.getRequesterLogin());
//        System.out.println(requestToAdd.getRequestDate());
//        System.out.println(requestToAdd.getCity());
//        System.out.println(requestToAdd.getDescription());
//        System.out.println(requestToAdd.getLostOrFound());
//        requestController.addRequest(requestToAdd);
//        return "submittedRequest";
//    }

}
