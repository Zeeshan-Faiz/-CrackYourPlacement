package DynamicProgramming.MediumQuestions;

import java.util.Arrays;

/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, 
which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.

Example 1:
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

Example 2:
Input: grid = [[1,2,3],[4,5,6]]
Output: 12
*/

public class Q64MinimumPathSum {

    public int minPathSum(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        int dp[][] = new int[m][n];

        // Initialize the DP matrix with -1
        for (int row[] : dp)
            Arrays.fill(row, -1);

        // Call the helper function starting from the bottom-right cell
        return helper(m - 1, n - 1, grid, dp);
    }

    private int helper(int i, int j, int[][] matrix, int[][] dp) {

        if (i == 0 && j == 0)
            return matrix[0][0]; // If we're at the top-left cell, return its value
        if (i < 0 || j < 0)
            return (int) Math.pow(10, 9); // If we're out of bounds, return a large value
        if (dp[i][j] != -1)
            return dp[i][j]; // If we've already calculated this cell, return the stored result

        // Calculate the sum of the current cell plus the minimum sum path from above and from the left
        int up = matrix[i][j] + helper(i - 1, j, matrix, dp);
        int left = matrix[i][j] + helper(i, j - 1, matrix, dp);

        // Store the minimum of the two possible paths
        return dp[i][j] = Math.min(up, left);
    }
}