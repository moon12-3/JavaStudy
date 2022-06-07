package UseException;

public class AcciybtExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account = new Account();
		// 예금하기
		account.desposit(10000);
		System.out.println("예금액 : "+ account.getBalance());
		
		//출금하기
		try {
			account.withdraw(30000);
		} catch(BalanceInsuffcientException s) {
			String message = s.getMessage();
			//
			System.out.println(message);
			System.out.println();
			s.printStackTrace();
		}
	}

}
