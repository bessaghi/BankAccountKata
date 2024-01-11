package fr.sg.services;

import fr.sg.data.Account;
import fr.sg.data.Transaction;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class StatementPrinter {

    private static final String STATEMENT_HEADER = "OPERATION | DATE | AMOUNT | BALANCE";
    private static final String LINE_BREAK = "\n";

    public String printStatement(Account account) {
        return STATEMENT_HEADER
                + LINE_BREAK
                + printTransactions(account.getTransactions());
    }

    private String printTransactions(List<Transaction> transactions) {
        return transactions
                .stream()
                .map(Transaction::print)
                .collect(joining(LINE_BREAK));
    }
}
