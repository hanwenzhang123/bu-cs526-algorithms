# Data Structure
## Array List
- useful to store elements of a single type in a certain order
- arraylist is array but can grow in size, will be fixed size when created
- insertion and deletion at interior position of arrays can be time consuming

## Linked List
- often used to implement stacks and queues
- In array, every location stores a single data, but linked lists store 2 jobs:
1. store data (like array)
2. remember which box is next (store a reference to the next box)

### Singly Linked List
- reference (or pointer) to the next node
- keep two references, head and tail
- You need the previous reference
- useful case: run search in two directions simultaneously

#### add to the head
```
newest = Node()
newest.next = head
head = neawest
size + 1
```

#### add to the tail
```
newest = Node()
newest.next = null
tail.next = newest
tail = newest
size + 1
```

#### removing the head
```
head = head.next
size - 1
```

### Doubly Linked List
- node has two pointers
- previous points to the previous node
- next points to the next node

#### inserting X
```
newest = Node()
predecessor.setNext(newest);
successor.setPrev(newest);
size++;
```

#### deleting X
```
x.prev.next = x.next
x.next.prev = x.prev

Node<E> predecessor = node.getPrev();
Node<E> successor = node.getNext();
predecessor.setNext(successor);
successor.setPrev(predecessor);
size--;
```

### When to use each type of list?
- doublylinkedlist when you need to removal at various points within the list
- singlylinkedlist has memory saving (only one reference per node), but does not enable deletion at arbitary points in list
  
## ArrayList vs LinkedList
- Arraylist gives you constant time read access from intermediate locations where linkedlist must traverse the list
- LinkedList gives constant time "add to the front" whereas ArrayList has to copy all elements to new locations - so O(n)
- LinkedList also never needs dynamic resizing (since the list has unlimited capacity); however this performance gain is cancelled out in practice because of ArrayList's "cache locality" - arrays are stored in contiguous locations in RAM
- To create an array, you have to specify a size for the array. 
- If you are not sure, just use ArrayList

#### ArrayList
- accessing O(1)
- adding O(n)

#### LinkedList
- accessing O(n)
- adding O(n)


## Testing Equality
- `==` - Test whether two reference variables  are pointing to the same object.
- `.equals()` - Test whether the contents of the  two objects pointed to by the references are the same.


## Clone Data Structure
- Shallow copy (copies point to the same object): `.clone()`
- Deep copy (different objects, but same data): defind your own method


## Algorithm Analysis (Big O)
- Algorithm is a sequence of steps that correctly map every possible input to the problem to the correct output
- How time and memory requirements grow as the input size grows
- we focus on the rate of growth, like how quickly or slowly running time grows as the input size increases

### Rate of Growth
```
f(n) = c          (constant)  
f(n) = c log n    (log n)
f(n) = cn         (linear)
f(n) = cn log n	  (n log n)
f(n) = cn2	    (quadratic)
f(n) = cnk        (polynomial)
f(n) = cn         (exponential)
f(n) = n!         (factorial)!
```

### input size
- length of array
- how long a block of code will take to run based on the input size
- constant does not depend on the length of array
- for loop runs depend on n => which runs n-1 time, loop body takes constant time
- look for the highest growth rate, ignore constance


## Recursion
- a function defined itself -> a way of implementing repeated execution of statements, where a method invokes itself, like factorial
- call stack windup and unwinding - where recursion happened and then something happened after the recursive call. 

#### Factorial
- O(n) -> invoke n+1 times while each takes O(1)
- input size - value of n
- number of recursive call -- n+1 -- O(n)
- runtime for a singel recursive call -- O(1)

### Search
- search a sequence of n elements for a target element
- Total runtime = number of recursive calls * amount of time for one recursive call

#### linear search
- Examine each element while scanning the sequence
- Best case: one comparison, or O(1)
- Worst case: n comparisons, or O(n)
- On average: n/2 comparisons, or O(n)

#### binary search
- If the sequence is sorted, we can use binary search
- Each time binary search is (recursively) invoked, the number of elements to be searched is reduced to at most half.
- Running time is O(log n)

### Designing Recursive Algorithms
- Two components: base case and recursion
- Base case: Recursive call stops when a certain condition is met.
- Recursion: When the condition of the base case is not  met, the algorithm invokes itself recursively.
- Make sure the base case is always reached to avoid infinite recursion.


