class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLL {
    public static Node addFirst(Node head, int data) {
        Node newNode = new Node(data); // dabba

        if (head == null) {
            head = newNode;
            return head;
        }

        newNode.next = head;
        head = newNode;

        return head;
    }

    public static Node addLast(Node head, int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return head;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        return head;
    }

    public static void printLL(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static Node deleteLast(Node head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            head = null;
            return head;
        }

        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
        return head;
    }

    public static void deleteNode(Node node) { // node is given to delete head ka access nai hai
        // 1 2 3 4
        Node nextNode = node.next;
        node.val = nextNode.val;

        node.next = nextNode.next;
        nextNode.next = null;
    }

    public static int searchInLinkedList(Node head, int target) {
        Node temp = head;
        int idx = 0;

        while (temp != null) {
            if (temp.data == target) {
                return idx;
            }
            idx++;
            temp = temp.next;
        }

        return -1;
    }

    public static Node reverseList(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseList(head.next);

        Node temp = head.next;
        temp.next = head;
        head.next = null;

        return newHead;
    }

    public static Node removeNthFromEnd(Node head, int n) {
        Node dummy = new Node(-1);
        dummy.next = head;

        Node fast = dummy;
        Node slow = dummy;

        for(int i=1; i<=n; i++) {
            fast = fast.next;
        }

        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }

    public static ListNode deleteMiddle(ListNode head) {
        ListNode temp = head;
        int size = 0;

        while(temp != null) {
            size++;
            temp= temp.next;
        }

        if(size == 1) {
            return null;
        }

        temp = head;
        int idx = 0;

        while(idx < (size/2)-1) {
            temp = temp.next;
            idx++;
        }

        temp.next = temp.next.next;
        return head;

    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5 };

        Node head = null;
        for (int i : arr) {
            head = addLast(head, i);
        }

        // printLL(head);
        // System.out.println();
        // deleteLast(head);
        // printLL(head);

        System.out.println(searchInLinkedList(head, 3));
    }
}