import java.io.File;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.Scanner;

import javax.swing.JPopupMenu.Separator;

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
	private int numRows = 0;

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

		// determine numRows and numSpotsPerRow; you can do so by
		// writing your own code or alternatively completing the 
		// private calculateLotDimensions(...) that I have provided
		calculateLotDimensions(strFilename);

		// instantiate the lotDesign and occupancy variables!
		// WRITE YOUR CODE HERE!

		// populate lotDesign and occupancy; you can do so by
		// writing your own code or alternatively completing the 
		// private populateFromFile(...) that I have provided
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
		CarType type = c.getType();
		String plateNum = c.getPlateNum();

		if (canParkAt(i, j, c)){
			occupancy[i][j].setType(type); 
			occupancy[i][j].setPlateNum(plateNum); 
		}else{
			System.out.println("Car "+ c.toString() + " cannot be parked at " + "("+i+","+j+")");
		}
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
		// WRITE YOUR CODE HERE!
		if (occupancy[i][j] == null){
			return null;
		} else{
			occupancy[i][j] = null; 
			System.out.println(occupancy[i][j].getPlateNum());
		}
		return null; 

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
		// WRITE YOUR CODE HERE!
// At most one car can be parked at any given (non-NA) spot;
// • An electric car is allowed to park at any (non-NA) spot: ELECTRIC, SMALL, REGULAR, LARGE;
// • A small car is allowed to park only at the following spot types: SMALL, REGULAR, LARGE;
// • A regular car is allowed to park only at the following spot types: REGULAR, LARGE;
// • A large car is allowed to park only at the following spot type: LARGE
		CarType type = c.getType();
		if ( occupancy[i][j]== null){
			switch (type) {
				case NA:
					return false;
				case ELECTRIC: 
					if (lotDesign[i][j] != CarType.NA){;
					return true;
					}
					return false;
				case SMALL:
					if (lotDesign[i][j] == CarType.SMALL || lotDesign[i][j] == CarType.LARGE || lotDesign[i][j] == CarType.REGULAR || lotDesign[i][j] == CarType.ELECTRIC){
						return true;
					}
					return false;
				case REGULAR:
					if (lotDesign[i][j] == CarType.REGULAR || lotDesign[i][j] == CarType.LARGE || lotDesign[i][j] == CarType.ELECTRIC){
						return true;
					}
					return false;
				case LARGE:
					if (lotDesign[i][j] == CarType.LARGE || lotDesign[i][j] == CarType.ELECTRIC){
						return true;
					}
					return false;
				
				}
		}	
		else if(occupancy[i][j] != null){
			return false;
		}
		return false;
		
	}

	/**
	 * @return the total capacity of the parking lot excluding spots that cannot be
	 *         used for parking (i.e., excluding spots that point to CarType.NA)
	 */
	public int getTotalCapacity() {
		int totalCapacity = 0;
		int unavailable = 0;
		totalCapacity = numRows*numSpotsPerRow;
		for (int i = 0; i < lotDesign.length; i++) {
			//System.out.println(lotDesign.length);
			for (int j = 0; j < lotDesign[0].length; j++) {
				if (lotDesign[i][j] == CarType.NA){
					unavailable += 1;
				}
			}
		}
		return totalCapacity-unavailable;
	}

	/**
	 * @return the total occupancy of the parking lot (i.e., the total number of
	 *         cars parked in the lot)
	 */
	public int getTotalOccupancy() {
		int totalOccupancy = 0; 
		for (int i = 0; i < lotDesign.length; i++){ 
			for (int j = 0; j < lotDesign[0].length; j++){
				if (occupancy[i][j] != null){ //checks if the parking spot is empty
					totalOccupancy += 1;
				}
			}
		}
		return totalOccupancy;	
	}

	private void calculateLotDimensions(String strFilename) throws Exception {
		Scanner scanner = new Scanner(new File(strFilename));
		String str = "";
		int commas = 0;

        outerloop:
		while (scanner.hasNext()) {
		   //System.out.println(str);
			str = scanner.nextLine();
			// WRITE YOUR CODE HERE!
			
            if (scanner.hasNext() && scanner.nextLine() == "###"){
				 break outerloop;
			} 
			for(int i=1;i<str.length();i++)
           {
                if(str.substring(i-1,i) == SEPARATOR) {
            		commas++;
					System.out.println(commas);
                }
                System.out.println(str);
				
                if (str == "###"){
                    System.out.println("break");
                   break outerloop;
                }
               
           }
			str = str.replaceAll(" ", "");

			str = str.replaceAll(",", "");
            //System.out.println(str);
           
            //System.out.println(" file has" + commas + "commas");
            System.out.println(str);
           numSpotsPerRow = str.length()-1;
		   numRows++;

			//System.out.println("calculateLotDimensions is")
		}
            
        /**while (scanner.hasNext()) {

		}
		*/

        // String fullstring = str;
        // int commas = 0;
        // for(int i=0;i<str.length();i++)
        // {
        //     if(str.charAt(i)==',') 
        //     {
        //     commas++;
        //     }
        // }
        


		// while (scanner.hasNext() && scanner.nextLine() != SECTIONER){
		// 	str = scanner.nextLine();
		// 	this.numRows++;
		// 	char temp;
		// 	for (int i = 0; i < str.length(); i++) {
		// 		temp = str.charAt(i);
		// 		if (temp == ',')
		// 			this.numSpotsPerRow++;
		// 	}
		// 	this.numSpotsPerRow++;
			
		// }

		scanner.close();
        System.out.println("number of rows: " + numRows);
        System.out.println("number of columns: " + numSpotsPerRow);

	}

	private void populateFromFile(String strFilename) throws Exception {

		Scanner scanner = new Scanner(new File(strFilename));

		// YOU MAY NEED TO DEFINE SOME LOCAL VARIABLES HERE!
		lotDesign = new CarType[numRows][numSpotsPerRow]; //CarType[4][5] was changed to this (also got rid of the CarType)
		int linesRead = 0;
		String platenum;
		CarType type;
		Car car1 = new Car(null, "000"); //idk my suggestion is just putting a temporary value here and the changing it later like when the stuff gets added

		// while loop for reading the lot design
		while (scanner.hasNextLine() ) { //*********/
			
			String str = scanner.nextLine();
			// WRITE YOUR CODE HERE!
			
			str = str.replaceAll(",", "");
			str = str.replaceAll(" ", "");
			//System.out.println(str.length());
			for (int i = 0;i< str.length();i++){
				char c = str.charAt(i);
				switch (c) {
					case 'E':
						lotDesign[linesRead][i] = CarType.ELECTRIC;
						break;
					case 'S':
						lotDesign[linesRead][i] = CarType.SMALL;
						break;
					case 'R':
						lotDesign[linesRead][i] = CarType.REGULAR;
						break;
					case 'L':
						lotDesign[linesRead][i] = CarType.LARGE;
						break;
					case 'N':
						lotDesign[linesRead][i] = CarType.NA;
						break;
					default:
						lotDesign[linesRead][i] = CarType.ELECTRIC;
				}
				//System.out.println(str);
			}
			for (int a = 0; a<str.length();a++){
				System.out.println(lotDesign[linesRead][a]);
			}

			linesRead++;
			//System.out.println("Lines read = " + linesRead);
		}

		// while loop for reading occupancy data
		while (scanner.hasNext()){
			String str = scanner.nextLine();
			// WRITE YOUR CODE HERE!
			if (Character.isDigit(str.charAt(0))){ //looks for the car positions in .inf file
				for (int i = 0; i >= numRows; i++){ //checks row number
					for (int j = 0; j >= numSpotsPerRow; j++){ //checks numberofspot number
						if (str.substring(0, 2)== Integer.toString(i)){ 
							if (str.substring(1, 3) == Integer.toString(j)){
								platenum = str.substring(3,6);
								car1.setPlateNum(platenum);
								type = occupancy[i][j].getType(); 
								car1.setType(type);  
							}
							
						}
					}
					
				} 
				
			}
			
		}

		scanner.close();
	}

	/**
	 * Produce string representation of the parking lot
	 * 
	 * @return String containing the parking lot information
	 */
	public String toString() {
		// NOTE: The implementation of this method is complete. You do NOT need to
		// change it for the assignment.
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

	public static void main(String args[]) throws Exception{

		StudentInfo.display();

		System.out.print("Please enter the name of the file to process: ");

		try (Scanner scanner = new Scanner(System.in)) {
			String strFilename = scanner.nextLine();

			ParkingLot lot = new ParkingLot(strFilename);

			System.out.println("Total number of parkable spots (capacity): " + lot.getTotalCapacity());

			System.out.println("Number of cars currently parked in the lot: " + lot.getTotalOccupancy());

			System.out.print(lot);
		}

	}
}