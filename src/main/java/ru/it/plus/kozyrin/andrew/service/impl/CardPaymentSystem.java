package ru.it.plus.kozyrin.andrew.service.impl;


import ru.it.plus.kozyrin.andrew.model.Gift;
import ru.it.plus.kozyrin.andrew.service.PaymentSystem;

public class CardPaymentSystem implements PaymentSystem {
    @Override
    public void pay(Gift gift) {
        System.out.println(String.format("Pay %d for a %s by CARD", gift.getPrice(), gift.getName()));
    }
}
