/**
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.

https://leetcode.com/problems/longest-consecutive-sequence/
*/

public class Solution {
    public int longestConsecutive(int[] nums) {
        int retValue = 0;
        Map<Integer, Integer> headToTail = new HashMap<>();
        Map<Integer, Integer> tailToHead = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        int head, tail, key;
        for (int num: nums) {
            if (visited.contains(num)) {
                continue;
            }
            visited.add(num);
            head = tail = num;
            key = tail + 1;
            if (headToTail.containsKey(key)) {
                tail = headToTail.get(key);
                tailToHead.remove(tail);
                headToTail.remove(key);
            }
            key = head - 1;
            if (tailToHead.containsKey(key)) {
                head = tailToHead.get(key);
                headToTail.remove(head);
                tailToHead.remove(key);
            }
            headToTail.put(head, tail);
            tailToHead.put(tail, head);
            retValue = Math.max(retValue, tail - head + 1);
        }
        return retValue;
    }
}
