package se.kioskByggarna.kiosk.services;

import org.springframework.stereotype.Service;
import se.kioskByggarna.kiosk.models.Employee;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Ali", "Kassör"));
        employees.add(new Employee("Ken", "Djurläkare"));
        return employees;
    }
}
