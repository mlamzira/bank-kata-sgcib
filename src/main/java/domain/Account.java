package domain;

import domain.spi.StatementPrinter;
import java.time.Clock;

public class Account {

  private final Clock clock;
  private final Statements history = new Statements();
  private Balance balance = new Balance(0L);

  public Account(Clock clock) {
    this.clock = clock;
  }

  public void deposit(Amount amount) {
    balance = balance.plus(amount);
    history.addLine(amount, balance, clock.instant());
  }

  public void withdraw(Amount amount) {
    balance = balance.minus(amount);
  }

  public void printStatement(StatementPrinter statementPrinter) {
    history.printStatement(statementPrinter);
  }

  public Balance balance() {
    return balance;
  }
}
