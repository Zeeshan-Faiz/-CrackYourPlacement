package DynamicProgramming.MediumQuestions;

/*
You are given two strings m and n. Your task is to find the length of the longest common substring 
among the given strings.

Input: m = "ABCDGH", n = "ACDGHR"
Output: 4
Explanation: The longest common substring is "CDGH" which has length 4.

Input: m = "ABC", n = "ACB"
Output: 1
Explanation: The longest common substrings are "A", "B", "C" all having length 1.
*/

public class QLongestCommonSubstring {

    public int longestCommonSubstr(String m, String n) {

        char[] str1 = m.toCharArray();
        char[] str2 = n.toCharArray();
        int[][] dp = new int[str1.length + 1][str2.length + 1];
        int max = 0;

        // Iterate over each position in the matrix
        for (int i = 1; i <= str1.length; i++) {
            for (int j = 1; j <= str2.length; j++) {

                // If numbers are equal
                if (str1[i - 1] == str2[j - 1]) {
                    // Get the number from diagonally opposite and add 1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max;
    }
}