package _java.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B8892 {

    private static boolean isPalindrome(String word) {

        int wordLength = word.length();

        for (int i=0; i<wordLength; i++) {
            if (word.charAt(i) != word.charAt(wordLength-i-1)) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCaseNum = Integer.parseInt(br.readLine());

        for (int i=0; i<testCaseNum; i++) {

            int wordCount = Integer.parseInt(br.readLine());
            String[] words = new String[wordCount];

            for (int j=0; j<wordCount; j++) {
                words[j] = br.readLine();
            }

            boolean palindromeFound = false;

            outerLoop:
            for (int j=0; j<wordCount; j++) {
                for (int k=j+1; k<wordCount; k++) {
                    if (isPalindrome(words[j] + words[k])) {
                        System.out.println(words[j] + words[k]);
                        palindromeFound = true;
                        break outerLoop;
                    }

                    if (isPalindrome(words[k] + words[j])) {
                        System.out.println(words[k] + words[j]);
                        palindromeFound = true;
                        break outerLoop;
                    }
                }
            }

            if (!palindromeFound) System.out.println(0);
        }
    }
}
