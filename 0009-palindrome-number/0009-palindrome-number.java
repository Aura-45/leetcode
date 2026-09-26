class Solution {
    public boolean isPalindrome(int x) {
        int original=x;
        int digit=0;
        while(x>0){
        digit =digit*10+x%10;
        x/=10;
        }
        return digit==original;
    }
}
