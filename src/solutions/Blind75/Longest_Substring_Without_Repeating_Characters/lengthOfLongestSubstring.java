package src.solutions.Blind75.Longest_Substring_Without_Repeating_Characters;

import java.util.HashSet;
import java.util.Set;

class lengthOfLongestSubstring{
    public static void main(String[] args){
        String s = "abcabcbb";
        String s_2 = "bbbbb";
        String s_3 = "pwwkew";
        String s_4 = "";
        String s_5 = " ";
        String s_6 = "dvdf";
        Solution sol = new Solution();
        System.out.println("Test 1: " + (sol.lengthOfLongestSubstring(s) == 3));
        System.out.println("Test 2: " + (sol.lengthOfLongestSubstring(s_2) == 1));
        System.out.println("Test 3: " + (sol.lengthOfLongestSubstring(s_3) == 3));
        System.out.println("Test 4: " + (sol.lengthOfLongestSubstring(s_4) == 0));
        System.out.println("Test 5: " + (sol.lengthOfLongestSubstring(s_5) == 1));
        System.out.println("Test 6: " + (sol.lengthOfLongestSubstring(s_6) == 3));
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
/*
    Logic:
    1. We will use two pointers left and right.
    2. We will use a hashset to keep track of the characters in the current substring.
    3. We will move the right pointer till we encounter a duplicate character.
    4. Once we encounter a duplicate character we will move the left pointer till we remove the duplicate character.
    5. We will keep track of the longest substring.
*/
class Solution{
    public int lengthOfLongestSubstring(String s){
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        int left = 0;
        int right = 0;
        int longestSub = 0;
        Set<Character> hash = new HashSet<>();

        while(right < len){
            if(!hash.contains(s.charAt(right))){
                hash.add(s.charAt(right));
                right++;
                longestSub = Math.max(longestSub, hash.size());
            }else{
                hash.remove(s.charAt(left));
                left++;
            }
        }

        return longestSub;
    }
}