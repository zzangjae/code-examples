package _java.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B24049 {
    static int n;
    static int m;
    static int[] gardenRow;
    static int[] gardenColumn;
    static HashMap<String, Integer> memo = new HashMap<>();


    public static int findValue(int r, int  c) {
        String key = r + "," + c;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (r == 0) return gardenColumn[c];
        if (c == 0) return gardenRow[r];

        int multiply = 1;
        while (r - multiply*2 >= 0 && c - multiply*2 >= 0) {
            multiply *= 2;
        }
        int result = (findValue(r - multiply, c) + findValue(r, c - multiply)) % 2;
        memo.put(key, result);
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        gardenRow = new int[n+1];
        gardenColumn = new int[m+1];

        st = new StringTokenizer(br.readLine());
        for (int r=1;  r<=n; r++) {
            gardenRow[r] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int c=1; c<=m; c++) {
            gardenColumn[c] = Integer.parseInt(st.nextToken());
        }

        System.out.println(findValue(n,m));
    }
}