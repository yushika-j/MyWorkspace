public class Spot {
	private Car car;
	private int timestamp;

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public int getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

	public Spot(Car car, int timestamp) {
		this.car = car;
		this.timestamp = timestamp;
	}

	/**
	 * Returns a string representation of the spot
	 */
	public String toString() {
		return car + ", timestamp: " + timestamp;
	}

}
