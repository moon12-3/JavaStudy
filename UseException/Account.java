package UseException;

public class Account {
	private int balance;
	
	public Account() {
		
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void desposit(int money) {
		balance += money;
	}
	
	public void withdraw(int money) throws BalanceInsuffcientException {
		if(balance < money) {
			throw new BalanceInsuffcientException("잔고부족:"+(money-balance)+" 모자람");
		}
		else
			balance -=money;
	}
}
