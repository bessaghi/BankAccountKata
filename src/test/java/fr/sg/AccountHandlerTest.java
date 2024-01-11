package fr.sg;

import fr.sg.data.Account;
import fr.sg.exceptions.NotEnoughBalanceException;
import fr.sg.services.AccountHandler;
import fr.sg.services.BankDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class AccountHandlerTest {


    private static final String A_DATE = "21/12/2023";

    private Account account;

    @Mock
    private BankDate bankDate;

    @InjectMocks
    private AccountHandler accountHandler;

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
        given(bankDate.now()).willReturn(A_DATE);
        accountHandler.deposit(account, 300);
        accountHandler.withdrawal(account, 100);
        accountHandler.withdrawalAll(account);

        String statement = accountHandler.printStatement(account);

        assertThat(statement).isEqualTo("OPERATION | DATE | AMOUNT | BALANCE\n" +
                "DEPOSIT | 21/12/2023 | 300.0 | 300.0\n" +
                "WITHDRAWAL | 21/12/2023 | 100.0 | 200.0\n" +
                "WITHDRAWAL | 21/12/2023 | 200.0 | 0.0");
    }
}