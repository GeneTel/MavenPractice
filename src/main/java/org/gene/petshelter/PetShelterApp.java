package org.gene.petshelter;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class PetShelterApp {
    private static final AnimalService animalService = new AnimalService();
    private static final StorageService storageService = new StorageService();

    public static void main(String[] args) {
        try {
            List<Animal> loadedAnimals = storageService.loadAnimals();
            loadedAnimals.forEach(animalService::addAnimal);
        } catch (IOException e) {
            System.out.println("Failed to load animals: " + e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Add pet");
            System.out.println("2. Show all pets");
            System.out.println("3. Take pet from shelter");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    addPet(scanner);
                    break;
                case 2:
                    showAllPets();
                    break;
                case 3:
                    takePetFromShelter(scanner);
                    break;
                case 4:
                    exit = true;
                    try {
                        storageService.saveAnimals(animalService.getAllAnimals());
                    } catch (IOException e) {
                        System.out.println("Failed to save animals: " + e.getMessage());
                    }
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static void addPet(Scanner scanner) {
        System.out.print("Enter pet name: ");
        String name = scanner.nextLine();
        System.out.print("Enter pet breed: ");
        String breed = scanner.nextLine();
        System.out.print("Enter pet age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        animalService.addAnimal(new Animal(name, breed, age));
        System.out.println("Pet added successfully.");
    }

    private static void showAllPets() {
        List<Animal> animals = animalService.getAllAnimals();
        if (animals.isEmpty()) {
            System.out.println("No pets in the shelter.");
        } else {
            animals.forEach(System.out::println);
        }
    }

    private static void takePetFromShelter(Scanner scanner) {
        List<Animal> animals = animalService.getAllAnimals();
        if (animals.isEmpty()) {
            System.out.println("No pets to take.");
            return;
        }

        showAllPets();
        System.out.print("Enter the index of the pet to take (1 to " + animals.size() + "): ");
        int index = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Animal removedAnimal = animalService.removeAnimal(index - 1);
        if (removedAnimal != null) {
            System.out.println("Removed pet: " + removedAnimal);
        } else {
            System.out.println("Invalid index.");
        }
    }
}
