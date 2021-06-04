package domain;

import domain.spi.StatementPrinter;
import java.time.Instant;

public record StatementLine(Amount amount, Balance currentBalance, Instant timestamp) {

  public void printTo(StatementPrinter statementPrinter) {
    statementPrinter.print(this);
  }
}
