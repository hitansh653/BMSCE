import java.util.Scanner;
public class Withdrawal{
    public static void main(String[] args) {
        double balance = 5000.0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Current Balance: "+balance);
	    System.out.println("\nEnter amount to withdraw: ");
	try{
		String input = sc.nextLine();
		double amount = Double.parseDouble(input);
		if(amount<=0){
			System.out.println("Error: Amount must be greater than 0");
		}
		else if(amount>balance){
			System.out.println("Error: Insufficient Balance.");
		}
		else{
			balance -= amount;
		System.out.println("Withdrawal Successful.");
		System.out.println("New Balance: "+balance);
		}
	}
	catch(NumberFormatException e){
		System.out.println("Error: Please enter a valid numeric amount.");
	}
	sc.close();
    }
}