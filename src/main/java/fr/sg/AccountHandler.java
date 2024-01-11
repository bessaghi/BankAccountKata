package fr.sg;

public class AccountHandler implements AccountService {

    private final StatementPrinter statementPrinter;
    private final BankDate bankDate;

    public AccountHandler(BankDate bankDate) {
        this.statementPrinter = new StatementPrinter();
        this.bankDate = bankDate;
    }

    @Override
    public void deposit(Account account, double amount) {
        account.add(amount, bankDate.now());
    }

    @Override
    public void withdrawal(Account account, double amount) {
        account.retrieve(amount, bankDate.now());
    }

    @Override
    public void withdrawalAll(Account account) {
        account.retrieveAll(bankDate.now());
    }

    @Override
    public String printStatement(Account account) {
        return statementPrinter.printStatement(account);
    }
}
