/**
 Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37

https://leetcode.com/problems/compare-version-numbers/

My note: tricky, I got bitte by 1.0 == 1 case.
 */

public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] tokens1 = version1.split("\\.", -1);
        String[] tokens2 = version2.split("\\.", -1);
        int ver1 = 0, ver2 = 0;
        int length = Math.max(tokens1.length, tokens2.length);
        for (int i = 0; i < length; i ++) {
            ver1 = i < tokens1.length ? Integer.parseInt(tokens1[i]) : 0;
            ver2 = i < tokens2.length ? Integer.parseInt(tokens2[i]) : 0;
            if (ver1 < ver2)
                return -1;
            if (ver1 > ver2)
                return 1;
        }
        return 0;
    }
}
