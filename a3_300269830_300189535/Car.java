/**
 * @author Mehrdad Sabetzadeh, University of Ottawa
 * 
 *         The implementation of this class is complete. You do *not* need to
 *         change this class in this assignment.
 * 
 */
public class Car {

	/**
	 * Instance variable for storing the car plate number
	 */
	private String plateNum;

	/**
	 * @return the plate number
	 */
	public String getPlateNum() {
		return plateNum;
	}

	/**
	 * Sets the car plate number
	 * 
	 * @param plateNum is the car plate number
	 */
	public void setPlateNum(String plateNum) {
		this.plateNum = plateNum;
	}

	/**
	 * Constructor for Car
	 * 
	 * @param type     is the type of the car
	 * @param plateNum is the car plate number
	 */
	public Car(String plateNum) {
		this.plateNum = plateNum;
	}

	/**
	 * Returns a string representation of the car
	 */
	public String toString() {
		return "Plate:  " + plateNum;
	}
}