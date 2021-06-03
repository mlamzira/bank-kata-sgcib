package domain;

import domain.spi.StatementPrinter;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Statements {

  private final List<StatementLine> history = new ArrayList<>();

  boolean addLine(Amount amount, Balance balance, Instant instant) {
    return history.add(new StatementLine(amount, balance, instant));
  }

  public void printStatement(StatementPrinter statementPrinter) {
    history.forEach(statementLine -> statementLine.printTo(statementPrinter));
  }
}