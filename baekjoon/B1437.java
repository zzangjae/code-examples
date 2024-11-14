package _java.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B1437 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n <= 4) {
            System.out.println(n);
            return;
        }

        int share = n / 3;
        int remainder = n % 3;

        int result = 1;
        for (int i=0; i<share-1; i++) {
            result *= 3;
            result %= 10007;
        }

        if (remainder == 0) {
            result *= 3;
            result %= 10007;
        }
        if (remainder == 1) {
            result *= 4;
            result %= 10007;
        }
        if (remainder == 2) {
            result *= 6;
            result %= 10007;
        }

        System.out.println(result);
    }
}
