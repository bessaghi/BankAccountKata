package fr.sg;

import lombok.Data;

@Data
public class Account {

    private double balance;

    public void add(double amount) {
        balance+= amount;
    }

    public void retrieve(double amount) {
        balance-= amount;
    }
}
