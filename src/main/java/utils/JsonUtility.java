package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonUtility {

    private static String projDirectory = System.getProperty("user.dir")
            + "/src/test/resources/data";

    public static String jsonFileReader(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(projDirectory + fileName)));
    }


    public static String jsonFileReader(String fileName, String projDir) throws IOException {
        return new String(Files.readAllBytes(Paths.get(projDir + fileName)));
    }


}