## Stack (LIFO)
- Linear data structure. Elements are added to and removed from one end called top. Like plates.
- useful cases: “Undo/Redo” in word processing, stack trace, broswer history

## Queues (FIFO)
- Linear data structure. An object is added to one end called rear, and removed  from the other end called front. Like waiting lines.
- Adding is called enqueue, Removing is called dequeue
- useful cases: Buffers in networking, Scheduling in Operating Systems

## List
- The location of an element is determined by an index, starting from index 0
- Advantage: direct access to elements
- Disadvantage: Adding or removing elements may require restructuring (shifting of elements) of the array and Size is fixed

### Array Lists with Dynamic Array
```java
protected void resize(int capacity) {
  E[ ] temp = (E[ ]) new Object[capacity];
  for (int k=0; k < size; k++)
    temp[k] = data[k];
    data = temp;
}
```

## Tree
- Parent nodes, child nodes, sibling nodes, ancestor (root node)
- External Nodes (Leaf Nodes) - no children - numChildren(n) == 0; 
- Internal Nodes - have children - numChildren(n) > 0
- Depth: If n is the root, the depth of n is 0. Otherwise, the depth of n is one plus the depth of its parent - 1 +  depth(parent(n));
- Height: The height of a tree is the length of the longest path from the root downward to an external node. If n is a leaf, then the height of n is 0. Otherwise, the height of n is one more than the maximum of the  heights of n’s children. -  Math.max(h, 1 + height(c));

### Binary Tree
- Every node has at most two children.
- Each child node is labeled as being a left child or a right child.
- A left child precedes a right child in the order of children of a node
- Proper = No only child!

#### Implementation using Array
- go to left child: multiply by 2 and add 1
- go to right child: multiply by 2 and add 2

### Tree Traversal
- visiting all nodes in tree

#### Preorder tree traversal
- visit the root
- visit all children

```java
preorder(n)  
  visit n
  for each child c in children(n)  
    preorder(c)
```

#### Postorder tree traversal
- visit all children (recursively)
- visit the root

```java
postorder(n)  
  for each child c in children(n)  
    postorder(c)
  visit n
```

#### breadth-first tree traversal
- Visits all nodes at depth d before visiting nodes  at depth d + 1

```java
breadthfirst( )
  initialize Q to contain the root of the tree  
  while Q is not empty
    p = Q.dequeue( )	// remove the oldest entry in Q  
    visit p
    for each child c in children(p)
      Q.enqueue(c)	// add all children of p to the rear of Q
```
Running time
- Each node is enqueued and dequeued once each.
- O(n)

#### inorder tree traversal
- Visit the left subtree
- Visit the root
- Visit the right subtree
```java
inorder(n)
  if n has a left child lc	// visit left subtree  
           inorder(lc)
  visit n
  if n has a right child rc	// visit right subtree  
           inorder(rc)
```

## Graph
- A graph is a set of nodes and a set of edges.
- Formally, a graph G = (V, E), where V is a set of nodes  (or vertices) and E is a set of edges.
- Each edge connects two nodes, and is represented as (u, v), where u and v are nodes.


## Priority Queue
- each element in a queue is associated with a key, usually keys are numbers
- keys must have total ordering - a specific way to put keys in a linear order
- useful cases: scheduling, operation system, routing etc

### Sorted Array
- expensive to enqueue an element 
- add - O(n) - array iteration with shifting/creating space for the element
- O(log n) - binary search with a linked list structure
- dequeue (remove - O(1))

### Unsorted Array
- expensive to dequeue an element 
- remove - O(n)
- enqueue (add - O(1))

## Heap
- complete binary tree
- heap-order property (minimum-oriented heap): the parent key should always be smaller than or equal to the child key.


# Algorithm
## Insertion Sort

# Useful Links
[Array List vs Linked List | Which one should you use](https://www.youtube.com/watch?time_continue=1&v=M_0q6rGUsNc&feature=emb_logo)
[Determining complexity for recursive functions (Big O notation)](https://stackoverflow.com/questions/13467674/determining-complexity-for-recursive-functions-big-o-notation)
[Stack Class in Java and Using Deque](https://blog.devgenius.io/you-should-be-aware-of-this-if-you-are-still-using-stack-class-in-java-87716280b788)
