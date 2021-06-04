package domain;

public record Amount(long cents) {

  public Amount negative() {
    return new Amount(-cents);
  }

  public boolean isNegative() {
    return cents < 0;
  }

  public Amount absoluteValue() {
    return new Amount(Math.abs(cents));
  }
}
