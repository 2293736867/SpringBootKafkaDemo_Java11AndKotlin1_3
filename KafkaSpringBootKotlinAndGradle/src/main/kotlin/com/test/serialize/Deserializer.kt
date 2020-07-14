package com.test.serialize

import com.fasterxml.jackson.databind.ObjectMapper
import com.test.Entity
import org.slf4j.LoggerFactory
import java.io.IOException

class Deserializer : org.apache.kafka.common.serialization.Deserializer<Entity?>
{
    private val log = LoggerFactory.getLogger(this.javaClass)

    override fun deserialize(topic: String?, data: ByteArray?): Entity? {
        try
        {
            return ObjectMapper().readValue(data, Entity::class.java)
        }
        catch (e:IOException)
        {
            e.printStackTrace()
            log.error("Can not deserialize entity in Deserializer")
        }
        return null
    }
}
