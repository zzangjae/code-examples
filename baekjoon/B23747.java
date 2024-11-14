package _java.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class B23747 {
    static int mr, mc, hr, hc;
    static char[][] board;
    static int[][] direction;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        mr = Integer.parseInt(st.nextToken());
        mc = Integer.parseInt(st.nextToken());

        board = new char[mr][mc];
        for (int i=0; i<mr; i++) {
            board[i] = br.readLine().toCharArray();
        }

        st = new StringTokenizer(br.readLine());
        hr = Integer.parseInt(st.nextToken()) - 1;
        hc = Integer.parseInt(st.nextToken()) - 1;

        String travelLog = br.readLine();
        direction = new int[][]{
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };
        visited = new boolean[mr][mc];
        for (int i=0; i<travelLog.length(); i++) {
            char log = travelLog.charAt(i);
            if (log == 'U') {
                hr--;
                continue;
            }
            if (log == 'D') {
                hr++;
                continue;
            }
            if (log == 'L') {
                hc--;
                continue;
            }
            if (log == 'R') {
                hc++;
                continue;
            }
            if (log == 'W' && !visited[hr][hc]) dfs(hr, hc, board[hr][hc]);
        }

        for (int i=0; i<mr; i++) {
            for (int j=0; j<mc; j++) {
                if (!visited[i][j]) board[i][j] = '#';
                else board[i][j] = '.';
            }
        }

        board[hr][hc] = '.';
        for (int i=0; i<4; i++) {
            int dr = hr + direction[i][0];
            int dc = hc + direction[i][1];

            if (dr >= 0 && dr < mr && dc >= 0 && dc < mc) board[dr][dc] = '.';
        }

        for (int i = 0; i < mr; i++) {
            for (int j=0; j<mc; j++) {
                bw.write(board[i][j]);
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    private static void dfs(int r, int c, char alphabet) {
        visited[r][c] = true;

        for (int i=0; i<4; i++) {
            int dr = r + direction[i][0];
            int dc = c + direction[i][1];

            if (dr >= 0 && dr < mr && dc >= 0 && dc < mc && board[dr][dc] == alphabet && !visited[dr][dc]) {
                dfs(dr, dc, alphabet);
            }
        }
    }
}
