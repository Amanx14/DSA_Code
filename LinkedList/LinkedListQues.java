import java.lang.classfile.components.ClassPrinter.ListNode;

class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListQues {
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
        return head;
    }

    public static void print(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while(curr != null) {
            Node next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        head = prev;
        return head;
    }

    public static boolean isPalindrome(Node head) {
        if(head == null || head.next == null) {
            return true;
        }

        Node middle = findMiddle(head);
        Node newHead = reverse(middle);
        
        Node temp1 = head , temp2 = newHead;
        while(temp2 != null) {
            if(temp1.data != temp2.data) {
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return true;
    }

    public static Node getIntersectionNode(Node headA, Node headB) { // alag se hoga
        
        while(headB != null) {
            Node temp = headA;
            while(temp != null) {
                if(temp == headB) {
                    return headB;
                }

                temp = temp.next;
            }
            headB = headB.next;
        }

        return null;
    }

    // optimized intersection
    public int findLength(Node head) {
        Node temp = head;
        int size = 0;

        while(temp != null) {
            size++;
            temp = temp.next;
        }

        return size;
    }
    
    public Node getIntersectionNode2(Node headA, Node headB) {
        int lengthA = findLength(headA);
        int lengthB = findLength(headB);

        while(lengthA > lengthB) {
            headA = headA.next;
            lengthA--;
        }

        while(lengthB > lengthA) {
            headB = headB.next;
            lengthB--;
        }

        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    // sort LL (merge sort)

    public static Node findMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    
    public static Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while(head1 != null && head2 != null) {
            if(head1.data <= head2.data) {
                temp.next = head1;

                head1 = head1.next;
                temp = temp.next;
            }
            else {
                temp.next = head2;

                head2 = head2.next;
                temp = temp.next;
            }
        }

        while(head1 != null) {
            temp.next = head1;

            head1 = head1.next;
            temp = temp.next;
        }

        while(head2 != null) {
            temp.next = head2;

            head2 = head2.next;
            temp = temp.next;
        }


        return mergedLL.next;
    }

    public static Node mergeSort(Node head){
        if(head == null) {
            return null;
        }

        if(head.next == null) {
            return head;
        }

        Node mid = findMid(head);
        Node right = mid.next;
        mid.next = null;

        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(right);

        return merge(newLeft, newRight);
    }

    public static Node sortList(Node head) {
        return mergeSort(head);    
    }

    // even odd linked list
    public static Node oddEvenList(Node head) {
        if(head == null) {
            return null;
        }

        Node odd = head;
        Node even = head.next;

        Node evenHead = even;

        while(even != null && even.next != null) {
            odd.next = odd.next.next; // linking to next element
            even.next = even.next.next;

            odd = odd.next; // update
            even = even.next; 
        }

        odd.next = evenHead;
        return head;
    }

    //sort 0 1 2 in linked list

    public static Node sort012List(Node head) {
        int count0 = 0, count1 = 0, count2 = 0;

        Node temp = head;

        while(temp != null) {
            if(temp.data == 0) {
                count0++;
            }
            else if(temp.data == 1) {
                count1++;
            }
            else {
                count2++;
            }
            temp = temp.next;
        }

        Node dummy = new Node(-1);
        Node ptr = dummy;

        while(count0 > 0) {
            Node newNode = new Node(0);
            ptr.next = newNode;

            ptr = ptr.next;
            count0--;
        }

        while(count1 > 0) {
            Node newNode = new Node(1);
            ptr.next = newNode;

            ptr = ptr.next;
            count1--;
        }

        while(count2 > 0) {
            Node newNode = new Node(2);
            ptr.next = newNode;

            ptr = ptr.next;
            count2--;
        }

        return dummy.next;
    }

    public static Node sortZeroOneTwoList(Node head)
    {
        Node ptr = head;
        int[] cnt = new int[3];

        // Iterate while ptr is not empty
        while(ptr != null)
        {
            cnt[ptr.data]++;
            ptr = ptr.next;
        }

        ptr = head;
        int i = 0;

        // Updating data.
        while(ptr != null)
        {
            while(cnt[i] == 0)
            {
                i++;
            }

            ptr.data = i;
            cnt[i]--;
            ptr = ptr.next;
        }

        // Return head
        return head;
    }

    // insert GCD between two nodes
    public static int calcGCD(int n1, int n2) {
        int gcd = 0;
        for(int i=1; i<=Math.min(n1, n2); i++) {
            if(n1 % i == 0 && n2 % i == 0) {
                gcd = i; 
            }
        }

        return gcd;
    }
    
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next == null) {
            return head;
        }

        ListNode head1 = head;
        ListNode head2 = head.next;

        while(head2 != null) {
            int GCD = calcGCD(head1.val, head2.val);
            ListNode newNode = new ListNode(GCD);

            newNode.next = head2;
            head1.next = newNode;

            head1 = head2;
            head2 = head2.next;
        }

        return head;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 2, 1 };
        Node head = null;

        for (int i = 0; i < arr.length; i++) {
            head = insertLast(head, arr[i]);
        }

        // print(head); System.out.println();
        // System.out.println(isPalindrome(head));
        sortList(head);
        print(head);

    }
}