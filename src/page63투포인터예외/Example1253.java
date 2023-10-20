package page63투포인터예외;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Example1253 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(arr);

        int count = 0;

        for (int i = 0; i < n; i++) {
            int p = 0;
            int q = n-1;  //배열의 수가 음수인경우가 있으므로 두 수의 합이 항상 타깃의 왼쪽에서만 발생하지 않는다.
            //양 끝에서부터 모든 경우에 대해서 생각해야 한다.

            while (p < q) {
                if(p==i){
                    p++;
                    continue;
                }
                if(q==i){
                    q--;
                    continue;
                }
                if (arr[p] + arr[q] < arr[i])
                    p++;
                else if (arr[p] + arr[q] > arr[i])
                    q--;
                else {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
        br.close();
    }
}
