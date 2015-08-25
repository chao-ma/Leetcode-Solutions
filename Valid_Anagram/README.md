Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

https://leetcode.com/problems/valid-anagram/

```java
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] != tChars[i])
                return false;
        }
        return true;
    }
}
```

Another Solution:

```java
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] bins = new int[26];
        int i;
        for (i = 0; i < s.length(); i++)
            bins[s.charAt(i) - 'a']++;
        for (i = 0; i < t.length(); i++) {
            if (bins[t.charAt(i) - 'a'] == 0)
                return false;
            bins[t.charAt(i) - 'a']--;
        }
        return true;
    }
}
```
