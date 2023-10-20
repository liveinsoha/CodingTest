package page139기수정렬;

import java.io.*;

public class Example10989_3 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] count = new int[10001];
        int idx = 0;
        //StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            count[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 0; i < 10001; i++) {
            while (count[i] > 0) {
                arr[idx++] = i;
                count[i]--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i =0; i < n; i++){
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
    }
}
