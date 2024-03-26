package org.aisd.dz_20_03;

/**
 Задан набор из m отсортированных строк различной длины,
 построенных в одном и том же алфавите.
 Разработайте эффективный алгоритм объединения всех строк в одну отсортированную строку.
 Сложность O(nlog m), где n – суммарная длина всех строк.
 **/

public class Main12 {
    public static void main(String[] args) {
        String[] strings = {"123", "479", "15", "24678"};
        String mergedString = mergeStrings(strings);
        System.out.println("Sorted string: " + mergedString);
    }

    public static String mergeStrings(String[] sortedStrings) {
        int m = sortedStrings.length;
        if (m == 0) {
            return "";
        }
        String result = "";
        int[] indices = new int[m];
        while (true) {
            char smallestChar = Character.MAX_VALUE;
            int smallestInd = -1;
            for (int i = 0; i < m; i++) {
                if (indices[i] < sortedStrings[i].length()) {
                    char curr = sortedStrings[i].charAt(indices[i]);
                    if (curr < smallestChar) {
                        smallestChar = curr;
                        smallestInd = i;
                    }
                }
            }
            if (smallestInd == -1) {
                break;
            }
            result += smallestChar;
            indices[smallestInd]++;
        }
        return result;
    }

}
