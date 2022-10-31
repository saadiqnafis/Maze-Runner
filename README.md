# Maze-Runner

I implemented a Maze generator and solver in this project. In our
project, the main data types we used are queue, which is implemented by
doubly linked lists, and stack. Queue follows the rule “First come first
served”, and stack follows the rule “First in last out”. While solving the
maze, we use two types of algorithms, one is Breadth First Search (BFS),
implemented by queue, and another is Depth First Search (DFS),
implemented by stack. While we use the DFS, we explore deeper and
backtrack when necessary. But while we use the BFS, we explore widely
among a large number of cells. We start by pushing/offering the start cell to
the stack/queue. Then gradually, we pop/poll and then get the neighbors of
the popped/polled cell and check the cells whether they are our targets. While
checking, we make sure that we mark the cells as checked. After we find our
target cell, then the algorithm backtracks until it reaches the start cell, and
marks the path as green color. We use different tests to check if our queue and
stack works well.
