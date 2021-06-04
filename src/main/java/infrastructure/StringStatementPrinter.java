package infrastructure;

import domain.Amount;
import domain.Balance;
import domain.StatementLine;
import domain.spi.StatementPrinter;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class StringStatementPrinter implements StatementPrinter {

  private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy")
      .withZone(ZoneId.systemDefault());
  private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.00");

  private final PrintStream printStream;
  private final ByteArrayOutputStream out;

  public StringStatementPrinter() {
    out = new ByteArrayOutputStream();
    printStream = new PrintStream(out, true);
  }

  @Override
  public void print(StatementLine statementLine) {
    printStream.printf("| %s |", symbole(statementLine.amount()));
    printStream.printf(" %s |", date(statementLine.timestamp()));
    printStream.printf(" %s |", amount(statementLine.amount()));
    printStream.printf(" %s |", balance(statementLine.currentBalance()));
    printStream.println();

  }

  private String balance(Balance currentBalance) {
    return DECIMAL_FORMAT.format(currentBalance.cents() / 100);
  }

  private String amount(Amount amount) {
    return DECIMAL_FORMAT.format(amount.absoluteValue().cents() / 100);
  }

  private String date(Instant timestamp) {
    return DATE_TIME_FORMATTER.format(timestamp);
  }

  private String symbole(Amount amount) {
    return amount.isNegative() ? "-" : "+";
  }

  public String printedLines() {
    return out.toString();
  }
}
