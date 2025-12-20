import java.util.Scanner;
abstract class Account{
	protected String custName;
	protected long accountNo;
	protected String accType;
	private static int accCounter = 0;
	protected double balance;
	public Account(String name, String type, double iBalance){
		this.custName = name;
		this.accType = type;
		this.balance = iBalance;
		this.accountNo = ++accCounter;
	}
	public void deposit(double amount){
		if(amount<=0){
			System.out.println("Invalid Deposit.");
			return;
		}
		balance+=amount;
		System.out.println("Successfully deposited.");
		displayBalance();
	}
	public void displayBalance(){
		System.out.println("Balance is: "+String.format("%2f", this.balance));
	}
	public abstract void interest();
	public abstract void withdraw(double amount);
}

class SavAcc extends Account{
	double interestRate, interest = 0;
	public SavAcc(String name, double iBalance){
		super(name, "Savings", iBalance);
		this.interestRate = 0.05;
	}
	public void interest(){
		interest = balance*(interest/(2*100));
		balance += interest;
		System.out.println("Final Balance: "+String.format("%2f",balance));
	}
	public void withdraw(double amount){
		if(amount<=0){
			System.out.print("No Withdrawal");
		}
		else{
			balance -= amount;
			System.out.println("Successfully Withdrew: "+String.format("%2f", amount));
			displayBalance();
		}
	}
}

class CurrAcc extends Account{
	double minBalance, penalty;
	public CurrAcc(String name, double iBalance){
		super(name, "Current", iBalance);
		this.minBalance = 1000.00;
		this.penalty = 100.00;
	}
	public void interest(){
		System.out.println("No Interest");
	}
	public void withdraw(double amount){
		if(amount<=0){
			System.out.println("Invalid withdraw account");
		}
		else if(amount>balance){
			System.out.println("Insufficient Funds");
		}
		else{
			balance -= amount;
			System.out.println("Successfully Withdrawn"+String.format("%2f", amount));
			checkMinBalance();
			displayBalance();
		}
	}
	public void checkMinBalance(){
		if(balance<minBalance){
			System.out.println("Warning: Low Funds");
			System.out.println("Apply Penalty");
			balance -= penalty;
			System.out.println("New Balance: "+String.format("%2f", balance));
		}
	}
}

public class Bank{
	public static void main(String[] args){
		System.out.println("Welcome to Bank");
		Account a1 = new SavAcc("Alice", 5000.00);
		a1.withdraw(5000.00);
		a1.interest();
	}
}