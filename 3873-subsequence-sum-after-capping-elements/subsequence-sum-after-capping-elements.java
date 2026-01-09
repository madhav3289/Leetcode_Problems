class Solution {
    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        int n = nums.length;

        Arrays.sort(nums);

        boolean [][] dp = new boolean[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int j=1; j<=k; j++) {
            dp[0][j] = false;
        }

        // dp[i][j] -> can we make sum j using first i element
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                }
            }
        }

        boolean [] res = new boolean[n];
        for (int x = 1; x <= n; x++) {
            int idxGreaterThanX = elementIdxGreaterThanX(nums, n, x);

            if (idxGreaterThanX >= n) {
                res[x - 1] = dp[n][k];
            } else {
                int eleCountGreaterThanX = n - idxGreaterThanX;
                boolean found = false;

                for (int j = 0; j <= k; j++) {
                    if (dp[idxGreaterThanX][j]) {
                        int remSum = k - j;

                        if (remSum % x == 0) {
                            int count = remSum / x;
                            if (eleCountGreaterThanX >= count) {
                                found = true;
                                break;
                            }
                        }
                    }
                }

                res[x - 1] = found;
            }
        }

        return res;
    }

    private int elementIdxGreaterThanX(int [] nums, int n, int x) {
        int s = 0, e = n - 1;

        int res = n;
        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] > x) {
                res = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return res;
    }
}