package _java.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B2512 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> province = new PriorityQueue<>();

        for (int i=0; i<n; i++) {
            province.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        int average = m / n;

        while (!province.isEmpty() && province.peek() < average) {
            n--;

            if (n==0) {
                average = province.poll();
                break;
            }

            m -= province.poll();
            average = m/n;
        }

        System.out.println(average);
    }
}
