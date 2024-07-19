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
    
    static void printDups(String str)
  {
    Map<Character, Integer> count = new HashMap<>();
    for (int i = 0; i < str.length(); i++) {
      if(count.containsKey(str.charAt(i)))
        count.put(str.charAt(i) , count.get(str.charAt(i))+1); 
      else count.put(str.charAt(i),1);
      //increase the count of characters by 1 
    }

    for (Map.Entry<Character,Integer> mapElement : count.entrySet()) {   //iterating through the unordered map 
      if (mapElement.getValue() > 1)   //if the count of characters is greater than 1 then duplicate found
        System.out.println(mapElement.getKey() + ", count = " + mapElement.getValue());
    }
  }
}