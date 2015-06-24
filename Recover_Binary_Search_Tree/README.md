Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

https://leetcode.com/problems/recover-binary-search-tree/

My note:

This is a constant space solution, if not counting the logn stack. If really care about this, use Morris traversal. Simplify this problem by, exchanging 2 elements in sorted array, find them and restore the array. Everything will be simple.
There are different cases such as
[1,2,3,4,5,6] -> [1,5,3,4,2,6]
                    | | | |
              -> [1,2,5,4,3,6]
                      | | |
              -> [1,2,3,5,4,6]
                        | |

No matter in which case, just exchange the last violating item with the first.
