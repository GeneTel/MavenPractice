package org.gene.petshelter;

import java.util.ArrayList;
import java.util.List;

public class AnimalService {
    private List<Animal> animals = new ArrayList<>();

    public List<Animal> getAllAnimals() {
        return animals;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public Animal removeAnimal(int index) {
        if (index >= 0 && index < animals.size()) {
            return animals.remove(index);
        }
        return null;
    }
}
