package _java.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11651 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] result = new int[n][2];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            result[i][0] = Integer.parseInt(st.nextToken());
            result[i][1] = Integer.parseInt(st.nextToken());
        }

        int temp;

        for (int i=0; i<n-1; i++) {
            for (int j=0; j<n-1-i; j++) {
                if (result[j][1] > result[j+1][1]) {
                    temp = result[j][1];
                    result[j][1] = result[j+1][1];
                    result[j+1][1] = temp;

                    temp = result[j][0];
                    result[j][0] = result[j+1][0];
                    result[j+1][0] = temp;
                }
                else if (result[j][1] == result[j+1][1] && result[j][1] > result[j+1][1]) {
                    temp = result[j][1];
                    result[j][1] = result[j+1][1];
                    result[j+1][1] = temp;

                    temp = result[j][0];
                    result[j][0] = result[j+1][0];
                    result[j+1][0] = temp;
                }
            }
        }

        for (int i=0; i<n; i++) {
            System.out.println(result[i][0] + " " + result[i][1]);
        }
    }
}
