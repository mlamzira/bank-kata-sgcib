package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class AccountTest {

  @Test
  void account_balance_should_be_empty_at_first() {
    Account account = new Account();
    Balance zeroBalance = new Balance(0L);

    assertThat(account.balance()).isEqualTo(zeroBalance);
  }

  @Test
  void account_balance_should_be_10EUR_after_making_a_deposit_of_10EUR() {
    Account account = new Account();

    account.deposit(new Amount(1000L));

    assertThat(account.balance()).isEqualTo(new Balance(1000L));
  }
}