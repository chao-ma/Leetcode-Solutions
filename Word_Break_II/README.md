Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].

https://leetcode.com/problems/word-break-ii/

My note:

I would like to write something about this:

1. Generics array
I didn't know I can't do this
List<String>[] dp = new List<String>[10]; for example

The reason is here

dp is simply an object, array object.
Object o = (Object) dp;

It can be further casted as array of objects

Object[] oa = (Object[]) dp;

So it is ok to

List<Integer> l = new LinkedList<>(); l.add(1);
oa[0] = l;

Then dp[0].get(0) // is this a string or integer?




Second I failed such a test case


dictionary is {"a","aa","aaa", ... , "aaaaaaaaaa"}
string is "aaaaaaaa....aaab"
Theoretically, dp is a pretty optimal solution, and each stage needs to keep track of solutions. If the string is valid, then the number of solutions will be tons. There is no way to avoid that, it is just complex.
But the test case ends with not a word, so simply reuse the code from Word Break I.

