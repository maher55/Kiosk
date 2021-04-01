package se.kioskByggarna.kiosk.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.kioskByggarna.kiosk.models.Animal;
import se.kioskByggarna.kiosk.services.AnimalService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    @Autowired
    AnimalService animalService;

    @GetMapping()
    public List<Animal> getAllAnimals() {
        return animalService.getAllAnimals();
    }

    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable("id") UUID id) {
        return animalService.getAnimalById(id)
                .orElse(null);
    }

    @PostMapping
    public void addAnimal(@RequestBody Animal animal) {
        animalService.addAnimal(animal);
    }

    @DeleteMapping("/{id}")
    public int deleteAnimal(@PathVariable("id") UUID id) {
        return animalService.deleteAnimal(id);
    }
}
