package ru.top.academy;

import java.util.Arrays;

/**
 * Класс для проверки номеров кредитных карт при помощи алгоритма Луна
 */
public class CreditCardValidator {
    private static String stringNumberCreditCard;
    private static String[] stringArrayNumberCreditCard;

    /**
     * Делает проверку длины карты
     *
     * @param stringNumberCreditCard номер карты
     * @return Возвращает результат проверки длины номера карты
     */
    private static boolean isValidLength(String stringNumberCreditCard) {
        return stringNumberCreditCard.length() >= 13 && stringNumberCreditCard.length() <= 19;
    }

    /**
     * Реализует алгоритм Луна
     *
     * @return возвращает результат проверки
     */
    private static boolean algorithmLuhn() {

        reverseNumberCreditCard();
        int[] numCard = getArray();
        numCard = multiplicationByTwo(numCard);
        int sum = getSum(numCard, numCard.length - 1);

        return isExactDivision(sum);

    }

    /**
     * Проверяет на кратность 10
     *
     * @param number на вход принимает число для проверки
     * @return возвращает результат
     */
    private static boolean isExactDivision(int number) {
        return number % 10 == 0;
    }

    /**
     * Рекурсивный метод для получения суммы чисел из массива
     *
     * @param numCard массив чисел
     * @param i       индекс последнего числа в массиве
     * @return возвращает сумму чисел
     */
    private static int getSum(int[] numCard, int i) {
        return (i == 0) ? numCard[i] : (numCard[i] + getSum(numCard, i - 1));
    }

    /**
     * Умножает каждое второе число на 2, если после умножения число больше 9,
     * то вызывает метод sumDigits() и присваивает результат элементу массива numCard
     *
     * @param numCard массив чисел
     * @return возвращает обновленный массив чисел
     */
    private static int[] multiplicationByTwo(int[] numCard) {

        for (int i = 0; i < stringArrayNumberCreditCard.length; i = i + 2) {
            numCard[i] = numCard[i] * 2;
            if (numCard[i] > 9) {
                numCard[i] = sumDigits(numCard[i]);
            }
        }

        return numCard;

    }

    /**
     * Преобразует массив строк в массив чисел
     *
     * @return возвращает массив чисел
     */
    private static int[] getArray() {
        return Arrays.stream(stringArrayNumberCreditCard).mapToInt(Integer::parseInt).toArray();
    }

    /**
     * Складывает цифры из аргумента между собой
     *
     * @param number число
     * @return возвращает результат суммы цифр
     */
    private static int sumDigits(int number) {

        int sum = 0;

        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;

    }

    /**
     * Переворачивает строку и записывает в массив строк stringArrayNumberCreditCard разделяя посимвольно
     */
    private static void reverseNumberCreditCard() {

        try {
            String reversNumber = new StringBuilder(stringNumberCreditCard).reverse().toString();
            stringArrayNumberCreditCard = reversNumber.split("");
        } catch (NullPointerException ex) {
            throw new NullPointerException("Пустая строка");
        }

    }

    /**
     * Метод принимает на вход строку, удаляет из нее все символы, которые не являются числом,
     * проверяет очищенный аргумент на длину и при положительном результате присваивает строку
     * глобальной переменной класса
     *
     * @param stringNumberCreditCard номер карты
     */
    public void setStringNumberCreditCard(String stringNumberCreditCard) {

        stringNumberCreditCard = stringNumberCreditCard.replaceAll("[^0-9]", "");
        if (isValidLength(stringNumberCreditCard)) {
            this.stringNumberCreditCard = stringNumberCreditCard;
        }

    }

    /**
     * Метод позволяет вызвать извне алгоритм Луна
     *
     * @return возвращает результат проверки номера карты
     */
    public boolean isValidCreditCardNumber() {
        return algorithmLuhn();
    }
}
