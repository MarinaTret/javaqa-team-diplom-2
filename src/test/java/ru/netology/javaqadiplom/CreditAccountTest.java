package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    //Некорректные параметры для кредитного счета
    @Test // Исключения для отрицательной ставки
    public void exceptionForRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    2_000,
                    5_000,
                    -10
            );
        });
    }


    //Олата с карты на указанную сумму
    @Test // покупка в рамках баланса
    public void PayAmount() {
        CreditAccount account = new CreditAccount(
                2_000,
                5_000,
                15
        );

        account.pay(500);

        Assertions.assertEquals(1_500, account.getBalance());
    }

    @Test // покупка выходит за пределы баланса - в лимит
    public void PayAmountWithinLimit() {
        CreditAccount account = new CreditAccount(
                2_000,
                5_000,
                15
        );

        account.pay(6_000);

        Assertions.assertEquals(-4_000, account.getBalance());
    }

    @Test // покупка больше лимита
    public void PayAmountMoreLimit() {
        CreditAccount account = new CreditAccount(
                2_000,
                5_000,
                15
        );

        account.pay(8_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test // покупка 0
    public void PayAmount0() {
        CreditAccount account = new CreditAccount(
                2_000,
                5_000,
                15
        );

        account.pay(0);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    // Пополнение баланса карты
    @Test // пополнение баланса карты на положительную сумму
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(4_000, account.getBalance());
    }

    @Test // пополнение баланса карты на 0
    public void shouldAddTo0() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(0);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test // пополнение баланса карты на отрицательную сумму
    public void shouldAddToNegativeBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(-100);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test //расчёт процентов на отрицательный баланс счёта при условии, что счёт не будет меняться год
    public void calculatePercentToNegativeBalance() {
        CreditAccount account = new CreditAccount(
                -200,
                5_000,
                15
        );

        Assertions.assertEquals(-30, account.yearChange());
    }

    @Test //расчёт процентов на положительный баланс счёта при условии, что счёт не будет меняться год
    public void calculatePercentToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }
}
