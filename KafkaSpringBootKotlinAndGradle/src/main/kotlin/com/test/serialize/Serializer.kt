package com.test.serialize

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.test.Entity
import org.slf4j.LoggerFactory


class Serializer : org.apache.kafka.common.serialization.Serializer<Entity?>
{
    private val log = LoggerFactory.getLogger(this.javaClass)

    override fun serialize(topic: String?, data: Entity?): ByteArray? {
        try {
            return if (data == null) null else ObjectMapper().writeValueAsBytes(data)
        }
        catch (e:JsonProcessingException)
        {
            e.printStackTrace()
            log.error("Can not serialize entity in Serializer")
        }
        return null
    }
}
