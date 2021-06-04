package domain;

public class Amount {

  public final long cents;

  public Amount(long cents) {
    this.cents = cents;
  }

  public Amount negative() {
    return new Amount(-cents);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Amount amount = (Amount) o;

    return cents == amount.cents;
  }

  @Override
  public int hashCode() {
    return (int) (cents ^ (cents >>> 32));
  }
}
