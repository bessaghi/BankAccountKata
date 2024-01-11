package fr.sg.exceptions;

public class NotEnoughBalanceException extends RuntimeException {

    public NotEnoughBalanceException() {
        super("You don't have enough balance in your account.");
    }
}
