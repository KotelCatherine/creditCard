package ru.top.academy;

/**
 * Главный класс с точкой входа в программу
 */
public class Main {

    /**
     * Точка входа в программу для проверки валидности номера карты (stringNumberCard) <br>
     * выводит в консоль true - если номер прошел проверку <br>
     * false - если номер не прошел проверку
     *
     * @param args аргументы строки
     * @see CreditCardValidator
     */
    public static void main(String[] args) {

        String stringNumberCard = "4532 7587 9245 1259";

        CreditCardValidator creditCardValidator = new CreditCardValidator();
        creditCardValidator.setStringNumberCreditCard(stringNumberCard);
        System.out.println(creditCardValidator.isValidCreditCardNumber());

    }
}