class Solution {
    public int maxArea(int[] height) {
        int retValue = 0;
        int i = 0, j = height.length - 1;
        int area;
        while (i < j) {
            area = Math.min(height[i], height[j]) * (j - i);
            if (area > retValue) {
                retValue = area;
            }
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] height = {2,3,2,4,5, 2};
        Solution solution = new Solution();
        System.out.println(solution.maxArea(height));
    }

}
