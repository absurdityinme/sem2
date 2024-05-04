package org.aisd.braces;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Stack;

public class BracesCheck {
    public static int correctBraces(String name) throws IOException, NullPointerException, NotTextFileException {
        if (name == null) throw new NullPointerException();
        if (!new File(name).exists()) throw new FileNotFoundException();
        String result = new String(Files.readAllBytes(Paths.get(name)), StandardCharsets.UTF_8);
        boolean hasNotOnlyDigits = true;
        for (int i = 0; i < result.length() && hasNotOnlyDigits; ++i) {
            if (!((int) result.charAt(i) >= (int) '0' && (int) result.charAt(i) <= (int) '9')) hasNotOnlyDigits = false;
        }
        if (hasNotOnlyDigits) throw new NotTextFileException("Text file is needed !");
        return check(result);
    }
    public static int check(String file) {
        Stack<String> json = new Stack<>();
        if (file.charAt(0) != '{') return -1;
        if (file.charAt(file.length() - 1) != '}') {
            return file.length() - 1;
        }
        for (int i = 0; i < file.length() - 1; i++) {
            if (file.charAt(i) == '{') {
                json.push("{");
            } else if (file.charAt(i) == '[') {
                json.push("[");
            } else if (file.charAt(i) == '}') {
                if (!json.pop().equals("{")) {
                    return i;
                }
            } else if (file.charAt(i) == ']') {
                if (!json.pop().equals("[")) {
                    return i;
                }
            }
        }
        return 0;
    }
}
