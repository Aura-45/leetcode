class Solution {
    public void moveZeroes(int[] nums) {

        int variable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[variable] = nums[i];
                variable++;
            }
        }
        while (variable < nums.length) {
            nums[variable] = 0;
            variable++;
        }
    }
}