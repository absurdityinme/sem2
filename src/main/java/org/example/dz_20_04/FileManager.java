package org.example.dz_20_04;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class FileManager {
    public static void main(String[] args) {
        File currdir = null;
        File currFile = null;
        File file;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите действие:");
            System.out.printf("""
                    1. Переход в указанную папку
                    2. Создание директории
                    3. Копирование файла
                    4. Переименование файла
                    5. Запрос списка файлов текущей директории""");
            System.out.println();
            switch (sc.nextLine()) {
                case "1":
                    System.out.println("Введите адрес папки, в которую вы хотите перейти");
                    String path = sc.nextLine();
                    if (currdir != null && currdir.toString().contains(path)) {
                        int ind = currdir.toString().lastIndexOf(path) + path.length();
                        currdir = new File(currdir.toString().substring(0, ind + 1));
                    }
                    else {
                        File dir = new File(path + "/");
                        if (dir.isDirectory() || (new File(currdir.toString() + "/" + dir.toString())).isDirectory()) {
                            if (currdir == null) currdir = new File(dir.toString());
                            else {
                                currdir = new File(currdir.toString() + "/" + dir.toString());
                            }
                        } else System.out.println("Такой папки не существует, попробуйте снова");
                    }
                    break;
                case "2":
                    System.out.print("Введите имя новой директории: ");
                    File newDir = new File(currdir.toString() + "/" + sc.nextLine());
                    System.out.println();
                    if (newDir.mkdir()) System.out.println("Директория создана !");
                    currdir = newDir;
                    break;
                case "3":
                    System.out.println("Введите название файла, которое хотите скопировать");
                    file = new File(currdir + "/" + sc.nextLine());
                    if (file.exists()) currFile = file;
                    else System.out.println("Файла не существует");
                    break;
                case "4":
                    System.out.println("Введите старое имя файла и новое имя через запятую");
                    String[] str = sc.nextLine().split(", ");
                    file = new File(currdir + "/" + str[0]);
                    if (file.exists()) {
                        boolean renamed = file.renameTo(new File(currdir + "/" + str[1]));
                        if (renamed) System.out.println("Файл был переименован !");
                    }
                    else System.out.println("Файла не существует");
                    break;
                case "5":
                    if (currdir != null) Arrays.stream(currdir.listFiles()).forEach(System.out::println);
                    break;
                default:
                    System.out.println("Такой операции не существует, попробуйте еще раз");
                    continue;
            }
            if (currdir != null) System.out.println(currdir + "\\ ");
        }
    }
}
