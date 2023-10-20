package page220소수찾기arraylist숫자자리수;

import java.io.*;
import java.util.*;
public class Example1456_2 {
    public static void main(String[] args) throws Exception{

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        int[] arr = new int[10000001];

        for (int i = 2; i < 10000001; i++) {
            arr[i] = i;
        }
        for (int i = 2; i < Math.sqrt(10000001); i++) {
            if (arr[i] != 0) {
                for (int j = i + 1; j < 10000001; j++) {
                    if (arr[j] % i == 0)
                        arr[j] = 0;
                }
            }
        }

        long count = 0;
        for(int i=2; i <10000001; i++){
            if(arr[i] !=0){
                long a = i;
                while(a*i <= m){
                    a = a*i;
                    if(a>=n)
                        count++;
                }
            }
        }

        System.out.println(count);
    }
}
