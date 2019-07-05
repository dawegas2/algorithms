package com.company;

public class MergeSort {
    public void run(int[] arr) {
        mergeSort(arr, 0, arr.length-1);
//        for (int i : arr) {
//            System.out.print(i + " ");
//        }
    }

    private int[] mergeSort(int[] arr, int first, int last) {
        int[] res;
        if (first < last)
        {
            int pos = (last + first)/2;
            res = merge(mergeSort(arr, first, pos), mergeSort(arr, pos+1, last));
        }else{
            res = new int[]{arr[first]};
        }
        return res;
    }

    private int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int l = 0, r = 0, i = 0;
        while (l < left.length && r < right.length){
            if (left[l] < right[r]){
                res[i] = left[l];
                l++;
            }else{
                res[i] = right[r];
                r++;
            }
            i++;
        }
        if (l == left.length){
            for (int j = i; j < res.length; j++){
                res[j] = right[r];
                r++;
            }
        }else{
            for (int j = i; j < res.length; j++){
                res[j] = left[l];
                l++;
            }
        }
        return res;
    }
}
