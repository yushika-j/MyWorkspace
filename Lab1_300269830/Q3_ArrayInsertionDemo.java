public class Q3_ArrayInsertionDemo{

	public static int[] insertIntoArray(int[] beforeArray, int indexToInsert, int valueToInsert){
		// Your code here
        int size = beforeArray.length + 1;
        int[] afterArray = new int[size];
        boolean flag = false;

    
        for(int i=0;i<beforeArray.length;i++){
            
           
            if (i == indexToInsert){
                afterArray[indexToInsert] = valueToInsert;
                flag = true;
            }
            if (flag == false){
                afterArray[i] = beforeArray[i];
            }else{
                afterArray[i+1] = beforeArray[i];
            }
        }
        return afterArray;

	}

	public static void main(String[] args){
		// Your code here
        int[] beforeArray = new int[] {10,14,3,5,8,7,5,9};
        int[] afterArray = insertIntoArray(beforeArray ,0 ,50);
        System.out.println("Array before insertion: ");
        for (int i = 0; i < beforeArray.length ;i++){
            System.out.println(beforeArray[i]);
        }
        System.out.println("Array after insertion: ");
        for (int i = 0; i < afterArray.length ;i++){
            System.out.println(afterArray[i]);
        }
	}
}