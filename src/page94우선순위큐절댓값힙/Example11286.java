package page94우선순위큐절댓값힙;

import java.util.*;
import java.io.*;

public class Example11286 {

    public static void main(String[] args) throws Exception {

        //Comp comp = new Comp(); //Priority Queue의 생성자의 매개값으로 Comparator준다
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) ->{
            if(Math.abs(a) > Math.abs(b))
                return 1;
            else if(Math.abs(a) == Math.abs(b)){
                return a > b? 1 : -1;
            }else{
                return -1;
            }
        });

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());

            if (k==0){
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            }else{
                pq.offer(k);
            }
        }
        System.out.println(sb);
    }
//인터페이스 Comparator 구현객체를 생성하여 주어도 된다.
    /*public static class Comp implements Comparator<Integer> {

        @Override
        public int compare(Integer a, Integer b) {
            if (Math.abs(a) > Math.abs(b))
                return 1;
            else if (Math.abs(a) == Math.abs(b)) {
                if (a > b)
                    return 1;
                else
                    return -1;
            } else
                return -1;
        }
    }*/
}
