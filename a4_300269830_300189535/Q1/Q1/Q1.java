public class Q1 {

    private static int sizeOfTest = 10000;
    private static String testString = "This is some string that I am testing with ...";

    private static String resultBuffer = "";
    private static String resultConcat = "";
    private static ITIStringBuffer buffer = new ITIStringBuffer();

    private static void testStringBuffer() {

        long start = System.currentTimeMillis();
        for(int i = 0; i < sizeOfTest; i++){
            buffer.append(testString + i );
        }
        long inter = System.currentTimeMillis();
        resultBuffer = buffer.toString();
        long end = System.currentTimeMillis();

        System.out.print("It took " + (end-start) + " ms with ITI1121StringBuffer ("
        + (inter-start) + " to append and "
        + (end - inter) + " to generate).");

        inter = System.currentTimeMillis();
        resultBuffer = buffer.toString();
        end = System.currentTimeMillis();
        System.out.println(" Regenerating the string took " + (end-inter) + " ms.");
    }

    private static void testStringAppend(){

        long start = System.currentTimeMillis();
        for(int i = 0; i < sizeOfTest; i++){
            resultConcat += testString + i;
        }
        long end = System.currentTimeMillis();

        System.out.println("It took " + (end-start) + " ms directly with String.");
    }

    private static void oneRound() {

        testStringBuffer();
        testStringAppend();
        if(!resultBuffer.equals(resultConcat)) {
            System.out.println("Error, the strings are not the same");
            return;
        } else{
            System.out.println("OK, the strings are the same.");
        }

    }

    public static void main(String[] args) {

        StudentInfo.display();

        /*
        ITIStringBuffer marco = new ITIStringBuffer();
        marco.append("Marco");
        marco.append(" Polo");
        System.out.println(marco);
        marco.append(" walks into a bar...");
        System.out.println(marco.toString());
        */

        System.out.println("First round");
        oneRound();

        System.out.println("Second round");
        oneRound();

        System.out.println("Third round");
        oneRound();
    }
}
