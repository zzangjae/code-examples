package _java.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16967 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int h = Integer.parseInt(st.nextToken());
        final int w = Integer.parseInt(st.nextToken());
        final int x = Integer.parseInt(st.nextToken());
        final int y = Integer.parseInt(st.nextToken());

        int[][] nums = new int[h+x][w+y];

        for (int i=0; i<h+x; i++) {

            st = new StringTokenizer(br.readLine());

            for (int j=0; j<w+y; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] answer = new int[h][w];

        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {

                if (i < x) {
                    answer[i][j] = nums[i][j];
                    continue;
                }

                if (j < y) {
                    answer[i][j] = nums[i][j];
                    continue;
                }

                answer[i][j] = nums[i][j] - answer[i-x][j-y];
            }
        }


        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}
