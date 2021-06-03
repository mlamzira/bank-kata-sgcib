package domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.spi.StatementPrinter;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountTest {

  private final Instant timestamp = Instant.parse("2021-06-03T23:34:07.786Z");
  private final Clock fixedClock = Clock.fixed(timestamp, ZoneId.systemDefault());
  private Account account;

  @BeforeEach
  void setUp() {
    account = new Account(Clock.systemDefaultZone());
  }

  @Test
  void account_balance_should_be_empty_at_first() {
    Balance zeroBalance = new Balance(0L);

    assertThat(account.balance()).isEqualTo(zeroBalance);
  }

  @Test
  void account_balance_should_be_10EUR_after_making_a_deposit_of_10EUR() {
    account.deposit(new Amount(1000L));

    assertThat(account.balance()).isEqualTo(new Balance(1000L));
  }

  @Test
  void account_balance_should_be_20EUR_after_making_two_deposits_of_10EUR() {
    account.deposit(new Amount(1000L));
    account.deposit(new Amount(1000L));

    assertThat(account.balance()).isEqualTo(new Balance(2000L));
  }

  @Test
  void account_balance_should_be_5EUR_after_making_a_withdrawal_of_5EUR() {
    account.deposit(new Amount(1000L)); // initial deposit

    account.withdraw(new Amount(500L));

    assertThat(account.balance()).isEqualTo(new Balance(500L));
  }

  @Test
  void account_balance_should_be_empty_after_making_two_withdrawals_of_5EUR() {
    account.deposit(new Amount(1000L)); // initial deposit

    account.withdraw(new Amount(500L));
    account.withdraw(new Amount(500L));

    assertThat(account.balance()).isEqualTo(new Balance(0L));
  }

  @Test
  void should_print_one_deposit_statement() {
    account = new Account(fixedClock);
    account.deposit(new Amount(1000L));
    FakeStatementPrinter statementPrinter = new FakeStatementPrinter();

    account.printStatement(statementPrinter);

    Balance balance = new Balance(1000L);
    Amount amount = new Amount(1000L);
    assertThat(statementPrinter.lines)
        .containsExactly(new StatementLine(amount, balance, timestamp));
  }

  private static class FakeStatementPrinter implements StatementPrinter {

    private final List<StatementLine> lines = new ArrayList<>();

    public void print(StatementLine statementLine) {
      lines.add(statementLine);
    }
  }
}