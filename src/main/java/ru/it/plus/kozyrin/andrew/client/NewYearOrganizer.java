package ru.it.plus.kozyrin.andrew.client;

import ru.it.plus.kozyrin.andrew.model.Person;
import ru.it.plus.kozyrin.andrew.service.GiftPresenter;

public class NewYearOrganizer {

    private final GiftPresenter giftPresenter = new GiftPresenter();

    public void prepareToCelebration() {
        Person friend = new Person("Иван Иванов");
        giftPresenter.present(friend);
    }
}
