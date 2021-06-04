package infrastructure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import domain.Account;
import domain.Amount;
import java.time.Clock;
import java.time.Instant;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class StringStatementPrinterTest {

  private final Instant timestamp1 = Instant.parse("2021-06-03T00:34:07.786Z");
  private final Instant timestamp2 = Instant.parse("2021-06-03T00:35:07.786Z");
  private final Instant timestamp3 = Instant.parse("2021-06-04T00:36:07.786Z");
  private final Instant timestamp4 = Instant.parse("2021-06-05T00:36:07.786Z");
  private final Clock clock = Mockito.mock(Clock.class);

  @Test
  void printedLines_should_render_statementLines_to_the_corresponding_format() {
    given(clock.instant()).willReturn(timestamp1, timestamp2, timestamp3, timestamp4);
    Account account = new Account(clock);
    StringStatementPrinter printer = new StringStatementPrinter();

    account.deposit(new Amount(2000L));
    account.withdraw(new Amount(500L));
    account.withdraw(new Amount(500L));
    account.deposit(new Amount(300L));

    account.printTo(printer);

    assertThat(printer.printedLines())
        .isEqualTo(
            """
            | + | 03/06/2021 | 20,00 | 20,00 |
            | - | 03/06/2021 | 5,00 | 15,00 |
            | - | 04/06/2021 | 5,00 | 10,00 |
            | + | 05/06/2021 | 3,00 | 13,00 |
            """
        );
  }
}