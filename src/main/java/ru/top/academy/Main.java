package ru.top.academy;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {

    public static void main(String[] args) {

        CreditCardValidator creditCardValidator = new CreditCardValidator();
        creditCardValidator.setStringNumberCreditCard("4532 7587 9245 1259");
        System.out.println(creditCardValidator.isValidCreditCardNumber());

    }
}