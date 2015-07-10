Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

https://leetcode.com/problems/single-number-ii/

My note: 

two lessions learnt
 - if (1 & 2 > 0) is illegal, should be if ((1 & 2) > 0)
 - to test if there is any bit set to one simply a & mask == 0, dont do a & mask > 0 as 1 << 31 < 0 but has a bit
