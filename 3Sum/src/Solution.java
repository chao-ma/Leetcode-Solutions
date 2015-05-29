import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;


class AlternativeSolution {

    HashMap<Integer, Integer> numToCount = new HashMap<>();
    List<List<Integer>> retValue = new ArrayList<>();
    int[] solutionSpace;
    int[] solutions;
    int solutionLen;
    
    private void nSumHelper(int solutionSpaceIndex, int solutionIndex, int target) {
        if (solutionSpaceIndex >= solutionSpace.length)
            return;
        if (solutionIndex==solutions.length - 1) {
            if (target >= solutionSpace[solutionSpaceIndex] &&
                    numToCount.containsKey(target) &&
                    numToCount.get(target) > 0) {
                solutions[solutionIndex] = target;
                List<Integer> oneSolution = new ArrayList<>();
                for (int i: solutions) {
                    oneSolution.add(i);
                }
                retValue.add(oneSolution);
            }
            return;
        }
        for (int i = solutionSpaceIndex; i < solutionSpace.length; i++) {
            int solution = solutionSpace[i];
            if (numToCount.get(solution) > 0) {
                numToCount.put(solution, numToCount.get(solution) - 1);
                solutions[solutionIndex] = solution;
                nSumHelper(i, solutionIndex + 1, target - solution);
                numToCount.put(solution, numToCount.get(solution) + 1);
            }
        }
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        solutionLen = 3;
        solutions = new int[solutionLen];
        for (int num: nums) {
            if (numToCount.containsKey(num)) {
                numToCount.put(num, numToCount.get(num) + 1);
            } else {
                numToCount.put(num, 1);
            }
        }
        solutionSpace = new int[numToCount.size()];
        int i = 0;
        for (Integer value: numToCount.keySet()) {
            solutionSpace[i++] = value;
        }
        Arrays.sort(solutionSpace);
        nSumHelper(0, 0, 0);
        return retValue;
    }
}

