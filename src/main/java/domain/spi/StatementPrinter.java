package domain.spi;

import domain.StatementLine;

public interface StatementPrinter {

  void print(StatementLine statementLine);
}
