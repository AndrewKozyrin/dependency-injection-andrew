package ru.it.plus.kozyrin.andrew.service.impl;

import ru.it.plus.kozyrin.andrew.model.Gift;
import ru.it.plus.kozyrin.andrew.service.PaymentSystem;

public class CashPaymentSystem implements PaymentSystem {
    @Override
    public void pay(Gift gift) {
        System.out.printf("Pay %d for a %s by cash%n", gift.getPrice(), gift.getName());
    }
}
