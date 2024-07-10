package com.didi.quizapp.helpers;

import java.lang.reflect.Field;
import java.util.Objects;

public class HashCode {

    public static int hashCode(Object instance) {
        try {
            Field[] fields = instance.getClass().getDeclaredFields();

            Object[] fieldValues = new Object[fields.length];

            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                field.setAccessible(true);
                fieldValues[i] = field.get(instance);
            }

            return Objects.hash(fieldValues);

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
