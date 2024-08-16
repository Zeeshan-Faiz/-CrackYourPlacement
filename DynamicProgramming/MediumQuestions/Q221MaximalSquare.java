package DynamicProgramming.MediumQuestions;

/*
Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 
1's and return its area.

Example 1:
Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 4

Example 2:
Input: matrix = [["0","1"],["1","0"]]
Output: 1

Example 3:
Input: matrix = [["0"]]
Output: 0
*/

public class Q221MaximalSquare {
    
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n][m];

        //fill first column and first row as is
        for (int i = 0; i < m; i++)
            dp[0][i] = matrix[0][i] - '0';
        for (int i = 0; i < n; i++)
            dp[i][0] = matrix[i][0] - '0';

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) 
            {
                if (matrix[i][j] == '1')
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
            }
        }

        //find the max count for total square at that index, return it's area.
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }

        return maxLength * maxLength;
    }
}