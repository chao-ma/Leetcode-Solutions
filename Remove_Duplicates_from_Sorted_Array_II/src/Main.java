class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < 2)
                j++;
            else if (nums[i] != nums[j - 1] || nums[i] != nums[j - 2])
                nums[j++] = nums[i];
        }
        return j;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {1,1,1,2,2,3};
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(nums));
    }

}
