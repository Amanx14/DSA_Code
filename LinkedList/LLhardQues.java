class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LLhardQues {
    public static Node addLast(Node head, int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return head;
        }

        Node temp = head;

        while(temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        return head;
    }

    public static void print(Node head) {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
    }
    
    // Rotate right bruteForce
    public static Node rotateRight(Node head, int k) {
        if(head == null || head.next == null) {
            return head;
        }

        for(int i=0; i<k; i++) {
            Node temp = head;

            while(temp.next.next != null) {
                temp = temp.next; // isse temp 2nd last element pe aa jayega
            }

            Node end = temp.next; //end ko store kar rahe
            temp.next = null;

            end.next = head;
            head = end;
        }

        return head;
    }

    //optimized

    public Node rotateRightOptimized(Node head, int k) {
        if(head == null || head.next == null || k==0) {
            return head;
        }

        Node temp = head; // finding the length of the node
        int length = 1;

        while(temp.next != null) {
            length++;
            temp = temp.next;
        }

        // go till that node jisko null karna hai
        temp.next = head;
        k = k % length;
        k = length - k;

        while(k > 0) {
            k--;
            temp = temp.next;
        }

        //make the node head and break the connection 
        head = temp.next;
        temp.next = null;
        
        return head;
    }

    // reverse in K group
    public static int findLength(Node head) {
        Node temp = head;
        int size = 0;

        while(temp != null) {
            size++;
            temp = temp.next;
        }

        return size;
    }
    
    public static Node reverse(Node head, int k, int length) {

        if(head == null || head.next == null || k==1 || length < k) {
            return head;
        }

        // step 1 : reverse first K nodes
        Node prev = null;
        Node curr = head;
        Node next = null;
        int count = 0;

        while(curr != null && count < k) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
            count++;
        }
        
        // step 2 : recursion
        if(next != null) {
            head.next = reverse(next, k, length-k);
        }

        return prev;
    }
    
    public static Node reverseKGroup(Node head, int k) {
        int length = findLength(head);

        return reverse(head, k, length);
    } 

    // flatten a multilevel doubly linked list

    public Node flatten(Node head) {
        if(head == null) {
            return head;
        }

        Node ptr = head;

        while(ptr != null) {
            if(ptr.child == null) {
                ptr = ptr.next;
            }
            else {
                Node temp = ptr.child;

                while(temp.next != null) {
                    temp = temp.next;
                }

                temp.next = ptr.next;

                if(ptr.next != null) {
                    ptr.next.prev = temp;
                }

                ptr.next = ptr.child;
                ptr.child.prev = ptr;

                ptr.child = null;
            }
        }
        return head;
    }

    //copy list with random pointers

    public Node copyRandomList(Node head) {

        // Step 1 : sara copy node create kar lo
        Node itr = head;
        Node front = head;

        while(itr != null) {
            front = itr.next;

            Node copy = new Node(itr.val);

            itr.next = copy;
            copy.next = front;

            itr = front;
        }

        // Step : 2 random pointer ke liye
        itr = head;

        while(itr != null) {
            if(itr.random != null) {
                itr.next.random = itr.random.next;
            }
            itr = itr.next.next;
        } 

        // Step : 3 seperate karo copy list or original list ko

        itr = head;
        front = head;

        Node dummy = new Node(-1); // copy list ka head
        Node copy = dummy;

        while(itr != null) {
            front = itr.next.next;
            copy.next = itr.next;
            itr.next = front;

            copy = copy.next;
            itr = itr.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int k = 2;

        Node head = null;

        for(int i=0; i<arr.length; i++) {
            head = addLast(head, arr[i]);
        }

        Node newList = rotateRight(head, k);
        print(newList);

    }
}