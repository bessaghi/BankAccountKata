package fr.sg;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.format.DateTimeFormatter.ofPattern;

public class BankDate {
    private static final DateTimeFormatter DATE_FORMATTER = ofPattern("dd/MM/yyyy");

    public String now() {
        return LocalDate.now().format(DATE_FORMATTER);
    }

}
