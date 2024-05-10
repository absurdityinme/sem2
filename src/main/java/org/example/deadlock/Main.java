package org.example.deadlock;

import net.bytebuddy.asm.MemberSubstitution;

//придумать и реализовать пример взаимной блокировки потоков для какой-нибудь предметной области
public class Main {
    public static void main(String[] args) {
        Museum louvre = new Museum("Louvre");
        Museum metropolitanMuseumOfArt = new Museum("Metropolitan Museum of Art");
        Painting goldfinch = new Painting("The Goldfinch", louvre);
        Painting anatomyLesson = new Painting("The Anatomy Lesson of Dr. Nicolaes Tulp", metropolitanMuseumOfArt);
        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start");
            synchronized (goldfinch) {
                try {
                    Thread.sleep(3*1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (anatomyLesson) {
                    reunion(goldfinch, anatomyLesson);
                }
            }
            System.out.println(goldfinch.getName() + " is in " + goldfinch.getMuseum().getName() +
                    ", " + anatomyLesson.getName() + " is in " + anatomyLesson.getMuseum().getName() +
                    "\n" + Thread.currentThread().getName() + " end");
        });
        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start");
            synchronized (anatomyLesson) {
                synchronized (goldfinch) {
                    reunion(anatomyLesson, goldfinch);
                }
            }
            System.out.println(goldfinch.getName() + " is in " + goldfinch.getMuseum().getName() +
                    ", " + anatomyLesson.getName() + " is in " + anatomyLesson.getMuseum().getName() +
                    "\n" + Thread.currentThread().getName() + " end");
        });
        thread1.start();
        thread2.start();

    }
    public static void reunion(Painting home, Painting traveler) {
        Museum temp = home.getMuseum();
        traveler.setMuseum(temp);
    }
}
