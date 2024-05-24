package org.example.reflexion;

import java.lang.reflect.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Object test = new TestClass("Test string", 12d);
        System.out.println(test.getClass().getName());
        System.out.println("-----------------------------");
        Field[] fields = test.getClass().getDeclaredFields();
        Arrays.stream(fields).forEach(v -> {
            v.setAccessible(true);
            try {
                System.out.println(v.getName() + ": " + v.getType() + " = " + v.get(test));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println("-----------------------------");
        Field field = test.getClass().getField("CONST");
        System.out.println("static field: " + field.get(null));
        System.out.println("-----------------------------");
        field = test.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(test, "new value");
        System.out.println(((TestClass) test).getName());
        System.out.println("-----------------------------");
        field = test.getClass().getDeclaredField("CONST");
        field.setAccessible(true);
        field.set(null, "new CONST");
        System.out.println(((TestClass) test).CONST);
        System.out.println("-----------------------------");
        Method[] methods = test.getClass().getDeclaredMethods();
        Arrays.stream(methods).forEach(v -> System.out.println(v.getReturnType() + ": " + v.getName()));
        System.out.println("-----------------------------");
        field = test.getClass().getDeclaredField("name");
        Method method = test.getClass()
                .getMethod("set" + field.getName().toUpperCase().charAt(0) + field.getName().substring(1),
                        String.class);
        method.invoke(test, "reeealy new value");
        System.out.println(((TestClass) test).getName());
        System.out.println("-----------------------------");
        Constructor[] constructors = test.getClass().getConstructors();
        Arrays.stream(constructors).forEach(v -> System.out.println(v.getName() + " " + v.getParameterCount()));
        System.out.println("-----------------------------");
        TestClass testClass = TestClass.class.newInstance(); // bad
        Constructor constructor = test.getClass().getConstructor(String.class, Double.class);
        Object testAsObjectReference = constructor.newInstance("HI", 4d);
        System.out.println(testAsObjectReference);
    }
}
