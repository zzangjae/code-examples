package _java.baekjoon;

import java.io.*;
import java.util.*;

public class B2693 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<t; i++) {
            String[] nums = br.readLine().split(" ");
            int[] sortedNums = new int[nums.length];

            for (int j=0; j<nums.length; j++) {
                sortedNums[j] = Integer.parseInt(nums[j]);
            }

            Arrays.sort(sortedNums);

            sb.append(sortedNums[7]).append("\n");
        }

        System.out.println(sb);
    }
}
