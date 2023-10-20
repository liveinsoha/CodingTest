package page38;

import java.util.Scanner;

public class Exmaple2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] intArr = new int[n];
        int max = 0;
        double sum = 0;
        for (int i = 0; i < n; i++) {
            intArr[i] = sc.nextInt();
           max = max > intArr[i] ? max : intArr[i];
           sum += (double)intArr[i];
        }

        double avg = sum/max/n*100;
        System.out.println(avg);
    }
}
