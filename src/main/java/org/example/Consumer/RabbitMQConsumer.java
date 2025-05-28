package org.example.Consumer;

import org.example.Service.IntegracaoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

    @Autowired
    private IntegracaoService integracaoService;

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void listen(String id) {
        System.out.println("ID recebido do RabbitMQ: " + id);
        integracaoService.processarId(id);
    }
}
