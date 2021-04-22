package se.kioskByggarna.kiosk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import se.kioskByggarna.kiosk.services.*;

import java.util.ArrayList;

@Controller
public class StoreController {

    @Autowired
    ProductService productService;

    @RequestMapping("/index")
    public String start(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "index";
    }

    @RequestMapping("/index/cart/add={id}_{amount}")
    public String addToCart(Model model, @PathVariable("id") Integer id, @PathVariable("amount") Integer amount) {
        return start(model);
    }
    @RequestMapping("/index/cart/remove={id}_{amount}")
    public String removeFromCart(Model model, @PathVariable("id") Integer id, @PathVariable("amount") Integer amount) {
        return start(model);
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
