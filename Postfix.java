import java.util.ArrayList;
import java.util.Stack;

public class Postfix {
	private Stack<String> stack;
	private String expression;
	private ArrayList<Character> operators;
	private double temp;
	
	
	public Postfix() {
		stack = new Stack<String>();
		expression = "5 5 + 2 * 4 / 9 +";
		operators = new ArrayList<Character>();
		operators.add('+');
		operators.add('-');
		operators.add('*');
		operators.add('/');
	}
	
	public void solvePostfix() {
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == ' ') {
				// do nothing
			}
			else if (operators.contains(expression.charAt(i))) { // if the current char is an operator
				switch (expression.charAt(i)) {
				case '+':
					temp = Double.parseDouble(stack.pop()) + Double.parseDouble(stack.pop());
					break;
				case '-':
					double temp1 = Double.parseDouble(stack.pop());
					double temp2 = Double.parseDouble(stack.pop());
					temp = temp2 - temp1;
					break;
				case '*':
					temp = Double.parseDouble(stack.pop()) * Double.parseDouble(stack.pop());
					break;
				case '/':
					double temp3 = Double.parseDouble(stack.pop());
					double temp4 = Double.parseDouble(stack.pop());
					temp = temp4 / temp3;
					break;
				}
				
				stack.push(String.valueOf(temp)); // push computed number onto stack
			}
			else {
				stack.push(Character.toString(expression.charAt(i))); // push the number in the expression onto the stack
			}
		}
		System.out.println(stack.peek());
	}
}
