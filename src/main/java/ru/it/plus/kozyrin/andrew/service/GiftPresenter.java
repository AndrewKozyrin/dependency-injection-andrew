package ru.it.plus.kozyrin.andrew.service;

import ru.it.plus.kozyrin.andrew.annotation.Inject;
import ru.it.plus.kozyrin.andrew.model.Gift;
import ru.it.plus.kozyrin.andrew.model.Person;

public class GiftPresenter {

    @Inject
    private GiftChooseHelper giftChooseHelper;
    @Inject
    private PaymentSystem paymentSystem;
    @Inject
    private DeliverySystem deliverySystem;

    public void present(Person person) {
        Gift gift = giftChooseHelper.choose(person);
        System.out.println(String.format("Gift has been chosen: %s", gift.getName()));
        paymentSystem.pay(gift);
        deliverySystem.deliver(gift, person);
    }
}
