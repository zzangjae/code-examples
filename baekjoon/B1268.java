package _java.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1268 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] studentsClasses = new int[n][5];
        StringTokenizer st;

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<5; j++) {
                studentsClasses[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] studentRelations = new boolean[n][n];

        for (int i=0; i<5; i++) {
            for (int j=0; j<n; j++) {
                for (int k=j+1; k<n; k++) {
                    if (studentsClasses[j][i] == studentsClasses[k][i]) {
                        studentRelations[j][k] = true;
                        studentRelations[k][j] = true;
                    }
                }
            }
        }

        int result = 0;
        int maxCount = 0;
        for (int i=0; i<n; i++) {
            int tempCount = 0;

            for (int j=0; j<n; j++) {
                if (studentRelations[i][j]) tempCount++;
            }

            if (tempCount > maxCount) {
                maxCount = tempCount;
                result = i;
            }
        }

        System.out.println(result+1);
    }
}
