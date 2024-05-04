package org.example.SortSmth;

import org.junit.Assert;
import org.junit.Test;

public class InsertionSortTest {
    @Test
    public void sortTest() {
        int[] arr = new int[] {54, 47, 40, 0, 23, 76, 44, 45, 26, 42};
        int[] sortedArr = new int[] {0, 23, 26, 40, 42, 44, 45, 47, 54, 76};
        InsertionSort.sort(arr);
        Assert.assertArrayEquals(sortedArr, arr);
    }

    @Test
    public void sortTestWrong() {
        int[] arr = new int[] {54, 47, 40, 0, 23, 76, 44, 45, 26, 42};
        int[] sortedArr = new int[] {0, 26, 23, 40, 42, 44, 45, 47, 54, 76};
        InsertionSort.sort(arr);
        Assert.assertNotEquals(sortedArr, arr);
    }

    @Test(expected = NullPointerException.class)
    public void sortNullPointerExceptionTest() {
        InsertionSort.sort(null);
    }
}
