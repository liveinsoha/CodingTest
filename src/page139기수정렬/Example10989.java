package page139기수정렬;

import java.util.*;
import java.io.*;
//메모리 초과
public class Example10989 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        //StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = arr[0];
        for (int i = 0; i < n; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        Queue<Integer>[] qArr = new Queue[10];
        for (int i = 0; i < 10; i++) { //Q배열의 각 Q를 제너릭으로 초기화
            qArr[i] = new LinkedList<Integer>();
        }

        int k = (int) Math.log10(max) + 1;

        for (int i = 0; i < k; i++) {

            for (int j = 0; j < n; j++) {
                int qidx = (arr[j] / (int) Math.pow(10, i)) % 10;
                qArr[qidx].offer(arr[j]);
            }

            int idx = 0;
            for (int m = 0; m < 10; m++) {
                while (!qArr[m].isEmpty()) {
                    arr[idx++] = qArr[m].poll();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }
}
