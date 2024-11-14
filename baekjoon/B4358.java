package _java.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class B4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> treeTypeCount = new HashMap<>();
        PriorityQueue<String> treeAlphabetOrder = new PriorityQueue<>();

        String treeName;
        int totalTreeCount = 0;

        while ((treeName = br.readLine()) != null && !treeName.isEmpty()) {
            totalTreeCount++;
            treeTypeCount.put(treeName, treeTypeCount.getOrDefault(treeName, 0) + 1);
        }

        TreeMap<String, Integer> sortedTreeTypeCount = new TreeMap<>(treeTypeCount);

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Integer> entry : sortedTreeTypeCount.entrySet()) {
            String name = entry.getKey();
            int count = entry.getValue();
            double percentage = (double) count / totalTreeCount * 100;
            sb.append(name + " " + String.format("%.4f", percentage) + "\n");
        }

        System.out.println(sb.toString());
    }
}
