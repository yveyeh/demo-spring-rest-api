package com.didi.quizapp.authentications.shared.utils.converters;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
// public class EnumConverter {

public class EnumConverter<E extends Enum<E>> implements AttributeConverter<E, String> {

    public static class Serializer<T extends Enum<T>> extends JsonSerializer<T> {
        @Override
        public void serialize(T value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.name());
        }
    }

    public static class Deserializer<T extends Enum<T>> extends JsonDeserializer<T> {
        private final Class<T> type;

        public Deserializer(Class<T> type) {
            this.type = type;
        }

        @Override
        public T deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            return Enum.valueOf(type, p.getText().toUpperCase());
        }
    }

    private Enum attribute;

    @Override
    public String convertToDatabaseColumn(E attribute) {
        // Convert enum to String representation (e.g., enum.name())
        return attribute.name();
    }

    @Override
    public E convertToEntityAttribute(String dbData) {
        // Convert String representation back to enum (e.g., Enum.valueOf(type, dbData))
        return Enum.valueOf((Class<E>) attribute.getClass(), dbData);
    }
}
