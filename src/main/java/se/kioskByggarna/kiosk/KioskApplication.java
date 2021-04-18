package se.kioskByggarna.kiosk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.kioskByggarna.kiosk.api.ProductController;
import se.kioskByggarna.kiosk.models.Product;
import se.kioskByggarna.kiosk.models.ProductType;

@SpringBootApplication
public class KioskApplication {

    public static void main(String[] args) {
        SpringApplication.run(KioskApplication.class, args);
    }
}
