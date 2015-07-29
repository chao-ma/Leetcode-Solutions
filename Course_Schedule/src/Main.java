import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> nodeToParents = new HashMap<>();
        Map<Integer, Set<Integer>> nodeToChildren = new HashMap<>();
        List<Integer> queue = new LinkedList<>();
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
        return nodeToChildren.size() == 0;
    }
}
public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        int numCourses = 5;
        int[][] prerequisites = {{5,4}, {5,3}, {5,2}, {3,2}, {1,0}, {0,5},{2,1}};
        System.out.println(solution.canFinish(numCourses, prerequisites));
    }

}
