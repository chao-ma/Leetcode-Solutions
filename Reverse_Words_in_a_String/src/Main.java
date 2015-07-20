class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ", -1);
        String retValue = "";
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].length() > 0) {
                if (retValue.length() == 0)
                    retValue = retValue + words[i];
                else {
                    retValue = retValue + " " + words[i];
                }
            }
        }
        return retValue;
    }
}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution solution = new Solution();
        String s = "the  sky  is  blue";
        System.out.println(solution.reverseWords(s));
    }

}
