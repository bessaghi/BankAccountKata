package fr.sg;

public interface AccountService {

    void deposit(Account account, double amount);
    void withdrawal(Account account, double amount);
    String printStatement(Account account);

    void withdrawalAll(Account account);
}
