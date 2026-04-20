package object;

public class AccountUse {
    public static void main(String[] args) {
        Account account = new Account("홍길동", "010115", 10000);
        System.out.println(account.name);
        System.out.println(account.ssn);
        System.out.println(account.money);
    }
}
