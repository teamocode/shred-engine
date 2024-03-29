package com.teamo.shredengine.engine.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Loader {

    public static String loadShader(String fileName) {
        String result = "";
        try (InputStream in = Loader.class.getResourceAsStream(fileName);
             Scanner scanner = new Scanner(in, java.nio.charset.StandardCharsets.UTF_8.name())) {
            result = scanner.useDelimiter("\\A").next();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
