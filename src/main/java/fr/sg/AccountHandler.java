package fr.sg;

public class AccountHandler implements AccountService {
    @Override
    public void deposit(Account account, double amount) {
        account.add(amount);
    }

    @Override
    public void withdrawal(Account account, double amount) {
        account.retrieve(amount);
    }
}
