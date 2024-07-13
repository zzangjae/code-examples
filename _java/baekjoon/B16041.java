package _java.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16041 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 받는 부분
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] cookies = new int[n];
        int lengthSum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            cookies[i] = Integer.parseInt(st.nextToken());
            lengthSum += cookies[i];
        }

        // 공평하게 과자를 나눠줄 수 없는 경우
        if (lengthSum < m) {
            System.out.println(0);
            return;
        }

        // 이분탐색으로 정답을 찾는 로직
        int left = 1;
        int right = 1000000000;
        int maxLength = (left+right) / 2;

        while (0 <= right - left) {
            int cookieCount = 0;

            for (int i=0; i<n; i++) {
                cookieCount += cookies[i] / maxLength;
            }

            if (cookieCount >= m) {
                left = maxLength + 1;
                maxLength = (left+right) / 2;
            }

            if (cookieCount < m) {
                right = maxLength - 1;
                maxLength = (left+right) / 2;
            }
        }

        System.out.println(maxLength);
    }
}
