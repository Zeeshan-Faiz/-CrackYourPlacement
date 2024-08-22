package BackTracking.MediumQuestions;

import java.util.ArrayList;
import java.util.List;

/*
Given a string s, partition s such that every substring of the partition is a palindrome. 
Return all possible palindrome partitioning of s.

Example 1:
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Example 2:
Input: s = "a"
Output: [["a"]]
*/

public class Q131PalindromePartitioning {

    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();
        helper(0, s, ans, new ArrayList<>());
        return ans;
    }

    void helper(int index, String s, List<List<String>> res, List<String> list) {
        
        if (index == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < s.length(); i++) 
        {
            if (isPalindrome(s, index, i)) 
            {
                list.add(s.substring(index, i + 1));
                helper(i + 1, s, res, list);
                list.remove(list.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}