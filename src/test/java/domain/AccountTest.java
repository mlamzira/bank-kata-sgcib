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

  @Test
  void account_balance_should_be_20EUR_after_making_two_deposits_of_10EUR() {
    Account account = new Account();

    account.deposit(new Amount(1000L));
    account.deposit(new Amount(1000L));

    assertThat(account.balance()).isEqualTo(new Balance(2000L));
  }

  @Test
  void account_balance_should_be_5EUR_after_making_a_withdrawal_of_5EUR() {
    Account account = new Account();
    account.deposit(new Amount(1000L)); // initial deposit

    account.withdraw(new Amount(500L));

    assertThat(account.balance()).isEqualTo(new Balance(500L));
  }

  @Test
  void account_balance_should_be_empty_after_making_two_withdrawals_of_5EUR() {
    Account account = new Account();
    account.deposit(new Amount(1000L)); // initial deposit

    account.withdraw(new Amount(500L));
    account.withdraw(new Amount(500L));

    assertThat(account.balance()).isEqualTo(new Balance(0L));
  }
}