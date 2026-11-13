
import java.util.*;

class Solution {
    public List<String> buildArray(int[] target, int n) {

        List<String> result = new ArrayList<>();

        int index = 0;

        for (int num = 1; num <= n && index < target.length; num++) {

            result.add("Push");

            if (num == target[index]) {
                index++;
            } else {
                result.add("Pop");
            }
        }

        return result;
    }
}
