Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

https://leetcode.com/problems/missing-number/

```java
public class Solution {
    public int missingNumber(int[] nums) {
        int i, swap, tmp;
        for (i = 0; i < nums.length; i++) {
            swap = nums[i];
            nums[i] = -1;
            while (swap > -1 && swap < nums.length && swap != nums[swap]) {
                tmp = nums[swap];
                nums[swap] = swap;
                swap = tmp;
            }
        }
        for (i = 0; i < nums.length; i++)
            if (nums[i] < 0)
                break;
        return i;
    }
}
```
