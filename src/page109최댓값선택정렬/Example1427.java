package page109최댓값선택정렬;

import java.io.*;

public class Example1427 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] intArr = new int[str.length()];
        int n = str.length();

        for(int i =0; i<str.length(); i++){
            intArr[i] = str.charAt(i) - '0';
        }

        for(int i =0; i<n-1; i++){
            int maxIdx = i;

            for(int j = i+1; j<n; j++){
                if(intArr[maxIdx]< intArr[j]){
                    maxIdx=j;
                }
            }
            swap(intArr,i, maxIdx);
        }

         char[] charArr = new char[n];

        for(int i=0; i<n; i++){
            charArr[i] = (char)(intArr[i]+'0');
        }

        System.out.println(charArr);




    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
