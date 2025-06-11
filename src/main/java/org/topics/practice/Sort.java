package org.topics.practice;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        int[] arr = {10, 2, 8, 17, 9, 5, 1, 23, 76, 43};
        mergeSort(arr);
    }

    private static void mergeSort(int[] arr) {

        divide(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void divide(int[] arr, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        divide(arr, start, mid);
        divide(arr, mid + 1, end);
        conqure(arr, start, end, mid);
    }

    public static void conqure(int[] arr, int start, int end, int mid) {
        int[] result = new int[end - start + 1];
        int index1 = start;
        int index2 = mid + 1;
        int x = 0;
        while (index1 <= mid && index2 <= end) {
            if (arr[index1] <= arr[index2]) {
                result[x++] = arr[index1++];
            } else {
                result[x++] = arr[index2++];
            }
        }
        while (index1 <= mid) {
            result[x++] = arr[index1++];
        }
        while (index2 <= end) {
            result[x++] = arr[index2++];
        }

        for (int i = 0, j = start; i < result.length; i++, j++) {
            arr[j] = result[i];
        }
    }
}
