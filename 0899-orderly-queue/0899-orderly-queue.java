class Solution {
    public String orderlyQueue(String s, int k) {
        if(k>1){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }
        String res = s;
        String curr = s;
        for(int i = 0; i<s.length(); i++){
            curr = curr.substring(1)+ curr.charAt(0);
            if(curr.compareTo(res)<0){
                res = curr;
            }
        }
        return res;
    }
}