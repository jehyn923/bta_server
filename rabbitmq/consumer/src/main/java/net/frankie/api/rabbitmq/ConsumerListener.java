package net.frankie.api.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListener {
    @RabbitListener(queues = "sample.queue")
    //final은 message가 수정되지 않게 하기
    public void receiveMessage(final Message message){
        System.out.println("################## MESSAGE RECEIVED ##################");
        System.out.println(message.toString());
    }
}
