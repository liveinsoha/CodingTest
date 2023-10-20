package page129머지소트;

import java.io.*;
import java.util.*;

public class Example2751 {

    static int[] sorted;
    static int[] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());
        arr = new int[n];
        sorted = new int[n];

        tokenizer = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        sort();

        System.out.println(arr[k-1]);

    }


    public static void sort() {
        mergeSort(0, arr.length - 1);
    }

    public static void mergeSort(int l, int r) {
        if (l == r)
            return;

        int mid = (l + r) / 2;

        mergeSort(l, mid);
        mergeSort(mid + 1, r);

        merge(l, mid, r);
    }

    public static void merge(int l, int mid, int r) {
        int lIdx = l;
        int rIdx = mid + 1;
        int idx = l;

        while (lIdx <= mid && rIdx <= r) {

            if (arr[lIdx] < arr[rIdx]) {
                sorted[idx] = arr[lIdx];
                idx++;
                lIdx++;
            } else {
                sorted[idx] = arr[rIdx];
                idx++;
                rIdx++;
            }
        }

        if (lIdx > mid) {
            while (rIdx <= r) {
                sorted[idx] = arr[rIdx];
                idx++;
                rIdx++;
            }
        } else {
            while (lIdx <= mid) {
                sorted[idx] = arr[lIdx];
                idx++;
                lIdx++;
            }
        }

        for(int i = l; i<=r; i++){
            arr[i] = sorted[i]; //기존 배열에 정렬된 배열을 복사하고 다시 진행해야 한다.
        }
    }
}
