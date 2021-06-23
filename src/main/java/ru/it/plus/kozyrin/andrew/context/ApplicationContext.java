package ru.it.plus.kozyrin.andrew.context;

import ru.it.plus.kozyrin.andrew.factory.BeanFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext {

    private BeanFactory beanFactory;
    private final Map<Class, Object> beanMap;

    public ApplicationContext() {
        beanMap = new ConcurrentHashMap<>();
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public <T> T getBean(Class<T> implementClass){
        if (beanMap.containsKey(implementClass)){
            return (T) beanMap.get(implementClass);
        }

        T bean = beanFactory.getBean(implementClass);
        beanMap.put(implementClass, bean);
        return bean;
    }
}
