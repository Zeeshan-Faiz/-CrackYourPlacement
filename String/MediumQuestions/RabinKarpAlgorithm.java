package String.MediumQuestions;

/*
Given a text T[0. . .n-1] and a pattern P[0. . .m-1], write a function 
search(String text,String pattern) that prints all occurrences of pattern present in text using 
Rabin Karp algorithm.
The Rabin-Karp algorithm check every substring. But unlike the Naive algorithm, it matches the 
hash value of the pattern with the hash value of the current substring of text, and if the 
hash values match then only it starts matching individual characters.
*/

public class RabinKarpAlgorithm {

    private final int PRIME = 101;

    public void search(String text, String pattern) {

        int patternLength = pattern.length();
        double patternHash = calculateHash(pattern);
        double textHash = calculateHash(text.substring(0, patternLength));

        for (int i = 0; i <= text.length() - patternLength; i++) 
        {
            if (textHash == patternHash) {
                if (text.substring(i, i + patternLength).equals(pattern))
                    System.out.println("Pattern found at index " + i);
            }
            if (i < text.length() - patternLength)
                textHash = updateHash(textHash, text.charAt(i), text.charAt(i + patternLength), patternLength);
        }
    }

    private double calculateHash(String str) {

        double hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash += str.charAt(i) * Math.pow(PRIME, i);
        }
        return hash;
    }

    private double updateHash(double prevHash, char oldChar, char newChar, int patternLength) {
        
        double newHash = (prevHash - oldChar) / PRIME;
        newHash = newHash + newChar * Math.pow(PRIME, patternLength - 1);
        return newHash;
    }
}