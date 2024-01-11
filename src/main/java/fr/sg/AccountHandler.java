package fr.sg;

public class AccountHandler implements AccountService {

    private final StatementPrinter statementPrinter;

    public AccountHandler() {
        this.statementPrinter = new StatementPrinter();
    }

    @Override
    public void deposit(Account account, double amount) {
        account.add(amount);
    }

    @Override
    public void withdrawal(Account account, double amount) {
        account.retrieve(amount);
    }

    @Override
    public void withdrawalAll(Account account) {
        account.retrieveAll();
    }

    @Override
    public String printStatement(Account account) {
        return statementPrinter.printStatement(account);
    }
}
