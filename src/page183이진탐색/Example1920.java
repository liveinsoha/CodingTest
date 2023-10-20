package page183이진탐색;

import java.io.*;
import java.util.*;

public class Example1920 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int key = Integer.parseInt(st.nextToken());
            sb.append(BinarySearch(arr, 0, n - 1, key)).append("\n");
        }
        System.out.println(sb);
    }

    public static int BinarySearch(int[] arr, int lo, int hi, int key) {

        if (lo > hi)
            return 0;

        int mid = (lo + hi) / 2;

        if (arr[mid] == key)
            return 1;
        else if (arr[mid] < key)
            return BinarySearch(arr, mid + 1, hi, key);
        else
            return BinarySearch(arr, lo, mid - 1, key);

    }
}

