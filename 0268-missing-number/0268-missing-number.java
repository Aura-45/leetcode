class Solution {
    public int missingNumber(int[] nums) {
     int n = nums.length;
     int missSum= n*(n+1)/2;
     int actSum = 0;
     for( int num:nums){
        actSum+=num;
     }
     return missSum-actSum; 
    }
}