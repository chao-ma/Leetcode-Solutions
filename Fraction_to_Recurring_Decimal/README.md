Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".

https://leetcode.com/problems/fraction-to-recurring-decimal/


My note: actually I thought about this problem long time ago, at elementary school Math Olympic
class. The idea is if the same numerator value shows up, it simply begins to loop from its initial
position. That is to say, for any a/b b != 0, it is always some form of recurring decimal as
a%b < b. It can't have more than b recurring digits
