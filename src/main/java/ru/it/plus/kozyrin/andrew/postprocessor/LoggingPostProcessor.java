package ru.it.plus.kozyrin.andrew.postprocessor;

public class LoggingPostProcessor implements BeanPostProcessor{
    @Override
    public void process(Object bean) {
        System.out.printf("Log: bean has been created: %s%n", bean.getClass());
    }
}
