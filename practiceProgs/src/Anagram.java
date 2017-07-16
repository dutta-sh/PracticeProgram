import java.util.Scanner;

/**
 * Write me a program that accepts a block of text (English words),
 * and outputs the groups of words that are anagrams of each other.
 * For example, “apt”, “tap” and “pat” are anagrams of each other.
 */
public class Anagram {
    public static void main(String[] args) {
        System.out.println("Enter the words as csv (no spaces):");
        Scanner in  = new Scanner(System.in);
        String input = in.next();

        String[] words = input.split(",");
        //String[] words = new String[]{"apt", "tap", "pat", "xyz", "aba", "baa"};
        findAnagrams(words);
    }

    //time complexity O(n^2)
    private static void findAnagrams(String[] words) {
        int[][] ascii = new int[words.length][128]; //128 printable characters

        for(int i = 0; i < words.length; i++) {
            char[] wordArr = words[i].toCharArray();
            for(int j = 0; j < wordArr.length; j++) {
                ascii[i][wordArr[j]]++ ;
            }
        }

        for(int i = 0; i < words.length; i++) {
            boolean isAnagram = true;
            for(int j = i+1; j < words.length; j++) {
                for(int k = 0; k < 128; k++) {
                    if(ascii[i][k] - ascii[j][k] != 0) {
                        isAnagram = false;
                        break;
                    }
                }
                if(isAnagram)
                    System.out.println(words[i] + " ::: " + words[j]);
            }
        }
    }
}
