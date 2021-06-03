package domain;

public class Account {

  private Balance balance = new Balance(0L);

  public void deposit(Amount amount) {
    balance = balance.plus(amount);
  }

  public Balance balance() {
    return balance;
  }
}
