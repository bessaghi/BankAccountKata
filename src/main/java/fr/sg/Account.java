package fr.sg;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class Account {

    private double balance;
    private List<Transaction> transactions = new ArrayList<>();

    public void add(double amount) {
        balance+= amount;
        transactions.add(Transaction.builder()
                        .operation(Operation.DEPOSIT)
                        .date(LocalDate.now())
                        .amount(amount)
                        .balance(balance)
                .build());
    }

    public void retrieve(double amount) {
        balance-= amount;
        transactions.add(Transaction.builder()
                .operation(Operation.WITHDRAWAL)
                .date(LocalDate.now())
                .amount(amount)
                .balance(balance)
                .build());
    }
}
