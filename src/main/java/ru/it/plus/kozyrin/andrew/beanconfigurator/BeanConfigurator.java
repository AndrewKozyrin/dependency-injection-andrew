package ru.it.plus.kozyrin.andrew.beanconfigurator;

public interface BeanConfigurator {

    <T> Class<? extends T> getImplementationClass(Class<T> interfaceClass);
}
