package Trie.MediumQuestions;

/*
Complete the Insert and Search functions for a Trie Data Structure. 
    Insert: Accepts the Trie's root and a string, modifies the root in-place, and returns nothing.
    Search: Takes the Trie's root and a string, returns true if the string is in the Trie, otherwise false.

Note: To test the correctness of your code, the code-judge will be inserting a list of N strings 
called into the Trie, and then will search for the string key in the Trie. The code-judge will 
generate 1 if the key is present in the Trie, else 0.

Example 1:
Input:
n = 8
list[] = {the, a, there, answer, any, by, bye, their}
key = the
Output: 1
Explanation: "the" is present in the given set of strings. 

Example 2:
Input:
n = 8
list[] = {the, a, there, answer, any, by, bye, their}
key = geeks
Output: 0
Explanation: "geeks" is not present in the given set of strings.
*/

public class QInsertAndSearchInTrie {

    static void insert(TrieNode root, String key) {
        // Your code here
        TrieNode curNode = root;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (curNode.children[ch - 'a'] == null) {
                // insert current character to the node and point to empty new node
                TrieNode newNode = new TrieNode();
                curNode.children[ch - 'a'] = newNode;
            }
            curNode = curNode.children[ch - 'a'];// move to new node
        }
        curNode.isEndOfWord = true;
    }

    // Function to use TRIE data structure and search the given string.
    static boolean search(TrieNode root, String key) {
        // Your code here
        TrieNode curNode = root;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (curNode.children[ch - 'a'] == null) {
                return false;
            }
            curNode = curNode.children[ch - 'a'];// move to new node
        }
        return curNode.isEndOfWord;
    }
}