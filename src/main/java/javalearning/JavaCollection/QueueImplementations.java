package javalearning.JavaCollection;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueImplementations {
    public static void main(String[] args) {
        // LinkedList based Queue
        Queue<String> linkedListQueue = new LinkedList<>();
        linkedListQueue.offer("LinkedList Item 1");
        linkedListQueue.offer("LinkedList Item 2");

        // Displaying elements of LinkedList Queue
        System.out.println("LinkedList Queue: " + linkedListQueue);

        // ArrayDeque based Queue
        Queue<String> arrayDequeQueue = new ArrayDeque<>();
        arrayDequeQueue.offer("ArrayDeque Item 1");
        arrayDequeQueue.offer("ArrayDeque Item 2");

        // Displaying elements of ArrayDeque Queue
        System.out.println("ArrayDeque Queue: " + arrayDequeQueue);


        // PriorityQueue based Queue
        Queue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer("PriorityQueue Item 1");
        priorityQueue.offer("PriorityQueue Item 2");


        // Displaying elements of PriorityQueue
        System.out.println("PriorityQueue: " + priorityQueue);
    }
}

/*
Differences:
- **LinkedList**:
  - Implements both `List` and `Deque` interfaces.
  - Can be used as a list, stack, or queue.
  - Maintains insertion order.
- **ArrayDeque**:
  - Implements the `Deque` interface.
  - Can be used as both stack and queue.
  - Does not allow null elements.
  - More memory-efficient than `LinkedList` when used as a queue.
- **PriorityQueue**:
  - Implements the `Queue` interface.
  - Elements are ordered according to their natural ordering or by a `Comparator` provided at queue construction time.
  - Does not guarantee to maintain insertion order.
  - Offers efficient removal of the smallest element.
 */