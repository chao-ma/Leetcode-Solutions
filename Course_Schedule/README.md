There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

https://leetcode.com/problems/course-schedule/



For Course Schedule 2, it is very similar, just paste it here


public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> nodeToParents = new HashMap<>();
        Map<Integer, Set<Integer>> nodeToChildren = new HashMap<>();
        List<Integer> queue = new LinkedList<>();
        List<Integer> order = new ArrayList<>();
        int prerequisit, course, i;
        for(int[] edge: prerequisites) {
            prerequisit = edge[1];
            course = edge[0];
            if (prerequisit == course)
                continue;
            if (!nodeToChildren.containsKey(course))
                nodeToChildren.put(course, new HashSet<Integer>());
            nodeToChildren.get(course).add(prerequisit);
            if (!nodeToParents.containsKey(prerequisit))
                nodeToParents.put(prerequisit, new HashSet<Integer>());
            nodeToParents.get(prerequisit).add(course);
        }
        for (i = 0; i < numCourses; i++)
            if (!nodeToChildren.containsKey(i))
                queue.add(i);
        while (!queue.isEmpty()) {
            Integer pre = queue.remove(0);
            order.add(pre);
            if (!nodeToParents.containsKey(pre))
                continue;
            for (Integer parent: nodeToParents.get(pre)) {
                nodeToChildren.get(parent).remove(pre);
                if (nodeToChildren.get(parent).isEmpty()) {
                    nodeToChildren.remove(parent);
                    queue.add(parent);
                }
            }
            nodeToParents.remove(pre);
        }
        if (nodeToChildren.size() != 0)
            return new int[] {};
        int[] retValue = new int[order.size()];
        for (i = 0; i < order.size(); i++)
            retValue[i] = order.get(i);
        return retValue;
    }
}
