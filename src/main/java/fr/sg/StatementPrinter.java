package fr.sg;

import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class StatementPrinter {

    private static final String STATEMENT_HEADER = "OPERATION | DATE | AMOUNT | BALANCE";
    private static final String LINE_BREAK = "\n";
    private static final String SEPARATOR = " | ";

    public String printStatement(Account account) {
        return STATEMENT_HEADER
                + LINE_BREAK
                + printTransactions(account);
    }

    private String printTransactions(Account account) {
        return account.getTransactions()
                .stream().map(t -> t.getOperation() + SEPARATOR +
                        t.getDate() + SEPARATOR +
                        t.getAmount()  + SEPARATOR +
                        t.getBalance()
                        ).collect(joining(LINE_BREAK));
    }
}
