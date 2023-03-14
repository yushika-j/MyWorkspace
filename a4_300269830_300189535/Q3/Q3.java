public class Q3 {

    private static void testCount(String first, String second, SinglyLinkedList<String> l){
        System.out.println("Distance between " + first
        + " and " + second +" is " + l.count(first,second));
    }
    public static void main(String[] args) {

        StudentInfo.display();

        SinglyLinkedList<String> l;
        l = new SinglyLinkedList<String>();

        l.add("A");
        l.add("B");
        l.add("C");
        l.add("D");
        l.add("A");
        l.add("B");
        l.add("C");
        l.add("D");
        l.add("E");
        System.out.println(l);
        testCount("A","A",l);
        testCount("A","B",l);
        testCount("A","D",l);
        testCount("A","E",l);
        testCount("A","F",l);
        testCount("B","B",l);
        testCount("B","A",l);
        testCount("B","D",l);
        testCount("B","E",l);
        testCount("B","F",l);
        testCount("E","A",l);
        testCount("F","A",l);
        testCount(null,"A",l);
        testCount("A",null,l);

    }
}
