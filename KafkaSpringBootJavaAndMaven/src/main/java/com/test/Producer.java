package com.test;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Producer {

    private final KafkaTemplate<String, Entity> kafkaTemplate;

    public void send(Entity entity) {
        ListenableFuture<SendResult<String, Entity>> future =
                kafkaTemplate.send(Constants.TOPIC, entity);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.info("Send message failed");
            }

            @Override
            public void onSuccess(SendResult<String, Entity> stringEntitySendResult) {
                log.info("Send message success");
            }
        });
    }
}
