package ru.it.plus.kozyrin.andrew.beanconfigurator;

import org.reflections.Reflections;

import java.util.Set;

public class JavaBeanConfigurator implements BeanConfigurator{

    final Reflections scanner;

    public JavaBeanConfigurator(String packageToScan) {
        scanner = new Reflections(packageToScan);
    }

    @Override
    public <T> Class<? extends T> getImplementationClass(Class<T> interfaceClass) {
        Set<Class<? extends T>> implementationClasses = scanner.getSubTypesOf(interfaceClass);
        if (implementationClasses.size() != 1){
            throw new RuntimeException("Interface hase 0 or more then 1 implementation");
        }
        return implementationClasses.stream().findFirst().get();
    }
}
