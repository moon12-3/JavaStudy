package UseException;

public class AcciybtExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account = new Account();
		// �����ϱ�
		account.desposit(10000);
		System.out.println("���ݾ� : "+ account.getBalance());
		
		//����ϱ�
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
