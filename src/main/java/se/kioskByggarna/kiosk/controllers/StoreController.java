package se.kioskByggarna.kiosk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import se.kioskByggarna.kiosk.services.*;

@Controller
public class StoreController {

    @Autowired
    AnimalService animalService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    VisitorService visitorService;

    @Autowired
    FeedService feedService;

    @Autowired
    ProductService productService;

    @RequestMapping("/index")
    public String start(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "index";
    }

    @RequestMapping("/contact")
    public String showAnimals(Model model) {
        model.addAttribute("animals", animalService.getAllAnimals());
        return "contact";
    }

    @RequestMapping("/myPages")
    public String showEmployees(Model model) {
        model.addAttribute("employees", employeeService.getEmployees());
        return "myPages";
    }

    @RequestMapping("/shoppingHistory")
    public String showFeed(Model model) {
        model.addAttribute("feedlist", feedService.getFeed());
        return "shoppingHistory";
    }
}
