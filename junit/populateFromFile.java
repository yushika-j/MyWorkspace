import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class populateFromFile {
	public void populateFromFileTest() throws FileNotFoundException{
		String strFilename = "parking.inf";
		Scanner scanner = new Scanner(new File(strFilename));
		CarType[][] lotDesign = new CarType[4][5];
		// YOU MAY NEED TO DEFINE SOME LOCAL VARIABLES HERE!

		//String SECTIONER = "###";
		// while loop for reading the lot design
		int linesRead = 0;
		
		
		while (scanner.hasNextLine() ) { //*********/
			
			String str = scanner.nextLine();
			// WRITE YOUR CODE HERE!
			
			str = str.replaceAll(",", "");
			//str.trim();
			str = str.replaceAll(" ", "");
			System.out.println(str.length());
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
					// default:
					// 	lotDesign[linesRead][i] = CarType.ELECTRIC;
				}
				System.out.println(str);
			}
			for (int a = 0; a<str.length();a++){
				System.out.println(lotDesign[linesRead][a]);
			}

			linesRead++;
			System.out.println("Lines read = " + linesRead);
		}
		
	}	
	

public static void main(String[] args) throws FileNotFoundException{
	populateFromFile file = new populateFromFile(); 
	file.populateFromFileTest();

}
}