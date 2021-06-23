package ru.it.plus.kozyrin.andrew;

import ru.it.plus.kozyrin.andrew.client.NewYearOrganizer;
import ru.it.plus.kozyrin.andrew.context.ApplicationContext;
import ru.it.plus.kozyrin.andrew.factory.BeanFactory;

public class App {
    public static void main(String[] args) {
        App application = new App();
        ApplicationContext context = application.run();

        NewYearOrganizer newYearOrganizer = context.getBean(NewYearOrganizer.class);
        newYearOrganizer.prepareToCelebration();
    }

    public ApplicationContext run(){
        ApplicationContext applicationContext = new ApplicationContext();
        BeanFactory beanFactory = new BeanFactory(applicationContext);
        applicationContext.setBeanFactory(beanFactory);

        return applicationContext;
    }
}
