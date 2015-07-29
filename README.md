<h3> Solutions to Leetcode </h3>

<a href="http://www.leetcode.com"> Leetcode </a> is a platform for preparing technical coding interviews. It focuses on fundamental data structures and basic algorithms. Many questions are taken from real-world interview questions, I believe. If done right, solutions shouldn't exceed 100 lines of code at all. <p>
<h6> It is not about how fast, how clean or how fancy we finish Leetcode. It is about what we learnt and we improved through this.</h6>
Even though I don't quite agree with Leetcode's way of technical interview, I have to admit that I love Leetcode. It comes with a comprehensive online judge, which covers many test cases, time complexity and even space complexity. Most importantly, I can focus on the problem itself without handling input and output. I should have used Leetcode earlier. When I interviewed with Youtube team onsite, I was asked to write a Sudoku solver. Obviously I struggled. After Leetcode, I can write a  clean and efficient solver. <p>

I did Leetcode in 2013 for the first time. And I decided to use a language I never knew, Java. It worked pretty well. Later I started to write Android app at work without any language barrier. And this is my second time doing Leetcode. <p>

All the solutions are original except some classic ones I learnt from CLRS, such as KMP string matching, merge sort, etc. There are a few implementations I am quite proud of: <br>
 - Sudoku solver (the way I backtrack solutions) <br>
 - LRU cache (the way to update circular double linked list)<br>
 - My own implementation of KMP algorithm<br>
 - Gas station (tracking min of subarray sum) <p>
 - Skyline Problem <a href="Skyline_Problem"> question </a> <a href="Skyline_Problem/src/Main.java"> solution </a><p>
 - Shortest Palindrome <a href="Shortest_Palindrome"> question </a> <a href="Shortest_Palindrome/src/Main.java"> solution </a> <p>

In my opinion, Leetcode questions have different difficulty level:
 - Easy. Straightforward and routine, no tricks, just pay attention to edge cases. Examples, reverse linked list, test palindrome, remove duplicate from linked list.
 - Intermediate. This requires some basic knowledge in algorithms and data structures, such as DFS, BFS. Recursion is common in this category. Examples, all subsets, permutation, word ladder.
 - Hard. Dynamic programming, especially DP with Math in it. Examples, best time to buy and sell stocks, interleaving strings, and longest subsequence.
 - Expert. These algorithms are quite hard to derive from scratch. Must know ahead of time. Example, KMP, largest rectangle. <br>
I don't mean merge sort is a simple algorithm. It is just commonly known.<p>

In this repo, each folder corresponds to a Leetcode question. At the beginning, I use Eclipse to write Java code. In some folders, you will see a subfolder "src". The source code is inside. If I had some comments, I left it in README.md. Later I try to write Java without IDE. In this case, there is only a "Solution.java" in each question folder. <p>

Sometimes I don't need to write code at work. To keep my mind refresh, I come back to Leetcode and randomly pick questions. I love Leetcode, and I bought their ebook to support their site. Hope Leetcode helps many other programmers as well.
