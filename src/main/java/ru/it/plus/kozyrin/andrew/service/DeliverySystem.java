package ru.it.plus.kozyrin.andrew.service;

import ru.it.plus.kozyrin.andrew.model.Gift;
import ru.it.plus.kozyrin.andrew.model.Person;

public interface DeliverySystem {

    void deliver(Gift gift, Person person);
}
