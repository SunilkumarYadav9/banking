import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author suneil.kumar
 *
 */
class TestingJava {

	public static void main(String[] args) {
		/*try {
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			String cardNumber = null;
			int startCharIndex = -1;
			int endCharIndex = -1;
			System.out.println("Please Enter  cardNumber in digit  ");
			cardNumber = input.readLine();
			System.out.println("Please Enter startCharIndex  ");
			startCharIndex = Integer.parseInt(input.readLine());
			System.out.println("Please Enter endCharIndex  ");
			endCharIndex = Integer.parseInt(input.readLine());
			String maskedCardNumber = new PaymentCardInfo().maskCCChars(cardNumber, startCharIndex, endCharIndex, false);
			System.out.println("cardNumber  " + maskedCardNumber);
		} catch (Exception exception) {
			System.out.println("Invalid String Exception  " + exception.getMessage());
		}*/
		
		try {
			new NumberToOrdinal().getNumberToOrdinal(new Integer("0"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");
	    String foo = " -22";
	    try {
			System.out.println(engine.eval(foo));
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
