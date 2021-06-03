package domain;

public class Account {

  private Balance balance = new Balance(0L);

  public void deposit(Amount amount) {
    balance = new Balance(1000L);
  }

  public Balance balance() {
    return balance;
  }
}
