package String.MediumQuestions;

/*
Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters. The words in s will be separated 
by at least one space. Return a string of the words in reverse order concatenated by a single space.
Note that s may contain leading or trailing spaces or multiple spaces between two words. 
The returned string should only have a single space separating the words. Do not include any 
extra spaces.

Example 1:
Input: s = "the sky is blue"
Output: "blue is sky the"

Example 2:
Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

Example 3:
Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
*/

public class Q151RevereseWordsInAString {

    public String reverseWords(String s) {
        
        int i = s.length() - 1;
        StringBuilder ans = new StringBuilder();

        while (i >= 0) 
        {
            // find the extra spaces
            while (i >= 0 && s.charAt(i) == ' ')
                i--;

            int j = i;
            // find the length of the current word without space
            while (i >= 0 && s.charAt(i) != ' ')
                i--;

            // start appending each word in ans
            if (ans.length() == 0)
                ans.append(s.substring(i + 1, j + 1));
            else
                ans.append(" ").append(s.substring(i + 1, j + 1));
        }
        return ans.toString().trim();
    }
}