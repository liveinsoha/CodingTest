package page52나머지합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Example10986 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken()); //n개의 숫자들
        int m = Integer.parseInt(tokenizer.nextToken());

        int[] intArr = new int[n + 1];
        long[] sumArr = new long[n + 1];

        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            intArr[i] = Integer.parseInt(tokenizer.nextToken());
            sumArr[i] = sumArr[i - 1] + intArr[i];
        }
        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                if ((sumArr[j] - sumArr[i - 1]) % m == 0)
                    cnt++;
            }
        }

        System.out.println(cnt);
    }
}
