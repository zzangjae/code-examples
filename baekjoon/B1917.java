package _java.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1917 {

    // 모든 전개도의 상대 좌표 정의
    static final int[][][] VALID_NETS = {
            {{0, 0}, {1, 0}, {1, 1}, {1, 2}, {1, 3}, {3, 0}},
            {{0, 0}, {1, 0}, {-1, 1}, {0, 1}, {0, 2}, {0, 3}},
            {{0, 0}, {1, 0}, {0, 1}, {0, 2}, {-1, 2}, {0, 3}},
            {{0, 0}, {1, 0}, {0, 1}, {0, 2}, {0, 3}, {-1, 3}},
            {{0, 0}, {-1, 1}, {0, 1}, {1, 1}, {0, 2}, {0, 3}},
            {{0, 0}, {0, 1}, {1, 1}, {-1, 2}, {0, 2}, {0, 3}},
            {{0, 0}, {0, 1}, {0, 2}, {-1, 2}, {-1, 3}, {-1, 4}},
            {{0, 0}, {0, 1}, {-1, 1}, {-1, 2}, {-2, 2}, {-2, 3}},
            {{0, 0}, {-1, 0}, {-1, 1}, {-1, 2}, {-2, 2}, {-2, 3}},
            {{0, 0}, {0, 1}, {1, 1}, {2, 1}, {1, 2}, {1, 3}},
            {{0, 0}, {0, 1}, {-1, -1}, {0, 2}, {1, 2}, {2, 2}}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t=0; t<3; t++) {
            int[][] grid = new int[6][6];

            // 1. 입력된 전개도의 상대 좌표 추출
            List<int[]> cells = new ArrayList<>();
            StringTokenizer st;
            for (int i=0; i<6; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j=0; j<6; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    if (grid[i][j] == 1) {
                        cells.add(new int[]{i, j});
                    }
                }
            }

            int minX = 7;
            int minY = 0;

            for (int[] cell : cells) {
                minX = Math.min(minX, cell[1]);
                if (minX == cell[1]) {
                    minY = Math.max(minY, cell[0]);
                }
            }

            // 각 좌표에서 최소 x, y를 빼서 기준점을 0, 0으로 맞추기
            for (int[] cell : cells) {
                cell[0] -= minY;
                cell[1] -= minX;
            }

            // 2. 모든 전개도와 비교
            String result = "NO";
            for (int[][] net : VALID_NETS) {
                if (matches(cells, net)) {
                    result  = "YES";
                }
            }

            System.out.println(result);
        }
    }

    // 현재 전개도가 특정 전개도(net)와 일치하는지 확인
    static boolean matches(List<int[]> cells, int[][] net) {
        for (int[][] transformed : generateTransformations(net)) {
            if (isSame(cells, transformed)) {
                return true;
            }
        }
        return false;
    }

    // 좌표 집합 비교
    static boolean isSame(List<int[]> cells, int[][] transformedNet) {
        Set<String> cellSet = new HashSet<>();
        for (int[] cell : cells) {
            cellSet.add(cell[0] + "," + cell[1]);
        }

        for (int[] coord : transformedNet) {
            if (!cellSet.contains(coord[0] + "," + coord[1])) {
                return false;
            }
        }
        return true;
    }

    // 전개도의 모든 변환(회전, 대칭) 생성
    static List<int[][]> generateTransformations(int[][] net) {
        List<int[][]> transformations = new ArrayList<>();

        // 원본 추가
        transformations.add(net);
        transformations.add(flipHorizontal(net));
        transformations.add(flipVertical(net));

        // 회전 90도, 180도, 270도
        int[][] rotated90 = rotate(net);
        transformations.add(flipHorizontal(rotated90));
        transformations.add(flipVertical(rotated90));
        transformations.add(rotated90);

        rotated90 = rotate(net);
        transformations.add(flipHorizontal(rotated90));
        transformations.add(flipVertical(rotated90));
        transformations.add(rotated90);

        rotated90 = rotate(net);
        transformations.add(flipHorizontal(rotated90));
        transformations.add(flipVertical(rotated90));
        transformations.add(rotated90);

        return transformations;
    }

    // 90도 회전
    static int[][] rotate(int[][] net) {
        int[][] rotated = new int[net.length][2];
        for (int i = 0; i < net.length; i++) {
            rotated[i][0] = net[i][1];
            rotated[i][1] = -net[i][0];
        }
        return rotated;
    }

    // 좌우 대칭
    static int[][] flipHorizontal(int[][] net) {
        int[][] flipped = new int[net.length][2];
        for (int i = 0; i < net.length; i++) {
            flipped[i][0] = net[i][0];
            flipped[i][1] = -net[i][1];
        }
        return flipped;
    }

    // 상하 대칭
    static int[][] flipVertical(int[][] net) {
        int[][] flipped = new int[net.length][2];
        for (int i = 0; i < net.length; i++) {
            flipped[i][0] = -net[i][0];
            flipped[i][1] = net[i][1];
        }
        return flipped;
    }
}
