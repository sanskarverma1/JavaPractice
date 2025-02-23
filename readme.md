# Java Collections Framework & Modern Java - Interview Guide

## Table of Contents
- [1. Lists](#1-lists)
  - [Collection Interface Methods (Must Know)](#collection-interface-methods-must-know)
  - [ArrayList](#arraylist)
    - [Internal Working](#internal-working)
    - [Time Complexities](#time-complexities)
    - [Key Interview Points](#key-interview-points)
  - [LinkedList](#linkedlist)
    - [Internal Working](#internal-working-1)
    - [Time Complexities](#time-complexities-1)
    - [Interview Focus Points](#interview-focus-points)
- [2. Maps](#2-maps)
- [3. Sets](#3-sets)
- [4. Queues](#4-queues)
- [5. Java 8+ Features](#5-java-8-features)
  - [Comparator](#comparator)
    - [Core Functionality](#core-functionality)
    - [Implementation Approaches](#implementation-approaches)
    - [Key Interview Points](#key-interview-points-1)
    - [Modern Implementations (Java 8+)](#modern-implementations-java-8)
    - [Common Pitfalls & Solutions](#common-pitfalls--solutions)
    - [Common Interview Questions & Answers](#common-interview-questions--answers)
    - [Best Practices Summary](#best-practices-summary)
- [6. Iteration & Comparison](#6-iteration--comparison)

## 1. Lists

### Collection Interface Methods (Must Know)
| Method | Description |
|--------|-------------|
| `add(E element)` | Adds element to collection |
| `remove(Object obj)` | Removes first occurrence |
| `contains(Object obj)` | Checks if element exists |
| `size()` | Returns number of elements |
| `isEmpty()` | Checks if collection is empty |
| `clear()` | Removes all elements |

### ArrayList

[ArrayList Example](src/ArrayList.java)

This file demonstrates different ways to work with ArrayLists and Lists in Java. It shows basic ArrayList operations (add, set, remove) and covers different types of List initialization:

- `Arrays.asList()` creates a fixed-size list where elements can be modified but size cannot be changed
- `List.of()` creates a completely immutable list 
- `new ArrayList<>(Arrays.asList(...))` creates a fully modifiable list

The examples demonstrate adding elements at specific indices, replacing elements using set(), and iterating through lists.

#### Internal Working
- Backed by dynamic array (`Object[] elementData`)
- Default capacity: 10
- Growth factor: 1.5x (`newCapacity = oldCapacity + (oldCapacity >> 1)`) 
- Memory: Contiguous allocation

#### Time Complexities
| Operation | Time | Notes |
|-----------|------|-------|
| add(E) | O(1) | Amortized |
| add(index, E) | O(n) | Shifts elements |
| remove(index) | O(n) | Shifts elements | 
| get(index) | O(1) | Direct access |
| contains(Object) | O(n) | Linear search |

#### Key Interview Points
- **ArrayList vs Array**

| ArrayList | Array |
|-----------|-------|
| Dynamic size | Fixed size | 
| Objects only | Any type |
| Generics supported | No generics |
| size() method | length property |

- **Common Pitfalls** 
  ```java
  // 1. Concurrent Modification
  for (Element e : list) {
      list.remove(e);    // Wrong!
  }
  
  // Correct way
  Iterator<Element> iter = list.iterator();
  while (iter.hasNext()) {
      Element e = iter.next();
      iter.remove();  
  }

  // 2. Thread Safety
  List<String> syncList = Collections.synchronizedList(new ArrayList<>());
  ```

### LinkedList

[LinkedList Example](src/LinkedListExample.java)

#### Internal Working
- Doubly-linked list implementation 
- Each node contains:
    - Element (data)
    - Previous node reference
    - Next node reference

#### Time Complexities
| Operation | Time | Notes |
|-----------|------|-------|
| addFirst/Last | O(1) | Constant time |
| add(E) | O(1) | At end | 
| add(index, E) | O(n) | Search then insert |
| get(index) | O(n) | Linear search | 
| remove(index) | O(n) | Search then remove |

#### Interview Focus Points
- **LinkedList vs ArrayList**

| Operation | LinkedList | ArrayList |
|-----------|------------|------------|
| Memory | More (nodes) | Less (array) |
| Random Access | O(n) | O(1) |
| Insert/Delete | O(1)* | O(n) | 
| End Operations | O(1) | O(1)** |

*If position is known  
**Amortized for addition

- **Implementation Features**
    - Implements both List and Deque interfaces
    - Can be used as List, Stack, or Queue
    - Bidirectional iteration supported
    - Allows null elements

- **Common Code Patterns**
  ```java
  // Queue operations
  linkedList.offer(element);    // Add at end
  linkedList.poll();            // Remove from front
  
  // Stack operations  
  linkedList.push(element);     // Add at front
  linkedList.pop();             // Remove from front
  
  // Deque operations
  linkedList.addFirst(element); 
  linkedList.addLast(element);
  ```

## 5. Java 8+ Features

### Comparator

[Comparator Example](src/ComparatorExample.java)

This file showcases different ways to sort objects using Comparators in Java. It includes a custom Student class with name and GPA fields to demonstrate object sorting. The implementation shows multiple approaches:

- Bare metal way using lambda expressions with proper handling of decimal comparisons
- Modern Java comparator using method references (`Student::getGpa`)
- Chaining comparators with `thenComparing`
- Reverse ordering

Additional examples demonstrate sorting integer lists in ascending/descending order and sorting strings by length.

#### Core Functionality
- Used for custom object comparison
- Functional interface with single method:
 ```java
 int compare(T o1, T o2) 
 // Returns: negative (o1 < o2), zero (equal), positive (o1 > o2)
 ```

#### Implementation Approaches
| Approach | When to Use | Example |
|----------|-------------|---------|
| Lambda | Simple comparisons | `(a, b) -> a.getGpa() - b.getGpa()` |
| Method Reference | Clean, reusable | `Comparator.comparing(Student::getGpa)` |
| Multiple Fields | Complex sorting | `comparing().thenComparing()` |

#### Key Interview Points

- **Comparator vs Comparable**

| Comparator | Comparable |
|------------|------------|
| Separate class/lambda | Inside class |
| Multiple sort orders | Natural order |
| `compare(o1, o2)` | `compareTo(o)` |
| More flexible | Single order |

#### Modern Implementations (Java 8+)
```java
// Method reference way
Comparator<Student> byGpa = Comparator.comparing(Student::getGpa);

// Multiple criteria with chaining
Comparator<Student> complex = Comparator
    .comparing(Student::getGpa)
    .thenComparing(Student::getName)
    .reversed();
    
// Null handling  
Comparator<Student> nullSafe = Comparator.nullsFirst(byGpa);
```

#### Common Pitfalls & Solutions
```java
// DON'T: Integer overflow risk
(a, b) -> a.getValue() - b.getValue()

// DO: Use proper comparison
(a, b) -> Integer.compare(a.getValue(), b.getValue())

// DON'T: Incorrect double comparison 
(a, b) -> (int)(a.getGpa() - b.getGpa())

// DO: Use Double.compare
(a, b) -> Double.compare(a.getGpa(), b.getGpa())  
```

#### Common Interview Questions & Answers
**Q1: When would you use Comparator vs Comparable?**

Answer:
```java
// Comparable - Natural ordering (used when class owns comparison)
public class Student implements Comparable<Student> {
    private String name;
    private double gpa;
    
    @Override
    public int compareTo(Student other) {
        return Double.compare(this.gpa, other.gpa);
    }
}

// Comparator - Multiple/external ordering strategies
public class StudentGpaComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Double.compare(s1.getGpa(), s2.getGpa());
    }
}

// Use Cases:
// 1. Comparable - When class has natural ordering (String, Integer)
// 2. Comparator - When multiple sort orders needed or can't modify class
```

**Q2: How to sort by multiple fields?**

Answer:  
```java
// Method 1: Using thenComparing
Comparator<Student> multiComparator = Comparator
    .comparing(Student::getGpa)
    .thenComparing(Student::getName)
    .thenComparing(Student::getAge);

// Method 2: Traditional way
Comparator<Student> traditional = (s1, s2) -> {
    int result = Double.compare(s1.getGpa(), s2.getGpa());
    if (result == 0) {
        result = s1.getName().compareTo(s2.getName()); 
        if (result == 0) {
            result = Integer.compare(s1.getAge(), s2.getAge());
        }
    }
    return result;
};
```

**Q3: How to handle null values in comparison?**

Answer:
```java  
// Method 1: Using nullsFirst/nullsLast
Comparator<Student> nullSafeComparator = Comparator
    .nullsFirst(  // or nullsLast
        Comparator.comparing(Student::getName)
    );

// Method 2: Manual null handling  
Comparator<Student> manual = (s1, s2) -> {
    if (s1 == s2) return 0;
    if (s1 == null) return -1; 
    if (s2 == null) return 1;
    return s1.getName().compareTo(s2.getName());  
};
```

**Q4: Explain comparing() vs thenComparing()**

Answer:
```java
// comparing() - Primary sort criteria
Comparator<Student> primary = Comparator.comparing(Student::getGpa);

// thenComparing() - Secondary sort when primary comparison equals 
Comparator<Student> combined = Comparator
    .comparing(Student::getGpa)      // First sort by GPA
    .thenComparing(Student::getName) // If GPAs equal, sort by name
    .thenComparing(Student::getAge); // If names equal, sort by age
    
// Real-world example
students.sort(Comparator
    .comparing(Student::getGrade)
    .thenComparing(Student::getGpa, Comparator.reverseOrder())  
    .thenComparing(Student::getName));
```

**Q5: How to ensure comparison is consistent with equals()?**

Answer:
```java  
public class Student {
    private final String name;
    private final double gpa;

    // Correct equals implementation
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Double.compare(student.gpa, gpa) == 0 &&
               Objects.equals(name, student.name);
    }
    
    // Consistent comparator
    public static final Comparator<Student> CONSISTENT_COMPARATOR = 
        Comparator.comparing(Student::getGpa)
                 .thenComparing(Student::getName);
                 
    // This ensures: compare(x,y) == 0 is consistent with x.equals(y)
}
```

#### Best Practices Summary
```java
// 1. Always use type-safe methods
Comparator.comparing(Student::getGpa)  // Good
(a, b) -> a.gpa - b.gpa               // Bad

// 2. Handle nulls explicitly 
Comparator.nullsFirst(naturalOrder())

// 3. Use method references when possible  
comparing(Student::getName)  // Better
comparing(s -> s.getName()) // OK

// 4. Chain comparisons clearly
students.sort(
    comparing(Student::getLastName)
        .thenComparing(Student::getFirstName)
        .thenComparing(Student::getId)  
);
```
