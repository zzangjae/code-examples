package _java.baekjoon;
import java.util.*;
import java.io.*;

/**
 * 2932 표 회전
 * 자료구조를 Array로 구현하고 실제 위치를 교환하는 작업을 수행하면 연산을 2000만정도 수행할 것으로 예상됨..
 *
 * 1. N, K 입력받기
 * 2. 이동하려는 숫자를 입력받고 이동 연산 수행
 * 3. 최종적으로 이동시키는데 필요한 회전 수 구하기
 */
public class B2932 {

    static class Position {
        int r;
        int c;

        Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] num = new int[n][n];
        Map<Integer, Position> map = new HashMap<>();

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                num[i][j] = 1 + i*n + j;
                map.put(1 + i*n + j, new Position(i, j));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            Position currentPosition = map.get(x);

            // 열 회전

            int[] tempNum = new int[n];
            for (int j=0; j<n; j++) {
                tempNum[j] = num[currentPosition.r][(j + currentPosition.c - c) < 0 ? (j + currentPosition.c - c + n) % n : (j + currentPosition.c - c) % n];
                map.put(tempNum[j], new Position(currentPosition.r, j));
            }
            num[currentPosition.r] = tempNum;

            tempNum = new int[n];
            for (int j=0; j<n; j++) {
                tempNum[j] = num[(j + currentPosition.r - r) < 0 ? (j + currentPosition.r - r + n) % n : (j + currentPosition.r - r) % n][c];
                map.put(tempNum[j], new Position(j, c));
            }
            for (int j=0; j<n; j++) {
                num[j][c] = tempNum[j];
            }

            sb.append((c - currentPosition.c >= 0 ? c - currentPosition.c : c - currentPosition.c + n) + (r - currentPosition.r >= 0 ? r - currentPosition.r : r - currentPosition.r + n)).append("\n");
        }

        System.out.println(sb);
    }
}
