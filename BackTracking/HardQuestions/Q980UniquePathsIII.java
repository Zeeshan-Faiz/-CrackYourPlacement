package BackTracking.HardQuestions;

/*
You are given an m x n integer array grid where grid[i][j] could be:

    1 representing the starting square. There is exactly one starting square.
    2 representing the ending square. There is exactly one ending square.
    0 representing empty squares we can walk over.
    -1 representing obstacles that we cannot walk over.

Return the number of 4-directional walks from the starting square to the ending square, that walk 
over every non-obstacle square exactly once.

Example 1:
Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)

Example 2:
Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
Output: 4
Explanation: We have the following four paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
*/

public class Q980UniquePathsIII {

    public int uniquePathsIII(int[][] grid) {
        int zero = 0; // Count the total 0's
        int sx = 0, sy = 0; // starting x and y index

        // count total zeroes and find the starting point
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0)
                    zero++;
                else if (grid[r][c] == 1) {
                    sx = r;
                    sy = c;
                }
            }
        }
        return helper(grid, sx, sy, zero);
    }

    public int helper(int grid[][], int x, int y, int zero) {

        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1)
            return 0;

        // reached ending point
        if (grid[x][y] == 2) {
            return zero == -1 ? 1 : 0;// if CountZero = -1, it means we covered all zeroes and return 1 otherwise 0
        }
        grid[x][y] = -1;// mark the visited cell and reduce countZero
        zero--;

        // traverse all 4 directions
        int totalPaths = helper(grid, x + 1, y, zero) +
                helper(grid, x - 1, y, zero) +
                helper(grid, x, y + 1, zero) +
                helper(grid, x, y - 1, zero);

        grid[x][y] = 0;
        zero++;// backtrack and unmark the cell and make the CountZero as is.

        return totalPaths;
    }
}