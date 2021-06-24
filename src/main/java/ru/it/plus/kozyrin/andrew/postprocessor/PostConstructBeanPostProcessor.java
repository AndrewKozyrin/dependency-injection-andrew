package ru.it.plus.kozyrin.andrew.postprocessor;

import ru.it.plus.kozyrin.andrew.annotation.PostConstruct;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class PostConstructBeanPostProcessor implements BeanPostProcessor{
    @Override
    public void process(Object bean) {
        Arrays.stream(bean.getClass().getDeclaredMethods())
                .forEach(method -> {
                    if(method.isAnnotationPresent(PostConstruct.class)){
                        try {
                            method.invoke(bean);
                        } catch (IllegalAccessException | InvocationTargetException reflectiveOperationException) {
                            reflectiveOperationException.printStackTrace();
                        }
                    }
                });
    }
}
