// public class removeTest {

//     CarType type;
//     String plateNum;
//     Car car1 = new Car(type, plateNum);
//     private CarType[][] lotDesign;
//     private int numRows = 0;

// 	/**
// 	 * Instance variable for storing the number of spaces per row in a parking lot
// 	 */
// 	private int numSpotsPerRow;

//     /**
// 	 * Removes the car parked at a given location (i, j) in the parking lot
// 	 * 
// 	 * @param i is the parking row index
// 	 * @param j is the index of the spot within row i
// 	 * @return the car removed; the method returns null when either i or j are out
// 	 *         of range, or when there is no car parked at (i, j)
// 	 */
//     public String remove(int i, int j) {
// 		// WRITE YOUR CODE HERE!
//         if (lotDesign[i][j] != null ){
//             type = car1.getType();
//             plateNum = car1.getPlateNum();
//             return plateNum;
//         }
//         if (i >= numRows || j >= numSpotsPerRow){
//             return "null";
//         }
//         return plateNum;
// 	}
// }
