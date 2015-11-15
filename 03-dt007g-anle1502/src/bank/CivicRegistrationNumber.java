package bank;

/** 
 * This class handles the validation of an Civic Registration Number.
 * 
 * @version 1.0
 * @author Andreas Lengqvist
 * Created 17:00, November 5, 2015.
 */
public class CivicRegistrationNumber {

	/*
	 * Method which transforms the input string to a Civic Registration Number.
	 * 
	 * @param input String - Input string to transform
	 */
	private static String stringToCrn(String input) {
		
		// RegEx that replaces everything that isn't a number with "".
		return input.replaceAll("[^0-9]+", "");
	}
	
	/*
	 * Method which transforms a string to an Array of integers.
	 * 
	 * @param crn String - String to transform
	 */
	private static int[] stringToArray(String crn) {
		
		// Define and initialize a array of integers with the length of the crn.
		int array[] = new int[crn.length()];
		
		// Basically divides the crn into digits and adds them to the array.
		for(int i = 0; i < crn.length(); i++) {
			array[i] = (new Integer("" + crn.charAt(i))).intValue();
		}
		
		return array;	
	}
	
	/*
	 * Validates a Civic Registration Number following the correct algorithm.
	 */
	public static String validate(String input) throws CivicRegistrationNumberException {
				
		String crn = stringToCrn(input);
		
		// Get the length of the crn.
		int crnLength = crn.length();

		// If the length is 10.
		if (crnLength != 10) {
			throw new CivicRegistrationNumberException("Personnumret "+ crn + " innehŒller inte 10 siffror!");
		} else {
			
			// Transform the crn to an Array.
			int[] crnArray = stringToArray(crn);

			int sum = 0;
			
			// For each digit in the crn.
			for(int i = 0; i < crnLength; i++) {

				// On every other digit (PŒ varannan siffra).
				if(i % 2 == 0) {
					
					// Multiple with 2.
					int digitSum = 2 * crnArray[i];

					// If the digitSum oversteps 10.
					if(digitSum >= 10) {
						
						// Decrement with 9.
						digitSum = digitSum - 9;
					}
					
					// Add the current digitSum to the total sum.
					sum = sum + digitSum;
				} else {
					
					// Add the current digitSum to the total sum.
					sum = sum + crnArray[i];
				}
			}
			
			// If modulus is not evenly with 10 otherwise CRN is valid, return it.
			if (sum % 10 != 0) {
				throw new CivicRegistrationNumberException(crn + " Šr ett ogiltigt personnummer!");
			} else {
				return crn;
			}
		}
	}
}