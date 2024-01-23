package timeTest;
import java.util.Stack;
public class StackExercise {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		
		stack.push(5);
		stack.push(10);
		stack.push(15);
		System.out.println("Peek:" + stack.peek());
		stack.pop();
		stack.push(20);
		stack.push(25);
		System.out.println("pop: " + stack.pop());
		stack.push(30);
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

}
