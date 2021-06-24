package ru.it.plus.kozyrin.andrew.factory;

import ru.it.plus.kozyrin.andrew.annotation.Inject;
import ru.it.plus.kozyrin.andrew.beanconfigurator.BeanConfigurator;
import ru.it.plus.kozyrin.andrew.beanconfigurator.JavaBeanConfigurator;
import ru.it.plus.kozyrin.andrew.config.Configuration;
import ru.it.plus.kozyrin.andrew.config.JavaConfiguration;
import ru.it.plus.kozyrin.andrew.context.ApplicationContext;
import ru.it.plus.kozyrin.andrew.service.PaymentSystem;
import ru.it.plus.kozyrin.andrew.service.impl.CardPaymentSystem;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BeanFactory {

    private final Configuration configuration;
    private final BeanConfigurator beanConfigurator;
    private ApplicationContext applicationContext;

    public BeanFactory(ApplicationContext applicationContext) {
        this.configuration = new JavaConfiguration();
        this.beanConfigurator = new JavaBeanConfigurator(configuration.getPackageToScan(),
                configuration.getInterfaceToImplementation(PaymentSystem.class, CardPaymentSystem.class));
        this.applicationContext = applicationContext;
    }

    public BeanConfigurator getBeanConfigurator() {
        return beanConfigurator;
    }

    public <T> T getBean(Class<T> initiateClass) {
        try {

            Class<? extends T> implementationClass = initiateClass;
            if (implementationClass.isInterface()) {
                implementationClass = beanConfigurator.getImplementationClass(implementationClass);
            }
            T bean = implementationClass.getDeclaredConstructor().newInstance();

            List<Field> fieldClassList = Arrays.stream(implementationClass.getDeclaredFields())
                    .filter(field -> field.isAnnotationPresent(Inject.class))
                    .collect(Collectors.toList());
            for (Field field : fieldClassList) {
                field.setAccessible(true);
                field.set(bean, applicationContext.getBean(field.getType()));
            }
            return bean;

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException reflectiveOperationException) {
            reflectiveOperationException.printStackTrace();
        }

        return null;
    }
}
