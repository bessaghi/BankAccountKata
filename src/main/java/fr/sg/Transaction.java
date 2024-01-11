package fr.sg;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Transaction {

    Operation operation;
    String date;
    double amount;
    double balance;
}
