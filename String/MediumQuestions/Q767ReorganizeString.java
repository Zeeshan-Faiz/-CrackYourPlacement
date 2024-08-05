package String.MediumQuestions;

/*
Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
Return any possible rearrangement of s or return "" if not possible.

Example 1:
Input: s = "aab"
Output: "aba"

Example 2:
Input: s = "aaab"
Output: ""
*/

public class Q767ReorganizeString {

    public String reorganizeString(String str) {
        int[] hash = new int[26];
        for (int i = 0; i < str.length(); i++)
            hash[str.charAt(i) - 'a']++;

        int max = 0, letter = 0;
        for (int i = 0; i < hash.length; i++)
            if (hash[i] > max) {
                max = hash[i];
                letter = i;
            }

        if (max > (str.length() + 1) / 2)
            return "";

        char[] res = new char[str.length()];

        // Fill all even places with majority character
        int idx = 0;
        while (hash[letter] > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
            hash[letter]--;
        }

        // Fill the remaining characters
        for (int i = 0; i < hash.length; i++)
            while (hash[i] > 0) {
                if (idx >= res.length)
                    idx = 1;

                res[idx] = (char) (i + 'a');
                idx += 2;
                hash[i]--;
            }

        return String.valueOf(res);
    }
}