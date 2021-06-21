package ru.it.plus.kozyrin.andrew.factory;

import ru.it.plus.kozyrin.andrew.beanconfigurator.BeanConfigurator;
import ru.it.plus.kozyrin.andrew.beanconfigurator.JavaBeanConfigurator;
import ru.it.plus.kozyrin.andrew.config.Configuration;
import ru.it.plus.kozyrin.andrew.config.JavaConfiguration;

import java.lang.reflect.InvocationTargetException;

public class BeanFactory {

    private static BeanFactory instance;
    private final Configuration configuration;
    private final BeanConfigurator beanConfigurator;

    public BeanFactory() {
        this.configuration = new JavaConfiguration();
        this.beanConfigurator = new JavaBeanConfigurator(configuration.getPackageToScan(), configuration.getInterfaceToImplementation());
    }

    public static synchronized BeanFactory getInstance() {
        if (instance == null) {
            instance = new BeanFactory();
        }
        return instance;
    }

    public <T> T getBean(Class<T> initiateClass) {
        try {

            Class<? extends T> implementationClass = initiateClass;
            if (implementationClass.isInterface()) {
                implementationClass = beanConfigurator.getImplementationClass(implementationClass);
            }
            return implementationClass.getDeclaredConstructor().newInstance();

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException reflectiveOperationException) {
            reflectiveOperationException.printStackTrace();
        }

        return null;
    }
}
