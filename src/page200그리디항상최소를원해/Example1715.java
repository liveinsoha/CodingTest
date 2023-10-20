package page200그리디항상최소를원해;

import java.io.*;
import java.util.*;

public class Example1715 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        int sum = 0;
        while (pq.size() != 1) { //1개 남은 경우가 아닐 때 까지. 합쳐서 더하고 다시 넣는다.
           int now =  pq.poll() + pq.poll();
           sum += now;
            pq.add(now);
        }
        System.out.println(sum);
    }
}
