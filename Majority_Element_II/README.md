Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
https://leetcode.com/problems/majority-element-ii/

```java
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int[] vals = {0, 0};
        int[] counts = {0, 0};
        List<Integer> retValue = new ArrayList<>();
        int i;
        for (int num: nums) {
            for (i = 0; i < 2; i++) {
                if (counts[i] == 0) {
                    counts[i] = 1;
                    vals[i] = num;
                    break;
                } else if (vals[i] == num) {
                    counts[i]++;
                    break;
                }
            }
            if (i == 2) {
                counts[0]--;
                counts[1]--;
            }
        }
        counts[0] = counts[1] = 0;
        for (int num: nums) {
            if (num == vals[0])
                counts[0]++;
            else if (num == vals[1])
                counts[1]++;
        }
        if (counts[0] > nums.length / 3)
            retValue.add(vals[0]);
        if (counts[1] > nums.length / 3)
            retValue.add(vals[1]);
        return retValue;
    }
}
```
