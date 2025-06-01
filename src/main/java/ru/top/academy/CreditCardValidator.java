package ru.top.academy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Класс для проверки номеров кредитных карт при помощи алгоритма Луна
 */
public class CreditCardValidator {
    private static String stringNumberCreditCard;
    private static String[] numberCreditCard;

    /**
     * Метод делает проверку длины карты
     * @param stringNumberCreditCard - номер карты
     * @return Возвращает результат проверки длины номера карты
     */
    private static boolean isValidLength(String stringNumberCreditCard) {
        return stringNumberCreditCard.length() >= 13 && stringNumberCreditCard.length() <= 19;
    }

    /**
     * Метод реализует алгоритм Луна
     * reverseNumberCreditCard() - переворачивает номер
     * getArray
     * @return
     */
    private static boolean algorithmLuhn() {

        reverseNumberCreditCard();
        int[] numCard = getArray();
        numCard = multiplicationByTwo(numCard);
        int sum = getSum(numCard, numCard.length - 1);

        return isExactDivision(sum);

    }

    private static boolean isExactDivision(int sum) {
        return sum % 10 == 0;
    }

    private static int getSum(int[] numCard, int i) {
        return (i == 0) ? numCard[i] : (numCard[i] + getSum(numCard, i - 1));
    }

    private static int[] multiplicationByTwo(int[] numCard) {

        for (int i = 0; i < numberCreditCard.length; i = i + 2) {
            numCard[i] = numCard[i] * 2;
            if (numCard[i] > 9) {
                numCard[i] = sumDigits(numCard[i]);
            }
        }

        return numCard;

    }

    private static int[] getArray() {
        return Arrays.stream(numberCreditCard).mapToInt(Integer::parseInt).toArray();
    }

    private static int sumDigits(int number) {

        int sum = 0;

        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;

    }

    private static void reverseNumberCreditCard() {

        String reversNumber = new StringBuilder(stringNumberCreditCard).reverse().toString();
        numberCreditCard = reversNumber.split("");

    }

    /**
     * Метод принимает на вход строку, удаляет из нее все символы, которые не являются числом,
     * проверяет входные данные и при положительном результате присваивает строку глобальной переменной класса
     *
     * @param stringNumberCreditCard - номер карты
     */
    public void setStringNumberCreditCard(String stringNumberCreditCard) {

        stringNumberCreditCard = stringNumberCreditCard.replaceAll("[^0-9]", "");

        if (isValidLength(stringNumberCreditCard)) {
            this.stringNumberCreditCard = stringNumberCreditCard;
        } else {
            System.out.println("Неверная длина номера");
        }

    }

    /**
     * Метод вызывает алгоритм Луна
     *
     * @return возвращает результат проверки номера карты
     */
    public boolean isValidCreditCardNumber() {
        return algorithmLuhn();
    }
}
