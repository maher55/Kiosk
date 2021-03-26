package se.stridsberg.lenaszoo.dao;

import org.springframework.stereotype.Repository;
import se.stridsberg.lenaszoo.models.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class AnimalDAO {

    private static List<Animal> DB = new ArrayList<>();

    public List<Animal> getAllAnimals() {
        return DB;
    }

    public void addAnimal(Animal animal) {
        UUID id = UUID.randomUUID();
        insertAnimal(id, animal);
    }

    private void insertAnimal(UUID id, Animal animal) {
        DB.add(new Animal(id, animal.getType(), animal.getName()));
    }

    public Optional<Animal> findAnimalByID(UUID id) {
        return DB.stream()
                .filter(animal -> animal.getId().equals(id))
                .findFirst();
    }

    public int deleteAnimal(UUID id) {
        Optional<Animal> optionalAnimal = findAnimalByID(id);
        if (optionalAnimal.isEmpty()) {
            return 0;
        }
        DB.remove(optionalAnimal.get());
        return 1;

    }
}
