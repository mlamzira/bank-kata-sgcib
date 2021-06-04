import domain.Account;
import domain.Amount;
import infrastructure.StringStatementPrinter;
import java.time.Clock;

public class AccountApp {

  public static void main(String[] args) {
    Account account = new Account(Clock.systemDefaultZone());

    account.deposit(new Amount(2000L));
    account.deposit(new Amount(2000L));
    account.withdraw(new Amount(3000L));
    account.deposit(new Amount(2200L));
    account.withdraw(new Amount(1700L));

    StringStatementPrinter printer = new StringStatementPrinter();

    account.printTo(printer);

    System.out.println(printer.printedLines());
  }

}
