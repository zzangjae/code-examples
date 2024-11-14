package _java.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B17175 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] fibonacciNum = new long[51];
        fibonacciNum[0] = 1;
        fibonacciNum[1] = 1;

        for (int i=2; i<=50; i++) {
            fibonacciNum[i] = fibonacciNum[i-1] + fibonacciNum[i-2] + 1;
        }

        System.out.println(fibonacciNum[n] % 1000000007);


    }
}
