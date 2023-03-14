import java.util.Arrays;
import java.util.Scanner;

public class Q6{
	public static void main(String[] args){
        
        double notes[] = new double[10];
        Scanner input = new Scanner(System.in)
        for(int i=0;i<10;i++)
        {
            System.out.print("Enter number "+(i+1)+ " in array=");
            notes[i] = input.nextInt();
        }  
        System.out.println(calculateAverage(notes));
        System.out.println(calculateMedian(notes));
        System.out.println(calculateNumberFailed(notes));
        System.out.println(calculateNumberPassed(notes));
	}

	public static double calculateAverage(double[] notes){
        double total =0;
        double average=0;
        for (int i=0;i<10;i++){
            total = total + notes[i];
        }
        average = total/10;
        return average;
	}

	public static double calculateMedian(double[] notes){
		Arrays.sort(notes);
        double median;
        int totalElements = notes.length;
        if (totalElements % 2 == 0) {
        double sumOfMiddleElements = notes[totalElements / 2] +
                                  notes[totalElements / 2 - 1];
        // calculate average of middle elements
        median = ((double) sumOfMiddleElements) / 2;
        } else {
        // get the middle element
            median = (double) notes[notes.length / 2];
        }
        return median;
	}

	public static int calculateNumberFailed(double[] notes){
		int numFailed = 0;
		for (int i=0;i<10;i++){
            if (notes[i] < 50){
                numFailed = numFailed + 1;
            }
        }
        return numFailed;
	}

	public static int calculateNumberPassed(double[] notes){
        int numPassed = 0;
		for (int i=0;i<10;i++){
            if (notes[i] >= 50){
                numPassed = numPassed + 1;
            }
        }
        return numPassed;
	}

}