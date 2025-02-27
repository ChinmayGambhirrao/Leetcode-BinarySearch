import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> index = new HashMap<>(); // Map value to index for quick lookup
        for (int i = 0; i < n; i++) {
            index.put(arr[i], i);
        }

        int[][] dp = new int[n][n]; // DP table to store lengths
        int maxLen = 0;

        // Initialize DP table
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                dp[i][j] = 2; // Any two elements can form a sequence of length 2
            }
        }

        // Fill the DP table
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                int kVal = arr[j] - arr[i]; // The required previous element
                if (index.containsKey(kVal)) {
                    int k = index.get(kVal);
                    if (k < i) { // Ensure k is before i
                        dp[i][j] = dp[k][i] + 1; // Update the length
                        maxLen = Math.max(maxLen, dp[i][j]); // Track the maximum length
                    }
                }
            }
        }

        return maxLen >= 3 ? maxLen : 0; // Return 0 if no valid subsequence exists
    }
}