package se.stridsberg.lenaszoo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.stridsberg.lenaszoo.dao.AnimalDAO;
import se.stridsberg.lenaszoo.models.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AnimalService {

    private final AnimalDAO animalDAO;

    @Autowired
    public AnimalService(AnimalDAO animalDAO) {
        this.animalDAO = animalDAO;
    }

    public List<Animal> getAnimals() {
        List<Animal> animals = new ArrayList<>();
        //animals.add(new Animal("Lejon", "Leo"));
        //animals.add(new Animal("Orm", "Väs"));
        return animals;
    }

    public List<Animal> getAllAnimals() {
        return animalDAO.getAllAnimals();
    }

    public void addAnimal(Animal animal) {
        animalDAO.addAnimal(animal);
    }

    public Optional<Animal> getAnimalById(UUID id) {
        return animalDAO.findAnimalByID(id);
    }

    public int deleteAnimal(UUID id) {
        return animalDAO.deleteAnimal(id);
    }
}
