package page104버블소트정렬끝;

import java.io.*;
import java.util.*;

public class Example1377_2 {
    //필드로 실제값과 초기 인덱스를 가지는 클래스를 정의하고 값에 대해서 오름차순 정렬하고 제일 많이 왼쪽으로 이동한'
    //곳을 찾는다. 그 이후부터는 버블 소트가 일어나지 않는다.
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] idxDiff = new int[n];

        Map[] mapArr = new Map[n];

        for (int i = 0; i < n; i++) {
            mapArr[i] = new Map(Integer.parseInt(br.readLine()),i);
        }

        Arrays.sort(mapArr);
        int max = 0 ;
        for (int i = 0; i < n; i++) {
            if(max <= mapArr[i].firstIdx - i){
                max = mapArr[i].firstIdx - i;
            }
        }

        System.out.println(max+1);
    }

    public static class Map implements Comparable<Map>{
        int value;
        int firstIdx;

        public Map(int value, int firstIdx){
            this.value = value;
            this.firstIdx = firstIdx;
        }

        @Override
        public int compareTo(Map o){
            return this.value - o.value;
        } //뒤에게 크면 음수. 클수록 뒤로 밀림. 오름차순



    }
}
