# Java Collections & Modern Java Practice

This repository contains examples demonstrating various features of Java Collections Framework.

## 📚 Table of Contents

### 1. Lists

#### [ArrayList](src/ArrayList.java)
This file demonstrates different ways to work with ArrayLists and Lists in Java. It shows basic ArrayList operations (add, set, remove) and covers different types of List initialization. It explains how `Arrays.asList()` creates a fixed-size list where elements can be modified but size cannot be changed, `List.of()` creates a completely immutable list, and `new ArrayList<>(Arrays.asList(...))` creates a fully modifiable list. The examples demonstrate adding elements at specific indices, replacing elements using set(), and iterating through lists.

#### [Comparator](src/Comparatorexample.java)
This file showcases different ways to sort objects using Comparators in Java. It includes a custom com.skv.corejava.Student class with name and GPA fields to demonstrate object sorting. The implementation shows multiple approaches including bare metal way using lambda expressions with proper handling of decimal comparisons, modern Java comparator using method references (com.skv.corejava.Student::getGpa), chaining comparators with thenComparing, and reverse ordering. Additional examples demonstrate sorting integer lists in ascending/descending order and sorting strings by length.

#### Coming Soon:
- [ ] LinkedList
- [ ] Vector
- [ ] Stack

### 2. Maps
- [ ] Map Interface
- [ ] HashMap
- [ ] LinkedHashMap
- [ ] LRU Cache Implementation
- [ ] WeakHashMap & Garbage Collection
- [ ] SortedMap
- [ ] NavigableMap
- [ ] HashTable
- [ ] ConcurrentHashMap
- [ ] ConcurrentSkipListMap
- [ ] EnumMap
- [ ] ImmutableMap

### 3. Sets
- [ ] Set Interface
- [ ] HashSet
- [ ] LinkedHashSet
- [ ] TreeSet
- [ ] CopyOnWriteArraySet

### 4. Queues
- [ ] Queue Interface
- [ ] PriorityQueue
- [ ] Deque
- [ ] BlockingQueue
- [ ] LinkedBlockingQueue
- [ ] PriorityBlockingQueue
- [ ] SynchronousQueue
- [ ] DelayQueue
- [ ] ConcurrentLinkedQueue

### 5. Java 8+ Features
- [ ] Core Concepts
- [ ] Lambda Expressions
- [ ] Functional Interfaces
    - [ ] Predicate
    - [ ] Function
    - [ ] Consumer
    - [ ] Supplier
- [ ] Streams
    - [ ] Stream API
    - [ ] Parallel Streams
    - [ ] Collectors
    - [ ] Primitive Streams

### 6. Iteration & Comparison
- [ ] Iterable Interface
- [ ] Iterator Pattern
- [ ] Comparable Interface
- [ ] Comparator Interface

## 🚀 Getting Started

### Prerequisites
- Java 8 or higher
- Any Java IDE (IntelliJ IDEA recommended)

### Setup
1. Clone the repository
2. Open in your IDE
3. Navigate to specific examples in their respective files

## 🤝 Contributing
Feel free to contribute:
1. Fork the repo
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## ⏳ Coming Soon
- More collection implementations
- Advanced usage patterns
- Performance comparisons
- Best practices
- Common pitfalls
- Thread safety examples