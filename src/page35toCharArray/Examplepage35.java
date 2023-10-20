package page35toCharArray;

import java.util.Scanner;

public class Examplepage35 {

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String str = sc.nextLine();
        char[] charArr = str.toCharArray();

        int sum = 0;
        for (int i = 0; i < n; i++) {
         sum += Integer.parseInt(String.valueOf(charArr[i]));

        }

        System.out.println(sum);


    }
}
