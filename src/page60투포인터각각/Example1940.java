package page60투포인터각각;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Example1940 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        long[] arr = new long[n];

        int sIdx = 0;
        int eIdx = n - 1;
        int count = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(arr);

        while (sIdx < eIdx) {
            if (arr[sIdx] + arr[eIdx] < m) {
                sIdx++;
            } else if (arr[sIdx] + arr[eIdx] > m) {
                eIdx--;
            } else {
                count++;
                sIdx++;
                eIdx--;
            }
        }

        System.out.println(count);
    }
}
