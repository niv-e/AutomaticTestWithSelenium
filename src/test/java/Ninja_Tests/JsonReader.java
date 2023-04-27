package Ninja_Tests;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class JsonReader{
    ObjectMapper mapper = new ObjectMapper();
    public List<Map<?, ?>> readList(String pathToInputFile) {
        List<Map<?, ?>> testInput;

        try {
            testInput = mapper.readValue(Paths.get(pathToInputFile)
                        .toFile(), List.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return testInput;
    }
    public Map<?, ?> read(String pathToInputFile) {
        Map<?, ?> testInput;

        try {
            testInput = mapper.readValue(Paths.get(pathToInputFile)
                    .toFile(), Map.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return testInput;
    }
}
