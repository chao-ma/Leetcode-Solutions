Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].

Note: 
You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

https://leetcode.com/problems/sliding-window-maximum/


Here is my thinking process, without checking "hints" honestly. I thought about this for a whole day.
Naively, we can always sort the last K elements and maintain the sorted order and maximum K elements when we progress.
This results minimum Log(K)N, when K=N, it is minimum NlogN
Let's rethink this way, sorting definitely works. It is a sufficient condition. But is it necessary?

Take an example, let's say K=5 and we have the following window

[3, 2, 5, 4, 2]

At this moment, [3, 2] will never be used because of the following 5. Is 4 needed? Yes, b/c when 5 is poped out of the queue
4 could be next largest elements. When 5 is added, remove 3 and 2. 4 is smaller than 5, useful. and so on.
In otherwords, the queue need to be in non-increasing order.
As each element in the queue is accessed by one comparison and dequeued, So it is linear time in amortized analysis
Scanning the array is also O(N), total is O(N)

Here is the solution:

```java
class Solution {
    private void addIndex(int[] nums, int index, List<Integer> queue) {
        while (!queue.isEmpty() && nums[index] > nums[queue.get(queue.size() - 1)])
            queue.remove(queue.size() - 1);
        queue.add(index);
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0)
            return new int[] {};
        int[] retValue = new int[nums.length - k + 1];
        int cursor = 0, i;
        List<Integer> queue = new ArrayList<>();
        for (i = 0; i < k - 1; i++)
            addIndex(nums, i, queue);
        for (; i < nums.length; i++) {
            addIndex(nums, i, queue);
            retValue[cursor++] = nums[queue.get(0)];
            if (i - queue.get(0) >= k - 1)
                queue.remove(0);
        }
        return retValue;
    }
}
```

