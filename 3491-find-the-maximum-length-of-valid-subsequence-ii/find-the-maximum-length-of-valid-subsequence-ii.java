public class Solution {
    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k];
        int max = 0;
        for (int num : nums) {
            int curr = num % k;
            for (int prev = 0; prev < k; prev++) {
                dp[prev][curr] = dp[curr][prev] + 1;
                if (dp[prev][curr] > max) {
                    max = dp[prev][curr];
                }
            }
        }
        return max;
    }
}