import java.util.*;
class Solution {
    public int trap(int[] height) {
        int retValue = 0;
        int[] maxHeightLeft = new int[height.length];
        int[] maxHeightRight = new int[height.length];
        int maxHeight = 0, i, minMaxHeight;
        for (i = 0; i < height.length; i++) {
            maxHeightLeft[i] = maxHeight;
            if (height[i] > maxHeight) {
                maxHeight = height[i];
            }
        }
        maxHeight = 0;
        for (i = height.length - 1; i >= 0; i--) {
            maxHeightRight[i] = maxHeight;
            if (height[i] > maxHeight) {
                maxHeight = height[i];
            }
        }
        System.out.println(Arrays.toString(maxHeightLeft));
        System.out.println(Arrays.toString(maxHeightRight));
        System.out.println(Arrays.toString(height));
        for (i = 0; i < height.length; i++) {
            minMaxHeight = maxHeightLeft[i] < maxHeightRight[i] ? maxHeightLeft[i]: maxHeightRight[i];
            if (minMaxHeight > height[i]) {
                retValue += minMaxHeight - height[i];
            }
        }
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution.trap(height));
    }

}
