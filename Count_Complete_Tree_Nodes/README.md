Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

https://leetcode.com/problems/count-complete-tree-nodes/

My note:
Simply guess a number, and travel the tree to see if the number exist.
let H be the height of the tree. 2^H leaves max. Binary search takes O(H). Travel the tree top down is O(H)
So it is O(H^2)
