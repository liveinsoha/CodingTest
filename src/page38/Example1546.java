package page38;


import java.io.*;
import java.util.StringTokenizer;


public class Example1546 {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //System.out.println("plz input size");
        String str = br.readLine();
        int size = Integer.parseInt(str);

        int[] intArr = new int[size];
        double[] doubleArr = new double[size];

        //System.out.println("plz input scores");
        str = br.readLine();

        StringTokenizer tokenizer = new StringTokenizer(str);


        int i=0;
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            intArr[i] = Integer.parseInt(token);
            i++;
        }

        int max = 0;
        for (int j = 0; j < intArr.length; j++) {

            if (max <= intArr[j])
                max = intArr[j];
        }

        for (int j = 0; j < intArr.length; j++) {
            doubleArr[j] =(double) intArr[j] / max * 100;
        }

        double sum = 0;
        double avg = 0;

        for(int j=0; j<intArr.length; j++){
            sum+=doubleArr[j];
        }
        avg = (double)sum/doubleArr.length;

        System.out.println(avg);
    }
}
