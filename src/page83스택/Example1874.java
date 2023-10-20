package page83스택;

import java.io.*;

public class Example1874 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        ArrayStack stack = new ArrayStack(n);

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        boolean result  = true;

        int count = 0;
        int now = 0;
        int p;
        StringBuilder builder = new StringBuilder();

        while (count < n) {
            p = arr[count];

            if (p > now) {
                for (int i = now + 1; i <= p; i++) {
                    stack.push(i);
                    builder.append("+\n");
                }
                stack.pop();
                builder.append("-\n");
                now = p;
            } else {
                if (stack.peek() == p) {
                    stack.pop();
                    builder.append("-\n");
                } else {
                    System.out.println("NO");
                    return;
                }
            }
            count++;
        }
            builder.deleteCharAt(builder.length() - 1);
            System.out.println(builder);

    }

    static class ArrayStack{
        int [] arr;
        int top = 0;

        public ArrayStack(int n){
            this.arr = new int[n];
        }

        public int pop(){
            int result = arr[top-1];
            top--;
            return result;
        }
        public int peek(){
            return arr[top-1];
        }

        public void push(int i){
            arr[top] = i;
            top++;
        }
    }
}
