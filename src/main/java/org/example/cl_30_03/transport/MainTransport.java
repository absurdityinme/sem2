package org.example.cl_30_03.transport;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

public class MainTransport {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TransportDataBase dataBase =
                mapper.readValue(new File("transport.json"), TransportDataBase.class);
        // task1(dataBase);
        // task2(dataBase, "8");
        // task3(dataBase);
        // task4(dataBase);
        // task5(dataBase);
        // task6(dataBase, "bus");
    }

    // определить какой транспорт в базе данных
    public static void task1(TransportDataBase dataBase) {
        Set<String> transportInDataBase = dataBase.getData().getVehicles().stream()
                .map(vehicle -> vehicle.getProperties().getVehicleMetaData().getTransport().getType()).collect(Collectors.toSet());
        transportInDataBase.forEach(System.out::println);
    }

    // определить количество транспорта определенного маршрута на линии
    public static void task2(TransportDataBase dataBase, String number) {
        long count =
                dataBase.getData().getVehicles().stream()
                        .filter(vehicle -> vehicle.getProperties().getVehicleMetaData().getTransport().getName().equals(number))
                        .count();
        System.out.println("Количество транспорта по маршруту " + number + ": " + count);
    }

    // создать map, показывающий транспортное средство и количество сообщений о своих координатах
    public static void task3(TransportDataBase dataBase) {
        Map<String, Integer> map = dataBase.getData().getVehicles().stream()
                .collect(Collectors.toMap(
                                vehicle -> vehicle.getProperties().getVehicleMetaData().getTransport().getId(),
                                vehicle -> vehicle.getFeatures().stream().mapToInt(
                                        feature -> feature.getGeometry().getCoordinates().length).sum()
                        )
                );
        map.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    // вывести номер, тип, id транспорта, отсортировав в порядке возрастания номера маршрута
    public static void task4(TransportDataBase dataBase) {
                dataBase.getData().getVehicles().stream()
                .sorted((v, e) -> v.getProperties().getVehicleMetaData().getTransport().getName().compareTo(e.getProperties().getVehicleMetaData().getTransport().getName()))
                .forEach(vehicle -> System.out.println(
                        vehicle.getProperties().getVehicleMetaData().getTransport().getName() + " "
                                + vehicle.getProperties().getVehicleMetaData().getTransport().getType() + ": "
                        + vehicle.getProperties().getVehicleMetaData().getTransport().getId()
                ));
    }

    // вывести для каждого транспортного средства массив из времени  (dd.MM.yyyy HH:mm:ss) (Properties)
    public static void task5(TransportDataBase dataBase) {
        dataBase.getData().getVehicles().stream()
                .map(vehicle -> vehicle.getFeatures().stream()
                        .map(v -> Date.from(Instant.ofEpochSecond(v.getProperties().getTrajectorySegmentMetaData().getTime())))
                        .collect(Collectors.toList()))
                .forEach(System.out::println);
    }

    // вывести id только трамваев, автобусов, троллейбусов
    public static void task6(TransportDataBase dataBase, String transportType) {
        dataBase.getData().getVehicles().stream()
                .filter(vehicle -> vehicle.getProperties().getVehicleMetaData().getTransport().getType().equals(transportType))
                .forEach(vehicle -> vehicle.getProperties().getVehicleMetaData().getTransport().getId());
    }
}
