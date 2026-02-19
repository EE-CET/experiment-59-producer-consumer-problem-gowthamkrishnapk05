[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/QiYJ1U6X)
# Experiment 59: Producer Consumer Problem

## Problem Statement

Implement the **Producer-Consumer** problem using `wait()` and `notify()` methods for inter-thread communication.
The producer should produce 5 items and the consumer should consume them sequentially.

**Requirement:** The output must show strict alternation between producing and consuming.

## Input Format

* No Input.

## Output Format

* `Produced: [item]`
* `Consumed: [item]`
* ... repeat for 5 items.

### Sample Output

```text
Produced: 1
Consumed: 1
Produced: 2
Consumed: 2
Produced: 3
Consumed: 3
Produced: 4
Consumed: 4
Produced: 5
Consumed: 5
```
