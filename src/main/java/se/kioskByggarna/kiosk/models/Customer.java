package se.kioskByggarna.kiosk.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Customer {
    private Integer id;
    private Account account;
    private HashMap<String, Integer> shoppingCart;
    public Customer(){
        this.id = idGenerator();
        this.account = new Account();
        this.shoppingCart = new HashMap<>();
    }
    public HashMap<String, Integer> getShoppingCart(){
        return this.shoppingCart;
    }
    static private int idCounter = 0;
    static Integer idGenerator(){
        return idCounter++;
    }


}
