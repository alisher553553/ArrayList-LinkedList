# ArrayList-LinkedList

This assignment involves building two custom implementations of the Java `List` interface:
- `MyArrayList`: using a dynamically resizing array
- `MyLinkedList`: using a custom doubly-linked list

We then evaluate the performance of standard list operations using:
- `MyArrayList`
- `MyLinkedList`
- Java's built-in `ArrayList`
- Java's built-in `LinkedList`

---

## ✏️ Features

- Generic support for both custom list types
- Core list methods implemented:
  - `add(E)`
  - `add(int, E)`
  - `clear()`
  - `remove(int)`
  - `remove(Object)`
  - `size()`
  - `toString()`
- Unsupported `List` methods throw `UnsupportedOperationException`

---

## ⚙️ Driver Class: `ListTester`

Performs benchmarking for different list sizes `N = {10, 100, ..., 1,000,000}`:

1. **Insertion Time**:
   - At start
   - At end
   - At random index

2. **Removal Time**:
   - From start
   - From end
   - From random index
   - By value

Results are saved to `testrun.txt`.

---

## 📄 Output Format

- Timing results presented in tables for each operation type and list size
- File `testrun.txt` must be submitted alongside source code

---
