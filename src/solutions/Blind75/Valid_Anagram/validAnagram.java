package src.solutions.Blind75.Valid_Anagram;// Problem Link: https://leetcode.com/problems/valid-anagram/
import java.util.Arrays;

class validAnagram{
    public static void main(String[] args){
        String test1 = "anagram";
        String test2 = "nagaram";
        String test3 = "rat";
        String test4 = "car";
        // Intitial Solution
        System.out.println("Initial Solution Result:");
        System.out.println(isValid(test1, test2));
        System.out.println(isValid(test3, test4));
        // Optimal Solution
        System.out.println("Optimal Solution Result:");
        System.out.println(isValidOptimal(test1, test2));
        System.out.println(isValidOptimal(test3, test4));
    }

    // Time Complexity : O(n)
    // Space Complexity : O(1)
    // This solution only uses one array to store the frequency of characters in s and t. We increment the frequency of characters in s and decrement the frequency of characters in t. If the frequency of any character is greater than 0, then we return false.
    private static boolean isValidOptimal(String s, String t){
        if(s.length() != t.length()) return false;
        int[] charFreqCount = new int[26];
        for(int i = 0; i < s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            charFreqCount[c1-'a']++;
            charFreqCount[c2-'a']--;
        }

        for(int freq : charFreqCount){
            if(freq > 0){
                return false;
            }
        }

        return true;
    }

    // Time Complexity : O(n)
    // Space Complexity : O(1)
    private static boolean isValid(String s, String t){
        if(s.length() != t.length()) return false;
        int[] sCharCount = new int[26];
        int[] tCharCount = new int[26];

        for(int i = 0; i < s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            sCharCount[c1-'a']++;
            tCharCount[c2-'a']++;
        }
        return 0 == Arrays.compare(sCharCount, tCharCount);
    }
}