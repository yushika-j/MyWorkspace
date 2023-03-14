import java.util.Scanner;

public class Q4 {
    public static int main(String[] args) {
        
        // ageGap =  java.lang.Math.abs(ageGap);
        System.out.print("How old are you? ");
        Scanner scanAge = new Scanner(System.in);
        Int myAge = scanAge.nextInt();
        System.out.print(myAge);
        int ageGap = (18-myAge);
        if (myAge < 18){
            System.out.println("You will be allowed to vote in "+ ageGap + " years.");
        }else{
            System.out.println("You have the right to vote!");
        }
    }
}