package object;

public class Account {
    // 계좌만들 때 필요한 필드(멤버변수)
    String name;
    String ssn;
    int money;

    public Account(String name, String ssn, int money) {
        this.name = name;
        this.ssn = ssn;
        this.money = money;
    }
}
