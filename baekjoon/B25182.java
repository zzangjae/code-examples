package _java.baekjoon;

import java.io.*;
import java.util.*;

public class B25182 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long result = 0;
        long sum = 0;
        long count = 1;

        for (int i=1; i<=n; i++) {
            sum = (sum + i * 2) % (1000000007);
            result += i * (sum) % (1000000007);
            result = result % (1000000007);
        }


        for (int i=2; i<=n; i++) {
            count = (count * i % 1000000007) * i % 1000000007;
        }

        System.out.println(result + " " + count);
    }
}
