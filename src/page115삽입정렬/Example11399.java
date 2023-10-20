package page115삽입정렬;

import java.io.*;
import java.util.*;

public class Example11399 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        int[] sumArr = new int[n + 1];

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        int target;
        int j;
        for (int i = 2; i < n + 1; i++) {
            target = arr[i];
            j = i - 1;
            while (j >= 1 && arr[j] > target) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = target;
        }
        int result = 0;
        for (int i = 1; i < n + 1; i++) {
            sumArr[i] = sumArr[i - 1] + arr[i];
            result += sumArr[i];
        }
        System.out.println(result);
    }
}
