package arrays;

import java.util.List;

public class LinkedListPractice {

    // =========================================================
    // NODE
    // =========================================================

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head;


    // =========================================================
    // DISPLAY
    // =========================================================

    static void display() {

        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }


    // =========================================================
    // INSERT AT BEGINNING
    // =========================================================

    static void insertAtBeginning(int data) {

        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;
    }


    // =========================================================
    // INSERT AT END
    // =========================================================

    static void insertAtEnd(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }


    // =========================================================
    // INSERT AT POSITION
    // 0-based index
    // =========================================================

    static void insertAtPosition(int data, int position) {

        Node newNode = new Node(data);

        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;

        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Invalid position");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
    }


    // =========================================================
    // DELETE FROM BEGINNING
    // =========================================================

    static void deleteFromBeginning() {

        if (head == null) {
            return;
        }

        head = head.next;
    }


    // =========================================================
    // DELETE FROM END
    // =========================================================

    static void deleteFromEnd() {

        if (head == null) {
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node current = head;

        while (current.next.next != null) {
            current = current.next;
        }

        current.next = null;
    }


    // =========================================================
    // DELETE BY VALUE
    // =========================================================

    static void deleteByValue(int value) {

        if (head == null) {
            return;
        }

        // If value is in first node
        if (head.data == value) {
            head = head.next;
            return;
        }

        Node current = head;

        while (current.next != null &&
                current.next.data != value) {

            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }


    // =========================================================
    // SEARCH
    // =========================================================

    static boolean search(int value) {

        Node current = head;

        while (current != null) {

            if (current.data == value) {
                return true;
            }

            current = current.next;
        }

        return false;
    }


    // =========================================================
    // LENGTH
    // =========================================================

    static int length() {

        int count = 0;

        Node current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }


    // =========================================================
    // REVERSE - ITERATIVE
    // =========================================================

    static void reverse() {

        Node previous = null;
        Node current = head;

        while (current != null) {

            Node next = current.next;

            current.next = previous;

            previous = current;
            current = next;
        }

        head = previous;
    }


    // =========================================================
    // REVERSE - RECURSIVE
    // =========================================================

    static Node reverseRecursive(Node current) {

        if (current == null || current.next == null) {
            return current;
        }

        Node newHead = reverseRecursive(current.next);

        current.next.next = current;

        current.next = null;

        return newHead;
    }


    // =========================================================
    // FIND MIDDLE
    // =========================================================

    static int findMiddle() {

        if (head == null) {
            return -1;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }


    // =========================================================
    // NTH NODE FROM END
    // =========================================================

    static int nthFromEnd(int n) {

        Node first = head;
        Node second = head;

        // Create gap of n
        for (int i = 0; i < n; i++) {

            if (first == null) {
                return -1;
            }

            first = first.next;
        }

        while (first != null) {

            first = first.next;
            second = second.next;
        }

        return second.data;
    }


    // =========================================================
    // DETECT CYCLE
    // Floyd's Slow/Fast Pointer
    // =========================================================

    static boolean hasCycle() {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }


    // =========================================================
    // FIND STARTING NODE OF CYCLE
    // =========================================================

    static Node cycleStart() {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                // Move slow to head
                slow = head;

                // Move both one step
                while (slow != fast) {

                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }


    // =========================================================
    // REMOVE CYCLE
    // =========================================================

    static void removeCycle() {

        Node cycleNode = cycleStart();

        if (cycleNode == null) {
            return;
        }

        Node current = cycleNode;

        while (current.next != cycleNode) {
            current = current.next;
        }

        current.next = null;
    }


    // =========================================================
    // PALINDROME
    // =========================================================

    static boolean isPalindrome() {

        if (head == null || head.next == null) {
            return true;
        }

        Node slow = head;
        Node fast = head;

        // Find middle
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node secondHalf = reverseNode(slow);

        Node firstHalf = head;

        // Compare
        while (secondHalf != null) {

            if (firstHalf.data != secondHalf.data) {
                return false;
            }

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }


    // =========================================================
    // HELPER REVERSE
    // =========================================================

    static Node reverseNode(Node node) {

        Node previous = null;
        Node current = node;

        while (current != null) {

            Node next = current.next;

            current.next = previous;

            previous = current;
            current = next;
        }

        return previous;
    }


    // =========================================================
    // MERGE TWO SORTED LINKED LISTS
    // =========================================================

    static Node merge(Node first, Node second) {

        Node dummy = new Node(0);

        Node current = dummy;

        while (first != null && second != null) {

            if (first.data <= second.data) {

                current.next = first;
                first = first.next;

            } else {

                current.next = second;
                second = second.next;
            }

            current = current.next;
        }

        if (first != null) {
            current.next = first;
        }

        if (second != null) {
            current.next = second;
        }

        return dummy.next;
    }


    // =========================================================
    // REMOVE DUPLICATES FROM SORTED LINKED LIST
    // =========================================================

    static void removeDuplicates() {

        Node current = head;

        while (current != null && current.next != null) {

            if (current.data == current.next.data) {

                current.next = current.next.next;

            } else {

                current = current.next;
            }
        }
    }


    // =========================================================
    // CREATE LINKED LIST
    // =========================================================

    static Node createList(int... values) {

        Node newHead = null;
        Node current = null;

        for (int value : values) {

            Node newNode = new Node(value);

            if (newHead == null) {

                newHead = newNode;
                current = newNode;

            } else {

                current.next = newNode;
                current = newNode;
            }
        }

        return newHead;
    }


    // =========================================================
    // DISPLAY ANY LINKED LIST
    // =========================================================

    static void display(Node node) {

        while (node != null) {

            System.out.print(node.data + " -> ");

            node = node.next;
        }

        System.out.println("null");
    }


    // =========================================================
    // MAIN
    // =========================================================

    public static void main(String[] args) {

        // -----------------------------------------------------
        // CREATE
        // -----------------------------------------------------

        head = createList(10, 20, 30, 40, 50);

        System.out.println("Original List:");
        display();


        // -----------------------------------------------------
        // INSERT
        // -----------------------------------------------------

        insertAtBeginning(5);

        System.out.println("\nAfter insert at beginning:");
        display();

        insertAtEnd(60);

        System.out.println("\nAfter insert at end:");
        display();

        insertAtPosition(25, 3);

        System.out.println("\nAfter insert at position 3:");
        display();


        // -----------------------------------------------------
        // SEARCH
        // -----------------------------------------------------

        System.out.println("\nSearch 30:");
        System.out.println(search(30));


        // -----------------------------------------------------
        // LENGTH
        // -----------------------------------------------------

        System.out.println("\nLength:");
        System.out.println(length());


        // -----------------------------------------------------
        // MIDDLE
        // -----------------------------------------------------

        System.out.println("\nMiddle:");
        System.out.println(findMiddle());


        // -----------------------------------------------------
        // NTH FROM END
        // -----------------------------------------------------

        System.out.println("\n2nd node from end:");
        System.out.println(nthFromEnd(2));


        // -----------------------------------------------------
        // DELETE
        // -----------------------------------------------------

        deleteByValue(25);

        System.out.println("\nAfter deleting 25:");
        display();


        // -----------------------------------------------------
        // REVERSE
        // -----------------------------------------------------

        reverse();

        System.out.println("\nAfter reverse:");
        display();


        // -----------------------------------------------------
        // REVERSE BACK
        // -----------------------------------------------------

        head = reverseRecursive(head);

        System.out.println("\nAfter recursive reverse:");
        display();


        // -----------------------------------------------------
        // PALINDROME
        // -----------------------------------------------------

        head = createList(1, 2, 3, 2, 1);

        System.out.println("\nIs Palindrome:");
        System.out.println(isPalindrome());


        // -----------------------------------------------------
        // DUPLICATES
        // -----------------------------------------------------

        head = createList(1, 1, 2, 2, 3, 3);

        System.out.println("\nBefore removing duplicates:");
        display();

        removeDuplicates();

        System.out.println("After removing duplicates:");
        display();


        // -----------------------------------------------------
        // MERGE TWO SORTED LISTS
        // -----------------------------------------------------

        Node list1 = createList(1, 3, 5);
        Node list2 = createList(2, 4, 6);

        Node merged = merge(list1, list2);

        System.out.println("\nMerged List:");
        display(merged);


        // -----------------------------------------------------
        // CYCLE
        // -----------------------------------------------------

        head = createList(10, 20, 30, 40, 50);

        // Create cycle:
        // 50 -> 30
        Node current = head;

        Node cycleNode = null;

        while (current.next != null) {

            if (current.data == 30) {
                cycleNode = current;
            }

            current = current.next;
        }

        current.next = cycleNode;


        System.out.println("\nHas Cycle:");
        System.out.println(hasCycle());


        System.out.println("Cycle starts at:");
        Node start = cycleStart();

        if (start != null) {
            System.out.println(start.data);
        }


        // -----------------------------------------------------
        // REMOVE CYCLE
        // -----------------------------------------------------

        removeCycle();

        System.out.println("\nAfter removing cycle:");
        display();

        System.out.println("Has Cycle:");
        System.out.println(hasCycle());
    }
}