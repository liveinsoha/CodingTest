package page122퀵소트피봇소트;

import java.io.*;
import java.util.*;

public class Example11004 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        int[] arr = new int[n];
        tokenizer = new StringTokenizer(br.readLine());

        for(int i=0; i< n; i++){
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        sort(arr);

        System.out.println(arr[k-1]);
    }

    public static void sort(int[] arr){
        pivotSortL(arr,0,arr.length-1);
    }

    public static void pivotSortL(int[] arr, int lo, int hi){

        if(lo >=hi)
            return;

        int pivot = partition(arr, lo, hi);
        pivotSortL(arr, lo, pivot-1);
        pivotSortL(arr, pivot+1, hi);
    }

    public static int partition(int[] arr, int lo,int hi){
        if(lo+1 == hi){
            if(arr[lo] > arr[hi]){
                swap(arr,lo,hi);
                return hi;
            }
        }

        int j = (lo+hi)/2;
        int left = lo;
        int right = hi;
        swap(arr , left, j);
        int pivot = arr[left];

        while(lo < hi) {

            while (arr[hi] > pivot && lo < hi)
                hi--;

            while (arr[lo] <= pivot && lo < hi)
                lo++;

            swap(arr, lo, hi);
        }
        swap(arr, left, lo);
        return lo;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
