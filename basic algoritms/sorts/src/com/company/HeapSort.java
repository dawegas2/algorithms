package com.company;

class HeapSort {
    void run(int[] arr) {
        heapSort(arr);
//        for (int i : arr) {
//            System.out.print(i + " ");
//        }
    }

    private void heapSort(int[] arr){
        buildMaxHeap(arr);
        int size = arr.length - 1;
        while (size > 0){
            int temp = arr[0];
            arr[0] = arr[size];
            arr[size] = temp;
            size--;
            siftDown(arr, 0, size);
        }
    }

    private void buildMaxHeap(int[] arr) {
        for (int i = (arr.length - 1)/2; i >= 0; i--){
            siftDown(arr, i, arr.length-1);
        }
    }

    private void siftDown(int[] arr, int pos, int end) {
        int pos_of_max = 0;
        while (true) {
            if (end < 2 * pos + 1)
                return;
            if (end == 2 * pos + 1)
                pos_of_max = 2 * pos + 1;
            if (end > 2 * pos + 1) {
                if (arr[2 * pos + 1] > arr[2 * pos + 2])
                    pos_of_max = 2 * pos + 1;
                else
                    pos_of_max = 2 * pos + 2;
            }

            if (arr[pos] < arr[pos_of_max]) {
                int temp = arr[pos];
                arr[pos] = arr[pos_of_max];
                arr[pos_of_max] = temp;
                pos = pos_of_max;
            } else {
                return;
            }
        }
    }
}
