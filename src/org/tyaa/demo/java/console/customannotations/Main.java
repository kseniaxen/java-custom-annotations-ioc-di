package org.tyaa.demo.java.console.customannotations;

import org.reflections.Reflections;
import org.tyaa.demo.java.console.customannotations.beans.Cookies;
import org.tyaa.demo.java.console.customannotations.beans.IsNotBean;
import org.tyaa.demo.java.console.customannotations.containers.Injector;
import org.tyaa.demo.java.console.customannotations.containers.Validator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException, ClassNotFoundException {

        Validator.validate(Cookies.class);
        Validator.validate(IsNotBean.class);

        // Java 8
        /* Reflections reflections = new Reflections("org.tyaa.demo.java.console.customannotations.beans");

        Set<Class<? extends Object>> beans =
                reflections.getSubTypesOf(Object.class);

        for (Class<? extends Object> beanClass : beans) {
            Validator.validate(beanClass);
        } */

        Controller controller = new Controller();
        Injector.addControlledInstance(controller);
        controller.doWork();
    }
}
