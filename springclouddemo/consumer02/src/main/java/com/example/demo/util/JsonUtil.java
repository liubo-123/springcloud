package com.example.demo.util;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil{
      static ObjectMapper mapper = new ObjectMapper();

        public static String toJson(Object object) {
            String json = new String();

            try {
                mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
                mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
                json = mapper.writeValueAsString(object);
            } catch (JsonProcessingException var3) {

            }
           //String json = JSONObject.toJSONString(object);

            return json;
        }
}
