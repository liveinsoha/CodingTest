package page44구간합;

import java.util.Scanner;

public class Example11659 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int times = sc. nextInt();

        int[] intArr = new int[size];
        int[] sumArr = new int[size];

        for(int i=0; i<intArr.length; i++){
            intArr[i]= sc.nextInt();
            if(i==0){
                sumArr[i]=intArr[i];
            }else {
                sumArr[i] = sumArr[i - 1] + intArr[i];
            }
        }

        for(int i=0; i< times; i++){
            int startIdx = sc.nextInt()-1;
            int endIdx = sc.nextInt()-1;
            if(startIdx == 0) {
                System.out.println(sumArr[endIdx]);
            }else {
                System.out.println(sumArr[endIdx] - sumArr[startIdx-1]);
            }
        }
    }
}
