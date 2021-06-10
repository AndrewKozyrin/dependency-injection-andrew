package ru.it.plus.kozyrin.andrew.service;

import ru.it.plus.kozyrin.andrew.model.Gift;
import ru.it.plus.kozyrin.andrew.model.Person;
import ru.it.plus.kozyrin.andrew.service.impl.CardPaymentSystem;
import ru.it.plus.kozyrin.andrew.service.impl.PostDeliverySystem;
import ru.it.plus.kozyrin.andrew.service.impl.SmartGiftChooseHelper;

public class GiftPresenter {

    private GiftChooseHelper giftChooseHelper = new SmartGiftChooseHelper();

    private PaymentSystem paymentSystem = new CardPaymentSystem();

    private DeliverySystem deliverySystem = new PostDeliverySystem();

    public void present(Person person) {
        Gift gift = giftChooseHelper.choose(person);
        System.out.println(String.format("Gift has been chosen: %s", gift.getName()));
        paymentSystem.pay(gift);
        deliverySystem.deliver(gift, person);
    }
}
