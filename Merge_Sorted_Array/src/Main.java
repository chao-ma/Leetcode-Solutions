import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer = m + n -1;
        int nums1Pointer = m - 1;
        int nums2Pointer = n - 1;
        while (pointer >= 0) {
            if (nums1Pointer >= 0) {
                if (nums2Pointer >= 0) {
                    if (nums1[nums1Pointer] >= nums2[nums2Pointer]) {
                        nums1[pointer] = nums1[nums1Pointer--];
                    } else {
                        nums1[pointer] = nums2[nums2Pointer--];
                    }
                }
            } else {
                nums1[pointer] = nums2[nums2Pointer--];
            }
            pointer--;
        }
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        int[] nums1 = {1,3,5,7,0,0,0};int m = 4;
        int[] nums2 = {0};int n = nums2.length;
        solution.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

}
