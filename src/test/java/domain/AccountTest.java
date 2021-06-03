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
}