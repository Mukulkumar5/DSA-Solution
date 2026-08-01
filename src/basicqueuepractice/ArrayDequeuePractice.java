package basicqueuepractice;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeuePractice {
    public static void main(String[] args) {
        /*
         * Deque (Double Ended Queue)
         *
         * A Deque allows insertion, deletion, and retrieval of elements from both
         * the front and the rear. It can be used as both a Queue (FIFO) and a Stack (LIFO).
         *
         * Default Behavior (ArrayDeque):
         * - Dynamically resizes as elements are added (no fixed capacity).
         * - Does not allow null elements.
         * - Not thread-safe.
         * - Provides O(1) insertion and deletion at both ends.
         *
         * Deque Interface Behavior:
         * - Most operations are available in two forms:
         *   1. Exception-based methods (add, remove, get) throw an exception on failure.
         *   2. Special-value methods (offer, poll, peek) return false or null instead of throwing an exception.
         *
         * Custom/Bounded Deque Behavior:
         * - A custom implementation may have a fixed capacity.
         * - In such cases:
         *      add/addFirst/addLast -> throws IllegalStateException if full.
         *      offer/offerFirst/offerLast -> returns false if full.
         *
         * Common Implementations:
         * - ArrayDeque (Resizable array, fastest for most use cases)
         * - LinkedList (Doubly linked list)
         * - LinkedBlockingDeque (Thread-safe, optional bounded capacity)
         */

        Deque<Integer> deque = new ArrayDeque<>();

        deque.addLast(10);
        deque.addLast(20);
        deque.addLast(30);

        System.out.println(deque.removeFirst()); // 10
        System.out.println(deque.removeLast());  // 30
        System.out.println(deque.getFirst());    // 20
        System.out.println(deque.getLast());     // 20
    }
}
