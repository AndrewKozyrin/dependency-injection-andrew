package ru.it.plus.kozyrin.andrew.context;

import ru.it.plus.kozyrin.andrew.factory.BeanFactory;
import ru.it.plus.kozyrin.andrew.postprocessor.BeanPostProcessor;

import java.lang.reflect.InvocationTargetException;
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

        callPostProcessors(bean);

        beanMap.put(implementClass, bean);
        return bean;
    }

    private void callPostProcessors(Object bean){
        beanFactory.getBeanConfigurator().getScanner().getSubTypesOf(BeanPostProcessor.class).forEach(processor -> {
            try {
                BeanPostProcessor beanPostProcessor = processor.getDeclaredConstructor().newInstance();
                beanPostProcessor.process(bean);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        });
    }
}
