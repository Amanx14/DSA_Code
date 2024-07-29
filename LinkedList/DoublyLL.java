class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLL {
    public static Node addFirst(Node head, int data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
            return head;
        }

        newNode.next = head;
        head.prev = newNode;

        head = newNode;
        return head;
    }

    public static Node insertLast(Node head, int data) {
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
        newNode.prev = temp;

        return head;
    }

    public static Node deleteLastNode(Node head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            head = null;
            return null;
        }

        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;

        return head;
    }

    public static Node deleteAtPos(Node head, int pos) {
        if(head == null || head.next == null) {
            return null;
        }

        if(pos==1) {
            head = head.next;
            return head;
        }

        Node temp = head;

        int i=1; // 1 2 3 4 5

        while(i < pos-1) {
            i++;
            temp = temp.next;
        }

        if(temp.next != null) {
            temp.next = temp.next.next;
        }

        return head;
    }

    public static Node reverseDLL(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;

        /*
         * swap next and prev for all nodes of
         * doubly linked list
         */
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;
        } 

        // Edge case if our linked list is empty Or list with only one node
        head = prev;
        return head;
    }

    public static void print(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.print("null");
    }


    
    public static Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }



    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        Node head = null;

        for (int i = 0; i < arr.length; i++) {
            head = insertLast(head, arr[i]);
        }

        print(head);System.out.println();

        Node newHead = reverseDLL(head);
        // deleteLastNode(head);
        print(newHead);

    }
}