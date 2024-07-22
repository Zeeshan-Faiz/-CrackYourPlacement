package Mathematical.EasyQuestions;

/*
Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
For example:
A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...

Example 1:
Input: columnNumber = 1
Output: "A"

Example 2:
Input: columnNumber = 28
Output: "AB"

Example 3:
Input: columnNumber = 701
Output: "ZY"
*/

public class Q168ExcelSheetColumnTitle {
    
    public String convertToTitle(int col) {
        StringBuilder ans = new StringBuilder();
        while (col > 0) {
            int r = (col - 1) % 26;
            ans.append((char)(r + 'A'));
            col = (col - 1) / 26;
        }
        return ans.reverse().toString();
    }
}