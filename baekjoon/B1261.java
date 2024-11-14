package _java.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B1261 {

    private static int[][] maze;
    private static int n;
    private static int m;
    private static int[][] isVisited;
    private static int[] dx = {1, 0};
    private static int[] dy = {0, 1};
    private static void dfs(int x, int y, int wallCount) {

        for (int i = 0; i < 2; i++) {
            if (x+dx[i] < 0 || x+dx[i] >= m) continue;
            if (y+dy[i] < 0 || y+dy[i] >= n) continue;

            if (isVisited[y+dy[i]][x+dx[i]] > wallCount) {
                if (maze[y+dy[i]][x+dx[i]] == 0) {
                    dfs(x+dx[i], y+dy[i], wallCount);
                    isVisited[y+dy[i]][x+dx[i]] = wallCount;
                }
                else {
                    dfs(x+dx[i], y+dy[i], wallCount+1);
                    isVisited[y+dy[i]][x+dx[i]] = wallCount+1;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        maze = new int[n][m];

        for (int i=0; i<n; i++) {
            String row = br.readLine();
            for (int j=0; j<m; j++) {
                if (row.charAt(j) == '0') maze[i][j] = 0;
                else maze[i][j] = 1;
            }
        }

        isVisited = new int[n][m];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                isVisited[i][j] = 200;
            }
        }

        isVisited[0][0] = 0;

        dfs(0, 0, 0);

        System.out.println(isVisited[n-1][m-1]);
    }
}
