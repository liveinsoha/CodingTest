package page91카드게임;
import java.io.*;
import java.util.*;

public class Example2164 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> d = new LinkedList<Integer>();

        for(int i = 1; i <= n; i++){
            d.add(i);
        }

        while(d.size() > 1){
            d.poll();
            d.add(d.poll());
        }

        System.out.println(d.peek());
    }
}
