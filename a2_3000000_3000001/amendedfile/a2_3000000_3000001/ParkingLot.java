import java.io.File;
//import java.sql.Time;
import java.util.Scanner;

/**
 * @author Mehrdad Sabetzadeh, University of Ottawa
 */
public class ParkingLot {
	/**
	 * The delimiter that separates values
	 */
	private static final String SEPARATOR = ",";

	private static final String SECTIONER = "###";

	/**
	 * Instance variable for storing the number of rows in a parking lot
	 */
	private int numRows;

	/**
	 * Instance variable for storing the number of spaces per row in a parking lot
	 */
	private int numSpotsPerRow;

	/**
	 * Instance variable (two-dimensional array) for storing the lot design
	 */
	private CarType[][] lotDesign;

	/**
	 * Instance variable (two-dimensional array) for storing occupancy information
	 * for the spots in the lot
	 */
	private Spot[][] occupancy;

	/**
	 * Constructs a parking lot by loading a file
	 * 
	 * @param strFilename is the name of the file
	 */
	public ParkingLot(String strFilename) throws Exception {

		// WRITE YOUR CODE HERE!
		if (strFilename == null) {
			System.out.println("File name cannot be null.");
			return;
		}

		// determine numRows and numSpotsPerRow
		calculateLotDimensions(strFilename);

		lotDesign = new CarType[numRows][numSpotsPerRow];

		occupancy = new Spot[numRows][numSpotsPerRow];

		populateDesignFromFile(strFilename);
	}

	public int getNumRows() {
		return numRows;
	}

	public int getNumSpotsPerRow() {
		return numSpotsPerRow;
	}

	/**
	 * Parks a car (c) at a given location (i, j) within the parking lot.
	 * 
	 * @param i         is the parking row index
	 * @param j         is the index of the spot within row i
	 * @param c         is the car to be parked
	 * @param timestamp is the (simulated) time when the car gets parked in the lot
	 */
	public void park(int i, int j, Car c, int timestamp) {

		// WRITE YOUR CODE HERE!		
		if (!canParkAt(i, j, c)) {
			System.out.println("Car " + c + " cannot be parked at (" + i + "," + j + ")");
		}else{
			occupancy[i][j].setCar(c);
		}
		
	}

	/**
	 * Removes the car parked at a given location (i, j) in the parking lot
	 * 
	 * @param i is the parking row index
	 * @param j is the index of the spot within row i
	 * @return the spot removed; the method returns null when either i or j are out
	 *         of range, or when there is no car parked at (i, j)
	 */
	public Spot remove(int i, int j) {

		// WRITE YOUR CODE HERE!
		if (i >= numRows || j >= numSpotsPerRow) {
			System.out.println("Out of range index error.");
			return null;
		}

		Spot c = occupancy[i][j];
		occupancy[i][j] = null;

		return c;

	}

	/**
	 * Returns the spot instance at a given position (i, j)
	 * 
	 * @param i is the parking row index
	 * @param j is the index of the spot within row i
	 * @return the spot instance at position (i, j)
	 */
	public Spot getSpotAt(int i, int j) {

		// WRITE YOUR CODE HERE!
		
			return occupancy[i][j];
		
	}

	/**
	 * Checks whether a car (which has a certain type) is allowed to park at
	 * location (i, j)
	 *
	 * NOTE: This method is complete; you do not need to change it.
	 * 
	 * @param i is the parking row index
	 * @param j is the index of the spot within row i
	 * @return true if car c can park at (i, j) and false otherwise
	 */
	public boolean canParkAt(int i, int j, Car c) {

		// WRITE YOUR CODE HERE!
		if (i >= numRows || j >= numSpotsPerRow) {
			return false;
		}

		if (occupancy[i][j] != null) {
			return false;
		}

		CarType carType = c.getType();
		CarType spotType = lotDesign[i][j];

		if (carType == CarType.ELECTRIC) {
			return (spotType == CarType.ELECTRIC) || (spotType == CarType.SMALL) || (spotType == CarType.REGULAR)
					|| (spotType == CarType.LARGE);

		} else if (carType == CarType.SMALL) {
			return (spotType == CarType.SMALL) || (spotType == CarType.REGULAR) || (spotType == CarType.LARGE);

		} else if (carType == CarType.REGULAR) {
			return (spotType == CarType.REGULAR) || (spotType == CarType.LARGE);
		} else if (carType == CarType.LARGE) {
			return (spotType == CarType.LARGE);
		}

		return false;
		
	}

