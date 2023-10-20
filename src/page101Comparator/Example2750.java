package page101Comparator;

import java.util.*;
import java.io.*;
public class Example2750 {

    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int n = Integer.parseInt(br.readLine());
       Integer[] arr = new Integer[n];
       StringBuilder sb = new StringBuilder();

       for(int i = 0; i<n; i++){
           arr[i] = Integer.parseInt(br.readLine());
       }

       Arrays.sort(arr, (a,b) ->{
           if(a<b) //뒤에게 크면 양수. 클수록 우선순위 앞. 내림차순
               return 1;
           else if(a>b)
               return -1;
           else
               return 0;
       });

       /*for(int i=0; i<n-1; i++){
           for(int j=0; j<n-1-i; j++){
               if(arr[j] > arr[j+1]){
                   int temp = arr[j];
                   arr[j] = arr[j+1];
                   arr[j+1] = temp;
               }
           }
       }*/

       for(int i=0; i<n; i++){
           sb.append(arr[i]).append("\n");
       }
       System.out.println(sb);
    }
}
