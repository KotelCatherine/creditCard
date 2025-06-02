package ru.top.academy;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестовый класс проверяет работу класса CreditCardValidator на три сценария
 *
 * @see CreditCardValidator
 */
public class CreditCardValidatorTest {

    /**
     * Положительный сценарий, ожидаем true
     */
    @Test
    void testValidCardNumber() {

        CreditCardValidator creditCardValidator = new CreditCardValidator();
        creditCardValidator.setStringNumberCreditCard("00Q00_000M0_00c00_00o00.");
        assertTrue(creditCardValidator.isValidCreditCardNumber());

    }

    /**
     * Негативный сценарий, ожидаем false
     */
    @Test
    void testNotValidCardNumber() {

        CreditCardValidator creditCardValidator = new CreditCardValidator();
        creditCardValidator.setStringNumberCreditCard("1111 1111 1111 1111");
        assertFalse(creditCardValidator.isValidCreditCardNumber());

    }

    /**
     * Негативный сценарий, при передаче пустой строки ожидаем выброс исключения NullPointerException
     */
    @Test
    void testNPE() {

        CreditCardValidator creditCardValidator = new CreditCardValidator();
        creditCardValidator.setStringNumberCreditCard("");
        assertThrows(NullPointerException.class, creditCardValidator::isValidCreditCardNumber);

    }

}
