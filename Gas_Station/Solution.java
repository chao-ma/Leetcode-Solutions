/**
here are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
https://leetcode.com/problems/gas-station/

My note: this is an interesting problem to think about. I started my thoughts
as a DP problem. Starting from next station simply recomputes the most negative
data point by moving previous station to the end.

 */

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int min = 0;
        int sum = 0;
        int i;
        for (i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            min = sum < min ? sum : min;
        }
        if (sum < 0)
            return -1;
        for (i = 0; i < gas.length; i++) {
            if (min >= 0)
                return i;
            min = min - (gas[i] - cost[i]);
        }
        return -1;
    }
}
