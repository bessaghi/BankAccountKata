package fr.sg;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class Transaction {

    Operation operation;
    LocalDate date;
    double amount;
    double balance;
}
