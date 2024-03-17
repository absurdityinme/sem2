package org.example.dz_18_03;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        List<Person> persons1 = new ArrayList<>();
        persons1.add(new Fremen("Chani"));
        persons1.add(new Harkonnen("Baron"));
        persons1.add(new Paul("Kwisatz Haderach"));
        persons1.add(new FeydRautha("Feyd-Rautha"));
        iAm(persons1);

        List<Person> persons2 = new ArrayList<>();
        persons2.add(new Harkonnen("Rabban"));
        persons2.add(new Harkonnen("Feyd"));
        killEnemies(persons2);

        List<Person> persons3 = new ArrayList<>();
        persons3.add(new Fremen("Jamis"));
        persons3.add(new Fremen("Jessica"));
        listOurTroops(persons3);
    }

    public static void iAm(List<? extends Person> list) {
        for (Person l : list) {
            l.kill();
            System.out.println(l + ": " + (l.alive ? "alive" : "dead"));
        }
        System.out.println();
    }
    public static void killEnemies(List<? super FeydRautha> list) {
        for (Object l : list) {
            System.out.println(l);
        }
        System.out.println();
    }
    public static void listOurTroops(List<? super Fremen> list) {
        for (Object l : list) {
            System.out.println(l);
        }
        System.out.println();
    }
}
