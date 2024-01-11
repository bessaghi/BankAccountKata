package fr.sg;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Account {

    private double balance;
    private List<Transaction> transactions = new ArrayList<>();

    public void add(double amount, String date) {
        balance+= amount;
        transactions.add(Transaction.builder()
                        .operation(Operation.DEPOSIT)
                        .date(date)
                        .amount(amount)
                        .balance(balance)
                .build());
    }

    public void retrieve(double amount, String date) {
        if (balance < amount) {
            throw new NotEnoughBalanceException("You don't have enough balance in your account.");
        }
        balance-= amount;
        transactions.add(Transaction.builder()
                .operation(Operation.WITHDRAWAL)
                .date(date)
                .amount(amount)
                .balance(balance)
                .build());
    }

    public void retrieveAll(String date) {
        retrieve(balance, date);
    }
}
