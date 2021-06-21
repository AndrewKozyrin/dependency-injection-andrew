package ru.it.plus.kozyrin.andrew.config;

import ru.it.plus.kozyrin.andrew.service.PaymentSystem;
import ru.it.plus.kozyrin.andrew.service.impl.CashPaymentSystem;

import java.util.Map;

public class JavaConfiguration implements Configuration{
    @Override
    public String getPackageToScan() {
        return "ru.it.plus.kozyrin.andrew";
    }

    @Override
    public Map<Class, Class> getInterfaceToImplementation() {
        return Map.of(PaymentSystem.class, CashPaymentSystem.class);
    }
}
