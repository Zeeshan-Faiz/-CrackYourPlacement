package StackAndQueues.EasyQuestions;

/*
Given two strings s and t, return true if they are equal when both are typed into empty text 
editors. '#' means a backspace character. Note that after backspacing an empty text, the text will continue empty.

Example 1:
Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".

Example 2:
Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".

Example 3:
Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".
*/

public class Q844BackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {
        return getActual(s).equals(getActual(t));
    }

    private String getActual(String input) {

        StringBuilder actualString = new StringBuilder();
        int hashCount = 0;

        for (int i = input.length() - 1; i >= 0; i--) {

            // Keep a count of backspace characters
            if (input.charAt(i) == '#') {
                hashCount++;
                continue;
            }

            // If backspace count > 0 reduce it and skip the character
            if (hashCount > 0) {
                hashCount--;
            } else {
                // If no backspace, just insert at beginning
                actualString.insert(0, input.charAt(i));
            }
        }

        return actualString.toString();
    }
}