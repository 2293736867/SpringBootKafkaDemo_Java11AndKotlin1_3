package com.test

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Component
import org.springframework.util.concurrent.ListenableFutureCallback

@Component
class Producer
{
    @Autowired
    private var kafkaTemplate:KafkaTemplate<String,Entity> ? = null
    private val log = LoggerFactory.getLogger(this.javaClass)

    fun send(entity: Entity)
    {
        val future = kafkaTemplate!!.send(Constants.TOPIC,entity);

        future.addCallback(object : ListenableFutureCallback<SendResult<String?, Entity?>?>{
            override fun onSuccess(result : SendResult<String?,Entity?>?)
            {
                log.info("Send success");
            }

            override fun onFailure(e:Throwable)
            {
                log.info("Send failed");
            }
        })

    }
}