package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void shouldAddUpToMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(8_000);

        Assertions.assertEquals(10_000, account.getBalance());
    }

    @Test
    public void shouldAddMoreThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(9_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldAddZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(0);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldAddNegativeAmount() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(-1_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldPayAboveBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(500);

        Assertions.assertEquals(1_500, account.getBalance());
    }

    @Test
    public void shouldPayUpToMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(1_000);

        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void shouldPayBelowBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(3_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldPayAmountLessThanZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(-2_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldPayAmountZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(0);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldCalculateYearChange() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        Assertions.assertEquals(100, account.yearChange());
    }

    @Test
    public void shouldCalculateYearChangeWithNegativeRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(2_000, 1_000, 10_000, -5);
        });
    }
}
