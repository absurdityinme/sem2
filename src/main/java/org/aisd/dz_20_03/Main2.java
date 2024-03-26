package org.aisd.dz_20_03;
/**
 Реализовать алгоритм лексикографической сортировки для векторов переменной длины,
 элементы которых принимают значения из конечного алфавита А.
 Сложность O(mk), где m – число всех векторов, k – длина максимального из них.
 Или сложность O(mlog m +n) или O(n), где n -суммарная длина всех векторов.
**/

public class Main2 {
    public static void main(String[] args) {
        int n = 3;
        int[][] vectors = new int[n][];
        vectors[0] = new int[]{1, 2, 5};
        vectors[1] = new int[]{1, 2};
        vectors[2] = new int[]{4, 5, 9};
        int[][] sortedVectors = lexicographicSort(vectors);

        for (int[] vector : sortedVectors) {
            for (int v : vector) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    public static int[][] lexicographicSort(int[][] vectors) {
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(vectors);
        return vectors;
    }
}
