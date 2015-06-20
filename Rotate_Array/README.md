Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

https://leetcode.com/problems/rotate-array/

My note: implemented recursive solution here, in place. Other solutions include

[1,2,3,4,5] k =2, make another array retValue <br>

a[i] = nums[(i + nums.length - k) % nums.length] for i in range(nums.length) <br>

OR <br>

double the array size <br>
[1,2,3,4,5,1,2,3,4,5] return Arrays.copyOf(nums.length - k, k) <br>

OR write a for loop to copy value into new array <br>

All of these are trivial. not going to implement.
