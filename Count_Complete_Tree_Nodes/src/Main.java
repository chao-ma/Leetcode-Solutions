class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        TreeNode cursor = root;
        int left = 0, right = 0;
        while (cursor != null) {
            left++;
            cursor = cursor.left;
        }
        cursor = root;
        while (cursor != null) {
            right++;
            cursor = cursor.right;
        }
        if (left == right)
            return (1 << left) - 1;
        int begin = (1 << (left - 1)) - 1;
        int end = (1 << left) - 2;
        int mid, i;
        boolean[] path = new boolean[left - 1];
        while (begin <= end) {
            //System.out.println(String.format("%d %d", begin, end));
            mid = (begin + end) / 2;
            for (i = path.length - 1; i >=0; i--, mid = (mid - 1) >>> 1)
                path[i] = (mid & 1) == 1;
            cursor = root;
            for (i = 0; i < path.length; i++) {
                if (path[i])
                    cursor = cursor.left;
                else
                    cursor = cursor.right;
            }
            mid = (begin + end) / 2;
            if (cursor != null)
                begin = mid + 1;
            else
                end = mid - 1;
        }
        return (begin + end) / 2 + 1;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);
        System.out.println(solution.countNodes(root));
    }

}
