package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BalanceTest {

  @Test
  void balance_should_be_15EUR_after_adding_10EUR_to_an_initial_balance_of_5EUR() {
    Balance initialBalance = new Balance(500L);
    Amount amount = new Amount(1000L);

    Balance actual = initialBalance.plus(amount);

    assertThat(actual).isEqualTo(new Balance(1500L));
  }

  @Test
  void balance_should_be_10EUR_after_subtracting_10EUR_from_an_initial_balance_of_20EUR() {
    Balance initialBalance = new Balance(2000L);
    Amount amount = new Amount(1000L);

    Balance actual = initialBalance.minus(amount);

    assertThat(actual).isEqualTo(new Balance(1000L));
  }
}