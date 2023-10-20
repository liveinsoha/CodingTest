package page56투포인터연속;

import java.util.Scanner;

public class Example2018 {

    /*수의 최대 크기는 10^7이므로 O(n)의 시간복잡도로 해결해야 한다.
    * 두 개의 인덱스를 지정 가장 작을 때 부터 연속 자연수의 합과 원하는 수의 값 N을 비교한다.
    * 작으면 뒤 인덱스를 옮기고 크면 앞 인덱스를 옮긴다. 앞 인덳는 빠지고 뒤 인덱스는 들어온다.*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int sIdx = 1;
        int eIdx = 1;
        int sum = 1;
        int count = 1;

        while(eIdx !=n){ //시간 복잡도 O(n)
            if(sum<n){
                eIdx++;
                sum += eIdx;
            }else if(sum>n){
                sum -= sIdx;
                sIdx++;

            }else{
                count++;
                sum-=sIdx;
                sIdx++;
            }
        }

        System.out.println(count);
    }
}
