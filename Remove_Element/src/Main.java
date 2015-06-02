class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {3,1,5,4,2,7,7,4};
        Solution solution = new Solution();
        System.out.println(solution.removeElement(nums, 0));
    }

}
