package com.didi.quizapp.authentications.shared.utils.converters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.didi.quizapp.authentications.otp.infra.shared.enums.Method;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true) // Apply converter automatically
public class MethodSetConverter implements AttributeConverter<Set<Method>, String> {

  private static final ObjectMapper mapper = new ObjectMapper();

  @Override
  public String convertToDatabaseColumn(Set<Method> methods) {
    if (methods == null) {
      return null;
    }
    List<String> methodNames = new ArrayList<>(methods.size());
    for (Method method : methods) {
      methodNames.add(method.name());
    }
    try {
      return mapper.writeValueAsString(methodNames);
    } catch (JsonProcessingException e) {
      throw new RuntimeException("Error converting Set<Method> to JSON", e);
    }
  }

  @Override
  public Set<Method> convertToEntityAttribute(String jsonString) {
    try {
      // Check if the deserialized list is indeed a List<String>
      List<?> tempList = mapper.readValue(jsonString, List.class);
      if (tempList instanceof List<?>) {
        @SuppressWarnings("unchecked") // Suppress warning only for this cast
        List<String> methodNames = (List<String>) tempList;
        Set<Method> methods = new HashSet<>(methodNames.size());
        for (String methodName : methodNames) {
          methods.add(Method.valueOf(methodName));
        }
        return methods;
      } else {
        // Handle the case where the list is not List<String> (log, throw exception, etc.)
        throw new RuntimeException("Unexpected list type during deserialization: " + tempList.getClass());
      }
    } catch (IOException e) {
      throw new RuntimeException("Error converting JSON to Set<Method>", e);
    }
  }
}
