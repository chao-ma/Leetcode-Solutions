class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        char[] buffer = new char[s.length()];
        int period = 2 * numRows - 2;
        int index = 0;
        int j;
        j = 0;
        while (j * period < buffer.length) {
            buffer[index] = s.charAt(j * period);
            index++;
            j++;
        }
        for (int i = 1; i < numRows - 1; i++) {
            j = 0;
            while (true) {
                if (i + j * period < buffer.length) {
                    buffer[index] = s.charAt(i + j * period);
                    index++;
                } else {
                    break;
                }
                if ((j + 1) * period - i < buffer.length) {
                    buffer[index] = s.charAt((j + 1) * period - i);
                    index++;
                } else {
                    break;
                }
                j++;
            }
        }
        j = 0;
        while (period / 2 + j * period < buffer.length) {
            buffer[index] = s.charAt(period / 2 + j * period);
            index++;
            j++;
        }
        return String.copyValueOf(buffer);
    }
}


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    Solution solution = new Solution();
		System.out.println(solution.convert("ABCDEF", 4));
	}

}
