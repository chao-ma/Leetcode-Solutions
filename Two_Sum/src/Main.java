import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int[] twoSum(int[] nums, int target) {
    	int valueToLookFor;
    	int[] retValue = new int[2];
    	HashMap<Integer, List<Integer>> numberCount = new HashMap<>();
    	boolean solutionFound = false;
    	for (int i = 0; i < nums.length; i++) {
    		if (numberCount.containsKey(nums[i]))	{
    			numberCount.get(nums[i]).add(i);
    		} else {
    			List<Integer> indexList = new ArrayList<>();
    			indexList.add(i);
    			numberCount.put(nums[i], indexList);
    		}
    	}
    	for (int i = 0; i < nums.length && !solutionFound; i++) {
    		valueToLookFor = target - nums[i];
    		List<Integer> indexList = numberCount.get(valueToLookFor);
    		if (indexList != null && indexList.size() > 0) {
    			for (int j: indexList) {
    				if (i != j) {
    					retValue[0] = i + 1;
    					retValue[1] = j + 1;
    					solutionFound = true;
    					break;
    				}
    			}
    		}
    	}
        return retValue;
    }
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.twoSum(nums, target)));

	}

}
