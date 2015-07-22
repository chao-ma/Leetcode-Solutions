class Solution {
    public String convertToTitle(int n) {
        if (n <= 0)
            return "";
        int tmp = n, count = 1;
        long end = 26;
        while (tmp > end) {
            tmp -= end;
            end = end * 26;
            count++;
        }
        char[] buffer = new char[count];
        for (int i = 0; i < buffer.length; i++)
            buffer[i] = 'A';
        tmp--;
        count = buffer.length - 1;
        while (tmp > 0) {
            buffer[count] = (char) (tmp % 26 + 'A');
            tmp = tmp / 26;
            count--;
        }
        return String.copyValueOf(buffer);
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        System.out.println(solution.convertToTitle(1000000001));
    }

}
