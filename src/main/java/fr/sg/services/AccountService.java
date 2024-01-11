package fr.sg.services;

import fr.sg.data.Account;

public interface AccountService {

    void deposit(Account account, double amount);
    void withdrawal(Account account, double amount);
    String printStatement(Account account);

    void withdrawalAll(Account account);
}
