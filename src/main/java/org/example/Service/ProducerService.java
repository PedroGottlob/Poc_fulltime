package org.example.Service;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private final RabbitTemplate rabbitTemplate;
    private final String exchange;
    private final String routingKey;

    public ProducerService(
            RabbitTemplate rabbitTemplate,
            @Value("${rabbitmq.exchange}") String exchange,
            @Value("${rabbitmq.routingKey}") String routingKey
    ) {
        this.rabbitTemplate = rabbitTemplate;
        this.exchange = exchange;
        this.routingKey = routingKey;
    }

    public void enviarMensagem(String mensagem) {
        rabbitTemplate.convertAndSend(exchange, routingKey, mensagem);
        System.out.println("Mensagem enviada: " + mensagem);
    }
}
