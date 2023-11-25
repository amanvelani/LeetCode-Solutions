class validPalindrome{
    public static void main(String[] args){
        String test1 = "A man, a plan, a canal: Panama";
        String test2 = "race a car";
        String test3 = " ";

        // Initial Solution
        System.out.println("Initial Solution Result:");
        System.out.println(isPalindrome(test1));
        System.out.println(isPalindrome(test2));
        System.out.println(isPalindrome(test3));

    }

    // Time Complexity : O(n)
    // Space Complexity : O(1)
    /*
        Logic:
        1. We will use two pointers, one at the start and one at the end.
        2. We will check if the character at the start is a letter or digit. If it is not a letter or digit, we will increment the start pointer.
        3. We will check if the character at the end is a letter or digit. If it is not a letter or digit, we will decrement the end pointer.
        4. If the character at the start and end are both letters or digits, we will check if they are equal. If they are not equal, we will return false.
        5. If the character at the start and end are both letters or digits, and they are equal, we will increment the start pointer and decrement the end pointer.
        6. We will return true at the end of the loop.
     */
    private static boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;

        while(left < right){
            char start = s.charAt(left);
            char end = s.charAt(right);
            if(!Character.isLetterOrDigit(start)) left++;
            else if(!Character.isLetterOrDigit(end)) right--;
            else{
                if(Character.toLowerCase(start) != Character.toLowerCase(end)) return false;
                left++;
                right--;
            }
        }
        return true;
    }
}