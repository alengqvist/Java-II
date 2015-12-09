package bank;

/** 
 * This class handles the validation of an Postal code.
 * 
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 17:00, November 5, 2015.
 */
public class PostalCode {

	/*
	 * Method which transforms the input string to a Postal Code.
	 * 
	 * @param input String - Input string to transform
	 */
	private static String stringToPostalCode(String input) {
		
		// RegEx that replaces everything that isn't a Postal Code with "".
		return input.replaceAll("[^0-9]+", "");
	}
	
	/*
	 * Validates a Civic Registration Number following the correct algorithm.
	 * 
	 * @param input
	 * @return postalCode
	 */
	public static String validate(String input) throws PostalCodeException {
		
		String postalCode = stringToPostalCode(input);
		int length = postalCode.length();
		
		if (length > 5) {
			throw new PostalCodeException("Postnumret är för långt!");
		}
		else if (length < 5) {
			throw new PostalCodeException("Postnumret är för kort!");
		} else {
			return postalCode;
		}
	}
}