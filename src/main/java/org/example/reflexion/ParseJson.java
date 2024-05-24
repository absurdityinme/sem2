package org.example.reflexion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ParseJson {
    Object object;
    File file;
    ParseJson(Object object, File file) {
        this.object = object;
        this.file = file;
    }
    public Object read() throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        FileInputStream fin = new FileInputStream(file);
        int IByte;
        while ((IByte = fin.read()) != (int) '}') {
            Field field;
            String stringField = "";
            while ((IByte = fin.read()) != (int) ':') {
                if (IByte != (int) '{' && IByte != (int) '}') stringField += (char) IByte;
            }
            stringField = stringField.strip().substring(1, stringField.strip().length() - 1);
            try {
                field = object.getClass().getDeclaredField(stringField);
            }
            catch (NoSuchFieldException e) {
                System.out.println(e.getMessage());
            }
            String stringValue = "";
            while ((IByte = fin.read()) != (int) '\n') {
                if (IByte != (int) '{' && IByte != (int) '}') stringValue += (char) IByte;
            }
            stringValue = stringValue.strip();
            if (!isNumeric(stringValue)) {
                if (stringValue.charAt(stringValue.length() - 1) == ',') {
                    stringValue = stringValue.substring(0, stringValue.length() - 1);
                }
                stringValue = stringValue.substring(1, stringValue.length() - 1);
            }
            Method method;
            if (!isNumeric(stringValue)) {
                method = object.getClass()
                        .getMethod("set" + stringField.toUpperCase().charAt(0) + stringField.substring(1),
                                String.class);
                method.invoke(object, stringValue);
            }
            else {
                method = object.getClass()
                        .getMethod("set" + stringField.toUpperCase().charAt(0) + stringField.substring(1), Integer.class);
                method.invoke(object, Integer.parseInt(stringValue));
            }
        }
        fin.close();
        return object;
    }
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }
}
