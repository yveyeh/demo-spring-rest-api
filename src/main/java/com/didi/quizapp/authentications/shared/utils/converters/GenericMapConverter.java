package com.didi.quizapp.authentications.shared.utils.converters;
// import com.fasterxml.jackson.databind.util.Converter;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true) // Apply converter automatically
public class GenericMapConverter<K, V> implements AttributeConverter<Map<K, V>, String> {
  
    @Override
    public String convertToDatabaseColumn(Map<K, V> attribute) {
        if (attribute == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting Map to JSON", e);
        }
    }
  
    @Override
    public Map<K, V> convertToEntityAttribute(String dbData) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(dbData, new TypeReference<Map<K, V>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Error converting JSON to Map", e);
        }
    }
}
