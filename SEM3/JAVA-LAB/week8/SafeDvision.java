/* Wap that asks for 2 numbers and prints their division. Handle the case when the user enters 0 as the denominator */
import java.util.Scanner;

public class SafeDvision{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Enter Numerator: ");
            double num = sc.nextDouble();
            System.out.println("Enter Denominator: ");
            double denominator = sc.nextDouble();
            if (denominator == 0){
                System.out.println("Error: Division by zero not allowed");
            }
            else{
                double result = num/denominator;
                System.out.println("Result" + result);
            }
        }
        catch (Exception e){
            System.out.println("Invalid Input. Please enter numeric values.");
        }
        sc.close();
    }
}
