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



# Algorithm
## Insertion Sort


# Useful Links
[Array List vs Linked List | Which one should you use](https://www.youtube.com/watch?time_continue=1&v=M_0q6rGUsNc&feature=emb_logo)
[Determining complexity for recursive functions (Big O notation)](https://stackoverflow.com/questions/13467674/determining-complexity-for-recursive-functions-big-o-notation)
[Stack Class in Java and Using Deque](https://blog.devgenius.io/you-should-be-aware-of-this-if-you-are-still-using-stack-class-in-java-87716280b788)
