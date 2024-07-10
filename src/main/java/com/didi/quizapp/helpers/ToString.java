package com.didi.quizapp.helpers;

import java.lang.reflect.Field;

public class ToString {

    public static String toString(Object obj) {
        if (obj == null) {
            return "null";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(obj.getClass().getSimpleName()).append(" {\n");

        Field[] fields = obj.getClass().getDeclaredFields();

        try {
            for (Field field : fields) {
                field.setAccessible(true);
                sb.append("    ").append(field.getName()).append(": ").append(toIndentedString(field.get(obj))).append("\n");
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        sb.append("}");
        return sb.toString();
    }

    private static String toIndentedString(Object obj) {
        if (obj == null) {
            return "null";
        }
        return obj.toString().replace("\n", "\n    ");
    }
}
