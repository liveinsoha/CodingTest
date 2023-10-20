package page209더하기뺴기괄호;

import java.io.*;

public class Example1541_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int sum = 0;
        String[] sArr = str.split("[-]");
        for (int i = 0; i < sArr.length; i++) {
            int temp = sum(sArr[i]);

            if (i == 0) {
                sum += temp;
            } else {
                sum -= temp;
            }
        }
        System.out.println(sum);
    }

    public static int sum(String str) {
        int temp = 0;
        String[] sArr = str.split("[+]+");
        for (int i = 0; i < sArr.length; i++) {
            temp += Integer.parseInt(sArr[i]);
        }
        return temp;
    }
}
