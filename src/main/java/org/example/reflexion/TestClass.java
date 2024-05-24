package org.example.reflexion;

import lombok.Setter;
import lombok.Getter;

public class TestClass {
    public static String CONST = "CONST";
    @Getter @Setter
    private String name;
    public String publicName;
    private Double count;
    public TestClass() {}
    public TestClass(String name, Double count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "name='" + name + '\'' +
                ", publicName='" + publicName + '\'' +
                ", count=" + count +
                '}';
    }
}
