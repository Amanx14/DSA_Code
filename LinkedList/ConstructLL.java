class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Code {
    public static Node constructLL(int arr[]) {
        Node head = new Node(arr[0]);
        Node temp = head;

        for(int i=1; i<arr.length; i++) {
            Node currNode = new Node(arr[i]);
            temp.next = currNode;
            temp = temp.next;
        }

        return head;
    }

    public static void printLL(Node head) {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    } 
    public static void main(String args[]) {
        int arr[] = {1,12,3,4,5};
        
    }
}