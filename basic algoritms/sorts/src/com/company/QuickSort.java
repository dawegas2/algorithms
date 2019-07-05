package com.company;

public class QuickSort {
    public void run(int[] arr) {
        quickSort(arr, 0, arr.length);
//        for (int i : arr) {
//            System.out.print(i + " ");
//        }
    }

    private void quickSort(int[] arr, int first, int last) {
        if (first >= last)
            return;
        int m = partition(arr, first, last);
        quickSort(arr, first, m - 1);
        quickSort(arr, m+1, last);
    }

    private int partition(int[] arr, int first, int last){
        int elem = arr[first];
        int i = first;
        for (int j = first + 1; j < last; j++){
            if (arr[j] < elem){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        int temp = arr[i];
        arr[i] = elem;
        arr[first] = temp;
        return i;
    }
}
