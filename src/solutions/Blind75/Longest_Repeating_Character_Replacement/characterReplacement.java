package src.solutions.Blind75.Longest_Repeating_Character_Replacement;

class characterReplacement{
    public static void main(String[] args) {
        String s_1 = "ABAB";
        String s_2 = "AABABBA";
        String s_4 = "AAAA";
        String s_5 = "ABAA";
        Solution s = new Solution();
        System.out.println("Test 1: " + (s.characterReplacement(s_1, 2) == 4));
        System.out.println("Test 2: " + (s.characterReplacement(s_2, 1) == 4));
        System.out.println("Test 3: " + (s.characterReplacement(s_4, 2) == 4));
        System.out.println("Test 4: " + (s.characterReplacement(s_5, 0) == 2));
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
/*
    Logic:
    1. We will use two pointers left and right.
    2. We will use an array to keep track of the frequency of characters in the current window.
    3. We will move the right pointer till we encounter a character which is not the most frequent character in the current window.
    4. Once we encounter a character which is not the most frequent character in the current window we will move the left pointer till we remove the character.
    5. We will keep track of the longest substring.
*/
class Solution{
    public int characterReplacement(String s, int k){
        int[] charCount = new int[26];
        int left = 0;
        int maxFreq = 0;
        int res = 0;
        int len = s.length();

        for(int right = 0; right < len; right++){
            maxFreq = Math.max(maxFreq, ++charCount[s.charAt(right) - 'A']);
            while (right - left + 1 - maxFreq > k){
                charCount[s.charAt(left)-'A']--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

}