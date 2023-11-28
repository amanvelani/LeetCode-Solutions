package src.solutions.Blind75.Container_With_Most_Water;

class containerWithMostWater{
    public static void main(String[] args){
        int[] heights = {1,8,6,2,5,4,8,3,7};
        int[] heights_2 = {1,1};
        int[] heights_3 = {4,3,2,1,4};
        int[] heights_4 = {1,2,1};
        Solution s = new Solution();
        System.out.println("Test 1: " + (s.maxArea(heights) == 49));
        System.out.println("Test 2: " + (s.maxArea(heights_2) == 1));
        System.out.println("Test 3: " + (s.maxArea(heights_3) == 16));
        System.out.println("Test 4: " + (s.maxArea(heights_4) == 2));
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
/*
    Logic:
    1. We will use two pointers left and right.
    2. We will calculate the area using the formula: width * height
    3. We will move the pointer which has the smaller height.
    4. We will keep track of the maxArea.
*/
class Solution {
    public int maxArea(int[] heights){
        int left = 0;
        int right = heights.length-1;
        int maxArea = 0;
        while(left < right){
            int width = right - left;
            int height = Math.min(heights[left], heights[right]);
            int area = width * height;

            maxArea = Math.max(area, maxArea);

            if(heights[left] > heights[right]){
                right--;
            }else if(heights[left] < heights[right]){
                left++;
            }else{
                left++;
                right--;
            }
        }
        return maxArea;
    }
}