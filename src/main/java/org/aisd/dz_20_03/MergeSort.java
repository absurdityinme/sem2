package org.aisd.dz_20_03;

import java.util.Comparator;

public class MergeSort implements Comparator<int[]> {
    private void merge(int[][] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[][] L = new int[n1][];
        int[][] R = new int[n2][];
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (compare(L[i], R[j]) <= 0) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    public void mergeSort(int[][] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }
    public void mergeSort(int[][] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public int compare(int[] e1, int[] e2) {
        for (int i = 0; i < Math.min(e1.length, e2.length); ++i) {
            if (e1[i] > e2[i]) return 1;
        }
        return e1.length == e2.length ? 0 : e1.length > e2.length ? 1 : 0;
    }
}
