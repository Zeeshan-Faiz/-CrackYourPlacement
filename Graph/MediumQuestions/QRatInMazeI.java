package Graph.MediumQuestions;

import java.util.ArrayList;

/*
Consider a rat placed at (0, 0) in a square matrix mat of order n* n. It has to reach the destination 
at (n - 1, n - 1). Find all possible paths that the rat can take to reach from source to destination. 
The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell 
in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix 
represents that rat can be travel through it.
Note: In a path, no cell can be visited more than one time. If the source cell is 0, the rat cannot move 
to any other cell. In case of no path, return an empty list. The driver will output "-1" automatically.

Example 1:
Input: mat[][] = [[1, 0, 0, 0],
                [1, 1, 0, 1], 
                [1, 1, 0, 0],
                [0, 1, 1, 1]]
Output: DDRDRR DRDDRR
Explanation: The rat can reach the destination at (3, 3) from (0, 0) by two paths - DRDDRR and DDRDRR, when printed in sorted order we get DDRDRR DRDDRR.

Example 2:
Input: mat[][] = [[1, 0],
                [1, 0]]
Output: -1
Explanation: No path exists and destination cell is blocked.
*/

public class QRatInMazeI {

    public static ArrayList<String> findPath(int[][] m, int n) {

        int vis[][] = new int[n][n];
        // mark all cells as 0 initially
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = 0;
            }
        }
        int delRow[] = { +1, 0, 0, -1 };
        int delCol[] = { 0, -1, 1, 0 };
        ArrayList<String> ans = new ArrayList<>();
        // if source starts with 1, start traversing
        if (m[0][0] == 1)
            solve(0, 0, m, n, ans, "", vis, delRow, delCol);
        return ans;
    }

    private static void solve(int i, int j, int a[][], int n, ArrayList<String> ans, String move,
            int vis[][], int delRow[], int delCol[]) {

        //if destination reached, add the path
        if (i == n - 1 && j == n - 1) {
            ans.add(move);
            return;
        }
        String dir = "DLRU";
        for (int ind = 0; ind < 4; ind++) {
            int newRow = i + delRow[ind];
            int newCol = j + delCol[ind];
            if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < n &&
                    vis[newRow][newCol] == 0 && a[newRow][newCol] == 1) {

                vis[i][j] = 1;
                solve(newRow, newCol, a, n, ans, move + dir.charAt(ind), vis, delRow, delCol);
                vis[i][j] = 0; //backtrack while coming back from path
            }
        }
    }
}