import java.util.regex.Pattern;

/**
 * @author suneil.kumar
 *
 */

public class PaymentCardInfo {
	private static final int MAX_ALLOWED_CARD_LENGTH = 50;// Can be configurable
	public  String maskCCChars(final String charsToBeMasked, int startChar, int lastChars,
			boolean inputTypeValidation) throws Exception {
		String charsToBeMaskedtrimmed = charsToBeMasked.trim();
		// Validated Card detail before masking
		isCardDetailsValid(charsToBeMasked,+ startChar, lastChars, inputTypeValidation);
		if (startChar < 0 || lastChars <0) {
			startChar = 0;
			lastChars = 0;
		}
		int maskedDigitLength = lastChars - startChar;
		StringBuilder maskedString = null;
		String startPortion = null;
		String endPortion = null;
		if (maskedDigitLength > 0) {//sun444
			startPortion = charsToBeMaskedtrimmed.substring(0, startChar);// (charsToBeMasked.length()
			endPortion = maskedDigitLength==1 ? charsToBeMaskedtrimmed.substring(startPortion.length()+2): 
				charsToBeMaskedtrimmed.substring(startPortion.length()+maskedDigitLength);
			maskedString = new StringBuilder(startPortion);
			for (int i = 0; i < maskedDigitLength; i++) {
				maskedString.append("*");
			}
			return maskedString.append(endPortion).toString();
		}else{
			startPortion = charsToBeMaskedtrimmed.substring(0, startChar);
			endPortion = maskedDigitLength==0 ? charsToBeMaskedtrimmed.substring(startPortion.length()+1): charsToBeMaskedtrimmed.substring((charsToBeMasked.length() - lastChars)+ (++startChar));
			return  new StringBuilder(startPortion).append("*"+endPortion).toString();
		}
	}

	private static void isCardDetailsValid(final String charsToBeMasked, final int startChars,
			int lastChars, boolean inputTypeValidation) throws Exception {
		if (null == charsToBeMasked || charsToBeMasked.length() == 0) {
			throw new Exception("Input Card Number is Null or Empty");
		}
		if (startChars > lastChars) {
			throw new Exception("Start Index Can not greater than endIndex");
		}
		if (charsToBeMasked.length() < lastChars) {
			throw new Exception("End Char Index Exceed the String Length");
		}
		if (charsToBeMasked.length() >= MAX_ALLOWED_CARD_LENGTH) {
			throw new IndexOutOfBoundsException("Invalid Card digit length 16 or less digit allowed");
		}
		if (inputTypeValidation) {
			Pattern isNumberType = Pattern.compile("[0-9]+");
			Pattern isStringType = Pattern.compile("[a-zA-Z]+");
			if (!isNumberType.matcher(charsToBeMasked).matches()) {
				throw new Exception("Only Numeric digits Allowed" + isNumberType);
			}
			if (!isStringType.matcher(charsToBeMasked).matches()) {
				throw new Exception("Only Alphabet  Allowed" + isStringType);
			}

		}

	}

}
