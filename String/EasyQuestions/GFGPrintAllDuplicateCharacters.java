package String.EasyQuestions;

import java.util.HashMap;
import java.util.Map;

/*
Given a string S, the task is to print all the duplicate characters with their occurrences in the given string.

Example 1:
Input: S = “geeksforgeeks”
Output:
e, count = 4
g, count = 2
k, count = 2
s, count = 2 
*/

public class GFGPrintAllDuplicateCharacters {

    static void printDups(String str) {

        Map<Character, Integer> map = new HashMap<>();

        //count the frequency of each character
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i)))
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            else
                map.put(str.charAt(i), 1);
        }

        for (Map.Entry<Character, Integer> mapElement : map.entrySet()) 
        {
            if (mapElement.getValue() > 1)
                System.out.println(mapElement.getKey() + ", count = " + mapElement.getValue());
        }
    }
}