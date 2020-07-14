package com.test

import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class Consumer {
    private val log = LoggerFactory.getLogger(this.javaClass)

    @KafkaListener(topics = [Constants.TOPIC],groupId = Constants.GROUP_ID)
    fun consume(entity: Entity) {
        log.info("Consume a entity, id is "+entity.id.toString())
    }
}