package org.example.building;

public class Building {
    public static void main(String[] args) throws InterruptedException {
        Work project = new Work("проект", 7);
        Thread projectThread = new Thread(project);
        Work windowsMaking = new Work("изготовление окон", 7);
        Thread windowsMakingThread = new Thread(windowsMaking);
        Work doorsMaking = new Work("изготовление дверей", 7);
        Thread doorsMakingThread = new Thread(doorsMaking);
        Work foundation = new Work("возведение фундамента", 14);
        Thread foundationThread = new Thread(foundation);
        Work communications = new Work("прокладка коммуникаций", 4);
        Thread communicationsThread = new Thread(communications);
        Work wallsBuilding = new Work("возведение стен", 14);
        Thread wallsBuildingThread = new Thread(wallsBuilding);
        Work roof = new Work("возведение крыши", 3);
        Thread roofThread = new Thread(roof);
        Work windowsInstallation = new Work("установка окон", 1);
        Thread windowsInstallationThread = new Thread(windowsInstallation);
        Work doorsInstallation = new Work("установка дверей", 1);
        Thread doorsInstallationThread = new Thread(doorsInstallation);
        Work battery = new Work("установка отопительных приборов", 3);
        Thread batteryThread = new Thread(battery);
        Work electricalWiring = new Work("прокладка электропроводки", 3);
        Thread electricalWiringThread = new Thread(electricalWiring);
        Work wallsCeilingFinishing = new Work("отделка стен и потолка", 7);
        Thread wallsCeilingFinishingThread = new Thread(wallsCeilingFinishing);
        Work floorFinishing = new Work("отделка пола", 7);
        Thread floorFinishingThread = new Thread(floorFinishing);
        Work lampsInstallation = new Work("установка осветительных приборов", 1);
        Thread lampsInstallationThread = new Thread(lampsInstallation);
        Work plumbingInstallation = new Work("установка сантехники", 2);
        Thread plumbingInstallationThread = new Thread(plumbingInstallation);

        long start = System.nanoTime();

        projectThread.start();
        if (projectThread.isAlive()) {
            projectThread.join();
            windowsMakingThread.start();
            doorsMakingThread.start();
            foundationThread.start();
        }
        if (foundationThread.isAlive()) {
            foundationThread.join();
            communicationsThread.start();
            wallsBuildingThread.start();
        }
        if (wallsBuildingThread.isAlive()) {
            wallsBuildingThread.join();
            roofThread.start();
        }
        if (windowsMakingThread.isAlive() || roofThread.isAlive() || roof.wasStarted) {
            windowsMakingThread.join();
            roofThread.join();
            windowsInstallationThread.start();
        }
        if (doorsMakingThread.isAlive() || roofThread.isAlive() || roof.wasStarted) {
            doorsMakingThread.join();
            roofThread.join();
            doorsInstallationThread.start();
        }
        if (communicationsThread.isAlive() || windowsInstallationThread.isAlive() || doorsInstallationThread.isAlive() ||
                communications.wasStarted || doorsInstallation.wasStarted || windowsInstallation.wasStarted) {
            communicationsThread.join();
            windowsInstallationThread.join();
            doorsInstallationThread.join();
            batteryThread.start();
        }
        if (communicationsThread.isAlive() || roofThread.isAlive() || communications.wasStarted || roof.wasStarted) {
            communicationsThread.join();
            roofThread.join();
            electricalWiringThread.start();
        }
        if (windowsInstallationThread.isAlive() || doorsInstallationThread.isAlive() || electricalWiringThread.isAlive() ||
                windowsInstallation.wasStarted || doorsInstallation.wasStarted || electricalWiring.wasStarted) {
            windowsInstallationThread.join();
            doorsInstallationThread.join();
            electricalWiringThread.join();
            wallsCeilingFinishingThread.start();
        }
        if (wallsCeilingFinishingThread.isAlive() || wallsCeilingFinishing.wasStarted) {
            wallsCeilingFinishingThread.join();
            floorFinishingThread.start();
            lampsInstallationThread.start();
        }
        if (communicationsThread.isAlive() || electricalWiringThread.isAlive() || wallsCeilingFinishingThread.isAlive() ||
                communications.wasStarted || electricalWiring.wasStarted || wallsBuilding.wasStarted) {
            communicationsThread.join();
            electricalWiringThread.join();
            wallsCeilingFinishingThread.join();
            plumbingInstallationThread.start();
        }

        long end = System.nanoTime();
        System.out.println(end - start);
    }
}
