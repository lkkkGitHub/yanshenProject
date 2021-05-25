package com.myannotationconf;

import java.lang.reflect.Field;

/**
 * @author lk
 * 2019/10/6 21:58
 */
public class PersonHandler {

    public void handPerson(MyConfigListener listener) throws IllegalAccessException {
        Class clazz = listener.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            Person person = field.getAnnotation(Person.class);
            if (person != null) {
                field.setAccessible(true);
                field.set(listener, person.value());
            }
        }
    }

}
