class Solution {
    public int sumOddLengthSubarrays(int[] arr) {

        int totalSum = 0;

        for (int i = 0; i < arr.length; i++) {

            int sum = 0;

            for (int j = i; j < arr.length; j++) {

                sum += arr[j];
                int length = j - i + 1;
                if (length % 2 != 0) {
                    totalSum += sum;
                }
            }
        }

        return totalSum;
    }
}