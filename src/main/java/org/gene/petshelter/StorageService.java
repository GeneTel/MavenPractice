package org.gene.petshelter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StorageService {
    private static final String DATA_FILE = "pets.json";

    public List<Animal> loadAnimals() throws IOException {
        File file = new File(DATA_FILE);
        if (file.exists()) {
            return JsonUtil.fromJsonFile(file, new com.fasterxml.jackson.core.type.TypeReference<List<Animal>>() {});
        }
        return new ArrayList<>();
    }

    public void saveAnimals(List<Animal> animals) throws IOException {
        JsonUtil.toJsonFile(new File(DATA_FILE), animals);
    }
}
