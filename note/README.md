## Array List
- useful to store elements of a single type in a certain order
- must be fixed size when created
- insertion and deletion at interior position of arrays can be time consuming

## Linked List
- often used to implement stacks and queues
In array, every location stores a single data, but linked lists store 2 jobs:
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
side + 1
```

#### add to the tail
```
newest = Node()
newest.next = null
tail.next = newest
tail = newest
side + 1
```

#### removing the head
```
head = head.next
side - 1
```

### Doubly Linked List
- you need the previous reference

#### deleting X
```
x.prev.next = x.next
x.next.prev = x.prev
```

### When to use each type of list?
- doubly linked list when you need to removal at various points withink the list
- singly linked list has memory saving (pnly one reference per node), but does not enable deletion at arbitary points in list
  
## ArrayList vs LinkedList
- Arraylist gives you constant time read access from intermediate locations where linkedlist must traverse the list
- If you are not sure, just use ArrayList

ArrayList
- accessing O(1)
- adding O(n)

LinkedList
- accessing O(n)
- adding O(n)

## Algorithm Analysis
- Algorithm is a sequence of steps that correctly map every possible input to the problem to the correct output
- How time and memory requirements grow as the input size grows
- we focus on the rate of growth, like how quickly or slowly running time grows as th input size increases

#### Rate of Growth
```
O(n^2) =      //it is a class

//prove blow for f(n) = n
f(n) = n, c = 1, n0 = 1
f(n) <= c*g(n)
n <= 1*n^2
```

How long a block of code will take to run based on the input size\

input size: length of array n\
constant does not depend on the length of array\
for loop runs depend on n => which runs n-1 time, loop body takes constant time

look for the highest growth rate, ignore constance


## Recursion
#### Factorial
input size - value of n
# of recursive call -- n+1 -- O(n)
runtime for a singel recursive call -- O(1)


#### Binary Search
search a sequence of n elements for a target element
- linear search

binary search
- requires the array is sorted


## Stack

## Queues
enqueue
f + size

dequeue
