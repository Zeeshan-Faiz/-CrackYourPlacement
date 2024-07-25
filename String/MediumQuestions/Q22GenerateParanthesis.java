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
}