class Solution {
    public String multiply(String num1, String num2) {
        char[] buffer = new char[num1.length() + num2.length()];
        if (buffer.length == 0) {
            return "0";
        }
        int add = 0, sum;
        int i, j;
        int num1Index, num2Index;
        for (i = 0; i < buffer.length; i++) {
            buffer[i] = '0';
        }
        for (i = 0; i < buffer.length; i++) {
            sum = add;
            for (j = 0; j <= i; j++) {
                num1Index = num1.length() - 1 - j;
                num2Index = num2.length() - 1 - (i - j);
                if (num1Index >= 0 && num1Index < num1.length() &&
                        num2Index >= 0 && num2Index < num2.length()) {
                    sum += (num1.charAt(num1Index) - '0') *
                            (num2.charAt(num2Index) - '0');
                }
            }
            buffer[buffer.length - i - 1] = (char)(sum % 10 + '0');
            add = sum / 10;
        }
        for (i = 0; i < buffer.length - 1 && buffer[i]=='0'; i++);
        return String.copyValueOf(buffer, i, buffer.length - i);
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        System.out.println(solution.multiply("", ""));

    }

}
