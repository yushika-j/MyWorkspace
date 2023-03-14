/**
 * This is a utility class to simplify the implementation of A1. You are NOT
 * supposed to change the Util class. You are nevertheless encouraged to study
 * the methods in this class for practice.
 * 
 * @author Mehrdad Sabetzadeh, University of Ottawa
 */
public class Util {

	public static CarType getCarTypeByLabel(String label) {

		if (label.equals("E"))
			return CarType.ELECTRIC;

		else if (label.equals("S"))
			return CarType.SMALL;

		else if (label.equals("R"))
			return CarType.REGULAR;

		else if (label.equals("L"))
			return CarType.LARGE;

		else
			return CarType.NA;
	}

	public static String getLabelByCarType(CarType type) {

		if (type == CarType.ELECTRIC)
			return "E";

		else if (type == CarType.SMALL)
			return "S";

		else if (type == CarType.REGULAR)
			return "R";

		else if (type == CarType.LARGE)
			return "L";

		else
			return "N";
	}
}