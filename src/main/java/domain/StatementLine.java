package domain;

import domain.spi.StatementPrinter;
import java.time.Instant;
import java.util.Objects;

public class StatementLine {

  private final Amount amount;
  private final Balance balance;
  private final Instant timestamp;

  public StatementLine(Amount amount, Balance currentBalance, Instant timestamp) {
    this.amount = amount;
    this.balance = currentBalance;
    this.timestamp = timestamp;
  }

  public void printTo(StatementPrinter statementPrinter) {
    statementPrinter.print(this);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    StatementLine that = (StatementLine) o;

    if (!Objects.equals(amount, that.amount)) {
      return false;
    }
    if (!Objects.equals(balance, that.balance)) {
      return false;
    }
    return Objects.equals(timestamp, that.timestamp);
  }

  @Override
  public int hashCode() {
    int result = amount != null ? amount.hashCode() : 0;
    result = 31 * result + (balance != null ? balance.hashCode() : 0);
    result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
    return result;
  }
}
