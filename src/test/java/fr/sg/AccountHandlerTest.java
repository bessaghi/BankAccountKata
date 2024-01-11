package fr.sg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AccountHandlerTest {

    private AccountHandler accountHandler = new AccountHandler();

    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account();
    }

    @Test
    void balance_of_newly_created_account_must_be_zero() {
        assertThat(account.getBalance()).isEqualTo(0);
    }

    @Test
    void make_deposit_into_account() {
        accountHandler.deposit(account, 100);

        assertThat(account.getBalance()).isEqualTo(100);
    }

    @Test
    void make_withdrawal_from_account() {
        accountHandler.deposit(account, 300);

        accountHandler.withdrawal(account, 100);

        assertThat(account.getBalance()).isEqualTo(200);
    }

    @Test
    void should_throw_exception_when_not_enough_money_to_withdrawal() {
        accountHandler.deposit(account, 300);

        assertThatThrownBy(() -> accountHandler.withdrawal(account, 400))
                .isInstanceOf(NotEnoughBalanceException.class)
                .hasMessage("You don't have enough balance in your account.");
    }

    @Test
    void withdrawal_all_from_account() {
        accountHandler.deposit(account, 300);

        accountHandler.withdrawalAll(account);

        assertThat(account.getBalance()).isEqualTo(0);
    }

    @Test
    void print_account_statement() {
        accountHandler.deposit(account, 300);
        accountHandler.withdrawal(account, 100);
        accountHandler.withdrawalAll(account);

        String statement = accountHandler.printStatement(account);

        assertThat(statement).isEqualTo("OPERATION | DATE | AMOUNT | BALANCE\n" +
                "DEPOSIT | 2024-01-11 | 300.0 | 300.0\n" +
                "WITHDRAWAL | 2024-01-11 | 100.0 | 200.0\n" +
                "WITHDRAWAL | 2024-01-11 | 200.0 | 0.0");
    }
}