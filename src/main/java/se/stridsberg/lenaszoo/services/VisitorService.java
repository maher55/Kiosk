package se.stridsberg.lenaszoo.services;

import org.springframework.stereotype.Service;
import se.stridsberg.lenaszoo.models.Visitor;

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
