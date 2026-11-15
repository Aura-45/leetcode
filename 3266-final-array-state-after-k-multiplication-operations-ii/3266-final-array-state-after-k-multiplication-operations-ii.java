
import java.util.*;

class Solution {

    static final long MOD = 1_000_000_007L;

    public int[] getFinalState(int[] nums, int k, int multiplier) {

        int n = nums.length;

        if (multiplier == 1) {
            for (int i = 0; i < n; i++) {
                nums[i] %= (int) MOD;
            }
            return nums;
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return Long.compare(a[0], b[0]);
                }
                return Long.compare(a[1], b[1]);
            }
        );

        long maxVal = 0;

        for (int i = 0; i < n; i++) {
            pq.offer(new long[]{nums[i], i});
            maxVal = Math.max(maxVal, nums[i]);
        }

        // Step 1: Perform operations until values become balanced
        while (k > 0 && pq.peek()[0] * multiplier <= maxVal) {

            long[] curr = pq.poll();

            curr[0] *= multiplier;

            pq.offer(curr);

            k--;
        }

        // Step 2: Sort remaining elements by value, then index
        List<long[]> list = new ArrayList<>();

        while (!pq.isEmpty()) {
            list.add(pq.poll());
        }

        // Step 3: Distribute remaining operations
        long base = k / n;
        int extra = k % n;

        for (int i = 0; i < n; i++) {

            long value = list.get(i)[0];
            int index = (int) list.get(i)[1];

            long power = base + (i < extra ? 1 : 0);

            long result = (value * modPow(multiplier, power)) % MOD;

            nums[index] = (int) result;
        }

        return nums;
    }

    // Fast Binary Exponentiation
    private long modPow(long a, long b) {

        long result = 1;
        a %= MOD;

        while (b > 0) {

            if ((b & 1) == 1) {
                result = (result * a) % MOD;
            }

            a = (a * a) % MOD;
            b >>= 1;
        }

        return result;
    }
}
