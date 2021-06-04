package domain;

public record Balance(long cents) {

  public Balance plus(Amount amount) {
    return new Balance(cents + amount.cents());
  }
}
