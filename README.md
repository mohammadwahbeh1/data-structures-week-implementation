# Data Structures – Week Implementation (Java)

This repository contains the full implementation of a one-week intensive data structures training in Java.  
Each day covers specific topics, from basic arrays and lists to advanced structures like Trie, Union-Find, and Graph traversals.

---

## Day 1 implemented:
- Dynamic Array
- Singly Linked List
- Stack (array + linked list)

### Time/Space (high level)
- **Dynamic Array**: access O(1), append amortized O(1), insert/remove at index O(n), space O(n)  
- **Singly Linked List**: addFirst/removeFirst O(1), get by index O(n), space O(n)  
- **Stack (both)**: push/pop/peek O(1), space O(n)

---

## Day 2 implemented:
- Queue (array + linked list)
- Doubly Linked List
- Circular Linked List

### Time/Space (high level)
- **Queue (array)**: enqueue/dequeue/peek O(1), space O(n)  
- **Queue (linked list)**: enqueue/dequeue/peek O(1), space O(n)  
- **Doubly Linked List**: add/remove at head/tail O(1), search/get O(n), space O(n)  
- **Circular Linked List**: add/remove O(1), traversal O(n), space O(n)

---

## Day 3 implemented:
- Binary Tree
- Binary Search Tree
- Tree Traversal (inorder, preorder, postorder)

### Time/Space (high level)
- **Binary Tree**: traversal O(n), space O(n)  
- **Binary Search Tree (balanced)**: search/insert/delete O(log n), space O(n)  
- **BST (unbalanced)**: worst-case O(n)  
- **Traversals**: all traversals visit each node once → O(n) time, O(n) space for recursive stack or list

---

## Day 4 implemented:
- Hash Table
- Min Heap
- Graph (Adjacency List)

### Time/Space (high level)
- **Hash Table (chaining)**: put/get/remove O(1) average, O(n) worst case, space O(n)  
- **Min Heap**: insert/extractMin O(log n), peek O(1), space O(n)  
- **Graph (adjacency list)**: addVertex/addEdge O(1), neighbors O(1), traversal (BFS/DFS) O(V+E), space O(V+E)

---

## Day 5 implemented:
- Trie (Prefix Tree)
- Union-Find (Disjoint Set)
- Graph Traversal (BFS, DFS)

### Time/Space (high level)
- **Trie**: insert/search O(L), space O(L×N) — L = word length, N = number of words  
- **Union-Find**: find/union O(α(N)) ≈ O(1), space O(N)  
- **Graph Traversal**: BFS/DFS O(V+E), space O(V)

---

## Notes
- All implementations are in **Java**.  
- Tests are provided using **JUnit 5** for each data structure.  
- Day-based packages in `src/main/java/ds/`:  
  - `arrays`, `linkedlists`, `stacks`, `queues`, `trees`, `advancedstructures`  
- The repository contains **organized folders, readable code, and comments** for easy understanding.  
- The README includes **high-level complexity analysis** and a summary of all implementations.

