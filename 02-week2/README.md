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
