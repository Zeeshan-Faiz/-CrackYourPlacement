package Matrix.MediumQuestions;

/*
Given an m x n grid of characters board and a string word, return true if word exists in 
the grid. The word can be constructed from letters of sequentially adjacent cells, where 
adjacent cells are horizontally or vertically neighboring. The same letter cell may not be 
used more than once.

Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
*/

public class Q79WordSearch {

    public boolean exist(char[][] board, String word) {
        
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == words[0] && helper(board, i, j, words, 0))
                    return true;
            }
        }
        return false;
    }
}