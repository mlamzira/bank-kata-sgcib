package domain;

import domain.spi.StatementPrinter;
import java.time.Clock;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Account {

  private final Clock clock;
  private Balance balance = new Balance(0L);
  private final List<StatementLine> history = new ArrayList<>();

  public Account(Clock clock) {
    this.clock = clock;
  }

  public void deposit(Amount amount) {
    balance = balance.plus(amount);
    history.add(new StatementLine(amount, balance, clock.instant()));
  }

  public void withdraw(Amount amount) {
    balance = balance.minus(amount);
  }

  public Balance balance() {
    return balance;
  }

  public void printStatement(StatementPrinter statementPrinter) {
    history.forEach(statementLine -> statementLine.printTo(statementPrinter));
  }
}
