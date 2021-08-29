package net.frankie.api.rabbitmq;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PublisherController {
    private static final String EXCHANGE_NAME = "sample.exchange";
    private final RabbitTemplate template;

    @GetMapping("/sample/queue")
    public String samplePublish() {
        //접미사 표식
        template.convertAndSend(EXCHANGE_NAME, "sample.key.#", "RabbitMQ Success !!!");
        return "message sending";
    }
}
