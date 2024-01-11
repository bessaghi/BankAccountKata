package fr.sg.data;

import fr.sg.exceptions.NotEnoughBalanceException;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Account {

    private double balance;
    private List<Transaction> transactions = new ArrayList<>();

    public void add(double amount, String date) {
        balance+= amount;
        addTransaction(Operation.DEPOSIT, date, amount);
    }

    private void addTransaction(Operation operation, String date, double amount) {
        transactions.add(Transaction.builder()
                .operation(operation)
                .date(date)
                .amount(amount)
                .balance(balance)
                .build());
    }

    public void retrieve(double amount, String date) {
        if (balance < amount) {
            throw new NotEnoughBalanceException();
        }
        balance-= amount;
        addTransaction(Operation.WITHDRAWAL, date, amount);
    }

    public void retrieveAll(String date) {
        retrieve(balance, date);
    }
}
