package _java.basic.inputoutput;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileInput {
    public static void main(String[] args) throws Exception {
        String filePath = "./_java/baekjoon/input.txt";

        BufferedReader br = new BufferedReader(new FileReader(filePath));
        System.out.println(br.readLine());
    }
}