	/**
	 * Attempts to park a car in the lot. Parking is successful if a suitable parking spot
	 * is available in the lot. If some suitable spot is found (anywhere in the lot), the car
	 * is parked at that spot with the indicated timestamp and the method returns "true".
	 * If no suitable spot is found, no parking action is taken and the method simply returns
	 * "false"
	 * 
	 * @param c is the car to be parked
	 * @param timestamp is the simulation time at which parking is attempted for car c 
	 * @return true if c is successfully parked somwhere in the lot, and false otherwise
	 */
	public boolean attemptParking(Car c, int timestamp) {

		// WRITE YOUR CODE HERE!
		

		for ( int i = 0; i < numRows; i++) {
			for (int j = 0; j < numSpotsPerRow; j++) {
				if (lotDesign[i][j].equals(c.getType())) {
					if (occupancy[i][j] != null){
						park(i,j,c,timestamp);
						return true;
					}
				}
			}
		}
		//double check this function idk if it's correct...
		return false;

	}

	/**
	 * @return the total capacity of the parking lot excluding spots that cannot be
	 *         used for parking (i.e., excluding spots that point to CarType.NA)
	 */
	public int getTotalCapacity() {

		// WRITE YOUR CODE HERE!
			int count = 0;
	
			for (int i = 0; i < numRows; i++)
				for (int j = 0; j < numSpotsPerRow; j++)
					if (lotDesign[i][j] != CarType.NA)
						count++;
	
			return count;
	
	}

	/**
	 * @return the total occupancy of the parking lot
	 */
	public int getTotalOccupancy() {

		// WRITE YOUR CODE HERE!
		int count = 0;

		for (int i = 0; i < numRows; i++)
			for (int j = 0; j < numSpotsPerRow; j++)
				if (occupancy[i][j] != null)
					count++;

		return count;
		

	}

	private void calculateLotDimensions(String strFilename) throws Exception {

		// WRITE YOUR CODE HERE!
		Scanner scanner = new Scanner(new File(strFilename));

		while (scanner.hasNext()) {
			String str = scanner.nextLine().trim();

			if (str.isEmpty()) {
				// Do nothing
			} else if (str.equals(SECTIONER)) {
				break;
			} else {
				numRows++;
				String[] tokens = str.split(SEPARATOR);
				numSpotsPerRow = Integer.max(tokens.length, numSpotsPerRow);
			}
		}

		scanner.close();
	}

	private void populateDesignFromFile(String strFilename) throws Exception {

		// WRITE YOUR CODE HERE!
		Scanner scanner = new Scanner(new File(strFilename));

		int lineCount = 0;

		int rowNumber = 0;
		// while loop for reading the lot design
		while (scanner.hasNext()) {
			String str = scanner.nextLine().trim();
			lineCount++;

			if (str.isEmpty()) {
				// Do nothing
			} else if (str.equals(SECTIONER)) {
				break;
			} else {
				String[] tokens = str.split(",");
				for (int i = 0; i < tokens.length; i++)
					lotDesign[rowNumber][i] = Util.getCarTypeByLabel(tokens[i].trim());
				rowNumber++;
			}
		}

		rowNumber = 0;
		// while loop for reading occupancy data
		while (scanner.hasNext()) {
			String str = scanner.nextLine().trim();
			lineCount++;

			if (str.isEmpty()) {
				// Do nothing
			} else {
				String[] tokens = str.split(SEPARATOR);
				if (tokens.length != 4 || !tokens[0].trim().matches("\\d+") || !tokens[1].trim().matches("\\d+")) {
					System.out.println("Skipped line " + lineCount + " due to an error.");
					continue;
				}

				int i = Integer.parseInt(tokens[0].trim());
				int j = Integer.parseInt(tokens[1].trim());

				if (Util.getCarTypeByLabel(tokens[2].trim()) == CarType.NA) {
					System.out.println("Skipped line " + lineCount + " due to an error.");
					continue;
				}

				Car c = new Car(Util.getCarTypeByLabel(tokens[2].trim()), tokens[3].trim()); 
				//########
				Spot cSpot = new Spot(c, 0);
				this.park(i, j, c, cSpot.getTimestamp());
				//########
				rowNumber++;
			}
		}

		scanner.close();
	
	}

	/**
	 * NOTE: This method is complete; you do not need to change it.
	 * @return String containing the parking lot information
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("==== Lot Design ====").append(System.lineSeparator());

		for (int i = 0; i < lotDesign.length; i++) {
			for (int j = 0; j < lotDesign[0].length; j++) {
				buffer.append((lotDesign[i][j] != null) ? Util.getLabelByCarType(lotDesign[i][j])
						: Util.getLabelByCarType(CarType.NA));
				if (j < numSpotsPerRow - 1) {
					buffer.append(", ");
				}
			}
			buffer.append(System.lineSeparator());
		}

		buffer.append(System.lineSeparator()).append("==== Parking Occupancy ====").append(System.lineSeparator());

		for (int i = 0; i < occupancy.length; i++) {
			for (int j = 0; j < occupancy[0].length; j++) {
				buffer.append(
						"(" + i + ", " + j + "): " + ((occupancy[i][j] != null) ? occupancy[i][j] : "Unoccupied"));
				buffer.append(System.lineSeparator());
			}

		}
		return buffer.toString();
	}
}