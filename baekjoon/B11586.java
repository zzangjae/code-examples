package _java.baekjoon;
import java.util.*;
import java.io.*;

/**
 * 11586 지영 공주님의 마법 거울
 *
 * 1. 마법 거울의 크기 N, 마법 거울에 비친 지영 공주, 마법 거울의 심리 상태 K를 입력 받는다.
 * 2. 거울의 심리 상태 K 에 따라 다르게 주어진 지영 공주의 모습을 보여준다.
 * K = 1 : 그대로 보여줌
 * K = 2 : 좌우 반전
 * K = 3 : 상하 반전
 */
public class B11586 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] mirror = new char[n][n];
        for (int i=0; i<n; i++) {
            mirror[i] = br.readLine().toCharArray();
        }

        int k = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {

            if (k == 1) sb.append(mirror[i]).append("\n");

            if (k == 2) {
                for (int j=n-1; j>=0; j--) sb.append(mirror[i][j]);
                sb.append("\n");
            }

            if (k == 3) sb.append(mirror[n-1-i]).append("\n");
        }

        System.out.println(sb);
    }
}
