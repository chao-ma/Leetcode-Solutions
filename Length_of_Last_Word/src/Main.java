class Solution {
    public int lengthOfLastWord(String s) {
        int retValue = 0;
        int lenLastWord = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (lenLastWord > 0)
                    retValue = lenLastWord;
                lenLastWord = 0;
            } else {
                lenLastWord++;
            }
        }
        if (lenLastWord > 0)
            retValue = lenLastWord;
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord("  Hi  "));
    }

}
