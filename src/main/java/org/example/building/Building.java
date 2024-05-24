package org.example.building;

import java.util.ArrayList;
import java.util.List;

public class Building {
    static long start;
    static long end;
    public static void main(String[] args) throws InterruptedException {
        build();
    }

    public static void build() throws InterruptedException {
        List<Thread> list = new ArrayList<>();
        Work project = new Work("проект", 7);
        Thread projectThread = new Thread(project);
        list.add(projectThread);
        Work windowsMaking = new Work("изготовление окон", 7);
        Thread windowsMakingThread = new Thread(windowsMaking);
        list.add(windowsMakingThread);
        Work doorsMaking = new Work("изготовление дверей", 7);
        Thread doorsMakingThread = new Thread(doorsMaking);
        list.add(doorsMakingThread);
        Work foundation = new Work("возведение фундамента", 14);
        Thread foundationThread = new Thread(foundation);
        list.add(foundationThread);
        Work communications = new Work("прокладка коммуникаций", 4);
        Thread communicationsThread = new Thread(communications);
        list.add(communicationsThread);
        Work wallsBuilding = new Work("возведение стен", 14);
        Thread wallsBuildingThread = new Thread(wallsBuilding);
        list.add(wallsBuildingThread);
        Work roof = new Work("возведение крыши", 3);
        Thread roofThread = new Thread(roof);
        list.add(roofThread);
        Work windowsInstallation = new Work("установка окон", 1);
        Thread windowsInstallationThread = new Thread(windowsInstallation);
        list.add(windowsInstallationThread);
        Work doorsInstallation = new Work("установка дверей", 1);
        Thread doorsInstallationThread = new Thread(doorsInstallation);
        list.add(doorsInstallationThread);
        Work battery = new Work("установка отопительных приборов", 3);
        Thread batteryThread = new Thread(battery);
        list.add(batteryThread);
        Work electricalWiring = new Work("прокладка электропроводки", 3);
        Thread electricalWiringThread = new Thread(electricalWiring);
        list.add(electricalWiringThread);
        Work wallsCeilingFinishing = new Work("отделка стен и потолка", 7);
        Thread wallsCeilingFinishingThread = new Thread(wallsCeilingFinishing);
        list.add(wallsCeilingFinishingThread);
        Work floorFinishing = new Work("отделка пола", 7);
        Thread floorFinishingThread = new Thread(floorFinishing);
        list.add(floorFinishingThread);
        Work lampsInstallation = new Work("установка осветительных приборов", 1);
        Thread lampsInstallationThread = new Thread(lampsInstallation);
        list.add(lampsInstallationThread);
        Work plumbingInstallation = new Work("установка сантехники", 2);
        Thread plumbingInstallationThread = new Thread(plumbingInstallation);
        list.add(plumbingInstallationThread);
        Thread endBuilding = new Thread(new EndBuilding());
        list.add(endBuilding);

        // ExecutorService es = Executors.newCachedThreadPool();

        Team rock = new Team("Каменщики");
        Team plot = new Team("Плотники");
        Team plumbers = new Team("Сатнехники");
        Team painters = new Team("Штукатуры");
        Team electrician = new Team("Электрики");
        start = System.currentTimeMillis();

//        do {
//            projectThread.start();
//            if (projectThread.isAlive()) {
//                projectThread.join();
//                windowsMakingThread.start();
//                doorsMakingThread.start();
//                foundationThread.start();
//            } else {
//                rock.start();
//            }
//            if (foundationThread.isAlive()) {
//                foundationThread.join();
//                communicationsThread.start();
//                wallsBuildingThread.start();
//            }
//            if (wallsBuildingThread.isAlive()) {
//                wallsBuildingThread.join();
//                roofThread.start();
//            }
//            if (windowsMakingThread.isAlive() || roofThread.isAlive() || roof.wasStarted) {
//                windowsMakingThread.join();
//                roofThread.join();
//                windowsInstallationThread.start();
//            }
//            if (doorsMakingThread.isAlive() || roofThread.isAlive() || roof.wasStarted) {
//                doorsMakingThread.join();
//                roofThread.join();
//                doorsInstallationThread.start();
//            }
//            if (communicationsThread.isAlive() || windowsInstallationThread.isAlive() || doorsInstallationThread.isAlive() ||
//                    communications.wasStarted || doorsInstallation.wasStarted || windowsInstallation.wasStarted) {
//                communicationsThread.join();
//                windowsInstallationThread.join();
//                doorsInstallationThread.join();
//                batteryThread.start();
//            }
//            if (communicationsThread.isAlive() || roofThread.isAlive() || communications.wasStarted || roof.wasStarted) {
//                communicationsThread.join();
//                roofThread.join();
//                electricalWiringThread.start();
//            }
//            if (windowsInstallationThread.isAlive() || doorsInstallationThread.isAlive() || electricalWiringThread.isAlive() ||
//                    windowsInstallation.wasStarted || doorsInstallation.wasStarted || electricalWiring.wasStarted) {
//                windowsInstallationThread.join();
//                doorsInstallationThread.join();
//                electricalWiringThread.join();
//                wallsCeilingFinishingThread.start();
//            }
//            if (wallsCeilingFinishingThread.isAlive() || wallsCeilingFinishing.wasStarted) {
//                wallsCeilingFinishingThread.join();
//                floorFinishingThread.start();
//                lampsInstallationThread.start();
//            }
//            if (communicationsThread.isAlive() || electricalWiringThread.isAlive() || wallsCeilingFinishingThread.isAlive() ||
//                    communications.wasStarted || electricalWiring.wasStarted || wallsBuilding.wasStarted) {
//                communicationsThread.join();
//                electricalWiringThread.join();
//                wallsCeilingFinishingThread.join();
//                plumbingInstallationThread.start();
//            }
//            if (allDead(list)) {
//                end = System.currentTimeMillis();
//                System.out.println(end - start);
//            }
//        }
    }
}
