package Trie.MediumQuestions;

/*
Design a data structure that supports adding new words and finding if a string matches any 
previously added string.

Implement the WordDictionary class:
    WordDictionary() Initializes the object.
    void addWord(word) Adds word to the data structure, it can be matched later.
    bool search(word) Returns true if there is any string in the data structure that matches word or 
    false otherwise. word may contain dots '.' where dots can be matched with any letter.

Example 1:
Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
*/

public class Q211DesignAddAndSearchDS {
    
    private Q211DesignAddAndSearchDS[] children;
    boolean isEndOfWord;

    // Initialize your data structure here.
    public Q211DesignAddAndSearchDS() {
        children = new Q211DesignAddAndSearchDS[26];
        isEndOfWord = false;
    }

    public void addWord(String word) {
        Q211DesignAddAndSearchDS curr = this;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new Q211DesignAddAndSearchDS();
            curr = curr.children[c - 'a'];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        Q211DesignAddAndSearchDS curr = this;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (c == '.') {
                for (Q211DesignAddAndSearchDS ch : curr.children)
                    if (ch != null && ch.search(word.substring(i + 1)))
                        return true;
                return false;
            }
            if (curr.children[c - 'a'] == null)
                return false;
            curr = curr.children[c - 'a'];
        }
        return curr != null && curr.isEndOfWord;
    }
}