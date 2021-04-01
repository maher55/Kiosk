package se.kioskByggarna.kiosk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import se.kioskByggarna.kiosk.services.FeedService;
import se.kioskByggarna.kiosk.services.VisitorService;
import se.kioskByggarna.kiosk.services.AnimalService;
import se.kioskByggarna.kiosk.services.EmployeeService;

@Controller
public class ZooController {

    @Autowired
    AnimalService animalService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    VisitorService visitorService;

    @Autowired
    FeedService feedService;

    @RequestMapping("/index")
    public String start() {
        return "index";
    }

    @RequestMapping("animals")
    public String showAnimals(Model model) {
        model.addAttribute("animals", animalService.getAllAnimals());
        return "animals";
    }

    @RequestMapping("employees")
    public String showEmployees(Model model) {
        model.addAttribute("employees", employeeService.getEmployees());
        return "contact";
    }

    @RequestMapping("feed")
    public String showFeed(Model model) {
        model.addAttribute("feedlist", feedService.getFeed());
        return "shoppingHistory";
    }

    @RequestMapping("visitors")
    public String showVisitors(Model model) {
        model.addAttribute("visitors", visitorService.getVisitors());
        return "myPages";
    }
}
