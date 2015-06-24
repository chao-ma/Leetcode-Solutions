class Solution {

    int[] cache;
    
    private int numTreesHelper(int from, int to) {
        if (from >= to)
            return 1;
        if (cache[to - from + 1] >= 0)
            return cache[to - from + 1];
        int retValue = 0;
        for (int i = from; i <= to; i++) {
            retValue += numTreesHelper(from, i - 1) * numTreesHelper(i + 1, to);
        }
        cache[to - from + 1] = retValue;
        return retValue;
    }
    
    public int numTrees(int n) {
        cache = new int[n + 1];
        for (int i = 0; i <= n; i++)
            cache[i] = -1;
        return numTreesHelper(1, n);
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        System.out.println(solution.numTrees(4));
    }

}
