package ru.it.plus.kozyrin.andrew.service;

import ru.it.plus.kozyrin.andrew.factory.BeanFactory;
import ru.it.plus.kozyrin.andrew.model.Gift;
import ru.it.plus.kozyrin.andrew.model.Person;

public class GiftPresenter {

    private GiftChooseHelper giftChooseHelper = BeanFactory.getInstance().getBean(GiftChooseHelper.class);

    private PaymentSystem paymentSystem = BeanFactory.getInstance().getBean(PaymentSystem.class);

    private DeliverySystem deliverySystem = BeanFactory.getInstance().getBean(DeliverySystem.class);

    public void present(Person person) {
        Gift gift = giftChooseHelper.choose(person);
        System.out.println(String.format("Gift has been chosen: %s", gift.getName()));
        paymentSystem.pay(gift);
        deliverySystem.deliver(gift, person);
    }
}
