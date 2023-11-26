import java.util.Arrays;

class LargestSubmatrix {
    public static void main(String[] args){
        int[][] test1 = {{0,0,1},{1,1,1},{1,0,1}};
        int[][] test2 = {{1,0,1,0,1}};
        int[][] test3 = {{1,1,0},{1,0,1}};
        int[][] test4 = {{0,0},{0,0}};
        int[][] test5 = {{0,0,0,1},{1,1,0,0}};
        int[][] test6 = {{0,0,0,0,0,1},{1,1,1,1,0,1},{1,0,1,0,0,1},{1,1,1,1,1,1},{1,0,1,1,1,1}};
        // Initial Solution
        System.out.println("Initial Solution Result:");
        System.out.println(largestSubMatrix(test1));
        System.out.println(largestSubMatrix(test2));
        System.out.println(largestSubMatrix(test3));
        System.out.println(largestSubMatrix(test4));
        System.out.println(largestSubMatrix(test5));
        System.out.println(largestSubMatrix(test6));
    }

    private static int largestSubMatrix(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;
        // We will iterate over the matrix and for each element we will check if the current element is 1. If the current element is 1, we will add the value of the element above it to the current element.
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = matrix[i - 1][j] + 1;
                }
            }
        }
        // We will sort each row of the matrix in descending order and for each element we will calculate the area of the rectangle formed by the current element and the elements above it.
        for (var row : matrix) {
            Arrays.sort(row);
            for (int j = n - 1, k = 1; j >= 0 && row[j] > 0; --j, ++k) {
                int s = row[j] * k;
                ans = Math.max(ans, s);
            }
        }
        // We will return the maximum area.
        return ans;
    }
}