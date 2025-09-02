# Data Structures – Week Implementation (Java)

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


## Day 3 implemented:
- Binary Tree
- Binary Search Tree
- Tree Traversal (inorder, preorder, postorder)

### Time/Space (high level)
- Binary Tree: traversal O(n), space O(n)  
- Binary Search Tree (balanced): search/insert/delete O(log n), space O(n)  
- BST (unbalanced): worst-case O(n)  


## Day 4 implemented:
- Hash Table
- Min Heap
- Graph (Adjacency List)

### Time/Space (high level)
- **Hash Table (chaining)**: put/get/remove O(1) average, O(n) worst case, space O(n)
- **Min Heap**: insert/extractMin O(log n), peek O(1), space O(n)
- **Graph (adjacency list)**: addVertex/addEdge O(1), neighbors O(1), traversal (BFS/DFS) O(V+E), space O(V+E)
