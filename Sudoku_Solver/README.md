Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.

https://leetcode.com/problems/sudoku-solver/

My note: This is a pretty fast solution.
Basically at each recursive call, the contract is each '.' cell has a list of choices.
If '.' is filled with some number, other cells' choices will be updated according to constraints.
The trick is the function needs to step back, it needs to restore to the previous state. My solution is each function has a stack id, when a function marks
a choice is occupied, it puts its stack id there, so during recovery, simply set choice[i]==stack back to -1
This solution does not require extra memory regarding stack. All depend on a prepopulated constraint array, precomputed for reuse, and a set of choices for each cell i,j
