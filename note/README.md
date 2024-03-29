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
- heap-order property (minimum-oriented heap): the parent key should always be smaller or equal to the child key.
- height of a heap with n entries is h = log n
- The total number of edges is less than the total number of edges in the entire tree.

#### Adding
- up-heap bubbling - O(log n) - bubbling all the way back to the root
- find last empty location
- swap based on the priority with the parent
- (current node is prior than parent - until we get the point that the child is no longer smaller than parent)

#### Removing
- O(log n) - comparison through bubbling down
- only one place to remove, remove from the root
- last node moves up to the root and performs down-heap bubbling 
- until we get to the point where no longer than the child

### Array-based Heap
- no empty element in the middle of the heap

### Sorting with Priorty Queue
- O(n log n)

## Map
- store and retrieve values based on search keys 
- a map stores (key, value) pairs
- keys are unique

Worst case
- add: O(1)
- get: O(n) - collision + unsorted


#### Avoid collision
- when two keys mapped to the same slot in the hash table, it is called a collision
- avoid collision for faster look up

### Hash Tables
- Hash table is an efficient implementation of a map.

issues
- the domain of keys may be much larger than actual number of elements stored in the table - waste of space
- key may not be integers which they can not be used as indices in the table

solutions
- use a hash function that maps key to integers range [0, N-1], distributing keys evenly

### Hash Code
- 32 bits
- Polynomial hash code: used for strings or variable-length objects – prevents collisions when the order matters

Java hasCode() - no good
- the defualt hasCode only uses the internal memory address of the object - so even object with the same value will have different hascode
- When designing a hashCode() for a user-defined class, make sure: If `x.equals(y), x.hashCode( ) = y.hashCode( )`

### Compression function
- must distribute hash code (of keys) relatively uniformly across the hash table

division method - more efficient
- i mod N
- where i is an integer (such as a hash code) and N is the  hash table size.

MAD (multiply-add-and-divide) method - better distributing keys across the hash table
- `[ (ai + b) mod p ] mod N`, where N is hash table size, p is a prime number larger than N, and a and b are integers in `[0, p – 1]`, a > 0.
```java
private int hashValue(K key) {
  return (int) ((Math.abs(key.hashCode( )*scale + shift) % prime) % capacity);
}
```

### collision handling
##### chaining
- each slot in the table keeps an unsorted list and all keys that are mapped to the same slot are kept in the list.
- each location in your hash table is going to store an unsorted list, when I want to go back and retrieve, I would have to go through this list to to check whether the key exists.
- advantage: easy to implement, get more storage for the storage that you use
- drawback: additional storage and slower when load factcor is low
- add: O(1)
- get: O(n) - all in the same location, then you have to search the entire list

##### open addressing - mod order
- all entries are stored in the hash table
- when adding a new key caused a collision, an alternative location in the table is found and the new element is stored in that location
- just find another location to store the key

linear probing
- if j is occupied, then just go to j+1, j+2 until an empty slot is found or all slots have been probed
- place defucnt in the slot from which an entry is removed
- issue: primary clustering - a cluster is a set of contiguous occupied slot, once a cluster is formed, it tends to grow

quadratic probing
- use a quadratic function to determine the next slot to probe
- no primary clustering but can be space inefficient

double probing
- `h(k, i) = (h(k) + i*h’(k)) mod N`
- avoid primary clustering, which probe sequence is determined by a secondary hash function
- pros: tends to requires smaller probe sequence when load factor is large
- cons: higher cost of computing the next probe location

##### load factor and efficiency
- load factor is defined as number of entries storing over the total size of the hash table
- "load factor" (number of items in hash table / capacity of hash table)
- a larger value of load factor means there is higher probability of collisions
- Java uses chaining method - higher load factors result in resizing the map to maintain lower than 0.75 load factor

##### What happens if no spots left in the hash table
- Most implementations monitor the "load factor" (number of items in hash table / capacity of hash table) and increase the capacity when the load factor is greater than some fixed value (like 0.75). So these implementations would never run into this problem.

## Binary Search Trees
- each internal node stores key value pair
- key has a total ordering
- proper binary tree (no single child), not complete
- O(h) - height of the tree - close to log n  most of the binary search tree - a tree is balanced
- O(log n) - the height of a complete binary tree
- O(n) - a tree is a linked list

### recall
- the height of a node is the number of edges on the longest path from that node to a leaf node
- the height of a tree is the height of the root of the tree
- the height of a leaft node is zero

### AVL tree
- a binary search tree that satisfies height-balance property
- for every internal node n of T, the heights of the children of n differ by at most one.
- the unbalanced node is the parent of the ones that differ in heights.

#### insertion
- work backwards, the second we hit an unbalanced note that is when we stop
- to fix it we do operation called trinode restructuring with a sequence called rotation
- search and repair strategy: search a node z that is the lowest ancesteor 

## Optimization
- solution for things take too long to run

### Greedy Algorithms
- considers all options that are available at that moment and choose the best among them
- beginning from a, select the next node which is the best choice at that moment (closest to the current node)

### Huffman Code
- data compression problem
- minimum sized compressed version of input, then translatable back to original input
- using the fewest number of binary digits as possible a fewest number of bits.

