import java.util.*;

class Solution {
    
    int[] rightBoundary;
    int[] leftBoundary;
    Stack<Integer> posStack = new Stack<>();
    
    public int largestRectangleArea(int[] height) {
        int i, retValue = 0;
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
    
    public int maximalRectangle(char[][] matrix) {
        int retValue = 0;
        if (matrix.length == 0)
            return 0;
        int[] height = new int [matrix[0].length];
        int i, j;
        rightBoundary = new int[height.length];
        leftBoundary = new int[height.length];
        for (i = 0; i < matrix.length; i++) {
            for (j = 0; j < matrix[i].length; j++) {
                height[j] = matrix[i][j] == '1' ? height[j] + 1: 0;
            }
            retValue = Math.max(retValue, largestRectangleArea(height));
        }
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /*String[] raw = {"0001101",
                        "0011111",
                        "0001111",
                        "0011110",
                        "0011001",
                        "0000111",};*/
        String[] raw = {"00","00"};
        char[][] matrix = new char[raw.length][];
        for (int i = 0; i < raw.length; i++)
            matrix[i] = raw[i].toCharArray();
        Solution solution = new Solution();
        System.out.println(solution.maximalRectangle(matrix));
    }

}
