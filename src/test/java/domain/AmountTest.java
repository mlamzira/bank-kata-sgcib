package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class AmountTest {

  @Test
  void isNegative_should_return_true_when_amount_is_negative() {
    assertThat(new Amount(1L).isNegative()).isFalse();
    assertThat(new Amount(-1L).isNegative()).isTrue();
  }

  @Test
  void absoluteValue_should_return_the_absoluteValue_of_cents() {
    assertThat(new Amount(1L).absoluteValue()).isEqualTo(new Amount(1L));
    assertThat(new Amount(-1L).absoluteValue()).isEqualTo(new Amount(1L));
  }
}