#### Encoding
- input is a sequence of characters, each character is encoded to a unique binary string called a codeword
- goal is to encode to a dictionary and maps characters to binary encoding

#### Decoding
- converting a codeword to the initial character

#### optimal prefix code with binary tree 
- frequent code to have short codeword
- frequency, fixed-length, variable-length(better) using binary tree
- Encoding: Represent each character in the data with the corresponding codeword.
- Encoding: Convert an encoded data to the  original data. This can be done efficiently using a binary tree

### Dynamic Programming
- combining solutions to subproblems like divide and conquer
- used for optimization problems

#### approach
- bottom-up approach: problems are solved in the increasing order of size
- each subproblems is solves once and the solution os stored in the table

#### examples
- matrix multiplication
- longest common subsequence
- optimal binary search tree

# Sorting Algorithm
- input is the collection of objects that can be ordered in some way
- goal of sorting is to reorder the collection

## Insertion Sort
- similar to the way you sort playing cards in your hands
- The array is virtually split into a sorted and an unsorted part. 
- Values from the unsorted part are picked and placed at the correct position in the sorted part.

```python
def insertionSort(array):

   for step in range(1, len(array)):
        key = array[step]
        j = step - 1
        
        # Compare key with each element on the left of it until an element smaller than it is found
        # For descending order, change key<array[j] to key>array[j].        
        while j >= 0 and key < array[j]:
            array[j + 1] = array[j]
            j = j - 1
        
        # Place key at after the element just smaller than it.
        array[j + 1] = key
```

## Heap Sort

## Merge Sort
- A divide-and-conquer algorithm
- Divide: If input size is smaller than a certain threshold, solve it using a straightforward method. Otherwise, divide the input into two or more subproblems.
- Conquer: Solve the subproblems recursively.
- Combine: Merge solutions to subproblems to generate a solution to the original problem.

### runtime
- each level takes O(n)
- there are (log n + 1) levels
- total running time = O(n)(log n + 1) = O(n)(log n) + O(n) = O(n log n)

## Quick Sort
- Divide (partition): put element into three sequences (x is called pivot):
```
L: This sequence contains the elements that are less than x.
E: This sequence contains the elements that are equal to x.
G: This sequence contains the elements that are greater than x.
```
- Conquer: Recursively sort L and G.
- Combine: Put back the elements from the three parts into S in order.

### runtime
- choosing pivot is essential
- If partitions are always balanced, the worst-case runtime is: O(n log n)
- Even when partitions are not completely balanced, the running time is still O(n log  n)
- In the worst case (extremely unbalanced): This occurs if an array is already sorted and the  last element is chosen as a pivot. Running time is O(n2).
- comparation-based sorting algorithm is at least O(n log n), no better than it

## Bucket Sort
- Sorts a sequence of elements in linear time with a constraint.
- create bucket array with fixed size, loop through and add the element to the bucket, then loop through bucket to put it back to the original list

### runtime
- O(N) + O(N) = O(N)

### Stable Sort
- The bucket-sort is stable if the order of same element behave as queues.
- first in first out queue order

## Radix Sort
- with fixed number of digit like sorting three digit numbers
- Each column is sorted using a stable sorting algorithm
- O(N) + O(N) + O(N) = O(N)

## Sorting Comparison
- O(n): bucket-sort, radix-sort 
- O(n log n): heap-sort, quick-sort, merge-sort
- O(n^2): insertion-sort

### Insertion sort
- When the number of elements is small (typically less  than 50), insertion-sort is very efficient.
- Insertion-sort is very efficient for an “almost” sorted  sequence.

### Heap-Sort
- Heap-sort runs in O(n log n) in the worst case.
- It works well on small- and medium-sized sequences.
- Its performance is poorer than that of quick-sort and merge-sort on large sequences.
- Heap-sort is not a stable sorting algorithm.

### Merge-Sort
- Worst-case running time is O(n log n).
- Less attractive than heap-sort or quick-sort.
- Merge-sort is an excellent algorithm for sorting data that resides on the disk (or storage outside the main memory), since it has good cache locality (data near each other at the beginning tends to be processed together)

### Quick-Sort
- Worst-case running time is O(n2).
- Experimental studies showed quick-sort outperformed heap-sort and merge-sort.
- Quick-sort has been a default algorithm as a general-purpose, in-memory sorting algorithm.

### Tim-Sort
- Tim-sort is a hybrid algorithm which uses a bottom-up merge-sort and insertion-sort.

### Bucket-sort & Radix-sort
- Excellent for sorting entries with small integer keys, character strings, or d-tuple keys from a small range.

# Useful Links
[Array List vs Linked List | Which one should you use](https://www.youtube.com/watch?time_continue=1&v=M_0q6rGUsNc&feature=emb_logo)
[Determining complexity for recursive functions (Big O notation)](https://stackoverflow.com/questions/13467674/determining-complexity-for-recursive-functions-big-o-notation)
[Stack Class in Java and Using Deque](https://blog.devgenius.io/you-should-be-aware-of-this-if-you-are-still-using-stack-class-in-java-87716280b788)
