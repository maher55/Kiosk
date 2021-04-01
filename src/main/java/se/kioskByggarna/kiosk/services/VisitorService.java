package se.kioskByggarna.kiosk.services;

import org.springframework.stereotype.Service;
import se.kioskByggarna.kiosk.models.Visitor;

import java.util.ArrayList;
import java.util.List;

@Service
public class VisitorService {

    public List<Visitor> getVisitors() {
        List<Visitor> visitors = new ArrayList<>();
        visitors.add(new Visitor("Barbie", 20));
        visitors.add(new Visitor("Björn", 40));
        return visitors;
    }

}
