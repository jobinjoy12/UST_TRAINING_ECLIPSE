// ==========================================
// 1. THE NODE CLASS (Required for all)
// ==========================================
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// ==========================================
// 2. INSERTION OPERATIONS
// ==========================================

// Insert at Beginning (Head) - O(1)
public Node insertAtHead(Node head, int data) {
    Node newNode = new Node(data);
    newNode.next = head;
    return newNode; // New head
}

// Insert at End (Tail) - O(n)
public Node insertAtEnd(Node head, int data) {
    Node newNode = new Node(data);
    
    if (head == null) {
        return newNode;
    }

    Node temp = head;
    while (temp.next != null) {
        temp = temp.next;
    }
    temp.next = newNode;
    return head;
}

// Insert at N-th Position - O(n)
// (Assumes 1-based indexing)
public Node insertAtPosition(Node head, int data, int n) {
    if (n == 1) {
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode;
    }

    Node temp = head;
    // Stop at node n-1
    for (int i = 1; i < n - 1 && temp != null; i++) {
        temp = temp.next;
    }

    if (temp != null) {
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }
    return head;
}

// ==========================================
// 3. DELETION OPERATIONS
// ==========================================

// Delete at Beginning - O(1)
public Node deleteAtHead(Node head) {
    if (head == null) return null;
    return head.next;
}

// Delete at End - O(n)
public Node deleteAtEnd(Node head) {
    if (head == null) return null;
    if (head.next == null) return null;

    Node temp = head;
    // Stop at second to last node
    while (temp.next.next != null) {
        temp = temp.next;
    }
    temp.next = null;
    return head;
}

// Delete at N-th Position - O(n)
public Node deleteAtPosition(Node head, int n) {
    if (head == null) return null;
    if (n == 1) return head.next;

    Node temp = head;
    // Stop at node n-1
    for (int i = 1; i < n - 1 && temp != null; i++) {
        temp = temp.next;
    }

    if (temp != null && temp.next != null) {
        temp.next = temp.next.next;
    }
    return head;
}

// ==========================================
// 4. ESSENTIAL ALGORITHMS (Must Know)
// ==========================================

// Reverse a Linked List
public Node reverseList(Node head) {
    Node prev = null;
    Node current = head;
    Node next = null;

    while (current != null) {
        next = current.next; // Save next
        current.next = prev; // Reverse pointer
        prev = current;      // Move prev
        current = next;      // Move current
    }
    return prev; // New Head
}

// Find Middle Node (Tortoise and Hare)
public Node findMiddle(Node head) {
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;       // 1 step
        fast = fast.next.next;  // 2 steps
    }
    return slow;
}

// Detect Cycle (Loop)
public boolean hasCycle(Node head) {
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) return true;
    }
    return false;
}