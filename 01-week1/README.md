## Array List
- useful to store elements of a single type in a certain order
- must be fixed size when created
- insertion and deletion at interior position of arrays can be time consuming

## Linked List
- often used to implement stacks and queues
- in array, every location stores a single data, but linked lists store 2 jobs
1. store data (like array)
2. remember which box is next (store a reference to the next box)

### Singly Linked List
- reference (or pointer) to the next node
- keep two references, head and tail
- You need the previous reference
- useful case: run search in two directions simultaneously

#### Operation
##### add to the head
```
newest = Node()
newest.next = head
head = neawest
```

##### add to the tail
```
newest = Node()
newest.next = null
tail.next = newest
tail = newest
```

##### removing the head
```
head = head.next
```

### Doubly Linked List

Delete X
x.prev.next = x.next
x.next.prev = x.prev
