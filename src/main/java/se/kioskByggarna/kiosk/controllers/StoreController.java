package se.kioskByggarna.kiosk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import se.kioskByggarna.kiosk.services.*;

@Controller
public class StoreController {

    @Autowired
    ProductService productService;

    @RequestMapping("/index")
    public String start(Model model) {
        return "index";
    }

    @RequestMapping("/contact")
    public String showContact(Model model) {
        return "contact";
    }
    @RequestMapping("/order")
    public String showOrder(Model model) {
        return "order";
    }
    @RequestMapping("/myPages")
    public String showMyPages(Model model) {
        return "myPages";
    }

    @RequestMapping("/shoppingHistory")
    public String showShoppingHistory(Model model) {
        return "shoppingHistory";
    }
}
