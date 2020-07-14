package com.test.serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.Entity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Serializer implements org.apache.kafka.common.serialization.Serializer<Entity> {
    public byte [] serialize(String topic, Entity entity)
    {
        try {
            return entity == null ? null : new ObjectMapper().writeValueAsBytes(entity);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            log.error("Can not serialize entity in Serializer");
        }
        return null;
    }
}
