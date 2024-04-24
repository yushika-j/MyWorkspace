import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

    public class decode {
        public static void main(String[] args) throws FileNotFoundException {
            try {
                File file = new File("coding_qual_input.txt");
                Scanner scanner = new Scanner(file);
                // Create a list to store each line of the file
                List<String> lines = new ArrayList<>();
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    lines.add(line);
                }
                int numLines = lines.size();
                scanner.close();
                //create an array with end pyramid numbers
                ArrayList<Integer> pyramidNums = new ArrayList<Integer>();
                int num = 1;
                for (int i = 1; i <= numLines; i++){
                    pyramidNums.add(i);
                    i = i + num;
                    num = num + 1;
                }
                System.out.println(pyramidNums);
                //compare the end pyramid numbers to the first number in each line	
                for (int numbers : pyramidNums){
                    for (String line : lines) {
                        String[] parts = line.split(" ", 2); // Split at the first whitespace
                        if (numbers == Integer.parseInt(parts[0])){
                            System.out.println(parts[1]);
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
