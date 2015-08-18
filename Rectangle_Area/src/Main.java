class Solution {

    private int interception(int[] interval1, int[] interval2) {
        int[] left, right;
        if (interval1[0] < interval2[0]) {
            left = interval1;
            right = interval2;
        } else {
            left = interval2;
            right = interval1;
        }
        int intercept = 0;
        if (right[0] < left[1])
            intercept = Math.min(left[1], right[1]) - right[0];
        return intercept;
    }
    
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int length = interception(new int[] {A, C}, new int[] {E, G});
        int height = interception(new int[] {B, D}, new int[] {F, H});
        return (C-A) * (D-B) - length * height + (G-E) * (H-F);
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        System.out.println(solution.computeArea(-3,0,3,4,8,-1,9,2));
    }

}
