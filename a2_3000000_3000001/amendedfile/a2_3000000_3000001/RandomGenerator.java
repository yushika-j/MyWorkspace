import java.util.Random;

/**
 * @author Mehrdad Sabetzadeh, University of Ottawa
 * 
 *         The implementation of this class is complete. You do *not* need to
 *         change this class in this assignment.
 * 
 */

public class RandomGenerator {

	/**
	 * Array of admissible characters in randomly generated strings (for car plates)
	 */
	private static final char[] ALPHANUM = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	/**
	 * Instance of Random class; all random quantities in this assignment will be
	 * generated through this single instance of Random
	 */
	private static Random rand = new Random();

	/**
	 * @param probability is the probability of the event of interest occurring
	 *                    within a SINGLE simulated time unit. The simulated time
	 *                    unit in this assignment is a second. For example, if this
	 *                    method is called with probability being 1/100, that means
	 *                    that the event of interest has a 1% probability of
	 *                    occurring in that second. This probability would translate
	 *                    to a (probabilistic) arrival rate of 3600 * 1% = 36 cars
	 *                    per hour.
	 * @return true if the event of interest occurred within the current single time
	 *         unit, false otherwise
	 */
	public static boolean eventOccurred(Rational probability) {
		if (probability.numerator() <= 0 || probability.denominator() < probability.numerator()) {
			return false;
		}

		int number = rand.nextInt(probability.denominator());

		if (number < probability.numerator())
			return true;

		return false;

	}

	/**
	 * @param length is the length of the random string to generate
	 * @return a random string with the specified length
	 */
	public static String generateRandomString(int length) {

		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < length; i++) {
			buffer.append(ALPHANUM[rand.nextInt(ALPHANUM.length)]);
		}

		return buffer.toString();
	}

	/**
	 * @return An instance of Car with the car type decided probabilistically,
	 *         according to predefined proportions
	 */
	public static Car generateRandomCar() {
		// Hard-coded:
		// ELECTRIC (prob: 5%),
		// SMALL (prob: 20%),
		// LARGE (prob: 10%),
		// REGULAR (default).

		CarType type;
		int number = rand.nextInt(100);

		if (number < 5)
			type = CarType.ELECTRIC;
		else if (number >= 5 && number < 25)
			type = CarType.SMALL;
		else if (number >= 25 && number < 35)
			type = CarType.LARGE;
		else
			type = CarType.REGULAR;

		return new Car(type, generateRandomString(3));
	}
}
