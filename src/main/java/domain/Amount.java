package domain;

public record Amount(long cents) {

  public Amount negative() {
    return new Amount(-cents);
  }
}
