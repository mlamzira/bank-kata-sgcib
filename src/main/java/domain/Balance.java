package domain;

public class Balance {

  private final long cents;

  public Balance(long cents) {
    this.cents = cents;
  }

  public Balance plus(Amount amount) {
    return new Balance(cents + amount.cents);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Balance balance = (Balance) o;

    return cents == balance.cents;
  }

  @Override
  public int hashCode() {
    return (int) (cents ^ (cents >>> 32));
  }
}
