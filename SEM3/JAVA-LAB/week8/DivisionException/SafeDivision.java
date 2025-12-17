//WAP that asks for 2 numbers and prints their division. Handle the case when the user enters 0 as the denominator

import java.util.Scanner;
public class SafeDivision{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		try{
			System.out.print("Enter numerator: ");
			double num = sc.nextDouble();
			System.out.print("\nEnter denominator: ");
			double den = sc.nextDouble();
			if(den == 0){
				System.out.println("Error: Division by 0 not allowed");
			}
			else{
				double result = num/den;
				System.out.print("Result: "+result);
			}
		}
		catch(Exception e){
			System.out.println("Invalid Input. Please enter integral values.");
		}
		sc.close();
	}
}