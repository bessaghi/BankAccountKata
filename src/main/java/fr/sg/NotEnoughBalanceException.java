package fr.sg;

public class NotEnoughBalanceException extends RuntimeException {


    public NotEnoughBalanceException(String message) {
        super(message);
    }
}
