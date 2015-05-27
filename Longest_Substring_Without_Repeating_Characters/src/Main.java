import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int retValue = 0;
        HashMap<Character, Integer> charToIndex = new HashMap<>();
        int currentMaxLen = 0;
        char curChar;
        for (int i=0; i < s.length(); i++) {
        	curChar = s.charAt(i);
        	if (charToIndex.containsKey(curChar)) {
        		int gap = i - charToIndex.get(curChar);
        		if (gap > currentMaxLen) {
        			currentMaxLen++;
        		} else {
        			currentMaxLen = gap;
        		}
        	} else {
        		currentMaxLen++;
        	}
        	charToIndex.put(curChar, i);
        	if (currentMaxLen > retValue) {
        		retValue = currentMaxLen;
        	}
        }
        return retValue;
    }
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.lengthOfLongestSubstring("abccefgb"));
		
	}

}
