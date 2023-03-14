
public class Q3_SquareArray{

	public static int[] createArray(int size) {

		// Your code here
        int[] myArray;
        myArray = new int[size];
        for (int i = 0; i < myArray.length; i++){
            myArray[i] = i * i;

        }
        return myArray;
        
	}

	public static void main(String[] args){
		// Your code here
        int[] squareArray = createArray(13);
        for (int i = 0;i< squareArray.length;i++){
            System.out.println("The square of " + i + " is : " + squareArray[i]);
        }
	}
}