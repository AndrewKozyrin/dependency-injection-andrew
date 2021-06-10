package ru.it.plus.kozyrin.andrew.service.impl;


import ru.it.plus.kozyrin.andrew.model.Gift;
import ru.it.plus.kozyrin.andrew.model.Person;
import ru.it.plus.kozyrin.andrew.service.GiftChooseHelper;

public class SmartGiftChooseHelper implements GiftChooseHelper {

    Recomendator recomendator;

    public SmartGiftChooseHelper(Recomendator recomendator) {
        this.recomendator = recomendator;
    }

    @Override
    public Gift choose(Person person) {
        recomendator.recomend();
        return new Gift("Smart watches", 10000);
    }
}
