import java.util.regex.Pattern;
class CreditCard {
 	private static final int MAX_ALLOWED_CARD_LENGTH = 32;
	private static final int MIN_ALLOWED_CARD_LENGTH = 6;
	private static final int lAST_FOUR_DIGIT_TO_MASK = 4;

	public static String maskify(String creditCardNumber) {
		String charsToBeMaskedtrimmed = creditCardNumber.trim();
		// Validated Card detail before masking		
		isCardDetailsValid(charsToBeMaskedtrimmed);
		String maskedString = getMaskedChars(charsToBeMaskedtrimmed);
		System.out.println("Masked String " + maskedString);
		return maskedString;
	}
		// Validate card before masking
	private static  String isCardDetailsValid(final String charsToBeMasked) {
		if (null == charsToBeMasked || charsToBeMasked.length() == 0) {
			throw new NullPointerException("Input Card Number is Null or Empty");
		}
		String ignoreHyphen = charsToBeMasked.replaceAll("[- ]+", "");
		//Validate onlyString in Card
		Pattern isAlphabetPattern = Pattern.compile("[a-zA-Z]+");
		if (isAlphabetPattern.matcher(ignoreHyphen).matches()) {
           System.out.println("Non Masked String " + charsToBeMasked.toString());
			return charsToBeMasked.toString();
		}
		//Validate Min card length
		if (ignoreHyphen.length() <= MIN_ALLOWED_CARD_LENGTH) {
          System.out.println("Non Masked String " + charsToBeMasked.toString());
			return charsToBeMasked.toString();
		}
		if (charsToBeMasked.length() > MAX_ALLOWED_CARD_LENGTH) {
			throw new StringIndexOutOfBoundsException("Invalid Card digit length 32 or less digit required");
		}
		return charsToBeMasked.toString();
	}

	// Masking String
  private static String getMaskedChars(final String charsToBeMasked) {
	if (charsToBeMasked != null && charsToBeMasked.length() > lAST_FOUR_DIGIT_TO_MASK) {
			final String endPortion = charsToBeMasked.substring(charsToBeMasked.length() - lAST_FOUR_DIGIT_TO_MASK);
			StringBuilder maskedString = new StringBuilder();
			char[] maskingArray = charsToBeMasked.toCharArray();
			for (int i = 0; i < maskingArray.length - endPortion.length(); i++) {
				if (i == 0) {
					maskedString.append(maskingArray[i]);
				} else if (maskingArray[i] == '-') {//skip for hyphen
					maskedString.append(maskingArray[i]);
                  //check for digit and append masked char
				} else if (Character.isDigit(maskingArray[i])) {                   
					maskedString.append("#");
				}else{
					maskedString.append(maskingArray[i]);
				}
			}
			return maskedString.append(endPortion).toString();
		}
		return charsToBeMasked;
	}
}