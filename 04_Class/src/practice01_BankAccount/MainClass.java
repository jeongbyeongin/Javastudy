package practice01_BankAccount;

public class MainClass {

	public static void main(String[] args) {
		
		BankAccount myAcc = new BankAccount("010-1111-1111", 50000);
		BankAccount yourAcc = new BankAccount("010-9999-9999", 100000);
		
		myAcc.transfer(yourAcc, 50_000);
		
		myAcc.inquiry();
		yourAcc.inquiry();
		}

}
