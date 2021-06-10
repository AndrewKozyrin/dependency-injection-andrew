package ru.it.plus.kozyrin.andrew.client;

import ru.it.plus.kozyrin.andrew.model.Person;
import ru.it.plus.kozyrin.andrew.service.DeliverySystem;
import ru.it.plus.kozyrin.andrew.service.GiftChooseHelper;
import ru.it.plus.kozyrin.andrew.service.GiftPresenter;
import ru.it.plus.kozyrin.andrew.service.PaymentSystem;
import ru.it.plus.kozyrin.andrew.service.impl.CardPaymentSystem;
import ru.it.plus.kozyrin.andrew.service.impl.PostDeliverySystem;
import ru.it.plus.kozyrin.andrew.service.impl.SmartGiftChooseHelper;

public class NewYearOrganizer {

    private GiftChooseHelper giftChooseHelper = new SmartGiftChooseHelper();
    private PaymentSystem paymentSystem = new CardPaymentSystem();
    private DeliverySystem deliverySystem = new PostDeliverySystem();
    private final GiftPresenter giftPresenter = new GiftPresenter(giftChooseHelper, paymentSystem, deliverySystem);

    public void prepareToCelebration() {
        Person friend = new Person("Иван Иванов");
        giftPresenter.present(friend);
    }
}
