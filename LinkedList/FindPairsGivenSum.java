import java.util.ArrayList;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class FindPairsGivenSum {
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

    public static void print(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        while (head != null) {
            Node temp = head.next;
            while (temp != null) {
                ArrayList<Integer> list = new ArrayList<>();
                if (head.data + temp.data == target) {
                    list.add(head.data);
                    list.add(temp.data);
                    ans.add(list);
                }
                temp = temp.next;
            }
            head = head.next;
        }

        return ans;
    }

    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSumOptimized(int target, Node head) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        Node first = head;
        Node last = head;

        while(last.next != null) {
            last = last.next;
        }

        while(first != last && last.next != first) {
            ArrayList<Integer> list = new ArrayList<>();
            if(first.data + last.data == target) {
                list.add(first.data);
                list.add(last.data);
                ans.add(list);

                first = first.next;
                last = last.prev;
            }
            else if(first.data + last.data > target) {
                last = last.prev;
            }
            else {
                first = first.next;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        int k = 6;

        Node head = null;

        for (int i = 0; i < arr.length; i++) {
            head = addLast(head, arr[i]);
        }

        ArrayList<ArrayList<Integer>> ans = findPairsWithGivenSum(k, head);

        System.out.println(ans);

    }
}