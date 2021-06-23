package ru.it.plus.kozyrin.andrew.client;

import ru.it.plus.kozyrin.andrew.annotation.Inject;
import ru.it.plus.kozyrin.andrew.factory.BeanFactory;
import ru.it.plus.kozyrin.andrew.model.Person;
import ru.it.plus.kozyrin.andrew.service.DeliverySystem;
import ru.it.plus.kozyrin.andrew.service.GiftChooseHelper;
import ru.it.plus.kozyrin.andrew.service.GiftPresenter;
import ru.it.plus.kozyrin.andrew.service.PaymentSystem;
import ru.it.plus.kozyrin.andrew.service.impl.*;

public class NewYearOrganizer {

    @Inject
    private GiftPresenter giftPresenter;

    public void prepareToCelebration() {
        Person friend = new Person("Иван Иванов");
        giftPresenter.present(friend);
    }
}
