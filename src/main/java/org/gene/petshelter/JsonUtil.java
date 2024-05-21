package org.gene.petshelter;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
public class JsonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T fromJsonFile(File file, com.fasterxml.jackson.core.type.TypeReference<T> typeReference) throws IOException {
        return objectMapper.readValue(file, typeReference);
    }

    public static void toJsonFile(File file, Object object) throws IOException {
        objectMapper.writeValue(file, object);
    }
}
