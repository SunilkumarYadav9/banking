
/**
 * @author suneil.kumar
 *
 */
public class NumberToOrdinal {
	private static final int MAX_ALLOWED_NUMBER = 1000;
	  private static final int MIN_ALLOWED_NUMBER = 0;

	public String getNumberToOrdinal(Integer number) {
		// return 0th for null,"" and 0
		if (null == number || number == 0) {
			return "0";
		}
		if (number > MAX_ALLOWED_NUMBER) {
			return "Integer value not allowed above "+ MAX_ALLOWED_NUMBER +".";
		}else if(number < MIN_ALLOWED_NUMBER){
          return "Integer value not allowed below "+ MIN_ALLOWED_NUMBER +".";
        }
		StringBuilder stringtoAppend = new StringBuilder(number.toString());
		Integer lastTwoDigits = number % 100;
		char lastChar = stringtoAppend.charAt(stringtoAppend.length() - 1);
		stringtoAppend.append(((lastTwoDigits >= 11 && lastTwoDigits <= 13) ? "th"
				: lastChar == '1' ? "st" : lastChar == '2' ? "nd" : lastChar == '3' ? "rd" : "th"));
        System.out.println("Ordinal No is " + stringtoAppend.toString());
		return stringtoAppend.toString();

	}
}
