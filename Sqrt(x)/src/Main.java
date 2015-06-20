class Solution {
    public int mySqrt(int x) {
        if (x <= 1)  //I am not going to consider x<0, should throw exception
            return x;
        long begin = 1, end = x;
        long mid = 0;
        long square;
        while (begin <= end) {
            mid = (begin + end) / 2;
            square = mid * mid;
            if (square == x)
                return (int)mid;
            else if (square < x)
                begin = mid + 1;
            else
                end = mid - 1;
        }
        return (int)(begin+end)/2;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(3));
        System.out.println(46340*46340);
    }

}
