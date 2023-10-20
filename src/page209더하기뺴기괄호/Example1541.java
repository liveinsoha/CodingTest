package page209더하기뺴기괄호;

import java.io.*;
import java.util.*;

public class Example1541 {
    public static void main(String[] args) throws Exception {

        int[] arr;
        String[] stArr;


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] sArr = str.split("[+-]+");
        arr = new int[sArr.length];
        stArr = new String[sArr.length - 1];

        for (int i = 0; i < sArr.length; i++) {
            char[] cArr = sArr[i].toCharArray();
            for (int j = 0; j < cArr.length; j++) {
                arr[i] += (int) (((cArr[cArr.length - 1 - j] - '0') * Math.pow(10, j)));
            }
        }

        StringTokenizer st = new StringTokenizer(str, "[0123456789]");

        for (int i = 0; i < stArr.length; i++) {
            stArr[i] = st.nextToken();
        }

        int sum = arr[0];
        int i = 0;
        while (i < stArr.length) {
            if (stArr[i].equals("-")) {
                int temp = arr[i + 1];
                i++;
                while (i < stArr.length && stArr[i].equals("+")) {
                    temp += arr[i + 1];
                    i++;
                }
                sum -= temp;
            } else {
                sum += arr[i + 1];
                i++;
            }
        }

        System.out.println(sum);


    }
}
