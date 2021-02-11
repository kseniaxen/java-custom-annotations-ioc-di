package org.tyaa.demo.java.console.customannotations.containers;

import org.tyaa.demo.java.console.customannotations.Controller;
import org.tyaa.demo.java.console.customannotations.annotations.Inject;
import org.tyaa.demo.java.console.customannotations.annotations.ManagedBean;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Injector {

    public static void addControlledInstance(Object _o) throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException {

        //Проверка полученного объекта на соответствие
        //определенному типа
        if (_o instanceof Controller) {

            Controller sc = (Controller)_o;
            //Получаем отражение (описание) управляемого объекта
            Class targetClass = sc.getClass();
            //Получаем описание всех полей управляемого объекта
            Field[] fields = targetClass.getDeclaredFields();
            //Перебираем описания всех полей управляемого объекта
            for(Field field : fields) {
                System.out.println("Field " + field.getName());
                //Работаем только с теми полями, которые помечены
                //нашей аннотацией Inject
                String className = field.getAnnotation(Inject.class).name();
                String output = className.substring(0, 1).toUpperCase() + className.substring(1);
                Class<?> injectingInstanceClass = Class.forName("org.tyaa.demo.java.console.customannotations.beans." + output);

                Constructor constructor =
                        injectingInstanceClass.getDeclaredConstructors()[0];
                constructor.setAccessible(true);
                field.setAccessible(true);
                field.set(sc, (injectingInstanceClass.cast(constructor.newInstance())));
                /*
                if(field.isAnnotationPresent(Inject.class)) {
                    //Получаем описание помеченного поля
                    Class injectingInstanceClass = field.getType();
                    System.out.println(injectingInstanceClass.getName());
                    //Получаем описание первого конструктора из
                    //описания текущего помеченного поля
                    //(должен быть один и без параметров)
                    Constructor constructor =
                            injectingInstanceClass.getDeclaredConstructors()[0];
                    //System.out.println(constructor.getParameterCount());
                    //Открывает доступ к конструктору
                    // constructor.setAccessible(true);
                    //Открывает доступ к полю
                    field.setAccessible(true);
                    //В управляемом объекте по ссылке из переменной sc
                    //находим поле, соответствующее описанию field,
                    //вызываем конструктор внедряемого типа,
                    //приводим полученную ссылку к нужному типу
                    //и инициализируем ею поле
                    field.set(sc, (injectingInstanceClass.cast(constructor.newInstance())));

                }
                 */
            }
        }
    }
}
