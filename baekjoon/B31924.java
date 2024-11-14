package _java.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B31924 {

    private static final int[][] direction = {
        {1, 0},
        {1, 1},
        {0, 1},
        {-1, 1},
        {-1, 0},
        {-1, -1},
        {0, -1},
        {1, -1}
    };

    private static char[][] grid;

    private static final char[] charObjective = {'M', 'O', 'B', 'I', 'S'};
    private static int n;

    private static boolean checkObjective(int r, int c, int d, int charIdx) {
        if (charIdx == 5) {
            return true;
        }

        int newR = r + direction[d][0]*charIdx;
        int newC = c + direction[d][1]*charIdx;

        if (newR < 0 || newR >= n || newC < 0 || newC >= n ) return false;

        if (grid[newR][newC] == charObjective[charIdx]) {
            return checkObjective(r, c, d, charIdx+1);
        }

        return false;
    }
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int answer = 0;

        grid = new char[n][n];

        for (int i=0; i<n; i++) {
            String row = br.readLine();

            for (int j=0; j<n; j++) {
                grid[i][j] = row.charAt(j);
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                for (int k=0; k<8; k++) {
                    if (checkObjective(i, j, k, 0)) answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
