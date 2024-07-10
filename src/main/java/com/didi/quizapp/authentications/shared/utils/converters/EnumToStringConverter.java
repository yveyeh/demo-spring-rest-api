package com.didi.quizapp.authentications.shared.utils.converters;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class EnumToStringConverter<E extends Enum<E>> implements AttributeConverter<E, String> {

    private Class<E> enumType;

    public EnumToStringConverter() {
        // Get the actual enum type from the generic superclass
        Type[] interfaces = getClass().getGenericInterfaces();
        for (Type interfaceType : interfaces) {
            if (interfaceType instanceof ParameterizedType) {
                ParameterizedType pt = (ParameterizedType) interfaceType;
                if (pt.getRawType() == AttributeConverter.class) {
                    enumType = (Class<E>) pt.getActualTypeArguments()[0];
                    break;
                }
            }
        }
    }

    @Override
    public String convertToDatabaseColumn(E attribute) {
        return attribute != null ? attribute.name() : null;
    }

    @Override
    public E convertToEntityAttribute(String dbData) {
        return dbData != null ? Enum.valueOf(enumType, dbData) : null;
    }
}

