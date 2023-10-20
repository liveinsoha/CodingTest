package page139기수정렬;

import java.util.*;
import java.io.*;

public class Example10989_4 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                max = arr[i] = Integer.parseInt(tokenizer.nextToken());
            } else {
                arr[i] = Integer.parseInt(tokenizer.nextToken());
                if (max < arr[i])
                    max = arr[i];
            }
        }
        Quu[] qArr = new Quu[10];
        for(int i =0; i<10; i++){
            qArr[i] = new Quu();
        }

        int k = (int) Math.log10(max) + 1;
        for (int i = 0; i < k; i++) {

            int jrs = (int) Math.pow(10, i);

            for (int j = 0; j < n; j++) {
                int qIdx = (arr[j] / jrs) % 10;
                qArr[qIdx].offer(arr[j]);
            }

            int idx = 0;
            for (int j = 0; j < 10; j++) {
                while (!qArr[j].isEmpty())
                    arr[idx++] = qArr[j].poll();
                qArr[j].init();
            }

        }
        System.out.println(Arrays.toString(arr));
    }

    static class Quu {
        int count = 0;
        int poll = 0;
        int[] arr = new int[10];


        public void init() {
            arr = new int[10];
            count = 0;
            poll = 0;
        }

        public void offer(int i) {
            if (count == arr.length)
                resize();
            arr[count] = i;
            count++;
        }

        private void resize() {
            arr = Arrays.copyOf(arr, arr.length * 2);
        }

        public int poll() {
            return arr[poll++];
        }

        public boolean isEmpty() {
            return count == poll;
        }
    }
}
