package fr.sg.data;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Transaction {

    private static final String SEPARATOR = " | ";

    Operation operation;
    String date;
    double amount;
    double balance;

    public String print() {
        return operation + SEPARATOR +
                date + SEPARATOR +
                amount  + SEPARATOR +
                balance;
    }
}
