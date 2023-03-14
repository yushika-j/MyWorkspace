/**
 * @author Mehrdad Sabetzadeh, University of Ottawa
 *
 */
public class Spot {
	private Car car;
	private int timestamp;

	public Car getCar() {

		// WRITE YOUR CODE HERE!
		return car;


	}

	public void setCar(Car car) {
	
		// WRITE YOUR CODE HERE!
		this.car = car;
	
	}

	public int getTimestamp() {
	
		// WRITE YOUR CODE HERE!
		return timestamp;
		

	}

	public void setTimestamp(int timestamp) {

		// WRITE YOUR CODE HERE!
		this.timestamp = timestamp;
		
	}

	public Spot(Car car, int timestamp) {

		// WRITE YOUR CODE HERE!
		this.car = car;
		this.timestamp = timestamp;
		
	}

	/**
	 * Returns a string representation of the spot
	 * This method is complete; you do not need to change it.
	 */
	public String toString() {
		return car + ", timestamp: " + timestamp;
	}
}
