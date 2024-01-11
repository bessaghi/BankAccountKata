package fr.sg;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccountHandlerTest {

    private AccountHandler accountHandler = new AccountHandler();

    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account();
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
}