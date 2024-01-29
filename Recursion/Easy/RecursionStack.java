import java.util.Stack;

public class RecursionStack {
    public static void sortedInsert(Stack<Integer> stack, int num) {
		if(stack.isEmpty() || (!stack.isEmpty() && stack.peek() < num)) {
			stack.push(num);
			return;
		}

		int n = stack.peek();
		stack.pop();
		
		// recursive call
		sortedInsert(stack, num);

		stack.push(n);
	}
	public static void sortStack(Stack<Integer> stack) {
		// base case
		if(stack.isEmpty()) {
			return;
		}

		int num = stack.peek();
		stack.pop();

		// recursive call
		sortStack(stack);

		sortedInsert(stack, num);
	}

	// Reverse a stack
	public static void insertAtBottom(Stack<Integer> s, int x) {
		if(s.isEmpty()) {
			s.push(x);
			return;
		}	

		int num = s.peek();
		s.pop();

		insertAtBottom(s, x); 

		s.push(num);
	}
    
	public static void reverseStack(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}

		int num = stack.peek();
		stack.pop();

		reverseStack(stack); // recursive call

		insertAtBottom(stack, num);
	}
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(11);
        st.push(4);
        st.push(5);
        st.push(8);

        sortStack(st);
        System.out.println(st);

		reverseStack(st);
		System.out.println(st);
    }
}
