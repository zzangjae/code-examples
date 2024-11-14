package _java.baekjoon;
import java.io.*;
import java.util.*;

/**
 * 아이디어
 * 틱택토 게임에서 이기는 경우의 케이스는 행 3줄, 열 3줄, 대각선 2줄 총 11개이다.
 * 문제 조건에서 한 칸을 두면 이기는 케이스만 준다고 했으므로,
 * 9개의 칸 중 한 칸에 둘 경우 이기는 11개 케이스를 모두 점검하여 이기는 경우를 구하자.
 *
 * 구현
 * 1. 테스트 케이스 개수 t를 입력 받고 각 테스트 케이스의 틱택토 판 현황을 입력 받는다.. (t 조건이 없음...)
 * 2. 각 테스트 케이스에 대해 9칸에 대해 11개 이기는 케이스를 모두 점검한 뒤 이기는 경우의 케이스를 출력한다.
 *
 */
public class B9290 {

    /**
     * 현재 board 가 이기는 경우인지 체크한다.
     */
    static boolean isWin(char[][] board, char marker) {
        // 가로와 세로 확인
        for (int i = 0; i < 3; i++) {
            // 가로 체크
            if (board[i][0] == marker && board[i][1] == marker && board[i][2] == marker) {
                return true;
            }
            // 세로 체크
            if (board[0][i] == marker && board[1][i] == marker && board[2][i] == marker) {
                return true;
            }
        }

        // 대각선 확인
        if (board[0][0] == marker && board[1][1] == marker && board[2][2] == marker) {
            return true;
        }
        if (board[0][2] == marker && board[1][1] == marker && board[2][0] == marker) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        // 테스트 케이스 개수 t를 입력 받고 각 테스트 케이스의 틱택토 판 현황을 입력 받는다.. (t 조건이 없음...)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i=1; i<=t; i++) {
            char[][] board = new char[3][3];

            for (int r = 0; r < 3; r++) {
                board[r] = br.readLine().toCharArray();
            }

            char marker = br.readLine().charAt(0);
            boolean foundWin = false;

            for (int r = 0; r < 3 && !foundWin; r++) {
                for (int c = 0; c < 3 && !foundWin; c++) {
                    if (board[r][c] == '-') {
                        board[r][c] = marker;
                        if (isWin(board, marker)) {
                            foundWin = true;
                            System.out.println("Case " + i + ":");
                            for (int l = 0; l < 3; l++) {
                                System.out.println(board[l]);
                            }
                        }
                        board[r][c] = '-';
                    }
                }
            }
        }
    }
}
