package ru.it.plus.kozyrin.andrew.service.impl;


import ru.it.plus.kozyrin.andrew.model.Gift;
import ru.it.plus.kozyrin.andrew.model.Person;
import ru.it.plus.kozyrin.andrew.service.DeliverySystem;

public class PostDeliverySystem implements DeliverySystem {
    @Override
    public void deliver(Gift gift, Person person) {
        System.out.println(String.format("Deliver a %s to %s by POST", gift.getName(), person.getName()));
    }
}
