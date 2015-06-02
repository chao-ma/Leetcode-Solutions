class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (index == 0 || nums[i] != nums[index-1]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}


public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {};
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(nums));
    }

}
