import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author suneil.kumar Method evaluateExp know how to evaluate the input
 *         expression and will return the result of the calculation
 *  Input "1 1 1 * -" / Output 
 */

public class EvaluateExpresion {
	// evaluate expression
	public double evaluateExp(String expression) throws Exception {
		if (null == expression || "".equals(expression)) {
			return 0.0;
		}
		char[] expressionTokens = expression.toCharArray();
		Stack<Double> stackOperands = new Stack<>();
		for (int location = 0; location < expressionTokens.length; location++) {
			// skip space in array
			if (expressionTokens[location] == ' ') {
				continue;
			}
			if (Character.isDigit(expressionTokens[location])) {
				// System.out.println( "Start pusing operandStack " +
				// expressionTokens[location] + " at location " + location);
				StringBuffer currentDigit = new StringBuffer();
				// check for more than one digit numbers
				while (location < expressionTokens.length
						&& (Character.isDigit(expressionTokens[location]) || expressionTokens[location] == '.')) {
					currentDigit.append(expressionTokens[location++]);
				}
				stackOperands.push(Double.parseDouble((currentDigit.toString())));
				System.out.println("Pushed Element in stack is " + stackOperands.peek() + " at top ");

			} else if (isAllowedOperators(expressionTokens[location])) {
				try {
					// push operator in stackOperators ,//Exception if
					// invalid expression e.g *34
					if (location == 0 && !allowedSignedUnsigned(expressionTokens[location])) {
					}
					stackOperands.push(
							calculateExpression(expressionTokens[location], stackOperands.pop(), stackOperands.pop()));
				} catch (EmptyStackException emptyStackException) {
					System.out.println("Exception during push of operator");
					throw emptyStackException;
				}
			}

		}
		// final value after calculation at the top of stack returned
		if (!stackOperands.isEmpty()) {
			System.out.println("Final Expresssion at top " + stackOperands.peek());
			return stackOperands.pop();
		}
		return 0.0;
	}

	/**
	 * @param location
	 * @return true this method is used for +/- identification
	 */
	private Boolean allowedSignedUnsigned(char expressionTokens) {
		if (expressionTokens == '+' || expressionTokens == '-') {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

	/**
	 * @param location
	 * @return true if valid operator for the functio his method is used for
	 *         +/-/* identificationn
	 */
	private Boolean isAllowedOperators(char expressionTokens) {
		if (allowedSignedUnsigned(expressionTokens) || expressionTokens == '*' || expressionTokens == '/'
				|| expressionTokens == ',') {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	/**
	 * @param operator
	 * @param firstOperator
	 * @param secondOperator
	 * @return calculated result for the expression
	 */
	public double calculateExpression(char operator, double secondOperator, double firstOperator) {
		switch (operator) {
		case '+':
			return firstOperator + secondOperator;
		case '-':
			return firstOperator - secondOperator;
		case '*':
			return firstOperator * secondOperator;
		case '/':
			if (firstOperator == 0) {
				throw new UnsupportedOperationException("Cannot divide by zero");
			}
			return firstOperator / secondOperator;
		default:
			break;
		}
		return 0.0;
	}
}
