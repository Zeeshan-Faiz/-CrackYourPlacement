package String.HardQuestions;

import java.util.ArrayList;
import java.util.List;

/*
Given an array of strings words and a width maxWidth, format the text such that each line has exactly 
maxWidth characters and is fully (left and right) justified.
You should pack your words in a greedy approach; that is, pack as many words as you can in each line. 
Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
Extra spaces between words should be distributed as evenly as possible. If the number of spaces on 
a line does not divide evenly between words, the empty slots on the left will be assigned more spaces 
than the slots on the right.
For the last line of text, it should be left-justified, and no extra space is inserted between words.

Note:
    A word is defined as a character sequence consisting of non-space characters only.
    Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
    The input array words contains at least one word.

Example 1:
Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]

Example 2:
Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
Note that the second line is also left-justified because it contains only one word.

Example 3:
Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]
*/

public class Q68TextJustification {
    
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> result = new ArrayList<>();
        int n = words.length;
        int index = 0;

        while (index < n) {
            int totalChars = words[index].length();
            int last = index + 1;

            // Determine the last word that fits on the current line
            while (last < n) {
                if (totalChars + 1 + words[last].length() > maxWidth)
                    break;
                totalChars += 1 + words[last].length();
                last++;
            }

            StringBuilder sb = new StringBuilder();
            int diff = last - index - 1; // number of gaps between words

            // If this is the last line or contains only one word, left-justify
            if (last == n || diff == 0) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) {
                        sb.append(" ");
                    }
                }
                int remainingSpaces = maxWidth - sb.length();
                appendSpaces(sb, remainingSpaces);
            } else {
                int spaces = (maxWidth - totalChars) / diff;
                int extraSpaces = (maxWidth - totalChars) % diff;

                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) {
                        int spacesToApply = spaces + (i - index < extraSpaces ? 1 : 0);
                        appendSpaces(sb, spacesToApply + 1); // one space for word separation
                    }
                }
            }
            result.add(sb.toString());
            index = last;
        }
        return result;
    }

    private void appendSpaces(StringBuilder sb, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(" ");
        }
    }
}