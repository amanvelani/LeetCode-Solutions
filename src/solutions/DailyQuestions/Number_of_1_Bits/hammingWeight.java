package src.solutions.DailyQuestions.Number_of_1_Bits;

class hammingWeight{
    public static void main(String[] args) {
        int n_1 = 00000000000000000000000000001011;
        int n_2 = 00000000000000000000000010000000;
        Solution s = new Solution();
        System.out.println("Test 1: " + (s.hammingWeight(n_1) == 3));
        System.out.println("Test 2: " + (s.hammingWeight(n_2) == 1));
    }
}

// Time Complexity : O(1)
// Space Complexity : O(1)
/*
    Logic:
    1. We will use the concept of bit manipulation.
    2. We will use the AND operator to check if the last bit is 1 or not.
    3. If the last bit is 1 then we will increment the count.
    4. We will right shift the number by 1.
    5. We will repeat the above steps till the number becomes 0.
*/
class Solution{
    public int hammingWeight(int n){
        int count = 0;
        while(n!=0){
            n = n & n-1;
            count++;
        }
        return count;
    }
}