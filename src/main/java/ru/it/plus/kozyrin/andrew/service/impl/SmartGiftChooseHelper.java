package ru.it.plus.kozyrin.andrew.service.impl;


import ru.it.plus.kozyrin.andrew.model.Gift;
import ru.it.plus.kozyrin.andrew.model.Person;
import ru.it.plus.kozyrin.andrew.service.GiftChooseHelper;

public class SmartGiftChooseHelper implements GiftChooseHelper {

    @Override
    public Gift choose(Person person) {
        return new Gift("Smart watches", 10000);
    }
}
