Contains Duplicate I <p>
Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
https://leetcode.com/problems/contains-duplicate/
```java
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i: nums) {
            if (set.contains(i))
                return true;
            set.add(i);
        }
        return false;
    }
}
```
Contains Duplicate II <p>
Given an array of integers and an integer k, find out whether there there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
https://leetcode.com/problems/contains-duplicate-ii/
```java
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k)
                return true;
            map.put(nums[i], i);
        }
        return false;
    }
}
```

Given an array of integers, find out whether there are two distinct indices i and j in the array such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
https://leetcode.com/problems/contains-duplicate-iii/

My note: O(N * K) is easy. The procedure is, to scan through last K elements to find if there is any element |nums[i] - val| <= t
This would take a linear time. To find the closest neighbors, BST gives log(k) solution. Insertion deletion cost log(k) as well


```java
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> bst = new TreeSet<>();
        LinkedList<Long> queue = new LinkedList<>();
        long gap = t;
        for (int i: nums) {
            long val = i;
            Long ceiling = bst.ceiling(val);
            if (ceiling != null && ceiling - val <= gap) {
                return true;
            }
            Long floor = bst.floor(val);
            if (floor != null && val - floor <= gap) {
                return true;
            }
            bst.add(val);
            queue.add(val);
            if (queue.size() > k) {
                Long head = queue.remove(0);
                bst.remove(head);
            }
        }
        return false;
    }
}
```
