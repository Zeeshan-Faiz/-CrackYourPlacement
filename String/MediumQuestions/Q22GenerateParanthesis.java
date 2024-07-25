package String.MediumQuestions;

import java.util.ArrayList;
import java.util.List;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed 
parentheses.

Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
Input: n = 1
Output: ["()"]
*/

public class Q22GenerateParanthesis {

    public List<String> generateParenthesis(int n) {
        
        List<String> result = new ArrayList<>();
        helper(result, new char[2 * n], 0, 0, 0, n);
        return result;
    }

    public void helper(List<String> result, char[] array, int open, int close, int index, int n) {

        if (index == array.length) {
            result.add(new String(array));
            return;
        }
        if (open < n) {
            array[index] = '(';
            helper(result, array, open + 1, close, index + 1, n);
        }
        if (close < open) {
            array[index] = ')';
            helper(result, array, open, close + 1, index + 1, n);
        }
    }
}