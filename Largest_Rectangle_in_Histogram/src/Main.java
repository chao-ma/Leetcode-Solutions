import java.util.*;

class Solution {
    
    int[] rightBoundary;
    int[] leftBoundary;
    Stack<Integer> posStack = new Stack<>();
    
    public int largestRectangleArea(int[] height) {
        int retValue = 0;
        rightBoundary = new int[height.length];
        leftBoundary = new int[height.length];
        int i;
        for (i = 0; i < height.length; i++) {
            while (!posStack.isEmpty() && height[posStack.peek()] > height[i]) {
                rightBoundary[posStack.pop()] = i;
            }
            posStack.push(i);
        }
        while (!posStack.isEmpty())
            rightBoundary[posStack.pop()] = i;
        for (i = height.length - 1; i >= 0; i--) {
            while (!posStack.isEmpty() && height[posStack.peek()] > height[i]) {
                leftBoundary[posStack.pop()] = i;
            }
            posStack.push(i);
        }
        while (!posStack.isEmpty())
            leftBoundary[posStack.pop()] = i;
        for (i = 0; i < height.length; i++) {
            retValue = Math.max(retValue, (rightBoundary[i] - leftBoundary[i] - 1) * height[i]);
        }
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        int[] height = {2,1,5,6,2,3};
        System.out.println(solution.largestRectangleArea(height));
    }

}
