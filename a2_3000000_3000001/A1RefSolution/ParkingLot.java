import java.io.File;
import java.util.Scanner;

/**
 * @author Mehrdad Sabetzadeh, University of Ottawa
 */
public class ParkingLot {
	/**
	 * The delimiter that separates values
	 */
	private static final String SEPARATOR = ",";

	/**
	 * The delimiter that separates the parking lot design section from the parked
	 * car data section
	 */
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
	private Car[][] occupancy;

	/**
	 * Constructs a parking lot by loading a file
	 * 
	 * @param strFilename is the name of the file
	 */
	public ParkingLot(String strFilename) throws Exception {

		if (strFilename == null) {
			System.out.println("File name cannot be null.");
			return;
		}

		// determine numRows and numSpotsPerRow
		calculateLotDimensions(strFilename);

		lotDesign = new CarType[numRows][numSpotsPerRow];

		occupancy = new Car[numRows][numSpotsPerRow];

		populateFromFile(strFilename);
	}

	/**
	 * Parks a car (c) at a give location (i, j) within the parking lot.
	 * 
	 * @param i is the parking row index
	 * @param j is the index of the spot within row i
	 * @param c is the car to be parked
	 */
	public void park(int i, int j, Car c) {
		if (!canParkAt(i, j, c)) {
			System.out.println("Car " + c + " cannot be parked at (" + i + "," + j + ")");
			return;
		}

		occupancy[i][j] = c;
	}

	/**
	 * Removes the car parked at a given location (i, j) in the parking lot
	 * 
	 * @param i is the parking row index
	 * @param j is the index of the spot within row i
	 * @return the car removed; the method returns null when either i or j are out
	 *         of range, or when there is no car parked at (i, j)
	 */
	public Car remove(int i, int j) {

		if (i >= numRows || j >= numSpotsPerRow) {
			System.out.println("Out of range index error.");
			return null;
		}

		Car c = occupancy[i][j];
		occupancy[i][j] = null;

		return c;

	}

	/**
	 * Checks whether a car (which has a certain type) is allowed to park at
	 * location (i, j)
	 * 
	 * @param i is the parking row index
	 * @param j is the index of the spot within row i
	 * @return true if car c can park at (i, j) and false otherwise
	 */
	public boolean canParkAt(int i, int j, Car c) {

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
	 * @return the total capacity of the parking lot excluding spots that cannot be
	 *         used for parking (i.e., excluding spots that point to CarType.NA)
	 */
	public int getTotalCapacity() {
		int count = 0;

		for (int i = 0; i < numRows; i++)
			for (int j = 0; j < numSpotsPerRow; j++)
				if (lotDesign[i][j] != CarType.NA)
					count++;

		return count;
	}

	/**
	 * @return the total occupancy of the parking lot (i.e., the total number of
	 *         cars parked in the lot)
	 */
	public int getTotalOccupancy() {
		int count = 0;

		for (int i = 0; i < numRows; i++)
			for (int j = 0; j < numSpotsPerRow; j++)
				if (occupancy[i][j] != null)
					count++;

		return count;
	}

	private void calculateLotDimensions(String strFilename) throws Exception {

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

	private void populateFromFile(String strFilename) throws Exception {

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
				this.park(i, j, c);
				rowNumber++;
			}
		}

		scanner.close();
	}

	/**
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

	/**
	 * <b>main</b> of the application. The method first reads from the standard
	 * input the name of the file to process. Next, it creates an instance of
	 * ParkingLot. Finally, it prints to the standard output information about the
	 * instance of the ParkingLot just created.
	 * 
	 * @param args command lines parameters (not used in the body of the method)
	 * @throws Exception
	 */

	public static void main(String args[]) throws Exception {

		StudentInfo.display();

		System.out.print("Please enter the name of the file to process: ");

		Scanner scanner = new Scanner(System.in);

		String strFilename = scanner.nextLine();

		ParkingLot lot = new ParkingLot(strFilename);

		System.out.println("Total number of parkable spots (capacity): " + lot.getTotalCapacity());

		System.out.println("Number of cars currently parked in the lot: " + lot.getTotalOccupancy());

		System.out.print(lot);

	}
}