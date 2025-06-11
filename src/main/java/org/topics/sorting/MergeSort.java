package org.topics.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {6, 3, 9, 5, 2, 8};
        //    TC=O(nlon n)  SC=O(n)
        divide(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    //    TC=O(lon n) SC=O(n)
    private static void divide(int[] arr, int s, int e) {
        if (s >= e) {
            return;
        }
        int mid = (s + e) / 2;
        divide(arr, s, mid);
        divide(arr, mid + 1, e);
        conqure(arr, s, e, mid);
    }

    //    TC=O(n)   O(n)
    private static void conqure(int[] arr, int s, int e, int mid) {
        int i = s,  //to track the 1st array
                j = mid + 1;    //to track the 2nd array
        int ind = 0;    //to track the main array
        int[] merged = new int[e - s + 1];
        while (i <= mid && j <= e) {
            if (arr[i] <= arr[j]) {
                merged[ind++] = arr[i++];
            } else {
                merged[ind++] = arr[j++];
            }
        }

        while (i <= mid) {
            merged[ind++] = arr[i++];
        }
        while (j <= e) {
            merged[ind++] = arr[j++];
        }
        for (int p = 0, q = s; p < merged.length; p++, q++) {
            arr[q] = merged[p];
        }
    }
}
