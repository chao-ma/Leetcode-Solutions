class Solution {
    public String addBinary(String a, String b) {
        int i = 0;
        char[] buff = new char[Math.max(a.length(), b.length()) + 1];
        int carry = 0;
        int numa, numb;
        while (a.length() - 1 - i >= 0 || b.length() - 1 - i >= 0) {
            if (a.length() - 1 - i >= 0) {
                numa = a.charAt(a.length() - 1 - i) - '0';
            } else {
                numa = 0;
            }
            if (b.length() - 1 - i >= 0) {
                numb = b.charAt(b.length() - 1 - i) - '0';
            } else {
                numb = 0;
            }
            buff[buff.length - 1 - i] = (char)((numa + numb + carry) % 2 + '0');
            carry = (numa + numb + carry) / 2;
            i++;
        }
        if (carry > 0) {
            buff[0] = '1';
            return String.copyValueOf(buff);
        } else {
            return String.copyValueOf(buff, 1, buff.length - 1);
        }
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String a = "0";
        String b = "110";
        Solution solution = new Solution();
        System.out.println(solution.addBinary(a, b));
    }

}
