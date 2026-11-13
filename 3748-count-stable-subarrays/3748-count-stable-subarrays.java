
class Solution {
    public long[] countStableSubarrays(int[] nums, int[][] queries) {
        int n = nums.length;

        int[] start = new int[n];
        long[] prefix = new long[n + 1];

        // Find the starting index of each
        // non-decreasing segment
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] >= nums[i - 1]) {
                start[i] = start[i - 1];
            } else {
                start[i] = i;
            }

            long len = i - start[i] + 1;
            prefix[i + 1] = prefix[i] + len;
        }

        long[] ans = new long[queries.length];

        for (int k = 0; k < queries.length; k++) {
            int l = queries[k][0];
            int r = queries[k][1];

            // Find first index after l whose segment
            // starts after l
            int low = l, high = r + 1;

            while (low < high) {
                int mid = low + (high - low) / 2;

                if (start[mid] > l) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            int split = low;

            // First partial segment
            long len = split - l;
            long result = len * (len + 1) / 2;

            // Remaining complete segments
            if (split <= r) {
                result += prefix[r + 1] - prefix[split];
            }

            ans[k] = result;
        }

        return ans;
    }
}
