package org.aisd.cl_20_03;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] a = new int[][] {{1, 5}, {3, 7}, {4, 9}, {6, 7}}; // answer is 3
        int[][] list = new int[a.length*2][2];
        for (int i = 0; i < a.length; ++i) {
            list[i][0] = a[i][0];
            list[i][1] = 1;
        }
        for (int i = 0; i < a.length; ++i) {
            list[a.length + i][0] = a[i][1];
            list[a.length + i][1] = -1;
        }
        quickSort(list);
        quickSort(list);
        int count = 0, max = 0;
        for (int i = 0; i < list.length; ++i) {
            count += list[i][1];
            if (count > max) max = count;
        }
        System.out.println("число максимального количества слоев отрезков: " + max);
    }
    public static void quickSort(int[][] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[][] array, int p, int r) {
        if (p < r) {
            int q = partition(array, p, r);
            quickSort(array, p, q - 1);
            quickSort(array, q + 1, r);
        }
    }

    private static int partition(int[][] array, int p, int r) {
        int i = p - 1;
        int j = p;
        while (j < r) {
            if (array[j][0] < array[r][0] || (array[j][0] == array[r][0] && array[j][1] > array[r][1])) {
                swap(array, i + 1, j);
                i++;
            }
            j++;
        }
        swap(array, i + 1, r);
        return i + 1;
    }

    private static void swap(int[][] array, int i, int j) {
        int[] temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

