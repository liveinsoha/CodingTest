package page86스택;

import java.io.*;
import java.util.*;

public class Exmaple17298 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> s = new Stack<Integer>();
        int[] arr = new int[n];
        int[] ans = new int[n];

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        for (int i = 0; i < n; i++) {
            if (s.isEmpty()) {
                s.push(i);
                continue;
            }
            while (!s.isEmpty() && arr[s.peek()] < arr[i]) {
                ans[s.pop()] = arr[i];
            }
            s.push(i);
        }

        for (int i = 0; i < n; i++) {
            if (ans[i] == 0)
                ans[i] = -1;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);

    }
}
